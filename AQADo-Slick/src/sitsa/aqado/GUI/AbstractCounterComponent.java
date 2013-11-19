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

    protected float x, y, width, height, id;
    protected double dx, dy;
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
        this.setBoxIn(boxIn);
        gameVariables.addCounter(this);
    }

    @Override
    public void update(int delta){
        this.x += delta * dx;
        this.y += delta * dy;
        /*if(gameVariables.isCounterSelected){
            if(gameVariables.playerTurn == "p1") {
                if(gameVariables.counterSelected == this){
                    if(gameVariables.nextBox(this.getBoxIn()).isSafeSpace()){
                        if(gameVariables.diceLandedNum != 4) {
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() + gameVariables.diceLandedNum));
                            this.moveTo(this.getBoxIn());
                                System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  moved to a safe space and did not equal 4.");
                        }else if(gameVariables.diceLandedNum == 4 && this.getBoxIn().getID() != 1){
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() - 1));
                            this.moveTo(this.getBoxIn());
                                System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Moved back to a safe space and was equal to 4.");
                        }
                    }else if(gameVariables.nextBox(this.getBoxIn()).getOccupiedBy() == 2){
                            System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Did not move, was occupied by player's counter.   Occupied by : "+gameVariables.nextBox(this.getBoxIn()).getOccupiedBy());
                    }else if(gameVariables.nextBox(this.getBoxIn()).getOccupiedBy() == 3 || gameVariables.nextBox(this.getBoxIn()).getOccupiedBy() == 4){
                        if(gameVariables.diceLandedNum != 4) {
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setY(gameVariables.getBoxID(1).getY() + 8);
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setBoxIn(gameVariables.getBoxID(1));
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() + gameVariables.diceLandedNum));
                            this.moveTo(this.getBoxIn());
                                System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Was occupied by opponent's counter, move forward and move opponent's piece to start.   Occupied by : "+gameVariables.nextBox(this.getBoxIn()).getOccupiedBy());
                        }else if(gameVariables.diceLandedNum == 4 && this.getBoxIn().getID() != 1){
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setY(gameVariables.getBoxID(1).getY() + 8);
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setBoxIn(gameVariables.getBoxID(1));
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() - 1));
                            this.moveTo(this.getBoxIn());
                                System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Was occupied by opponent's counter, move back and move opponent's piece to start.   Occupied by : "+gameVariables.nextBox(this.getBoxIn()).getOccupiedBy());
                        }
                    }else{
                        if(gameVariables.diceLandedNum != 4) {
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() + gameVariables.diceLandedNum));
                            this.moveTo(this.getBoxIn());
                                System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Space was unoccupied space. Moved forward.");
                        }else{
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() - 1));
                            this.moveTo(this.getBoxIn());
                                System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Space was unoccupied space. Moved backward.");
                        }
                    }
                    gameVariables.moveMade = true;
                    gameVariables.playerTurn = "p2";
                }
            }else if(gameVariables.playerTurn == "p2"){
                if(gameVariables.counterSelected == this){
                    if(gameVariables.nextBox(this.getBoxIn()).isSafeSpace()){
                        if(gameVariables.diceLandedNum != 4) {
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() + gameVariables.diceLandedNum));
                            this.moveTo(this.getBoxIn());
                        System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  moved to a safe space and did not equal 4.");
                        }else if(gameVariables.diceLandedNum == 4 && this.getBoxIn().getID() != 1){
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() - 1));
                            this.moveTo(this.getBoxIn());
                        System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Moved back to a safe space and was equal to 4.");
                        }
                    }else if(gameVariables.nextBox(this.getBoxIn()).getOccupiedBy() == 4){
                    System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Did not move, was occupied by player's counter.   Occupied by : "+gameVariables.nextBox(this.getBoxIn()).getOccupiedBy());
                    }else if(gameVariables.nextBox(this.getBoxIn()).getOccupiedBy() == 1 || gameVariables.nextBox(this.getBoxIn()).getOccupiedBy() == 2){
                        if(gameVariables.diceLandedNum != 4) {
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setY(gameVariables.getBoxID(1).getY() + 8);
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setBoxIn(gameVariables.getBoxID(1));
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() + gameVariables.diceLandedNum));
                            this.moveTo(this.getBoxIn());
                        System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Was occupied by opponent's counter, move forward and move opponent's piece to start.   Occupied by : "+gameVariables.nextBox(this.getBoxIn()).getOccupiedBy());
                        }else if(gameVariables.diceLandedNum == 4 && this.getBoxIn().getID() != 1){
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setY(gameVariables.getBoxID(1).getY() + 8);
                            gameVariables.getCounterByID((int) gameVariables.nextBox(this.getBoxIn()).getOccupiedBy()).setBoxIn(gameVariables.getBoxID(1));
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() - 1));
                            this.moveTo(this.getBoxIn());
                        System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Was occupied by opponent's counter, move back and move opponent's piece to start.   Occupied by : "+gameVariables.nextBox(this.getBoxIn()).getOccupiedBy());
                        }
                    }else{
                        if(gameVariables.diceLandedNum != 4) {
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() + gameVariables.diceLandedNum));
                            this.moveTo(this.getBoxIn());
                        System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Space was unoccupied space. Moved forward.");
                        }else{
                            this.setBoxIn(gameVariables.getBoxID((int) this.getBoxIn().getID() - 1));
                            this.moveTo(this.getBoxIn());
                        System.out.println("Counter ID : "+gameVariables.counterSelected.getID()+"  Box in : "+gameVariables.counterSelected.getBoxIn().getID()+"  Space was unoccupied space. Moved backward.");
                        }
                    }
                    gameVariables.moveMade = true;
                    gameVariables.playerTurn = "p1";
                }
            }
        }*/
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
    public void setDX(double dx) {
        this.dx = dx;
    }

    @Override
    public void setDY(double dy) {
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
        if(!boxIn.isSafeSpace()){
            boxIn.setOccupied(true, this.getID());
        }
        this.y = boxIn.getY() + 10;

    }

    @Override
    public void setTexture(Image texture) {
        this.texture = texture;
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
    public double getDX() {
        return this.dx;
    }

    @Override
    public double getDY() {
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
