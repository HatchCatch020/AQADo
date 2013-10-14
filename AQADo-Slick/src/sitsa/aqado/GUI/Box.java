package sitsa.aqado.GUI;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 14/10/2013
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class Box  extends AbstractboxGameComponent{

    public Box(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }

    public void update(int delta) {
    }
}
