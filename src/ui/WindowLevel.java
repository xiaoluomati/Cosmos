package ui;

import java.awt.*;

import config.*;

public class WindowLevel extends Window {
	
	private final int expX;
	
	private final int expY;
	
	private final int expW;
	
	private final int expH;
	
	public WindowLevel(double ratioX, double ratioY, double ratioW, double ratioH) {
		super(ratioX, ratioY, ratioW, ratioH);
		FrameConfig frameConfig = GameConfig.getFRAME_CONFIG();
		expX = (int) (frameConfig.getExpXRatio() * this.w);
		expY = (int) (frameConfig.getExpYRatio() * this.h);
		expW = (int) (frameConfig.getExpWRatio() * this.w);
		expH = (int) (frameConfig.getExpHRatio() * this.h);
	}

	@Override
	public void paint(Graphics g) {
		this.createWindow(g);
		this.drawRect(this.x + expX, this.y + expY, expW, expH, this.gameDto.getNowPoint(), 30, g);
		g.drawImage(Img.LVEVL, this.x + 30, this.y + expY, null);
		this.drawNumber(this.x + Img.LVEVL.getWidth(null) + 50, 
						this.y + (expY >> 1), 
						this.gameDto.getNowLevel(), 
						g);
	}

	/**
	 * @param expX 左上角 x 坐标
	 * @param expY 左上角 y 坐标
	 * @param expLength 值槽长度
	 * @param content 值槽表示的内容
	 * @param maxLength 值槽最大容量
	 * @param g 画笔对象
	 */
	protected void drawRect(int expX, int expY, int expW, int expH, int content,
			double maxLength, Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(expX, expY, expW, expH);
		g.setColor(Color.WHITE);
		g.fillRect(expX + 1, expY + 1, expW - 2, expH - 2);
		g.setColor(new Color(30, 20, 40));
		g.fillRect(expX + 2, expY + 2, expW - 4, expH - 4);

		double length = content % maxLength / maxLength * (expW - 4);
		g.setColor(getNowColor(content % maxLength, maxLength));
		g.fillRect(expX + 2, expY + 2, (int) length, expH - 4);
	}

	/**
	 * 颜色渐变
	 * @param len
	 * @param maxLen
	 * @return
	 */
	private Color getNowColor(double len, double maxLen) {
		int colorR = 0;
		int colorG = 255;
		int colorB = 0;
		double halfLen = maxLen / 2;
		if (len > halfLen) {
			colorR = 255 - (int) ((len - halfLen) / (maxLen / 2) * 255);
			colorG = 255;
		} else {
			colorR = 255;
			colorG = (int) (len / (maxLen / 2) * 255);
		}
		return new Color(colorR, colorG, colorB);
	}
}
