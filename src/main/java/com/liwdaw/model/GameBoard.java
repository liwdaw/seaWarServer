package com.liwdaw.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard implements Serializable {
	
	private Map<Coordinates, Integer> battleGround;		// -1 = miss; 1 = hit
	private int xSize = 10;
	private int ySize = 10;
	
	public GameBoard(Map<Coordinates, Integer> battleGround) {
		this.battleGround = battleGround;
	}

	public Map<Coordinates, Integer> getBattleGround() {
		return battleGround;
	}

	public void setBattleGround(Map<Coordinates, Integer> battleGround) {
		this.battleGround = battleGround;
	}
	
	private void initBattleGround() {
		for (int i=0; i<xSize; i++) {
			for (int j=0; j<ySize; j++) {
				battleGround.put(new Coordinates(i, j), 0);
			}
		}
	}
	
}
