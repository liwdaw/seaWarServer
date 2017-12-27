package com.liwdaw.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Player extends Thread {
	
	private Socket playerSocket;
	private boolean isConnected;
	private boolean isInGame;
	private String nickname;
	private GameBoard gameBoard;
	private ObjectInputStream inStream;
	private ObjectOutputStream outStream;
	
	public Player(Socket playerSocket) throws Exception {
		this.playerSocket = playerSocket;
		isConnected = true;
		inStream = new ObjectInputStream(playerSocket.getInputStream());
		outStream = new ObjectOutputStream(playerSocket.getOutputStream());
	}
	
	public void createGameBoard(List<Ship> ships) {
		gameBoard = new GameBoard(ships);
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getNickname() {
		return nickname;
	}

	public GameBoard getGameBoard() {
		return gameBoard;
	}
	
	public boolean isConnected() {
		return isConnected;
	}
	
	public void run() {
		while (isConnected) {
			if (isInGame) {
				getPlayerGameAction();
			}
			else {
				getPlayerMenuAction();
			}
		}
	}
	
	public void kill() {
		
	}
	
	private void getPlayerMenuAction() {
		
	}
	
	private void getPlayerGameAction() {
		
	}
	
}
