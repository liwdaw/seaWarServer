package com.liwdaw.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class GameBoard implements Serializable {
	private Map<Coordinates, Integer> battleGround;		// -1 = miss; 1 = hit
	
	public GameBoard() {
		battleGround = new HashMap<Coordinates, Integer>(100);
	}
	
	public GameBoard(Map<Coordinates, Integer> battleGround) {
		this.battleGround = battleGround;
	}

	public Map<Coordinates, Integer> getBattleGround() {
		return battleGround;
	}

	public void setBattleGround(Map<Coordinates, Integer> battleGround) {
		this.battleGround = battleGround;
	}
	
	
}
