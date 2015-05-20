package config;

import org.dom4j.*;
import org.dom4j.io.*;

public class GameConfig {
	
	private static FrameConfig FRAME_CONFIG;
	
	private static SystemConfig SYSTEM_CONFIG;
	
	private static DataConfig DATA_CONFIG;
	
	static {
		Element game = null;
		try {
			// 创建 XML 读取器
			SAXReader reader = new SAXReader();
			// 读取 XML 文件
			Document doc = reader.read("data/config.xml");
			game = doc.getRootElement();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		// 获得 XML 根节点
		FRAME_CONFIG = new FrameConfig(game.element("frame"));
		SYSTEM_CONFIG = new SystemConfig(game.element("system"));
		DATA_CONFIG = new DataConfig(game.element("data"));
	}
	
	private GameConfig() {}
	
	public static FrameConfig getFRAME_CONFIG() {
		return FRAME_CONFIG;
	}

	public static SystemConfig getSYSTEM_CONFIG() {
		return SYSTEM_CONFIG;
	}

	public static DataConfig getDATA_CONFIG() {
		return DATA_CONFIG;
	}
	
	
}
