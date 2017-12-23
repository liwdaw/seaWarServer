package com.liwdaw.model;

import java.util.List;

public class Player {
	
	private String nickname;
	private GameBoard gameBoard;
	
	public Player(String nickname) {
		this.nickname = nickname;
	}
	
	public void createGameBoard(List<Ship> ships) {
		gameBoard = new GameBoard(ships);
	}

	public String getNickname() {
		return nickname;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
}
