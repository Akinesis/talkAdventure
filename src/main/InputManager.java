package main;

import org.lwjgl.input.Keyboard;

public class InputManager {

	private Game mainGame;

	public InputManager(Game main){
		mainGame = main;
	}

	public void check(){
		boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
		boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP);

		while(Keyboard.next()){
			if(keyDown){
				mainGame.changeCursorPos(1);
			}
			if(keyUp){
				mainGame.changeCursorPos(-1);
			}
		}

	}

}
