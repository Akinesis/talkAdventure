package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import openGL.Window;
import robots.BotsManager;

public class Game {
	BotsManager botManager;
	Window gameWindow;
	InputManager inputManager;
	TextManager textManager;

	public Game(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gameWindow = new Window(1024, 576);
		botManager = new BotsManager();
		inputManager = new InputManager(this);
		textManager = new TextManager(gameWindow);

		//gameWindow.messageToDraw(new LineOfText(0, 0, botManager.dialogue(), 24));
		initialScreen();

		start();

		botManager = new BotsManager();
	}

	private void start(){
		while(!gameWindow.isClose()){
			gameWindow.render();
			gameWindow.update();
			inputManager.check();
		}
	}
	
	private void gameStart(){
		gameWindow.clearScreen();
		gameWindow.setInMenu(false);
		gameWindow.hideCursor();
		
		textManager.setIsInGame(true);
		textManager.gamingScreen();
	}

	private void initialScreen(){
		textManager.firstScreen();
	}

	public void changeCursorPos(int y){
		gameWindow.changeCursorPos(y);
	}

	public void enterIsDown() {
		//si on est sur le menu
		if(gameWindow.isInMenu()){
			int pos = gameWindow.getPosMenu();

			switch(pos){
			case 0:
				gameStart();
				break;
			case 1:
				break;
			case 2:
				break;
			default:
				break;
			}
		}
		

	}

	public boolean inGame(){
		return textManager.getIsInGame();
	}
	
	public void escIsDown() {
		gameWindow.clearScreen();
		gameWindow.setInMenu(false);
		//afficher le curseur
		textManager.escScreen();
	}
	
	public void addCharToLine(char character){
		textManager.addCharToLine(character);
	}
	
	
}
