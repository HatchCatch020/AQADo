package sitsa.aqado;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import sitsa.aqado.GUI.AbstractButton;

import java.awt.*;
import java.awt.Font;

//TODO get player name input
public class HowTo extends BasicGameState {
	
	private int state;
    private Image bg;
    private Button returnButton;
    private TrueTypeFont font;

	public HowTo(int state) {
		this.state = state;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		bg = new Image("tex/bg300x400.png");
    	returnButton = new Button(245, 300, 200, 60, Color.cyan);
 		Font awtFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 16);
    	font = new TrueTypeFont(awtFont, false);;
    }

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        bg.draw(-600, -800);
        returnButton.draw(g);
        font.drawString(320, 320, "Return", Color.black);
        font.drawString(30, 470, "AQADo is a turn by turn based game, each player will roll", Color.black);
        font.drawString(30, 480, "the dice to generate a number. They will then select a", Color.black);
        font.drawString(30, 490, "counter that belongs to them to make the move. If the landed", Color.black);
        font.drawString(30, 500, "number is a four the counter selected will move back by one.", Color.black);
        font.drawString(30, 510, "If it lands one, two or three the counter will move forward.", Color.black);
        font.drawString(30, 520, "If it lands in a box with another player's counter in the", Color.black);
        font.drawString(30, 530, "opposing playe'rs counter will be moved back to start except", Color.black);
        font.drawString(30, 540, "if it lands in the safe box which is the fifth box.", Color.black);
    }

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {
        // Button logic
        if(returnButton.isMouseOn(gc)){
            returnButton.setFillColor(Color.cyan.brighter());
        }else{
            returnButton.setFillColor(Color.cyan.darker());
        }
	}

	@Override
	public int getID() {
		return this.state;
	}


    private static class Button extends AbstractButton {
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
        }
    }
}
