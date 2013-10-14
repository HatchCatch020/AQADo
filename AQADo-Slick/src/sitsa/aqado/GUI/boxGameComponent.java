package sitsa.aqado.GUI;

import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 10/10/2013
 * Time: 19:20
 * To change this template use File | Settings | File Templates.
 */
public interface boxGameComponent {

    public void draw(Graphics g);
    public void update(int delta);
    public void setLocation(float x, float y);
    public void setX(float x);
    public void setY(float y);
    public void setWidth(float width);
    public void setHeight(float height);
    public void setOccupiedByMe(boolean occupiedByMe);
    public void setOccupiedByOpponent(boolean occupiedByOpponent);
    public void setBoxNum(float boxNumber);
    public void setSpecialBox(boolean specialBox);
    public float getX();
    public float getY();
    public float getWidth();
    public float getHeight();
    public boolean isOccupiedByMe();
    public boolean isOccupiedByOpponent();
    public boolean isSpecialBox();
    public float getBoxNum();
}
