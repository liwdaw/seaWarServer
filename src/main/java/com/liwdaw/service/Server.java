package com.liwdaw.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.liwdaw.config.ServerConfig;
import com.liwdaw.model.Game;
import com.liwdaw.model.Player;

public class Server extends Thread {
	
	private ServerSocket serverSocket;
	private boolean isRunning;
	private List<Game> games = new ArrayList<Game>();
	private List<Player> players = new ArrayList<Player>();
	private Player playerWaitingForOpponent;
	
	public Server() throws Exception {
		ServerConfig config = new ServerConfig();
		serverSocket = new ServerSocket(config.loadPort());
		isRunning = true;
	}
	
	public void run() {
		System.out.println("Server started! Type 'stop' to stop server and disconnect all players.");
	 	watchConnections();
	 	watchPlayers();
	 	watchGames();
	}
	
	public void kill() {
		
	}
	
	private void watchConnections() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				while (isRunning) {
			 		Socket playerSocket;
					try {
						playerSocket = serverSocket.accept();
						Player player = new Player(playerSocket);
				 		player.start();
				 		players.add(player);
					} catch (Exception e) {
						continue;
					}
			 		for (int i=0; i<players.size(); i++) {
			 			if (!players.get(i).isConnected()) {
			 				players.get(i).kill();
			 			}
			 		}
				}
			}
		});
		thread.start();
	}
	
	private void watchPlayers() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				
			}		
		});
		thread.start();
	}
	
	private void watchGames() {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				
			}		
		});
		thread.start();
	}
	
}
