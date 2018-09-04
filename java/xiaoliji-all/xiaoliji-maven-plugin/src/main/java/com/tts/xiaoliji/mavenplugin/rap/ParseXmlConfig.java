package com.tts.xiaoliji.mavenplugin.rap;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.tts.xiaoliji.mavenplugin.rap.RapGeneratorConfig.Javavalidator;

public class ParseXmlConfig {

	@SuppressWarnings("unchecked")
	public static RapGeneratorConfig parse(File file) throws Exception {
		RapGeneratorConfig result = new RapGeneratorConfig();

		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();

		Iterator<Element> nodes = root.elementIterator();

		while (nodes.hasNext()) {
			Element node = nodes.next();

			String nodeName = node.getName().trim();

			if ("property".equals(nodeName)) {
				String key = node.attributeValue("name");
				String value = node.attributeValue("value");
				result.setProperty(key, value);
			}

			if ("excludeResponseParas".equals(nodeName)) {
				List<String> valueList = new ArrayList<>();
				result.setExcludeResponseParaList(valueList);

				Iterator<Element> subNodes = node.elementIterator("value");
				while (subNodes.hasNext()) {
					Element subNode = subNodes.next();
					valueList.add(subNode.attributeValue("name"));
				}
			}

			if ("excludeRequestParas".equals(nodeName)) {
				List<String> valueList = new ArrayList<>();
				result.setExcludeRequestParaList(valueList);

				Iterator<Element> subNodes = node.elementIterator("value");
				while (subNodes.hasNext()) {
					Element subNode = subNodes.next();
					valueList.add(subNode.attributeValue("name"));
				}
			}

			if ("primitiveDataTypes".equals(nodeName)) {
				List<String> valueList = new ArrayList<>();
				result.setPrimitiveDataTypeList(valueList);

				Iterator<Element> subNodes = node.elementIterator("value");
				while (subNodes.hasNext()) {
					Element subNode = subNodes.next();
					valueList.add(subNode.attributeValue("name"));
				}
			}

			if ("requestUrls".equals(nodeName)) {
				List<String> valueList = new ArrayList<>();
				result.setRequestUrlList(valueList);

				Iterator<Element> subNodes = node.elementIterator("value");
				while (subNodes.hasNext()) {
					Element subNode = subNodes.next();
					valueList.add(subNode.attributeValue("name"));
				}
			}

			if ("javavalidators".equals(nodeName)) {
				List<Javavalidator> javavalidatorList = new ArrayList<>();
				result.setJavavalidatorList(javavalidatorList);

				Iterator<Element> subNodes = node.elementIterator("javavalidator");
				while (subNodes.hasNext()) {
					Element subNode = subNodes.next();

					Javavalidator javavalidator = new Javavalidator();
					javavalidator.setAnnotationName(subNode.attributeValue("annotationName"));
					javavalidator.setAnnotationClass(subNode.attributeValue("annotationClass"));
					javavalidatorList.add(javavalidator);
				}
			}
		}

		return result;
	}
}
