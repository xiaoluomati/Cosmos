package ui;

import java.awt.*;

import javax.swing.*;

import util.FrameUtil;

@SuppressWarnings("serial")
public class JPanelGame extends JPanel {
	
	private ButtonExit buttonExit;
	
	public JPanelGame() {
		this.setLayout(null);
		this.initComponent();
	}
	
	private void initComponent() {
		
		buttonExit= new ButtonExit(Img.GAME_EXIT_DARK, Img.GAME_EXIT_LIGHT);
		buttonExit.setBounds(FrameUtil.SCREEN_SIZE.width - 28, 8, 18, 18);
		this.add(buttonExit);		
	}

	public void paintComponent(Graphics g) {
		g.drawImage(Img.BG_GAME, 0, 0, 
				FrameUtil.SCREEN_SIZE.width, 
				FrameUtil.SCREEN_SIZE.height, 
				null);
		
	}
}
