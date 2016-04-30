package main;

import openGL.Window;
import robots.BotsManager;
import state.*;

public class Game {
	BotsManager botManager;
	Window gameWindow;
	InputManager inputManager;
	TextManager textManager;
	State currentState;
	State menuState, gameState, optionState, quitterState;


	public Game(){
		gameWindow = new Window(1024, 576);
		botManager = new BotsManager();
		inputManager = new InputManager(this);
		textManager = new TextManager(gameWindow);
		botManager = new BotsManager();

		//gestion des States
		menuState = new MenuState(this);
		gameState = new GameState(this);
		optionState = new OptionState(this);
		quitterState = new QuitState(this);

		currentState = menuState;


		//gameWindow.messageToDraw(new LineOfText(0, 0, botManager.dialogue(), 24));
		//initialScreen();
		currentState.isShow();

		start();

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
		/*gameWindow.setInMenu(false);
		gameWindow.hideCursor();*/
		currentState = gameState;

		textManager.setIsInGame(true);
		textManager.gamingScreen();
	}

	private void initialScreen(){
		textManager.firstScreen();
	}

	public void changeCursorPos(int y){
		gameWindow.changeCursorPos(y);
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

	public TextManager getTexManager() {
		return textManager;
	}
	
	/**
	 * Méthode de gestion des states
	 * 
	 * 
	 */
	public void setState(State newState){
		currentState = newState;
	}
	
	public boolean inGame(){
		return currentState == gameState;
	}
	
	public void enterIsDown() {
		//si on est sur le menu
		/*if(currentState == menuState){
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
		}*/
		currentState.enterIsDown();
	}


}
