package main;

public class LineOfText {

	private int nbChar;
	private int posX;
	private int posY;
	private String text;
	private int fontSize;
	
	public LineOfText(int x, int y, String words, int taille){
		posX = x;
		posY = y;
		text = words;
		fontSize = taille;
		nbChar = text.length();
	}
	
	public void addText(String toAdd){
		text += toAdd;
	}
	
	public String getText(){
		return text;
	}
	
	public int getX(){
		return posX;
	}
	
	public int getY(){
		return posY;
	}
	
	public int getFontSize(){
		return fontSize;
	}
	
	public void setX(int x){
		posX = x;
	}
	
	public void setY(int y){
		posY = y;
	}
}
