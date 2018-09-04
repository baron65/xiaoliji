package com.tts.xiaoliji.intf.base.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;

public class ParamUtil {
	private static Log log = LogFactory.getLog(ParamUtil.class);

	@Deprecated
	public static ParamMap newMap() {
		return new ParamMap(new HashMap());
	}

	@Deprecated
	public static <T> ParamBean<T> newBean(Class<T> beanType) {
		try {
			return new ParamBean(beanType.newInstance());
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	@Deprecated
	public static ParamList newList() {
		return new ParamList(new ArrayList());
	}

	@Deprecated
	public static <T> ParamBean<T> processBean(T bean) {
		return new ParamBean(bean);
	}

	@Deprecated
	public static <T> ParamMap processMap(Map map) {
		return new ParamMap(map);
	}

	@Deprecated
	public static ParamList processList(List list) {
		return new ParamList(list);
	}

	public static Map printBean(Object bean) {
		Map map = new HashMap();
		if (bean == null) {
			return map;
		}
		try {
			map.put("TYPE", bean.getClass());
			map.put("JSON", JSON.toJSONString(bean));

			return map;
		} catch (Exception e) {
			log.error("printBean error : " + e.getMessage(), e);

			map.put("JSON", "Bean解析失败");
		}
		return map;
	}

	public static Map bean2Map(Object bean) {
		Map result = new HashMap();
		try {
			if (bean == null) {
				return result;
			}
			if ((bean.getClass().isPrimitive()) || (bean.getClass().getName().startsWith("java"))) {
				result.put("value", bean);
				return result;
			}
			PropertyDescriptor[] srcPds = PropertyUtils.getPropertyDescriptors(bean.getClass());
			for (PropertyDescriptor srcPd : srcPds) {
				if (srcPd.getReadMethod() != null) {
					String property = srcPd.getName();
					if (!Class.class.equals(srcPd.getPropertyType())) {
						Object o = getProperty(bean, property);
						if (o != null) {
							if (srcPd.getPropertyType().isArray()) {
								Class clazz = srcPd.getPropertyType().getComponentType();
								if ((clazz.isPrimitive()) || (Number.class.isAssignableFrom(clazz))
										|| (String.class.equals(clazz)) || (Character.class.equals(clazz))
										|| (Boolean.class.equals(clazz))) {
									result.put(property, o);
								} else {
									int len = Array.getLength(o);
									Object arr = Array.newInstance(Object.class, len);
									for (int i = 0; i < len; i++) {
										Object v = Array.get(o, i);
										if (v == null) {
											Array.set(arr, i, null);
										} else {
											Array.set(arr, i, bean2Map(v));
										}
									}
									result.put(property, arr);
								}
							} else if (Map.class.isAssignableFrom(srcPd.getPropertyType())) {
								Map map = (Map) o;
								Iterator i = map.entrySet().iterator();
								while (i.hasNext()) {
									Map.Entry entry = (Map.Entry) i.next();
									Object v = entry.getValue();
									if (v != null) {
										entry.setValue(bean2Map(v));
									}
								}
								Map res = new HashMap(map.size());
								res.putAll(map);

								result.put(property, res);
							} else if (Collection.class.isAssignableFrom(srcPd.getPropertyType())) {
								List list = new ArrayList(((Collection) o).size());
								for (Object v : (Collection) o) {
									if (v != null) {
										list.add(bean2Map(v));
									} else {
										list.add(null);
									}
								}
								result.put(property, list);
							} else {
								if ((!srcPd.getPropertyType().isPrimitive())
										&& (!srcPd.getPropertyType().getName().startsWith("java"))) {
									result.put(property, bean2Map(o));
								}
								result.put(property, o);
							}
						}
					}
				}
			}
		} catch (Throwable e) {
			log.error("bean2Map transfer error", e);
		}
		return result;
	}

	public static class ParamMap {
		private Map map;
		private long startTime;

		public ParamMap(Map map) {
			this.startTime = System.currentTimeMillis();
			this.map = map;
		}

		public ParamMap set(String key, Object value) {
			this.map.put(key, value);
			return this;
		}

		public ParamMap set(Object bean) {
			this.map.putAll(ParamUtil.describe(bean, new String[0]));
			return this;
		}

		public ParamMap set(Object bean, String... properties) {
			this.map.putAll(ParamUtil.describe(bean, properties));
			return this;
		}

		public Map build() {
			long buildTime = System.currentTimeMillis() - this.startTime;

			ParamUtil.log.debug("===BUILD MAP===" + this.map + " ===ELAPSED TIME===" + buildTime + "ms");
			return this.map;
		}
	}

	public static class ParamBean<T> {
		private T target;
		private long startTime;

		public ParamBean(T newInstance) {
			this.target = newInstance;
			this.startTime = System.currentTimeMillis();
		}

		public ParamBean<T> set(String property, Object value) {
			ParamUtil.setProperty(this.target, property, value);

			return this;
		}

		public ParamBean<T> set(Object bean) {
			return set(bean, new String[0]);
		}

		public ParamBean<T> set(Object bean, String... properties) {
			if (bean == null) {
				return this;
			}
			if ((bean.getClass().isPrimitive()) || (bean.getClass().getName().startsWith("java"))) {
				ParamUtil.log.error("set error , Object is not Bean " + bean + "beanType:" + bean.getClass());
				return this;
			}
			if ((bean instanceof Map)) {
				return set((Map) bean, properties);
			}
			PropertyDescriptor[] targetPds = PropertyUtils.getPropertyDescriptors(this.target.getClass());
			PropertyDescriptor[] srcPds = PropertyUtils.getPropertyDescriptors(bean.getClass());
			for (PropertyDescriptor targetPd : targetPds) {
				String property = targetPd.getName();
				if ((properties == null) || (properties.length <= 0) || (ArrayUtils.contains(properties, property))) {
					PropertyDescriptor srcPd = ParamUtil.getMatchPropertyDescriptor(srcPds, property);
					if (srcPd != null) {
						if (!targetPd.getPropertyType().isArray()) {
							if (!Collection.class.isAssignableFrom(targetPd.getPropertyType())) {
								if (!Map.class.isAssignableFrom(targetPd.getPropertyType())) {
									if (!Class.class.equals(targetPd.getPropertyType())) {
										if ((targetPd.getWriteMethod() != null) && (srcPd.getReadMethod() != null)) {
											Object o = ParamUtil.getProperty(bean, property);
											if (o != null) {
												ParamUtil.setProperty(this.target, property, o);
											}
										}
									}
								}
							}
						}
					}
				}
			}
			return this;
		}

		public ParamBean<T> set(Map map, String... properties) {
			PropertyDescriptor[] targetPds = PropertyUtils.getPropertyDescriptors(this.target.getClass());
			for (PropertyDescriptor targetPd : targetPds) {
				String property = targetPd.getName();
				if (!targetPd.getPropertyType().isArray()) {
					if (!Collection.class.isAssignableFrom(targetPd.getPropertyType())) {
						if (!Map.class.isAssignableFrom(targetPd.getPropertyType())) {
							if (!Class.class.equals(targetPd.getPropertyType())) {
								if ((properties == null) || (properties.length <= 0)
										|| (ArrayUtils.contains(properties, property))) {
									if (map.containsKey(property)) {
										Object o = map.get(property);
										if (o != null) {
											ParamUtil.setProperty(this.target, property, o);
										}
									}
								}
							}
						}
					}
				}
			}
			return this;
		}

		public T build() {
			long buildTime = System.currentTimeMillis() - this.startTime;
			ParamUtil.log.debug("===BUILD BEAN===" + this.target.getClass() + " " + ParamUtil.bean2Map(this.target)
					+ " ===ELAPSED TIME===" + buildTime + "ms");

			return (T) this.target;
		}
	}

	public static class ParamList {
		List list;
		private long startTime;

		public ParamList(List list) {
			this.list = list;
		}

		public void set(Object bean) {
			this.list.add(bean);
		}

		public List build() {
			long buildTime = System.currentTimeMillis() - this.startTime;
			ParamUtil.log.debug("===BUILD LIST===" + this.list + " ===ELAPSED TIME===" + buildTime + "ms");
			return this.list;
		}
	}

	private static void setProperty(Object obj, String property, Object value) {
		try {
			PropertyUtils.setProperty(obj, property, value);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage(), e);
		}
	}

	private static Object getProperty(Object obj, String property) {
		try {
			return PropertyUtils.getProperty(obj, property);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
		} catch (NoSuchMethodException e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	private static PropertyDescriptor getMatchPropertyDescriptor(PropertyDescriptor[] srcPds, String property) {
		for (PropertyDescriptor srcPd : srcPds) {
			if (srcPd.getName().equals(property)) {
				return srcPd;
			}
		}
		return null;
	}

	private static Map describe(Object bean, String... properties) {
		Map result = new HashMap();
		if (bean == null) {
			return result;
		}
		if ((bean.getClass().isPrimitive()) || (bean.getClass().getName().startsWith("java"))) {
			result.put("value", bean);
			return result;
		}
		PropertyDescriptor[] srcPds = PropertyUtils.getPropertyDescriptors(bean.getClass());
		for (PropertyDescriptor srcPd : srcPds) {
			String property = srcPd.getName();
			if ((properties == null) || (properties.length <= 0) || (ArrayUtils.contains(properties, property))) {
				Object o = getProperty(bean, property);
				if (o != null) {
					if (!srcPd.getPropertyType().isArray()) {
						if (!Collection.class.isAssignableFrom(srcPd.getPropertyType())) {
							if (!Map.class.isAssignableFrom(srcPd.getPropertyType())) {
								if (!Class.class.equals(srcPd.getPropertyType())) {
									if (o != null) {
										result.put(property, o);
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
}
