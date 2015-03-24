package sitsa.aqado.GUI;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 10/10/2013
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public interface Button {

    public void draw(Graphics g);
    public void update(int delta);
    public void disabled(boolean i);
    public void setLocation(float x, float y);
    public void setX(float x);
    public void setY(float y);
    public void setWidth(float width);
    public void setHeight(float height);
    public void setFillColor(Color color);
    public float getX();
    public float getY();
    public float getHeight();
    public float getWidth();
    public boolean isMouseOn(GameContainer container);
    public boolean isMouseClicked(GameContainer container);
}
