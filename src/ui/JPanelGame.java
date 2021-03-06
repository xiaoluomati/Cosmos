package ui;

import java.awt.*;

import javax.swing.*;

import control.*;
import dto.GameDto;
import entity.BattleAct;
import entity.GameAct;
import util.FrameUtil;

@SuppressWarnings("serial")
public class JPanelGame extends JPanel {

	private GameDto dto;

	private GameAct act;

	private BattleAct battleAct;
	
	private GameControl gameControl;

	private ButtonExit buttonExit;

	public JPanelGame(GameControl gameControl, GameDto dto) {
		this.gameControl = gameControl;
		this.dto = dto;
		this.setLayout(null);
		this.initComponent();
		this.addKeyListener(new PlayerControl(gameControl));
	}

	private void initComponent() {

		buttonExit = new ButtonExit(Img.GAME_EXIT_DARK, Img.GAME_EXIT_LIGHT);
		buttonExit.setBounds(FrameUtil.SCREEN_SIZE.width - 28, 8, 18, 18);
		this.add(buttonExit);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Img.BG_GAME, 0, 0, FrameUtil.SCREEN_SIZE.width,
				FrameUtil.SCREEN_SIZE.height, null);
		this.act = dto.getGameAct();
		
		g.drawImage(act.getStarImage(), act.getStarLocation().x,
				act.getStarLocation().y, GameAct.STAR_SIZE, GameAct.STAR_SIZE,
				null);
		this.battleAct = dto.getBattleAct();
                battleAct.battleMove(g,this.battleAct.fixPosition(act.getStarLocation()));
		this.requestFocus();
	}

}
