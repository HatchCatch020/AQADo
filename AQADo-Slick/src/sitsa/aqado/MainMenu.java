package sitsa.aqado;

import org.lwjgl.Sys;
import java.awt.Font;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import sitsa.aqado.GUI.AbstractButton;

import java.awt.*;
import java.util.Random;

public class MainMenu extends BasicGameState {
	
	private int state;
	private Image bg;
	private Image logo;
	private StateBasedGame game;
    private Button playbutton;
    private Button optionbutton;
    private Button howtobutton;
    private Button quitbutton;
    private TrueTypeFont font;

	public MainMenu(int state) {
		this.state = state;
    }

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		bg = new Image("tex/bg300x400.png");
		logo = new Image("tex/logo.png");
        playbutton = new Button(245, 300, 200, 60, Color.cyan);
        optionbutton = new Button(245, 370, 200, 60, Color.cyan);
        howtobutton = new Button(245, 440, 200, 60, Color.cyan);
        quitbutton = new Button(245, 510, 200, 60, Color.cyan);
        Font awtFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);
        font = new TrueTypeFont(awtFont, false);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		bg.draw(-600,-800);
		logo.draw(70, 30, 1);
        playbutton.draw(g);
        optionbutton.draw(g);
        howtobutton.draw(g);
        quitbutton.draw(g);
        g.setColor(Color.black);
        font.drawString(325, 320, "Play", Color.black);
        font.drawString(315, 390, "Options", Color.black);
        font.drawString(315, 460, "How to ?", Color.black);
        font.drawString(325, 530, "Quit", Color.black);
        g.drawString("Connor Monaghan", 10, 780);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException{
        delta = getDelta();
        if(playbutton.isMouseOn(gc)){
            playbutton.setFillColor(Color.cyan.brighter());
        }else{
            playbutton.setFillColor(Color.cyan.darker());
        }
        if(optionbutton.isMouseOn(gc)){
            optionbutton.setFillColor(Color.cyan.brighter());
        }else{
            optionbutton.setFillColor(Color.cyan.darker());
        }
        if(howtobutton.isMouseOn(gc)){
            howtobutton.setFillColor(Color.cyan.brighter());
        }else{
            howtobutton.setFillColor(Color.cyan.darker());
        }
        if(quitbutton.isMouseOn(gc)){
            quitbutton.setFillColor(Color.cyan.brighter());
        }else{
            quitbutton.setFillColor(Color.cyan.darker());
        }

        if(playbutton.isMouseClicked(gc)){
            game.enterState(5);
        }
        if(optionbutton.isMouseClicked(gc)){
            game.enterState(2);
        }
        if(howtobutton.isMouseClicked(gc)){
            game.enterState(4);
        }
        if(quitbutton.isMouseClicked(gc)){
            gc.exit();
        }
        playbutton.update(delta);
        optionbutton.update(delta);
        howtobutton.update(delta);
        quitbutton.update(delta);
	}

	@Override
	public int getID() {
		return this.state;
	}

    private static class Button extends AbstractButton{
        public Button(float x, float y, float width, float height, Color fillColor){
            super(x, y, width, height, fillColor);
        }

        @Override
        public void draw(Graphics g) {
            g.setLineWidth(3);
            g.setColor(fillColor);
            g.fillRoundRect(x, y, width, height, 15);
            g.setColor(Color.black);
            g.drawRoundRect(x, y, width, height, 15);
        }

        public void update(int delta) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    private long lastFrame;

    private long getTime(){
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private int getDelta(){
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }
}
