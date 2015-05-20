package service;

import java.util.Random;
import config.GameConfig;
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

	private JPanelGame jPanelGame;

	private JFrameStart frameStart;
	
	public GameService(JPanelGame jPanelGame, GameDto dto) {
		this.jPanelGame = jPanelGame;
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(GameAct.MAX_TYPE));
		dto.setGameAct(act);
	}

	public void percentIncrease(){
	        this.dto.getGameAct().setPercent(this.dto.getPercent() + 0.01);
	}
	
	public void levelUp() {
	        if (this.dto.getPercent() == 1.0) {
	                this.dto.getGameAct().setNowLevel(this.dto.getNowLevel() + 1);
	                this.dto.getGameAct().setPercent(0.0);
                }       
        }

	public void startGame() {
		this.frameStart.add(jPanelGame);
	}

	public void setFrameStart(JFrameStart frameStart) {
		this.frameStart = frameStart;
	}
	
	/**
	 * 移动幅度
	 */
	private static int moveStep = GameConfig.getSYSTEM_CONFIG().getMoveStep();

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

    public void TESTkeyE() {
                
    }

}
