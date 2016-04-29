package main;

import java.util.Vector;

import openGL.Window;

public class TextManager {
	private Window gameWindow;
	private Vector<LineOfText> currentScreen;
	private Vector<LineOfText> previousScreen;
	private boolean isInGame;
	
	public TextManager(Window gameWind){
		gameWindow = gameWind;
		currentScreen = new Vector<LineOfText>();
	}
	
	public void firstScreen(){
		previousScreen = currentScreen;
		currentScreen.clear();
		int widht = gameWindow.getWidth();
		int heigth = gameWindow.getHeight();
		int[] stringSize;
		int lineHeigth = 30;
		isInGame = false;

		//affichage du nom
		stringSize = gameWindow.getStringSize("***********************", 40);
		currentScreen.add(new LineOfText((widht/2)-(stringSize[0]/2), lineHeigth, "***********************", 40));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("Talk Adventure", 60);
		currentScreen.add(new LineOfText((widht/2)-(stringSize[0]/2), lineHeigth, "Talk Adventure", 60));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("***********************", 40);
		currentScreen.add(new LineOfText((widht/2)-(stringSize[0]/2), lineHeigth, "***********************", 40));

		//affichage du menu.
		lineHeigth += stringSize[1] +150;
		stringSize = gameWindow.getStringSize("Start", 40);
		int middleStart = stringSize[0]/2;
		currentScreen.add(new LineOfText((widht/2)-(middleStart), lineHeigth, "Start", 40));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("Option", 40);
		currentScreen.add(new LineOfText((widht/2)-(middleStart), lineHeigth, "Option", 40));
		lineHeigth += stringSize[1] +5;
		stringSize = gameWindow.getStringSize("Quit", 40);
		currentScreen.add(new LineOfText((widht/2)-(middleStart), lineHeigth, "Quit", 40));
		
		//envoi de l'écran à afficher.
		gameWindow.messageToDraw(currentScreen);
	}
	
	public void escScreen(){
		previousScreen = currentScreen;
		currentScreen.clear();
		int widht = gameWindow.getWidth();
		int heigth = gameWindow.getHeight();
		int[] stringSize;
		int lineHeigth = 0;
		
		//affichage de QUITER ?
		stringSize = gameWindow.getStringSize("QUITTER ?", 70);
		lineHeigth += stringSize[1];
		currentScreen.add(new LineOfText((widht/2)-(stringSize[0]/2), (heigth/4)-(lineHeigth/2), "QUITTER ?", 70));
		
		//affichage des options oui/non
		currentScreen.add(new LineOfText(449, 298, "oui", 40));
		currentScreen.add(new LineOfText(449, 298+31, "non", 40));
		
		gameWindow.messageToDraw(currentScreen);
		
	}
	
	public void gamingScreen(){
		previousScreen = currentScreen;
		currentScreen.clear();
		currentScreen.add(new LineOfText(5, 5, "", 24));
		
	}
	
	public void addCharToLine(char character){
		String tempString = ""+character;
		currentScreen.lastElement().addText(tempString);
		gameWindow.clearScreen();
		gameWindow.messageToDraw(currentScreen);
	}
	
	public void bringPreviousScreen(){
		currentScreen = previousScreen;
		gameWindow.messageToDraw(currentScreen);
	}
	
	public void setIsInGame(boolean state){
		isInGame = state;
	}
	
	public boolean getIsInGame(){
		return isInGame;
	}
}
