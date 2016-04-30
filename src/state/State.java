package state;

import main.Game;

public abstract class State {

	protected Game mainGame;
	
	public State(Game main){
		mainGame = main;
	}
	
	public abstract void escIsDown();
	public abstract void goBack();
	public abstract String enterIsDown();
	public abstract void isShow();
}
