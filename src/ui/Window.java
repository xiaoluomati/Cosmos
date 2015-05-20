package ui;

import java.awt.*;

import dto.*;
import util.*;

abstract public class Window {
	
	// 窗口左上角 x 坐标
	protected int x;
	
	// 窗口左上角 y 坐标
	protected int y;
	
	// 窗口高度
	protected int w;
	
	// 窗口宽度
	protected int h;
	
	// 屏幕宽度
	protected static final int SCREEN_W = FrameUtil.SCREEN_SIZE.width;
	
	// 屏幕高度
	protected static final int SCREEN_H = FrameUtil.SCREEN_SIZE.height;
	
	// 每个数字的宽度
	protected static final int NUMBER_W = Img.NUMBER.getWidth(null) / 10;

	// 数字高度
	protected static final int NUMBER_H = Img.NUMBER.getHeight(null);
	
	protected GameDto gameDto = null;
	
	public Window(double ratioX, double ratioY, double ratioW, double ratioH) {
		this.x = (int)(ratioX * SCREEN_W);
		this.y = (int)(ratioY * SCREEN_H);
		this.w = (int)(ratioW * SCREEN_W);
		this.h = (int)(ratioH * SCREEN_H);
	}
	
	abstract public void paint(Graphics g);
	
	protected void createWindow(Graphics g) {
		g.drawImage(Img.WINDOW, this.x, this.y, this.w, this.h, null);
	}
	
	/**
	 * 画数字
	 * @param startX
	 * @param startY
	 * @param number 要显示的数字
	 * @param g
	 */
	protected void drawNumber(int startX, int startY, int number, Graphics g) {
		
		String num = Integer.toString(number);
		int bin = 0;
		
		for (int i = 0; i < num.length(); i++) {
			bin = num.charAt(i) - '0';
			g.drawImage(Img.NUMBER, 
						startX + i * NUMBER_W, 
						startY, 
						startX + (i + 1) * NUMBER_W, 
						startY + NUMBER_H,
						bin * NUMBER_W, 0,
						(bin + 1) * NUMBER_W, NUMBER_H,
						null);
		}
	}
	
	public void setGameDto(GameDto gameDto) {
		this.gameDto = gameDto;
	}
}
