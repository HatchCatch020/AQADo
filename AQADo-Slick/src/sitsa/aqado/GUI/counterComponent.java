package sitsa.aqado.GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 03/11/2013
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 */

//NEW INGAME
public interface counterComponent {

    public void draw(Graphics g);
    public void update(int delta);
    public void setX(float x);
    public void setY(float y);
    public void setDX(double dx);
    public void setDY(double dy);
    public void setWidth(float width);
    public void setHeight(float height);
    public void setID(float id);
    public void setBoxIn(AbstractBoxComponent boxIn);
    public void setTexture(Image texture);
    public void moveTo(AbstractBoxComponent box);
    public boolean isClicked(GameContainer gc);
    public float getX();
    public float getY();
    public double getDX();
    public double getDY();
    public float getWidth();
    public float getHeight();
    public float getID();
    public AbstractBoxComponent getBoxIn();
}
