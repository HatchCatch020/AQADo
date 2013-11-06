package sitsa.aqado.GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import sitsa.aqado.gameVariables;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 03/11/2013
 * Time: 13:01
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCounterComponent implements counterComponent {

    protected float x, y, width, height, id, dx, dy;
    protected Image texture;
    protected AbstractBoxComponent box, boxIn;

    public AbstractCounterComponent(float x, float y, float width, float height, float id, Image texture, AbstractBoxComponent boxIn){
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.width = width;
        this.height = height;
        this.id = id;
        this.texture = texture;
        this.boxIn = boxIn;
        gameVariables.addCounter(this);
    }

    @Override
    public void update(int delta){
        this.x += delta * dx;
        this.y += delta * dy;
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
    public void setDX(float dx) {
        this.dx = dx;
    }

    @Override
    public void setDY(float dy) {
        this.dy = dy;
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
    public void setID(float id) {
        this.id = id;
    }

    @Override
    public void setBoxIn(AbstractBoxComponent boxIn) {
        this.boxIn = boxIn;
    }

    @Override
    public void setTexture(Image texture) {
        this.texture = texture;
    }

    @Override
    public void moveTo(AbstractBoxComponent box) {
        while(this.y >= box.getY() + 10){
            this.dy = -1;
        }
        this.dy = 0;
        this.box = box;
    }

    @Override
    public boolean isClicked(GameContainer gc) {
        if((gc.getInput().getMouseX() >= x) && (gc.getInput().getMouseX() <= x + width) && (gc.getInput().getMouseY() >= y) && (gc.getInput().getMouseY() <= y + height) && gc.getInput().isMousePressed(0)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public float getDX() {
        return this.dx;
    }

    @Override
    public float getDY() {
        return this.dy;
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }

    @Override
    public float getID() {
        return this.id;
    }

    @Override
    public AbstractBoxComponent getBoxIn() {
        return this.boxIn;
    }
}
