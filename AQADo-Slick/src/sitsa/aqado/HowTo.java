package sitsa.aqado;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HowTo extends BasicGameState {

    private int state;

    public HowTo(int state) {
        this.state = state;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        // TODO Auto-generated method stub

    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawRoundRect(40, 40, 200, 50, 20);
        g.drawString("How To !", 90, 55);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){

        }

    }

    @Override
    public int getID() {
        // TODO Auto-generated method stub
        return this.state;
    }

}
