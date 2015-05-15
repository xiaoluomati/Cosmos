package control;

import dto.*;
import service.*;
import ui.*;

public class GameControl {
    
	private JFrameStart jFrameStart;
	
	// 游戏数据源
	private GameDto gameDto;
	
	// 游戏开始面板
	private JPanelStart jPanelStart;
	
	// 游戏逻辑块
	private GameService gameService;
	
	// 游戏主面板
	private JPanelGame jPanelGame;
	
	public GameControl() {
		// 创建游戏数据源
		this.gameDto = new GameDto();
		// 创建游戏开始面板
		this.jPanelStart = new JPanelStart(this);
		// 创建游戏主面板
		this.jPanelGame = new JPanelGame(this, gameDto);
		// 创建游戏逻辑块
		this.gameService = new GameService(jPanelGame, gameDto);
		
		this.jFrameStart = new JFrameStart(jPanelStart);
		this.gameService.setFrameStart(jFrameStart);
	}
	
	public void startGame() {
		this.gameService.startGame();
	}

	 /**
         * 控制方向键（上）
         */
        public void keyUp() {
                this.gameService.keyUp();
                this.jPanelGame.repaint();
        }
        /**
         * 控制方向键（下）
         */
        public void keyDown() {
                this.gameService.keyDown();
                this.jPanelGame.repaint();
        }
        /**
         * 控制方向键（左）
         */
        public void keyLeft() {
                this.gameService.keyLeft();
                this.jPanelGame.repaint();
        }
        /**
         * 控制方向键（右）
         */
        public void keyRight() {
                this.gameService.keyRight();
                this.jPanelGame.repaint();
        }
        
}
