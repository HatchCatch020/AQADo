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
    public static boolean isOccupiedByCounter;
    public static AbstractCounterComponent getCounterOccupiedBy;

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

    public static boolean LegalMove1(AbstractCounterComponent counter){
        if(nextBox(counter.getBoxIn()).isSafeSpace()){
            return true;
        }else if(nextBox(counter.getBoxIn()).getOccupiedBy() == 3 || nextBox(counter.getBoxIn()).getOccupiedBy() == 4){
            isOccupiedByCounter = true;
            getCounterOccupiedBy = getCounterByID((int) nextBox(counter.getBoxIn()).getOccupiedBy());
            return true;
        }else{
            return true;
        }
    }

    public static boolean isLegalMove2(AbstractCounterComponent counter){
        if(nextBox(counter.getBoxIn()).isSafeSpace() || nextBox(counter.getBoxIn()).isOccupied() == false){
            return true;
        }else if(nextBox(counter.getBoxIn()).getOccupiedBy() == 3 || nextBox(counter.getBoxIn()).getOccupiedBy() == 4 || counter.getBoxIn().getID() == 11){
            return false;
        }else if(nextBox(counter.getBoxIn()).getOccupiedBy() == 1 || nextBox(counter.getBoxIn()).getOccupiedBy() == 2){
            isOccupiedByCounter = true;
            getCounterOccupiedBy = getCounterByID((int) nextBox(counter.getBoxIn()).getOccupiedBy());
            return true;
        }else{
            return false;
        }
    }

    public static AbstractBoxComponent nextBox(AbstractBoxComponent after){
        int i = (int) after.getID() + diceLandedNum;
        AbstractBoxComponent nextBox = gameVariables.getBoxID(i);
        return nextBox;
    }

    public static AbstractBoxComponent lastBox(AbstractBoxComponent before){
        int i = (int) before.getID() - 1;
        AbstractBoxComponent lastBox = gameVariables.getBoxID(i);
        return lastBox;
    }
}
