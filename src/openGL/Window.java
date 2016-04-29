package openGL;

import static org.lwjgl.opengl.GL11.*;

import java.awt.Font;
import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import main.Cursor;
import main.LineOfText;

public class Window {

	private UnicodeFont uniFont;
	private Vector<LineOfText> onScreen;
	private int defaultFontSize;
	private boolean inMenu;
	private long lastFPS;
	private Cursor cursor;
	private Font awtFont;

	public Window(int width, int heigth){
		try{
			Display.setResizable(false);
			Display.setDisplayMode(new DisplayMode(width, heigth));
			Display.setTitle("Dino Survive");
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			Display.destroy();
			System.exit(1);
		}

		onScreen = new Vector<LineOfText>();
		defaultFontSize = 24;
		inMenu = true;
		cursor = new Cursor();
		
		awtFont = new Font("Manaspace Regular", Font.PLAIN,24);
		
		lastFPS = getTime();

		enable();
		initGL(width, heigth);
		initFonts();

		Mouse.setGrabbed(false);
	}
	
	
	public void render(){
		glClear(GL_COLOR_BUFFER_BIT);
		glClear(GL_DEPTH_BUFFER_BIT);

		glPushMatrix(); 
		glEnable(GL_BLEND);

		/**
		 * Dessin de tout les textes
		 */
		for(LineOfText line : onScreen ){
			if(line.getFontSize() != defaultFontSize){
				changeFontSize(line.getFontSize());
				uniFont.drawString(line.getX(), line.getY(), line.getText());
				initFonts();
			}else{
				uniFont.drawString(line.getX(), line.getY(), line.getText());
			}
		}
		
		if(inMenu){
			//dessin du curseur devant le menu
			if (getTime() - lastFPS > 400) {
				lastFPS +=400;
				//blink du cursseur
				cursor.changeVisbility();
			}
			if(cursor.getVisibility()){
				changeFontSize(cursor.getFontSize());
				uniFont.drawString(cursor.getX(), cursor.getY(), cursor.getText());
				initFonts();
			}
		}
		

		glDisable(GL_BLEND);
		glPopMatrix();
	}
	
	
	private void enable(){
		glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_CULL_FACE);
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}

	
	private void initGL(int width, int heigth){
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, width, heigth, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	
	//méthode de création et modification de la Font
	private void initFonts() {

		if(uniFont != null){
			uniFont.destroy();
		}
		
		uniFont = new UnicodeFont(awtFont, defaultFontSize, false, false);
		uniFont.addAsciiGlyphs();
		uniFont.addGlyphs(400, 600);         // Setting the unicode Range
		uniFont.getEffects().add(new ColorEffect(java.awt.Color.black));
		try {
			uniFont.loadGlyphs();
		} catch (SlickException e) {};

	}
	
	public void changeFontSize(int size){

		if(uniFont != null){
			uniFont.destroy();
		}
		
		uniFont = new UnicodeFont(awtFont, size, false, false);
		uniFont.addAsciiGlyphs();
		uniFont.addGlyphs(400, 600);         // Setting the unicode Range
		uniFont.getEffects().add(new ColorEffect(java.awt.Color.black));
		try {
			uniFont.loadGlyphs();
		} catch (SlickException e) {};
	}
	
	public int[] getStringSize(String text, int fontSize){
		
		if(uniFont != null){
			uniFont.destroy();
		}
		
		uniFont = new UnicodeFont(awtFont, fontSize, false, false);
		uniFont.addAsciiGlyphs();
		uniFont.addGlyphs(400, 600);         // Setting the unicode Range
		uniFont.getEffects().add(new ColorEffect(java.awt.Color.black));
		try {
			uniFont.loadGlyphs();
		} catch (SlickException e) {};
		
		int[] ret = new int[2];
		ret[0] = uniFont.getWidth(text);
		ret[1] = uniFont.getHeight(text);
		initFonts();
		return ret;
	}
	
	public void changeCursorPos(int y){
		cursor.changeCursorPos(y);
	}
	
	//méthode relative à la fenêtre
	public boolean isClose(){
		return Display.isCloseRequested();
	}

	
	public void update(){
		Display.update();
		Display.sync(70);
	}

	
	public void changeGrabeMouse(){
		Mouse.setGrabbed(!Mouse.isGrabbed());
	}

	
	public void end(){
		Display.destroy();
	}

	
	public int getHeight(){
		return Display.getHeight();
	}

	
	public int getWidth(){
		return Display.getWidth();
	}

	
	//autres méthodes
	public void messageToDraw(LineOfText mess){
		onScreen.add(mess);
	}
	
	public void messageToDraw(Vector<LineOfText> currentScreen) {
		for(LineOfText line : currentScreen){
			onScreen.add(line);
		}
		
	}
	
	public void clearScreen(){
		onScreen.clear();
	}
	
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}


	public boolean isInMenu() {
		return inMenu;
	}
	
	public void setInMenu(boolean set){
		inMenu = set;
	}
	
	public int getPosMenu(){
		return cursor.getCurrentPos();
	}
	
	public void hideCursor(){
		cursor.hideCursor();
	}

}
