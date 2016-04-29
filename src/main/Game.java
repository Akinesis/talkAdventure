package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import openGL.Window;
import robots.BotsManager;

public class Game {
	BotsManager botManager;
	Window gameWindow;
	InputManager inputManager;
	
	public Game(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gameWindow = new Window(1024, 576);
		botManager = new BotsManager();
		inputManager = new InputManager(this);
		
		//gameWindow.messageToDraw(new LineOfText(0, 0, botManager.dialogue(), 24));
		initialScreen();
		
		start();
		
		botManager = new BotsManager();
	}
	
	private void start(){
		while(!gameWindow.isClose()){
			gameWindow.update();
			gameWindow.render();
			inputManager.check();
		}
	}
	
	private void initialScreen(){
		int widht = gameWindow.getWidth();
		int heigth = gameWindow.getHeight();
		int[] stringSize;
		int lineHeigth = 30;
		
		//affichage du nom
		stringSize = gameWindow.getStringSize("***********************", 40);
		gameWindow.messageToDraw(new LineOfText((widht/2)-(stringSize[0]/2), lineHeigth, "***********************", 40));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("Talk Adventure", 60);
		gameWindow.messageToDraw(new LineOfText((widht/2)-(stringSize[0]/2), lineHeigth, "Talk Adventure", 60));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("***********************", 40);
		gameWindow.messageToDraw(new LineOfText((widht/2)-(stringSize[0]/2), lineHeigth, "***********************", 40));
		
		//affichage du menu.
		lineHeigth += stringSize[1] +150;
		stringSize = gameWindow.getStringSize("Start", 40);
		int middleStart = stringSize[0]/2;
		gameWindow.messageToDraw(new LineOfText((widht/2)-(middleStart), lineHeigth, "Start", 40));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("Option", 40);
		gameWindow.messageToDraw(new LineOfText((widht/2)-(middleStart), lineHeigth, "Option", 40));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("Quit", 40);
		gameWindow.messageToDraw(new LineOfText((widht/2)-(middleStart), lineHeigth, "Quit", 40));
	}
	
	public void changeCursorPos(int y){
		gameWindow.changeCursorPos(y);
	}
}
