package dto;

import java.awt.Point;

import entity.BattleAct;
import entity.GameAct;

public class GameDto {

	/**
	 * 本地存档
	 */
	private Player diskRecorder;
	/**
	 * 现在的文明发展等级
	 */
	private int nowLevel;
	/**
	 * 现在的文明发展程度(进度条比例)
	 */
	private int point;
	/**
	 * 现在星球位置
	 */
	private Point nowLocation;

	private GameAct gameAct;

	private BattleAct battleAct;
	
	public Player getDiskRecorder() {
		return diskRecorder;
	}

	public void setDiskRecorder(Player diskRecorder) {
		this.diskRecorder = diskRecorder;
	}

	public int getNowLevel() {
		return nowLevel;
	}

	public void setNowLevel(int nowLevel) {
		this.nowLevel = nowLevel;
	}

	public int getNowPoint() {
		return point;
	}

	public void setNowPoint(int point) {
		this.point = point;
	}

	public Point getNowLocation() {
		return nowLocation;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public void setNowLocation(Point nowLocation) {
		this.nowLocation = nowLocation;
	}

	public BattleAct getBattleAct() {
		return battleAct;
	}

	public void setBattleAct(BattleAct battleAct) {
		this.battleAct = battleAct;
	}
        
}
