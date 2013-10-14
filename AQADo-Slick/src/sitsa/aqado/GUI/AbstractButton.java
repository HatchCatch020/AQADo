package sitsa.aqado.GUI;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 10/10/2013
 * Time: 16:49
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractButton implements Button {
    protected float x, y, width, height;
    protected Color fillColor;

    public AbstractButton(float x, float y, float width, float height, Color fillColor){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
    }

    @Override
    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    @Override
    public void setWidth(float width) {
        this.width = width;
    }

    @Override
    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void setFillColor(Color fillColor){
        this.fillColor = fillColor;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getHeight() {
        return height;
    }

    @Override
    public float getWidth() {
        return width;
    }

    @Override
    public boolean isMouseOn(GameContainer gc) {
        if((gc.getInput().getMouseX() >= x) && (gc.getInput().getMouseX() <= x + width) && (gc.getInput().getMouseY() >= y) && (gc.getInput().getMouseY() <= y + height)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isMouseClicked(GameContainer gc) {
        if((gc.getInput().getMouseX() >= x) && (gc.getInput().getMouseX() <= x + width) && (gc.getInput().getMouseY() >= y) && (gc.getInput().getMouseY() <= y + height) && gc.getInput().isMousePressed(0)) {
            return true;
        } else {
            return false;
        }
    }
}
