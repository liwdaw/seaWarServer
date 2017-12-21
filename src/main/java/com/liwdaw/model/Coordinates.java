package com.liwdaw.model;

import java.io.Serializable;

public class Coordinates implements Serializable {
	
	private int x;
	private int y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
    @Override
    public boolean equals(Object object) {
        if (this == object) {
        	return true;
        }
        if (!(object instanceof Coordinates)) {
        	return false;
        }
        Coordinates coordinates = (Coordinates) object;
        return x == coordinates.getX() && y == coordinates.getY();
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
	
}
