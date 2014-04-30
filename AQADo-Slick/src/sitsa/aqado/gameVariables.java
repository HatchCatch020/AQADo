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
    public static boolean hasPlayerWon = false;
    public static String playerWon = null;
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
    
    public static boolean checkMove(AbstractCounterComponent counter, int playerOtherCounterID){
        int nextBoxID = (int) counter.getBoxIn().getID() + diceLandedNum;
        AbstractBoxComponent nextBox = getBoxID(nextBoxID);
        int previousBoxID = (int) counter.getBoxIn().getID() - 1;
        AbstractBoxComponent previousBox = getBoxID(previousBoxID);
        if(diceLandedNum != 4){
            if(nextBox.getOccupiedBy() == playerOtherCounterID){
                return false;
            }else{
                return true;
            }
        }else if(diceLandedNum == 4){
            if(nextBox.getOccupiedBy() == play4rOtherCounterID){
                return false;
            }else{
                return true;
            }
        }
    }
