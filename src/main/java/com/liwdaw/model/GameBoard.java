package com.liwdaw.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard implements Serializable {
	
	private Map<Coordinates, Integer> battleGround;		// -1 = miss; 1 = hit
	private List<Ship> ships;
	private int xSize = 10;
	private int ySize = 10;
	
	public GameBoard(List<Ship> ships) {
		this.ships = ships;
		initBattleGround();
	}

	public Map<Coordinates, Integer> getBattleGround() {
		return battleGround;
	}

	public void setBattleGround(Map<Coordinates, Integer> battleGround) {
		this.battleGround = battleGround;
	}
	
	private void initBattleGround() {
		battleGround = new HashMap<Coordinates, Integer>(100);
		for (int i=0; i<xSize; i++) {
			for (int j=0; j<ySize; j++) {
				battleGround.put(new Coordinates(i, j), 0);
			}
		}
	}
	
	public void shoot(Coordinates coordinates) {
		for (int i=0; i<ships.size(); i++) {
			if (ships.get(i).areThisShipCoordinates(coordinates)) {
				ships.get(i).destroyPart(coordinates);
				battleGround.put(coordinates, 1);
				if (ships.get(i).isShipDestroyed()) {
					ships.remove(i);
				}
				return;
			}
		}
		battleGround.put(coordinates, -1);
	}

}
