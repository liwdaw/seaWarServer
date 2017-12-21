package com.liwdaw.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ship implements Serializable {
	
	private Map<Coordinates, Boolean> parts;		// false = part is destroyed
	
	public Ship(List<Coordinates> partsCoordinates) {
		parts = new HashMap<Coordinates, Boolean>(partsCoordinates.size());
		for (int i=0; i<partsCoordinates.size(); i++) {
			parts.put(partsCoordinates.get(i), true);
		}
	}
	
	public boolean areThisShipCoordinates(Coordinates coordinates) {
		return parts.containsKey(coordinates);
	}
	
	public void destroyPart(Coordinates coordinates) {
		parts.put(coordinates, false);
	}
	
	public boolean isShipDestroyed() {
		return !parts.containsValue(true);
	}
	
}
