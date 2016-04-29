package main;

public class lineIndicator {
	private LineOfText lineIndicator;
	
	public lineIndicator(){
		lineIndicator = new LineOfText(0, 0, " | ", 24);
	}
	
	public LineOfText getLineIndicator(){
		return lineIndicator;
	}
	
	public void setIndicatorPos(int x){
		lineIndicator.setX(x);
	}
}
