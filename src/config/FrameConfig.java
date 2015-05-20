package config;

import org.dom4j.*;

public class FrameConfig {
	
	private final int bottonWidth;
	
	private final int bottonHeight;
	
	// 值槽 x 坐标占比
	private final double expXRatio;
	
	// 值槽 y 坐标占比
	private final double expYRatio;
	
	// 值槽长度占比
	private final double expWRatio;
	
	// 值槽宽度占比
	private final double expHRatio;
	
	public FrameConfig(Element frame) {
		// 获取按钮宽度
		this.bottonWidth = Integer.parseInt(frame.attributeValue("buttonW"));
		// 获取按钮高度
		this.bottonHeight = Integer.parseInt(frame.attributeValue("buttonH"));
		// 获取值槽 x 坐标占比
		this.expXRatio = Double.parseDouble(frame.attributeValue("expXRatio"));
		// 获取值槽 y 坐标占比
		this.expYRatio = Double.parseDouble(frame.attributeValue("expYRatio"));
		// 获取值槽长度占比
		this.expWRatio = Double.parseDouble(frame.attributeValue("expWRatio"));
		// 获取值槽宽度占比
		this.expHRatio = Double.parseDouble(frame.attributeValue("expHRatio"));
	}

	public int getBottonWidth() {
		return bottonWidth;
	}

	public int getBottonHeight() {
		return bottonHeight;
	}

	public double getExpXRatio() {
		return expXRatio;
	}

	public double getExpYRatio() {
		return expYRatio;
	}

	public double getExpWRatio() {
		return expWRatio;
	}

	public double getExpHRatio() {
		return expHRatio;
	}
	
	
}
