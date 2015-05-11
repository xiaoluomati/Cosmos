package control;

import service.GameService;
import ui.JPanelGame;

public class GameControl {
	
	private GameService gameService;
	
	private JPanelGame panelGame;
	
	public GameControl(GameService gameService,JPanelGame panelGame) {
		this.gameService = gameService;
		this.panelGame = panelGame;
	}
	
	public void startGame() {
		this.gameService.startGame();
	}

	 /**
         * 控制方向键（上）
         */
        public void keyUp() {
                this.gameService.keyUp();
                this.panelGame.repaint();
        }
        /**
         * 控制方向键（下）
         */
        public void keyDown() {
                this.gameService.keyDown();
                this.panelGame.repaint();
        }
        /**
         * 控制方向键（左）
         */
        public void keyLeft() {
                this.gameService.keyLeft();
                this.panelGame.repaint();
        }
        /**
         * 控制方向键（右）
         */
        public void keyRight() {
                this.gameService.keyRight();
                this.panelGame.repaint();
        }
        
}
