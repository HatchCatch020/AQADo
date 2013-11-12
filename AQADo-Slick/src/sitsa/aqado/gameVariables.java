package sitsa.aqado;

import sitsa.aqado.GUI.AbstractBoxComponent;
import sitsa.aqado.GUI.AbstractCounterComponent;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 12/10/2013
 * Time: 10:57
 * To change this template use File | Settings | File Templates.
 */
public class gameVariables {

    public static String p1Name;
    public static String p2Name;
    public static boolean fromPause = false;
    public static String playerTurn = "p1";

    public static boolean diceRolled = false;
    public static int diceLandedNum = 0;

    public static AbstractCounterComponent counterSelected;
    public static boolean isCounterSelected;
    public static boolean moveMade = false;

    public static HashMap boxes = new HashMap();
    public static HashMap counters = new HashMap();
    public static HashMap players = new HashMap();

    public static void addBox(AbstractBoxComponent box){
        boxes.put(new Integer((int) box.getID()), box);
    }

    public static AbstractBoxComponent getBoxID(int id) {
        return (AbstractBoxComponent) boxes.get(new Integer(id));
    }

    public static void addCounter(AbstractCounterComponent counter){
        counters.put(new Integer((int) counter.getID()), counter);
    }

    public static AbstractCounterComponent getCounterByID(int id) {
        return (AbstractCounterComponent) counters.get(new Integer(id));
    }

    public static boolean isLegalMove1(AbstractCounterComponent counter){
        /*if(counter.getBoxIn().nextBox().isOccupied() && (counter.getBoxIn().getOccupiedBy() == 3 || counter.getBoxIn().getOccupiedBy() == 4) && counter.getBoxIn().nextBox().getID() == 11){
            return false;
        }else{
            return true;
        }*/
        if(nextBox(counter.getBoxIn()).isOccupied() && (nextBox(counter.getBoxIn()).getOccupiedBy() == 3 || nextBox(counter.getBoxIn()).getOccupiedBy() == 4) && nextBox(counter.getBoxIn()).getID() == 11){
            return false;
        }else{
            return  true;
        }
    }
    public static boolean isLegalMove2(AbstractCounterComponent counter){
        /*if(counter.getBoxIn().nextBox().isOccupied() && (counter.getBoxIn().getOccupiedBy() == 1 || counter.getBoxIn().getOccupiedBy() == 2) && counter.getBoxIn().nextBox().getID() == 11){
            return false;
        }else{
            return true;
        }*/
        if(nextBox(counter.getBoxIn()).isOccupied() && (nextBox(counter.getBoxIn()).getOccupiedBy() == 1 || nextBox(counter.getBoxIn()).getOccupiedBy() == 2) && nextBox(counter.getBoxIn()).getID() == 11){
            return false;
        }else{
            return  true;
        }
    }

    public static AbstractBoxComponent nextBox(AbstractBoxComponent after){
        int i = (int) after.getID() + 1;
        AbstractBoxComponent nextBox = gameVariables.getBoxID(i);
        return nextBox;
    }

}
