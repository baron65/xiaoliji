package com.tts.xiaoliji.mavenplugin.rap;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.tts.xiaoliji.mavenplugin.rap.RapGeneratorConfig.Javavalidator;
import com.tts.xiaoliji.mavenplugin.util.DBConnectionFactory;
import com.tts.xiaoliji.mavenplugin.util.FileUtils;
import com.tts.xiaoliji.mavenplugin.util.SQLExecutor;

public class DubboServiceBeanGeneratorCore {

	private static String INDENT = "    ";

	private static RapGeneratorConfig rapGeneratorConfig;
	private static String javaFileEncoding;
	private static String driverclass;
	private static String connectionurl;
	private static String userid;
	private static String password;

	private static boolean javavalidatorFlag;
	private static boolean setterAndGetterFlag;
	private static boolean fieldIsPublicFlag;

	private static String projectName;
	private static String packageName;
	private static String commontypePackageName;

	private static String superClassRequest;
	private static String superClassResponse;

	private static List<String> excludeResponseParas;
	private static List<String> excludeRequestParas;
	private static List<String> primitiveDataTypes;
	private static List<String> javavalidatorNameList;
	private static Map<String, String> javavalidatorMap;
	private static Map<String, String> commonTypeMap;

	private static void initPara(RapGeneratorConfig config) {
		{
			excludeResponseParas = new ArrayList<>();
			excludeRequestParas = new ArrayList<>();
			primitiveDataTypes = new ArrayList<>();
			javavalidatorNameList = new ArrayList<>();
			javavalidatorMap = new HashMap<>();
			commonTypeMap = new HashMap<>();
		}

		rapGeneratorConfig = config;
		{
			List<String> excludeResponseParaList = config.getExcludeResponseParaList();
			if (null != excludeResponseParaList) {
				for (String s : excludeResponseParaList) {
					excludeResponseParas.add(s);
				}
			}
		}
		{
			List<String> excludeRequestParaList = config.getExcludeRequestParaList();
			if (null != excludeRequestParaList) {
				for (String s : excludeRequestParaList) {
					excludeRequestParas.add(s);
				}
			}
		}
		{
			List<String> primitiveDataTypeList = config.getPrimitiveDataTypeList();
			if (null != primitiveDataTypeList) {
				for (String s : primitiveDataTypeList) {
					primitiveDataTypes.add(s);
				}
			}
		}
		{
			javaFileEncoding = config.getProperty("javaFile.encoding");
			if (null == javaFileEncoding || javaFileEncoding.trim().length() <= 0) {
				javaFileEncoding = "UTF-8";
			}

			driverclass = config.getProperty("jdbc.driverClass");
			connectionurl = config.getProperty("jdbc.connectionURL");
			userid = config.getProperty("jdbc.userId");
			password = config.getProperty("jdbc.password");

			{

				String javavalidatorFlagS = config.getProperty("flag.javavalidator");

				if (null == javavalidatorFlagS || "true".equalsIgnoreCase(javavalidatorFlagS)) {
					javavalidatorFlag = true;
				} else {
					javavalidatorFlag = false;
				}
			}
			{
				String setterAndGetterFlagS = config.getProperty("flag.setterAndGetter");
				if (null == setterAndGetterFlagS || "true".equalsIgnoreCase(setterAndGetterFlagS)) {
					setterAndGetterFlag = true;
				} else {
					setterAndGetterFlag = false;
				}
			}
			{
				String fieldIsPublicFlagS = config.getProperty("flag.fieldIsPublic");
				if (null == fieldIsPublicFlagS || "false".equalsIgnoreCase(fieldIsPublicFlagS)) {
					fieldIsPublicFlag = false;
				} else {
					fieldIsPublicFlag = true;
				}
			}

			projectName = config.getProperty("filePath.targetProject");
			packageName = config.getProperty("filePath.targetPackage");
			commontypePackageName = packageName + ".common";

			superClassRequest = config.getProperty("superClass.request");
			superClassResponse = config.getProperty("superClass.response");
		}

		{
			List<Javavalidator> javavalidatorList = config.getJavavalidatorList();
			if (null != javavalidatorList) {
				for (Javavalidator javavalidator : javavalidatorList) {
					String annotationName = javavalidator.getAnnotationName();
					String annotationClass = javavalidator.getAnnotationClass();

					javavalidatorNameList.add(annotationName);
					javavalidatorMap.put(annotationName, annotationClass);
				}
			}
		}
	}

	public static void generate(RapGeneratorConfig config) {

		if (config == null) {
			throw new IllegalArgumentException("configuration is a required parameter");
		}

		try {
			initPara(config);

			Connection conn = null;
			{
				conn = DBConnectionFactory.getConnection(driverclass, connectionurl, userid, password);
			}

			String actionSql = buildActionSql(rapGeneratorConfig);

			List<Map<String, String>> actionList = SQLExecutor.queryMapList(conn, actionSql);

			for (Map<String, String> action : actionList) {
				String actionId = action.get("id");
				String url = action.get("request_url");

				String classDesc = action.get("name");

				try {
					String subPackage = buildSubPackagePath(url);

					String myPackageName = packageName;
					if (null != subPackage && subPackage.trim().length() > 0) {
						myPackageName += ".";
						myPackageName += subPackage;
					}

					{
						clearExistsType();

						List<Map<String, String>> requestParaList = queryRequestParaList(conn, actionId);

						String className = buildClassName(url, BeanType.REQUEST);

						JavaFileBean bean = buildJavaFileContent(conn, className, classDesc, myPackageName,
								superClassRequest, requestParaList, url);

						String filePath = buildFilePath(projectName, bean);
						FileUtils.writer(filePath, bean.lines, javaFileEncoding, false);
					}

					{
						clearExistsType();

						List<Map<String, String>> responseParaList = queryResponseParaList(conn, actionId);

						String className = buildClassName(url, BeanType.RESPONSE);

						myPackageName = packageName;
						if (null != subPackage && subPackage.trim().length() > 0) {
							myPackageName += ".";
							myPackageName += subPackage;
						}

						JavaFileBean bean = buildJavaFileContent(conn, className, classDesc, myPackageName,
								superClassResponse, responseParaList, url);

						String filePath = buildFilePath(projectName, bean);
						FileUtils.writer(filePath, bean.lines, javaFileEncoding, false);
						System.out.println("成功：服务[" + action.get("name") + "][" + url + "][" + filePath + "]");
					}
				} catch (Exception e) {
					System.out.println("失败■■■■■■■■：服务[" + action.get("name") + "][" + action.get("request_url")
							+ "]，原因：" + e.getMessage());
					continue;
				}
			}

			Set<String> finishedCommonType = new HashSet<>();
			if (commonTypeMap.size() > 0) {

				do {

					// for (String commonTypeName : commonTypeMap.keySet()) {
					Iterator<String> keyIterator = commonTypeMap.keySet().iterator();
					while (keyIterator.hasNext()) {
						String commonTypeName = keyIterator.next();
						clearExistsType();
						String paraId = commonTypeMap.get(commonTypeName);

						List<Map<String, String>> paraList = queryComplexParaList(conn, paraId, false);

						String classDesc = "公共类型[" + commonTypeName + "]";

						JavaFileBean bean = buildJavaFileContent(conn, commonTypeName, classDesc, commontypePackageName,
								"", paraList, "");

						String filePath = buildFilePath(projectName, bean);
						FileUtils.writer(filePath, bean.lines, javaFileEncoding, false);

						finishedCommonType.add(commonTypeName);
					}
				} while (commonTypeMap.size() > finishedCommonType.size());
			}

			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String buildFilePath(String projectName, JavaFileBean bean) {
		String filePath = projectName + "/" + bean.packageName.replaceAll("\\.", "/") + "/" + bean.className + ".java";
		return filePath;
	}

	private static List<Map<String, String>> queryRequestParaList(Connection conn, String actionId) throws Exception {
		String sql = "select * from tb_request_parameter_list_mapping req join tb_parameter para on req.parameter_id = para.id where action_id='"
				+ actionId + "' and identifier <>'' order by id";

		List<Map<String, String>> paraList = SQLExecutor.queryMapList(conn, sql);

		List<Map<String, String>> result = new ArrayList<>();
		Set<String> savedParaName = new HashSet<>();

		for (Map<String, String> para : paraList) {
			String name = para.get("identifier");
			if (excludeRequestParas.contains(name) || savedParaName.contains(name)) {
				continue;
			}
			result.add(para);
		}

		completeParaInfo(result, false);
		return result;
	}

	private static List<Map<String, String>> queryResponseParaList(Connection conn, String actionId) throws Exception {
		String sql = "select * from tb_response_parameter_list_mapping req join tb_parameter para on req.parameter_id = para.id where action_id='"
				+ actionId + "' and identifier <>'' order by id";

		List<Map<String, String>> paraList = SQLExecutor.queryMapList(conn, sql);

		List<Map<String, String>> result = new ArrayList<>();

		Set<String> savedParaName = new HashSet<>();
		for (Map<String, String> para : paraList) {
			String name = para.get("identifier");
			if (excludeResponseParas.contains(name) || savedParaName.contains(name)) {
				continue;
			}
			result.add(para);
			savedParaName.add(name);
		}

		completeParaInfo(result, false);
		return result;
	}

	private static List<Map<String, String>> queryComplexParaList(Connection conn, String paraId, boolean isCommonType)
			throws Exception {
		String sql = "select * from tb_complex_parameter_list_mapping com left join tb_parameter para on com.parameter_id = para.id where com.complex_parameter_id='"
				+ paraId + "'";

		List<Map<String, String>> paraList = SQLExecutor.queryMapList(conn, sql);

		List<Map<String, String>> result = new ArrayList<>();

		Set<String> savedParaName = new HashSet<>();

		for (Map<String, String> para : paraList) {
			String name = para.get("identifier");
			if (savedParaName.contains(name)) {
				continue;
			}
			result.add(para);
			savedParaName.add(name);
		}

		completeParaInfo(result, isCommonType);
		return result;
	}

	/*
	 * static boolean hasListType = false; static boolean hasMapType = false;
	 * static boolean hasBigDecimalType = false; static boolean hasDateType =
	 * false;
	 */
	private static Map<String, Boolean> existsType = new HashMap<String, Boolean>();
	private static Set<String> commonTypeNameSet = new HashSet<>();

	private static boolean isExistsType(String key) {
		Boolean exists = existsType.get(key);
		if (null == exists) {
			return false;
		}
		return exists;
	}

	private static void clearExistsType() {
		existsType = new HashMap<String, Boolean>();
		commonTypeNameSet = new HashSet<>();
	}

	private static void setExistsType(String key) {
		existsType.put(key, true);
	}

	private static void completeParaInfo(List<Map<String, String>> paraList, boolean isCommonType) throws Exception {

		try {
			// 整理字段信息
			for (Map<String, String> para : paraList) {

				String name = para.get("identifier");
				name = name.substring(0, 1).toLowerCase() + name.substring(1);
				para.put("java_field_name", name);

				String dataType = para.get("data_type");
				String desc = para.get("remark");

				String javaType = transferFieldType(name, dataType, desc);

				para.put("java_field_type", javaType);

				if (!isCommonType) {
					if (javaType.startsWith("List<")) {
						setExistsType("hasListType");
					}
					if (javaType.contains("Map<")) {
						setExistsType("hasMapType");
					}
					if ("BigDecimal".equals(javaType)) {
						setExistsType("hasBigDecimalType");
					}
					if ("Date".equals(javaType)) {
						setExistsType("hasDateType");
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// private static JavaFileBean buildJavaFileContent(Connection conn, String
	// packageName, BeanType type, Map<String, String> action,
	// List<Map<String, String>> paraList) throws Exception {
	//
	// JavaFileBean result = new JavaFileBean();
	//
	// String url = action.get("request_url");
	//
	// String className = buildClassName(url, type);
	// String classDesc = action.get("name");
	// String subPackage = buildSubPackagePath(url);
	//
	// result.className = className;
	//
	// String myPackageName = packageName;
	// if (StringUtils.isNotEmpty(subPackage)) {
	// myPackageName += ".";
	// myPackageName += subPackage;
	// }
	//
	// List<String> lines = new ArrayList<String>();
	// result.lines = lines;
	// {
	// List<String> classBody = buildClassBody(conn, myPackageName, type,
	// action, paraList);
	//
	// lines.add("package " + myPackageName + ";");
	// result.packageName = myPackageName;
	// lines.add("");
	//
	// if (isExistsType("hasBigDecimalType")) {
	// lines.add("import java.math.BigDecimal;");
	// }
	// if (isExistsType("hasDateType")) {
	// lines.add("import java.util.Date;");
	// }
	// if (isExistsType("hasListType")) {
	// lines.add("import java.util.List;");
	// }
	// if (isExistsType("hasMapType")) {
	// lines.add("import java.util.Map;");
	// }
	//
	// if (isExistsType("hasBigDecimalType") || isExistsType("hasListType") ||
	// isExistsType("hasMapType")
	// || isExistsType("hasDateType")) {
	// lines.add("");
	// }
	//
	// /*
	// if (BeanType.REQUEST.compareTo(type) == 0) {
	// lines.add("import " + packageName + ".RequestBaseDTO;");
	// }
	// else if (BeanType.RESPONSE.compareTo(type) == 0) {
	// lines.add("import " + packageName + ".ResponseBaseDTO;");
	// }
	// else {
	//
	// }
	//
	// lines.add("");
	// */
	//
	// boolean javavalidatorExists = false;
	// for (String javavalidatorName : javavalidatorNameList) {
	// if (isExistsType("javavalidator." + javavalidatorName)) {
	// lines.add("import " + javavalidatorMap.get(javavalidatorName) + ";");
	// javavalidatorExists = true;
	// }
	// }
	//
	// if (javavalidatorExists) {
	// lines.add("");
	// }
	//
	// lines.addAll(buildJavaComment(className, classDesc, url));
	// lines.addAll(classBody);
	// }
	//
	// return result;
	// }

	private static JavaFileBean buildJavaFileContent(Connection conn, String className, String classDesc,
			String packageName, String superClassName, List<Map<String, String>> paraList, String url)
			throws Exception {

		JavaFileBean result = new JavaFileBean();

		String classDesc1 = "公共类型[" + className + "]";

		if (null != classDesc && classDesc.trim().length() > 0) {
			classDesc1 = classDesc;
		}

		result.className = className;

		List<String> lines = new ArrayList<String>();
		result.lines = lines;
		{
			List<String> classBody = buildClassBody(conn, packageName, superClassName, className, paraList);

			lines.add("package " + packageName + ";");
			result.packageName = packageName;
			lines.add("");

			if (isExistsType("hasBigDecimalType")) {
				lines.add("import java.math.BigDecimal;");
			}
			if (isExistsType("hasDateType")) {
				lines.add("import java.util.Date;");
			}
			if (isExistsType("hasListType")) {
				lines.add("import java.util.List;");
			}
			if (isExistsType("hasMapType")) {
				lines.add("import java.util.Map;");
			}

			if (isExistsType("hasBigDecimalType") || isExistsType("hasListType") || isExistsType("hasMapType")
					|| isExistsType("hasDateType")) {
				lines.add("");
			}

			boolean javavalidatorExists = false;
			if (javavalidatorFlag) {
				for (String javavalidatorName : javavalidatorNameList) {
					if (isExistsType("javavalidator." + javavalidatorName)) {
						lines.add("import " + javavalidatorMap.get(javavalidatorName) + ";");
						javavalidatorExists = true;
					}
				}
			}

			if (javavalidatorExists) {
				lines.add("");
			}

			if (commonTypeNameSet.size() > 0) {

				for (String commonTypeName : commonTypeNameSet) {
					lines.add("import " + commontypePackageName + "." + commonTypeName + ";");
				}

				lines.add("");
			}

			lines.addAll(buildJavaComment(className, classDesc1, url));
			lines.addAll(classBody);
		}

		return result;
	}

	// private static List<String> buildClassBody(Connection conn, String
	// packageName, BeanType type, Map<String, String> action,
	// List<Map<String, String>> paraList) throws Exception {
	//
	// String url = action.get("request_url");
	//
	// String className = buildClassName(url, type);
	//
	// List<String> lines = new ArrayList<String>();
	// {
	// if (BeanType.REQUEST.compareTo(type) == 0) {
	// if (isEmpty(superClassRequest)) {
	// lines.add("public class " + className + " {");
	// }
	// else {
	// lines.add("public class " + className + " extends " + superClassRequest +
	// " {");
	// }
	// }
	// else if (BeanType.RESPONSE.compareTo(type) == 0) {
	// if (isEmpty(superClassResponse)) {
	// lines.add("public class " + className + " {");
	// }
	// else {
	// lines.add("public class " + className + " extends " + superClassResponse
	// + " {");
	// }
	// }
	// else {
	// lines.add("public class " + className + " {");
	// }
	// lines.add("");
	//
	// lines.addAll(buildFields("", paraList));
	// lines.addAll(buildSetterAndGetter("", paraList));
	//
	// for (Map<String, String> para : paraList) {
	// String paraDataType = para.get("data_type");
	//
	// if ("array<object>".equals(paraDataType) || "object".equals(paraDataType)
	// || "array<bean>".equals(paraDataType)
	// || "bean".equals(paraDataType)) {
	//
	// String fieldName = para.get("java_field_name");
	// String remark = para.get("remark");
	// String paraId = para.get("id");
	//
	// List<Map<String, String>> subParaList = queryComplexParaList(conn,
	// paraId);
	// List<String> innerClassBody = buildInnerClassBody(conn, INDENT, para,
	// subParaList);
	//
	// // 如果是公用类型，则不用生成内部类
	// if (isCommonType(remark)) {
	// String commonTypeName = buildInnerClassName(fieldName, remark);
	// commonTypeMap.put(commonTypeName, "paraId");
	// }
	// else {
	// lines.addAll(innerClassBody);
	// }
	// }
	//
	// }
	// lines.add("}");
	// }
	//
	// return lines;
	// }

	private static List<String> buildClassBody(Connection conn, String packageName, String superClassName,
			String className, List<Map<String, String>> paraList) throws Exception {

		List<String> lines = new ArrayList<String>();
		{
			if (isEmpty(superClassName)) {
				lines.add("public class " + className + " {");
			} else {
				lines.add("public class " + className + " extends " + superClassName + " {");
			}

			lines.add("");

			lines.addAll(buildFields("", paraList, false));
			if (setterAndGetterFlag) {
				lines.addAll(buildSetterAndGetter("", paraList));
			}

			for (Map<String, String> para : paraList) {
				String paraDataType = para.get("data_type");

				if ("array<object>".equals(paraDataType) || "object".equals(paraDataType)
						|| "array<bean>".equals(paraDataType) || "bean".equals(paraDataType)) {

					String fieldName = para.get("java_field_name");
					String remark = para.get("remark");
					String paraId = para.get("id");

					boolean isCommonType = isCommonType(remark);

					List<Map<String, String>> subParaList = queryComplexParaList(conn, paraId, isCommonType);

					// 如果是公用类型，则不用生成内部类
					if (isCommonType(remark)) {
						String commonTypeName = buildInnerClassName(fieldName, remark);

						// 如果是java基本类型，则不需要生成公共类
						if (!primitiveDataTypes.contains(commonTypeName)) {
							commonTypeNameSet.add(commonTypeName);
							if (isAdvancedCommonType(remark)) {
								commonTypeMap.put(commonTypeName, paraId);
							} else {
								if (!commonTypeMap.containsKey(commonTypeName)) {
									commonTypeMap.put(commonTypeName, paraId);
								}
							}
						}

						// 20180125.修复不能处理嵌套的公共类型的bug.
						buildInnerClassBody(conn, INDENT, para, subParaList, true);
					} else {
						List<String> innerClassBody = buildInnerClassBody(conn, INDENT, para, subParaList, false);
						lines.addAll(innerClassBody);
					}
				}
			}
			lines.add("}");
		}

		return lines;
	}

	private static List<String> buildInnerClassBody(Connection conn, String indent, Map<String, String> mainPara,
			List<Map<String, String>> paraList, boolean isCommonType) throws Exception {

		String fieldName = mainPara.get("java_field_name");
		String remark = mainPara.get("remark");

		String className = buildInnerClassName(fieldName, remark);

		List<String> lines = new ArrayList<String>();
		{

			lines.add(indent + "public static class " + className + " {");
			lines.add("");

			lines.addAll(buildFields(indent, paraList, isCommonType));
			if (setterAndGetterFlag) {
				lines.addAll(buildSetterAndGetter(indent, paraList));
			}

			for (Map<String, String> para : paraList) {
				String paraDataType = para.get("data_type");

				if ("array<object>".equals(paraDataType) || "object".equals(paraDataType)
						|| "array<bean>".equals(paraDataType) || "bean".equals(paraDataType)) {
					// {
					// String paraId = para.get("id");
					// List<Map<String, String>> subParaList =
					// queryComplexParaList(conn, paraId);
					// lines.addAll(buildInnerClassBody(conn, indent + INDENT,
					// para, subParaList));
					// }

					String innerFieldName = para.get("java_field_name");
					String innerRemark = para.get("remark");
					String innerParaId = para.get("id");

					List<Map<String, String>> subParaList = queryComplexParaList(conn, innerParaId,
							(isCommonType || false));

					// 如果是公用类型，则不用生成内部类
					if (isCommonType(innerRemark)) {
						String commonTypeName = buildInnerClassName(innerFieldName, innerRemark);

						// 如果是java基本类型，则不需要生成公共类
						if (!primitiveDataTypes.contains(commonTypeName)) {
							// commonTypeNameSet.add(commonTypeName);
							if (isAdvancedCommonType(innerRemark)) {
								commonTypeMap.put(commonTypeName, innerParaId);
							} else {
								if (!commonTypeMap.containsKey(commonTypeName)) {
									commonTypeMap.put(commonTypeName, innerParaId);
								}
							}
						}

						// 20180125.修复不能处理嵌套的公共类型的bug.
						buildInnerClassBody(conn, indent + INDENT, para, subParaList, true);
					} else {
						List<String> innerClassBody = buildInnerClassBody(conn, indent + INDENT, para, subParaList,
								(isCommonType || false));
						lines.addAll(innerClassBody);
					}
				}
			}

			lines.add(indent + "}");
			lines.add("");
		}

		return lines;
	}

	private static enum BeanType {
		REQUEST, RESPONSE;
	}

	private static List<String> buildJavaComment(String className, String classDesc, String url) {
		List<String> result = new ArrayList<String>();
		result.add("/**");
		result.add(" * <p> Title: " + className + " </p>");
		result.add(" * <p> Description: " + classDesc + " " + url + " </p>");
		result.add(" * <p> Copyright: openlo.cn Copyright (C) 2016 </p>");
		result.add(" *");
		result.add(" * @author auto-generator");
		// result.add(" * @since 2016年10月7日");
		result.add(" * @since " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		result.add(" */");
		return result;
	}

	private static List<String> buildFields(String indent, List<Map<String, String>> paraList, boolean isCommonType) {
		List<String> result = new ArrayList<String>();

		int maxJavaTypeLength = 6;

		for (Map<String, String> para : paraList) {
			String javaFieldType = para.get("java_field_type");

			if (javaFieldType.length() > maxJavaTypeLength) {
				maxJavaTypeLength = javaFieldType.length();
			}
		}

		for (Map<String, String> para : paraList) {
			String fieldName = para.get("java_field_name");
			String javaType = para.get("java_field_type");
			String desc = para.get("name") + para.get("remark");
			String javavalidator = para.get("javavalidator");
			if (!isCommonType) {
				setJavavalidatorExists(javavalidator);
			}

			result.add(indent + INDENT + "// " + desc);
			if (javavalidatorFlag) {
				if (null != javavalidator && javavalidator.trim().length() > 0) {
					result.add(indent + INDENT + javavalidator);
				}
			}
			if (fieldIsPublicFlag) {
				result.add(String.format(indent + INDENT + "public %-" + maxJavaTypeLength + "s %s;", javaType,
						fieldName));
			} else {
				result.add(String.format(indent + INDENT + "private %-" + maxJavaTypeLength + "s %s;", javaType,
						fieldName));
			}
			result.add("");
		}

		return result;
	}

	private static void setJavavalidatorExists(String javavalidator) {
		if (isEmpty(javavalidator)) {
			return;
		}
		String[] arr = javavalidator.split("@");

		for (String s : arr) {
			if (isEmpty(s)) {
				continue;
			}

			int index = s.indexOf("(");
			if (index == 0) {
				continue;
			} else if (index < 0) {
				// do nothing
			} else {
				s = s.substring(0, index);
			}
			setExistsType("javavalidator." + s);
		}
	}

	public static void main(String[] args) {
		setJavavalidatorExists("@VNotEmpty@VNotEmpty(message=\"xxx\")@VLength(min=2,max=10)");
	}

	private static List<String> buildSetterAndGetter(String indent, List<Map<String, String>> paraList) {
		List<String> result = new ArrayList<String>();

		for (Map<String, String> para : paraList) {
			String fieldName = para.get("java_field_name");
			String javaType = para.get("java_field_type");

			String getter = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			result.add(indent + INDENT + "public " + javaType + " " + getter + "() {");
			result.add(indent + INDENT + INDENT + "return " + fieldName + ";");
			result.add(indent + INDENT + "}");
			result.add("");

			String setter = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			result.add(indent + INDENT + "public void " + setter + "(" + javaType + " " + fieldName + ") {");
			result.add(indent + INDENT + INDENT + "this." + fieldName + " = " + fieldName + ";");
			result.add(indent + INDENT + "}");
			result.add("");
		}

		return result;
	}

	private static String buildClassName(String url, BeanType type) {
		String result = "";
		String savedUrl = url;

		url = url.trim();

		if (isEmpty(url)) {
			throw new RuntimeException("无效的url[" + savedUrl + "]");
		}
		if (url.contains(".")) {
			url = url.substring(url.indexOf(".") + 1);

			String[] arr = url.split("\\.");

			for (String s : arr) {
				if (isEmpty(s)) {
					continue;
				}

				result += (s.substring(0, 1).toUpperCase() + s.substring(1));
			}
		} else {
			result = url.substring(0, 1).toUpperCase() + url.substring(1);
		}

		if (isEmpty(result)) {
			throw new RuntimeException("无效的url[" + savedUrl + "]");
		}

		if (BeanType.REQUEST.compareTo(type) == 0) {
			result = result + "Request";
		} else if (BeanType.RESPONSE.compareTo(type) == 0) {
			result = result + "Response";
		} else {
			// do nothing
		}
		return result;
	}

	private static String buildInnerClassName(String fieldName, String remark) {

		if (isCommonType(remark)) {
			remark = remark.trim();

			int index = remark.indexOf("#", 1);

			fieldName = remark.substring(1, index);
		}

		if (primitiveDataTypes.contains(fieldName)) {
			return fieldName;
		}

		String result = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

		if (result.length() > 4 && result.endsWith("List")) {
			result = result.substring(0, result.length() - 4);
		}

		result += "DTO";
		return result;
	}

	private static boolean isCommonType(String remark) {
		if (isEmpty(remark)) {
			return false;
		}

		remark = remark.trim();

		int index = remark.indexOf("#", 1);
		if (index > 1) {
			return true;
		}

		return false;
	}

	/**
	 * 对于公共类型，标记了+的，优先作为DTO来源
	 *
	 * @param remark
	 * @return
	 */
	private static boolean isAdvancedCommonType(String remark) {
		if (isEmpty(remark)) {
			return false;
		}

		remark = remark.trim();

		int index = remark.indexOf("#+", 1);
		if (index > 1) {
			return true;
		}

		return false;
	}

	private static String buildSubPackagePath(String url) {
		String result = "";

		url = url.trim();

		if (isEmpty(url)) {
			return "";
		}

		if (url.contains(".")) {
			url = url.substring(0, url.indexOf("."));
			if (url.length() > 6 && url.startsWith("zuche-")) {
				url = url.substring(6);
			}
			url = url.replaceAll("-", "");
			url = url.replaceAll("_", "");
			result = url.toLowerCase();
		} else {
			result = "";
		}

		return result;
	}

	private static String transferFieldType(String fieldName, String rapType, String remark) {
		String origRemark = remark;

		if (isEmpty(rapType)) {
			rapType = "string";
		}

		rapType = rapType.trim();
		rapType = rapType.toLowerCase();

		remark = remark == null ? "" : remark.trim().toLowerCase();

		String result = "Object";
		if ("".equals(rapType)) {

		} else if ("number".equals(rapType)) {
			if (remark.startsWith("int")) {
				result = "int";
			} else if (remark.startsWith("long")) {
				result = "long";
			} else if (remark.startsWith("double")) {
				result = "double";
			} else if (remark.startsWith("float")) {
				result = "float";
			} else {
				result = "BigDecimal";
			}
		} else if ("string".equals(rapType)) {
			result = "String";
		} else if ("object".equals(rapType)) {
			String innerClassName = buildInnerClassName(fieldName, origRemark);
			result = innerClassName;
		} else if ("boolean".equals(rapType)) {
			result = "boolean";
		} else if ("array<number>".equals(rapType)) {
			if (remark.startsWith("int")) {
				result = "List<Integer>";
			} else if (remark.startsWith("long")) {
				result = "List<Long>";
			} else if (remark.startsWith("double")) {
				result = "List<Double>";
			} else if (remark.startsWith("float")) {
				result = "List<Float>";
			} else {
				result = "List<BigDecimal>";
			}
		} else if ("array<string>".equals(rapType)) {
			result = "List<String>";
		} else if ("array<object>".equals(rapType)) {
			String innerClassName = buildInnerClassName(fieldName, origRemark);
			result = "List<" + innerClassName + ">";
		} else if ("array<boolean>".equals(rapType)) {
			result = "List<Boolean>";
		} else if ("array<map>".equals(rapType)) {
			result = "List<Map<String, Object>>";
		} else if ("map".equals(rapType)) {
			result = "Map<String, Object>";
		} else if ("int".equals(rapType)) {
			result = "int";
		} else if ("long".equals(rapType)) {
			result = "long";
		} else if ("double".equals(rapType)) {
			result = "double";
		} else if ("float".equals(rapType)) {
			result = "float";
		} else if ("date".equals(rapType)) {
			result = "Date";
		} else {
			throw new RuntimeException("无效的rap数据类型[" + rapType + "]");
		}

		return result;
	}

	private static String buildActionSql(RapGeneratorConfig config) {
		String sSql = "select * from tb_action where request_url <> '' ";

		if (null != config && null != config.getRequestUrlList() && config.getRequestUrlList().size() > 0) {
			sSql += " and (" + andOrClause(config.getRequestUrlList()) + ")";
		}
		return sSql;
	}

	private static String andOrClause(List<String> requestUrlList) {

		StringBuilder builder = new StringBuilder();

		for (String url : requestUrlList) {
			if (null == url) {
				continue;
			}
			url = url.replaceAll(" ", "");
			url = url.trim();

			if (url.length() <= 0) {
				continue;
			}

			if (url.contains("'")) {
				throw new RuntimeException("无效的requestUrl[" + url + "]");
			}

			if (url.contains("%")) {
				builder.append(" request_url like '" + url + "' or ");
			} else {
				builder.append(" request_url = '" + url + "' or ");
			}
		}

		if (builder.length() <= 0) {
			builder.append("1=1");
		} else {
			builder.delete(builder.length() - 3, builder.length());
		}

		return builder.toString();
	}

	static class JavaFileBean {

		String packageName;
		String className;
		List<String> lines;
	}

	private static boolean isEmpty(String s) {
		if (null == s) {
			return true;
		}

		s = s.trim();
		if (s.length() <= 0) {
			return true;
		} else {
			return false;
		}
	}
}
