package sitsa.aqado.GUI;

import org.newdawn.slick.Image;
import sitsa.aqado.InGame;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 11/10/2013
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractCounter implements Counter {

    protected float x, y, dx, dy, width, height, moveBy, boxNum;
    protected int id;
    protected Image texture;
    protected AbstractboxGameComponent box;

    public AbstractCounter(float x, float y, Image texture, AbstractboxGameComponent box){
        this.x = x;
        this.y = y;
        this.dx = 0;
        this.dy = 0;
        this.texture = texture;
        this.box = box;
        this.boxNum = 1;
    }

    @Override
    public void update(int delta) {
        this.x += delta * dx;
        this.y += delta * dy;


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
    public void setDX(float dx) {
        this.dx = dx;
    }

    @Override
    public void setDY(float dy) {
        this.dy = dy;
    }

    @Override
    public void setWidth(float width){
        this.width = 51;
    }

    @Override
    public void setHeight(float height){
        this.height = 51;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public void setBoxOccupying(AbstractboxGameComponent box) {
        this.box = box;
    }

    @Override
    public void setBoxOccupyingF(float boxNum) {
        this.boxNum = boxNum;
    }

    @Override
    public void setTexture(Image texture) {
        this.texture = texture;
    }

    @Override
    public void moveByB(AbstractboxGameComponent toBox) {
        float moveTo = toBox.getY() + 10;
        this.y = moveTo;
    }

    @Override
    public void moveByF(float moveBy) {
        float toY = this.getBoxOccupying().getY() - 60;

        // Attempt one
        if(moveBy == 1){
            this.y = toY;
            this.boxNum = boxNum + 1;
        }else if(moveBy == 2){
            this.y = toY - 70;
        }else if(moveBy == 3){
            this.y = toY - 140;
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
    public float getWidth(){
        return this.width;
    }

    @Override
    public float getHeight(){
        return this.height;
    }

    @Override
    public float getID() {
        return this.id;
    }

    @Override
    public float getBoxOccupyingF() {
        return this.boxNum;
    }

    @Override
    public AbstractboxGameComponent getBoxOccupying() {
        return this.box;
    }
}
