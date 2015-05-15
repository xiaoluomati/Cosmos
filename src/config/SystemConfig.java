package config;

import org.dom4j.*;

public class SystemConfig {
	
	// 星球数量
	private final int numOfStar;
	
	// 星球大小
	private final int sizeOfStar;
	
	// 感应区域
	private final int nearSide;
	
	// 移动步长
	private final int moveStep;
	
	public SystemConfig(Element system) {
		// 获取星球数量
		numOfStar = Integer.parseInt(system.attributeValue("numOfStar"));
		// 获取星球大小
		sizeOfStar = Integer.parseInt(system.attributeValue("sizeOfStar"));
		// 获取感应区域
		nearSide = Integer.parseInt(system.attributeValue("nearSide"));
		// 获取移动步长
		moveStep = Integer.parseInt(system.attributeValue("moveStep"));
	}

	public int getNumOfStar() {
		return numOfStar;
	}

	public int getSizeOfStar() {
		return sizeOfStar;
	}

	public int getNearSide() {
		return nearSide;
	}

	public int getMoveStep() {
		return moveStep;
	}
	
}
