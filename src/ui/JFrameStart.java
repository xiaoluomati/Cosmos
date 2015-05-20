package ui;

import javax.swing.*;

import util.*;

@SuppressWarnings("serial")
public class JFrameStart extends JFrame {

	public JFrameStart(JPanelStart jPanelStart) {

		this.setSize(FrameUtil.SCREEN_SIZE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setUndecorated(true);
		this.add(jPanelStart);
		this.setVisible(true);
	}
}
