package main;

public class Cursor {
	private int[] cursorPos;
	private LineOfText cursor;
	private boolean cursorIsVisible;
	int currentPos;
	
	public Cursor(){
		cursor = new LineOfText(385, 293, " > ", 45);
		cursorPos = new int[3];
		cursorPos[0] = 293;
		cursorPos[1] = 293 + 31;
		cursorPos[2] = 293 + 31 + 40;
		
		cursorIsVisible = false;
		currentPos = 0;
	}
	
	public void changeCursorPos(int y){
		if(y > 0){
			//go down if possible
			if(currentPos < 2){
				++currentPos;
			}
		}else{
			//go up if possible
			if(currentPos > 0){
				--currentPos;
			}
		}
	}
	
	public LineOfText getCursor(){
		return cursor;
	}
	
	public void changeVisbility(){
		cursorIsVisible = !cursorIsVisible;
	}
	
	public boolean getVisibility(){
		return cursorIsVisible;
	}
	
	public int getFontSize(){
		return 45;
	}
	
	public int getX(){
		return 385;
	}
	
	public int getY(){
		return cursorPos[currentPos];
	}
	
	public String getText(){
		return " > ";
	}
}
