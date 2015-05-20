package config;

import org.dom4j.*;

public class DataConfig {
	
	private final DataInterfaceConfig dataA;
	
	public DataConfig(Element data) {
		dataA = new DataInterfaceConfig(data.element("dataA"));
	}

	public DataInterfaceConfig getDataA() {
		return dataA;
	}
	
}
