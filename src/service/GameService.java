package service;

import java.util.Random;
import dto.GameDto;
import entity.GameAct;
import ui.*;

public class GameService {
	
	/**
	 * 游戏数据对象
	 */
	private GameDto dto;
	/**
	 * 随机数生成器
	 */
	private Random random = new Random();

	private JPanelGame panelGame;

	private JFrameStart frameStart;

	public GameService(JPanelGame panelGame, GameDto dto) {
		this.panelGame = panelGame;
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(GameAct.MAX_TYPE));
		dto.setGameAct(act);
	}

	public void startGame() {
		this.frameStart.add(panelGame);
	}

	public void setFrameStart(JFrameStart frameStart) {
		this.frameStart = frameStart;
	}

	// TODO 确定移动幅度
	private static int moveStep = 9;

	public void keyUp() {
		this.dto.getGameAct().starMove(0, -moveStep);
	}

	public void keyDown() {
		this.dto.getGameAct().starMove(0, moveStep);
	}

	public void keyLeft() {
		this.dto.getGameAct().starMove(-moveStep, 0);
	}

	public void keyRight() {
		this.dto.getGameAct().starMove(moveStep, 0);
	}

}
