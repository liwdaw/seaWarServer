package com.liwdaw.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Ship implements Serializable {
	
	int length;
	Map<Integer, Coordinates> partsCoordinates;
	Map<Integer, Boolean> destroyedParts;
	
	public Ship(int length) {
		this.length = length;
		partsCoordinates = new HashMap<Integer, Coordinates>(length);
		destroyedParts = new HashMap<Integer, Boolean>(length);
		for (int i=0; i<length; i++) {
			destroyedParts.put(i, false);
		}
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public Coordinates getPartCoordinates(int partIndex) {
		return partsCoordinates.get(partIndex);
	}
	
	public void setPartCoordinates(int partIndex, Coordinates coordinates) {
		partsCoordinates.put(partIndex, coordinates);
	}
	
	public boolean isPartDestroyed(int partIndex) {
		return destroyedParts.get(partIndex);
	}
	
	public void destroyPart(int partIndex) {
		destroyedParts.put(partIndex, true);
	}
	
	public boolean isShipDestroyed() {
		for (int i=0; i<length; i++) {
			if (!destroyedParts.get(i)) {
				return false;
			}
		}
		return true;
	}
	
}
