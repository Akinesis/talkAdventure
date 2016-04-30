package main;

import org.lwjgl.input.Keyboard;

public class InputManager {

	private Game mainGame;

	public InputManager(Game main){
		mainGame = main;
	}

	public void check(){

		boolean keyEnter = Keyboard.isKeyDown(Keyboard.KEY_RETURN);
		boolean keyEsc = Keyboard.isKeyDown(Keyboard.KEY_ESCAPE);

		if(mainGame.inGame()){
			while(Keyboard.next()){
				if(keyEnter){
					mainGame.enterIsDown();
				}else if(keyEsc){
					mainGame.escIsDown();
				}else{
					if (Keyboard.getEventKeyState()) {
						mainGame.addCharToLine(Keyboard.getEventCharacter());
					}
				}

			}

		}else{
			boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN);
			boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP);

			while(Keyboard.next()){
				if(keyDown){
					mainGame.changeCursorPos(1);
				}
				if(keyUp){
					mainGame.changeCursorPos(-1);
				}
				if(keyEnter){
					mainGame.enterIsDown();
				}
				if(keyEsc){
					mainGame.escIsDown();
				}
			}
		}

	}

}
