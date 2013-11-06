package sitsa.aqado;

import sitsa.aqado.GUI.AbstractBoxComponent;
import sitsa.aqado.GUI.AbstractCounterComponent;
import sitsa.aqado.GUI.Box;

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
    public static int fromPause = 0;

    public static boolean diceRolled = false;
    public static float diceLandedNum = 1;

    public static HashMap boxes = new HashMap();
    public static HashMap counters = new HashMap();

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
}
