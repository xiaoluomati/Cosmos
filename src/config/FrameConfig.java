package config;

import org.dom4j.*;

public class FrameConfig {
	
	private final int bottonWidth;
	
	private final int bottonHeight;
	
	public FrameConfig(Element frame) {
		// 获取按钮宽度
		this.bottonWidth = Integer.parseInt(frame.attributeValue("buttonW"));
		// 获取按钮高度
		this.bottonHeight = Integer.parseInt(frame.attributeValue("buttonH"));
	}

	public int getBottonWidth() {
		return bottonWidth;
	}

	public int getBottonHeight() {
		return bottonHeight;
	}
	
}
