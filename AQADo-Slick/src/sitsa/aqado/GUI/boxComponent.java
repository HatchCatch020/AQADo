package sitsa.aqado.GUI;

import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 02/11/2013
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */

//NEW INGAME
public interface boxComponent {

    public void draw(Graphics g);
    public void update(int delta);
    public void setX(float x);
    public void setY(float y);
    public void setWidth(float width);
    public void setHeight(float height);
    public void setOccupied(boolean occupied, float counterNum);
    public void setID(float id);
    public void setNextBox(AbstractBoxComponent nextBox);
    public void setSafeSpace(boolean safeSpace);
    public void setboxDrawn(boolean drawn);
    public void isTextBox(boolean textBox);
    public float getX();
    public float getY();
    public float getWidth();
    public float getHeight();
    public float getOccupiedBy();
    public float getID();
    public AbstractBoxComponent nextBox();
    public boolean isOccupied();
    public boolean isSafeSpace();
    public boolean isBoxDrawn();
    public boolean isTextBox();
}
