package state;

import main.Game;

public class MenuState extends State {

	public MenuState(Game main) {
		super(main);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void escIsDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void goBack() {
		// TODO Auto-generated method stub

	}

	@Override
	public String enterIsDown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void isShow() {
		mainGame.getTexManager().firstScreen();
		
	}

}
