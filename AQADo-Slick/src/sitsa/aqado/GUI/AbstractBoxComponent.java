package sitsa.aqado.GUI;

import sitsa.aqado.gameVariables;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 02/11/2013
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractBoxComponent implements boxComponent {

    protected float x, y, width, height, counterNum, id;
    protected boolean occupied, safeSapce, drawn, textBox;
    protected AbstractBoxComponent nextBox;

    public AbstractBoxComponent(float x, float y, float width, float height, float boxNum){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = boxNum;
        this.occupied = false;
        this.drawn = false;
        this.textBox = false;
        gameVariables.addBox(this);
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
    public void setOccupied(boolean occupied, float counterNum) {
        this.occupied = occupied;
        this.counterNum = counterNum;
    }

    @Override
    public void setID(float boxNum) {
        this.id = boxNum;
    }

    @Override
    public void setNextBox(AbstractBoxComponent nextBox) {
        this.nextBox = nextBox;
    }

    @Override
    public void setSafeSpace(boolean safeSpace) {
        this.safeSapce = safeSpace;
    }

    @Override
    public void setboxDrawn(boolean drawn) {
        this.drawn = drawn;
    }
    
    @Override
    public void setTextBox(boolean textBox){
        this.textBox = textBox;
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
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }

    @Override
    public float getOccupiedBy() {
        return this.counterNum;
    }

    @Override
    public float getID() {
        return this.id;
    }

    @Override
    public AbstractBoxComponent nextBox() {
        int i = (int) this.id + 1;
        this.nextBox = gameVariables.getBoxID(i);
        return gameVariables.getBoxID(i);
    }

    @Override
    public boolean isOccupied() {
        return this.occupied;
    }

    @Override
    public boolean isSafeSpace() {
        return this.safeSapce;
    }

    @Override
    public boolean isBoxDrawn() {
        return this.drawn;
    }
    
    @Override
    public boolean isTextBox(){
        return this.textBox;
    }


}
