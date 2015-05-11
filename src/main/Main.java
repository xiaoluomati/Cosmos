package main;

import control.GameControl;
import service.*;
import ui.*;

public class Main {
	
	public static void main(String[] args) {	
		JPanelGame jPanelGame = new JPanelGame();
		
		GameService gameService = new GameService(jPanelGame);
		
		GameControl gameControl = new GameControl(gameService,jPanelGame);
		
		JPanelStart jPanelStart = new JPanelStart(gameControl);
		
		JFrameStart jFrameStart = new JFrameStart(jPanelStart);
		
		gameService.setFrameStart(jFrameStart);
	}
}
