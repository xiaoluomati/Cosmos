package ui;

import java.awt.*;

import javax.swing.*;

import control.PlayerControl;

import dto.GameDto;
import entity.GameAct;

import util.FrameUtil;

@SuppressWarnings("serial")
public class JPanelGame extends JPanel {
    private GameDto dto;
    private GameAct act;
	
    private ButtonExit buttonExit;
	
	public JPanelGame(GameDto dto) {
		this.setLayout(null);
		this.initComponent();
		this.dto = dto;
	        
	}
	
	private void initComponent() {
		
		buttonExit= new ButtonExit(Img.GAME_EXIT_DARK, Img.GAME_EXIT_LIGHT);
		buttonExit.setBounds(FrameUtil.SCREEN_SIZE.width - 28, 8, 18, 18);
		this.add(buttonExit);		
	}

	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
		g.drawImage(Img.BG_GAME, 0, 0, 
				FrameUtil.SCREEN_SIZE.width, 
				FrameUtil.SCREEN_SIZE.height, 
				null);	
		this.act = dto.getGameAct();
                g.drawImage(act.getStarImage(), act.getStarLocation().x,
                                act.getStarLocation().y, GameAct.STAR_SIZE,
                                GameAct.STAR_SIZE, null);
		//返回焦点
                this.requestFocus();
	}
	
	/**
         * 安装玩家控制器
         */
        public void  setGameControl(PlayerControl control) {
                this.addKeyListener(control);
        }
}
