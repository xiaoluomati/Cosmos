package main;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.*;
import ui.*;

public class Main {
	
	public static void main(String[] args) {	
	        //创建游戏数据源
                GameDto dto = new GameDto();
                
		JPanelGame jPanelGame = new JPanelGame(dto);
		
		GameService gameService = new GameService(jPanelGame,dto);
		
		GameControl gameControl = new GameControl(gameService,jPanelGame);
		
		//创建玩家控制器（连接游戏控制器）
                PlayerControl playerControl = new PlayerControl(gameControl);
                
                //安装玩家控制器
                jPanelGame.setGameControl(playerControl);
                
		JPanelStart jPanelStart = new JPanelStart(gameControl);
		
		JFrameStart jFrameStart = new JFrameStart(jPanelStart);
		
		gameService.setFrameStart(jFrameStart);
		
	}
}
