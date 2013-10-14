package sitsa.aqado.GUI;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 10/10/2013
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractboxGameComponent implements boxGameComponent {
    protected float x, y, width, height, boxNumber;
    protected boolean occupiedByMe, occupiedByOpponent, specialBox;

    public AbstractboxGameComponent(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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
    public void setOccupiedByMe(boolean occupiedByMe) {
        this.occupiedByMe = occupiedByMe;
    }

    @Override
    public void setOccupiedByOpponent(boolean occupiedByOpponent) {
        this.occupiedByOpponent = occupiedByOpponent;
    }

    @Override
    public void setBoxNum(float boxNumber) {
        this.boxNumber = boxNumber;
    }

    @Override
    public void setSpecialBox(boolean specialBox){
        this.specialBox = specialBox;
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
    public boolean isOccupiedByMe() {
        return this.occupiedByMe;
    }

    @Override
    public boolean isOccupiedByOpponent() {
        return this.occupiedByOpponent;
    }

    @Override
    public boolean isSpecialBox(){
        return this.specialBox;
    }

    @Override
    public float getBoxNum() {
        return this.boxNumber;
    }
}
