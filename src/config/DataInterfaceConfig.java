package config;

import java.util.*;

import org.dom4j.*;

public class DataInterfaceConfig {
	
	private final String className;
	
	private final Map<String, String> param;
	
	public DataInterfaceConfig(Element dataInterface) {
		this.className = dataInterface.attributeValue("className");
		
		param = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<Element> params = dataInterface.elements("param");
		for (Element p : params) {
			param.put(p.attributeValue("key"), p.attributeValue("value"));
		}
	}

	public String getClassName() {
		return className;
	}

	public Map<String, String> getParam() {
		return param;
	}
	
	
}
