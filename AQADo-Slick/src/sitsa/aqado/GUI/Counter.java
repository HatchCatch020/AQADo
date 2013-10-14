package sitsa.aqado.GUI;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 11/10/2013
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
public interface Counter {

    public void draw(Graphics g);
    public void update(int delta);
    public void setLocation(float x, float y);
    public void setX(float x);
    public void setY(float y);
    public void setDX(float dx);
    public void setDY(float dy);
    public void setWidth(float width);
    public void setHeight(float height);
    public void setID(int id);
    public void setBoxOccupying(AbstractboxGameComponent box);
    public void setBoxOccupyingF(float boxNum);
    public void setTexture(Image texture);
    public void moveByF(float moveBy);
    public void moveByB(AbstractboxGameComponent toBox);
    public float getX();
    public float getY();
    public float getDX();
    public float getDY();
    public float getWidth();
    public float getHeight();
    public float getID();
    public float getBoxOccupyingF();
    public AbstractboxGameComponent getBoxOccupying();

}
