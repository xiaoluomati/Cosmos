package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import control.*;
import util.*;

@SuppressWarnings("serial")
public class JPanelStart extends JPanel {
	
	private GameControl gameControl;
	
	private ButtonExit buttonExit;
	
	private JButton buttonStart;
	
	private JButton buttonConig;
	
	private JButton buttonLoad;
	
	private JButton buttonAbout;
	
	private static final Font MYFONT = new Font("黑体", Font.BOLD, 25);
	
	Dimension screenSize = FrameUtil.SCREEN_SIZE;
	

	public JPanelStart(GameControl gameControl) {
		this.gameControl = gameControl;
		this.setLayout(null);
		this.initComponent();
	}

	private void initComponent() {
		this.createExitButton();
		this.createStartButton();
		this.createConfigButton();
		this.createLoadButton();
		this.createAboutButton();
	}
	
	private void createAboutButton() {
		int w = 160;
		int h = 60;
		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5 * 4;
		buttonAbout = new JButton("关于我们");
		buttonAbout.setFont(MYFONT);
		buttonAbout.setBounds(startX, startY, w, h);
		this.add(buttonAbout);
	}

	private void createLoadButton() {
		int w = 160;
		int h = 60;
		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5 * 2;
		buttonLoad = new JButton("载入存档");
		buttonLoad.setFont(MYFONT);
		buttonLoad.setBounds(startX, startY, w, h);
		this.add(buttonLoad);
	}

	private void createConfigButton() {
		int w = 160;
		int h = 60;
		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5 * 3;
		buttonConig = new JButton("设置");
		buttonConig.setFont(MYFONT);
		buttonConig.setBounds(startX, startY, w, h);
		this.add(buttonConig);
	}

	private void createStartButton() {
		int w = 160;
		int h = 60;
		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5;
		buttonStart = new JButton("开始");
		buttonStart.setFont(MYFONT);
		buttonStart.setBounds(startX, startY, w, h);
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gameControl.startGame();
			}
		});
		this.add(buttonStart);
	}

	private void createExitButton() {
		
		buttonExit= new ButtonExit(Img.EXIT_DARK, Img.EXIT_LIGHT);
		buttonExit.setBounds(screenSize.width - 26, 8, 14, 14);
		this.add(buttonExit);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Img.BG_START, 0, 0, screenSize.width, screenSize.height, null);
	}

}











