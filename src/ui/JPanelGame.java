package ui;

import java.awt.*;

import javax.swing.*;

import control.*;
import dto.*;
import entity.*;
import util.*;

@SuppressWarnings("serial")
public class JPanelGame extends JPanel {

	private GameDto dto;

	private GameAct act;

	private BattleAct battleAct;

	private GameControl gameControl;

	private ButtonExit buttonExit;
	
	private static final int SCREEN_H;
	
	private static final int SCREEN_W;

	private static final int EXIT_X;
	
	private static final int EXIT_Y;
	
	private static final int EXIT_W;
	
	private static final int EXIT_H;
	
	static {
		SCREEN_H = FrameUtil.SCREEN_SIZE.height;
		SCREEN_W = FrameUtil.SCREEN_SIZE.width;
		EXIT_X = (int) (0.95 * SCREEN_W);
		EXIT_Y = (int) (0.01 * SCREEN_H);
		EXIT_W = 72;
		EXIT_H = 72;
	}
	
	public JPanelGame(GameControl gameControl, GameDto dto) {
		this.gameControl = gameControl;
		this.dto = dto;
		this.setLayout(null);
		this.initComponent();
		this.addKeyListener(new PlayerControl(gameControl));
	}

	private void initComponent() {

		buttonExit = new ButtonExit(Img.GAME_EXIT_DARK, Img.GAME_EXIT_LIGHT);
		buttonExit.setBounds(EXIT_X, EXIT_Y, EXIT_W, EXIT_H);
		this.add(buttonExit);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Img.BG_GAME, 0, 0, FrameUtil.SCREEN_SIZE.width,
				FrameUtil.SCREEN_SIZE.height, null);
		this.act = dto.getGameAct();
		
		// 值槽窗口
		new WindowLevel(0.4, 0.01, 0.35, 0.05).paint(g);
		
		g.drawImage(act.getStarImage(), act.getStarLocation().x,
				act.getStarLocation().y, GameAct.STAR_SIZE, GameAct.STAR_SIZE,
				null);
		this.battleAct = dto.getBattleAct();
		battleAct.battleMove(g,
				this.battleAct.fixPosition(act.getStarLocation()));

		// 返回焦点
		this.requestFocus();
	}

}
