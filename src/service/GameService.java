package service;

import dto.GameDto;
import ui.*;

public class GameService {
        /**
         * 游戏数据对象
         */
        private GameDto dto;

	private JPanelGame panelGame;
	
	private JFrameStart frameStart;
	
	public GameService(JPanelGame panelGame) {
		this.panelGame = panelGame;
	}
	
	public void startGame() {
		this.frameStart.add(panelGame);
	}

	public void setFrameStart(JFrameStart frameStart) {
		this.frameStart = frameStart;
	}

	//TODO 确定移动幅度
        public void keyUp() {
                this.dto.getGameAct().starMove(0, -1);
        }

        public void keyDown() {
                this.dto.getGameAct().starMove(0, 1);
        }

        public void keyLeft() {
                this.dto.getGameAct().starMove(-1, 0);
        }

        public void keyRight() {
                this.dto.getGameAct().starMove(1, 0);
        }

}
