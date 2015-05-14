package ui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import control.*;
import util.*;

@SuppressWarnings("serial")
public class JPanelStart extends JPanel {

	private JPanelGame jPanelGame;
	
	private GameControl gameControl;

	private ButtonExit buttonExit;

	private JButton buttonStart;

	private JButton buttonConig;

	private JButton buttonLoad;

	private JButton buttonAbout;

	private static final Font MYFONT = new Font("黑体", Font.BOLD, 25);

	Dimension screenSize = FrameUtil.SCREEN_SIZE;

	private static final int BUTTON_WIDTH = 160;

	private static final int BUTTON_HEIGHT = 60;

	public JPanelStart(JPanelGame jPanelGame, GameControl gameControl) {
		this.jPanelGame = jPanelGame;
		this.gameControl = gameControl;
		this.setLayout(new BorderLayout());
		this.initComponent();
		this.add(jPanelGame);
	}

	private void initComponent() {
		this.createExitButton();
		this.createStartButton();
		this.createConfigButton();
		this.createLoadButton();
		this.createAboutButton();
	}

	private void createAboutButton() {

		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5 * 4;
		buttonAbout = new JButton("关于我们");
		buttonAbout.setFont(MYFONT);
		buttonAbout.setBounds(startX, startY, BUTTON_WIDTH, BUTTON_HEIGHT);
		this.add(buttonAbout);
	}

	private void createLoadButton() {

		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5 * 2;
		buttonLoad = new JButton("载入存档");
		buttonLoad.setFont(MYFONT);
		buttonLoad.setBounds(startX, startY, BUTTON_WIDTH, BUTTON_HEIGHT);
		this.add(buttonLoad);
	}

	private void createConfigButton() {

		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5 * 3;
		buttonConig = new JButton("设置");
		buttonConig.setFont(MYFONT);
		buttonConig.setBounds(startX, startY, BUTTON_WIDTH, BUTTON_HEIGHT);
		this.add(buttonConig);
	}

	private void createStartButton() {

		int startX = screenSize.width * 3 / 4;
		int startY = screenSize.height / 5;
		buttonStart = new JButton("开始");
		buttonStart.setFont(MYFONT);
		buttonStart.setBounds(startX, startY, BUTTON_WIDTH, BUTTON_HEIGHT);
		buttonStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameControl.startGame();
			}
		});
		this.add(buttonStart);
	}

	private void createExitButton() {

		buttonExit = new ButtonExit(Img.EXIT_DARK, Img.EXIT_LIGHT);
		buttonExit.setBounds(screenSize.width - 26, 8, 14, 14);
		this.add(buttonExit);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Img.BG_START, 0, 0, screenSize.width, screenSize.height,
				null);
	}

}
