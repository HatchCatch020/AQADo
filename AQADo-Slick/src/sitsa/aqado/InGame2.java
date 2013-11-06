package sitsa.aqado;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import sitsa.aqado.GUI.AbstractBoxComponent;
import sitsa.aqado.GUI.AbstractButton;
import sitsa.aqado.GUI.AbstractCounterComponent;

import java.awt.Font;

/**
 * Created with IntelliJ IDEA.
 * User: connormonaghan
 * Date: 02/11/2013
 * Time: 12:36
 * To change this template use File | Settings | File Templates.
 */

//NEW INGAME
public class InGame2 extends BasicGameState {

    private int state;
    private boolean PAUSED = false;
    private Image bg, pauseBut, pauseOverlay, redCounterTex, blueCounterTex;
    private Button pauseButton;
    private pMenuButton quitToTitleButton, resumeButton, optionsButton, restartButton;
    public boxComponent box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11;
    private TrueTypeFont font;
    private CounterComponent redCounter1, redCounter2, blueCounter1, blueCounter2;

    public InGame2(int state){
        this.state = state;
    }

    @Override
    public int getID() {
        return this.state;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        // Initialize images
        bg = new Image("tex/bg300x400.png");
        redCounterTex = new Image("tex/redCounter.png");
        blueCounterTex = new Image("tex/blueCounter.png");
        // Load boxes
        box11 = new boxComponent(100, 20, 500, 70, 11);
        box10 = new boxComponent(100, 90, 500, 70, 10);
        box9 = new boxComponent(100, 160, 500, 70, 9);
        box8 = new boxComponent(100, 230, 500, 70, 8);
        box7 = new boxComponent(100, 300, 500, 70, 7);
        box6 = new boxComponent(100, 370, 500, 70, 6);
        box5 = new boxComponent(100, 440, 500, 70, 5);
        box4 = new boxComponent(100, 510, 500, 70, 4);
        box3 = new boxComponent(100, 580, 500, 70, 3);
        box2 = new boxComponent(100, 650, 500, 70, 2);
        box1 = new boxComponent(100, 720, 500, 70, 1);
        // Load counters
        redCounter1 = new CounterComponent(130, 730, 51, 51, 1, redCounterTex, box1);
        redCounter2 = new CounterComponent(218, 730, 51, 51, 2, redCounterTex, box1);
        blueCounter1 = new CounterComponent(430, 730, 51, 51, 3, blueCounterTex, box1);
        blueCounter2 = new CounterComponent(518, 730, 51, 51, 4, blueCounterTex, box1);
        // Load buttons
            //Pause menu
            pauseButton = new Button(665, 0, 29, 31, Color.transparent);
            pauseBut = new Image("tex/pause.png");
            pauseOverlay = new Image("tex/overlay.png");
            resumeButton = new pMenuButton(245, 290, 200, 60, Color.cyan.darker());
            restartButton = new pMenuButton(245, 360, 200, 60, Color.cyan.darker());
            optionsButton = new pMenuButton(245, 430, 200, 60, Color.cyan.darker());
            quitToTitleButton = new pMenuButton(245, 500, 200, 60, Color.cyan.darker());
        // Initialize font
        Font awtFont = new Font("Arial", Font.BOLD, 24);
        font = new TrueTypeFont(awtFont, false);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        bg.draw(-600,-800);
        // Render boxes
        box11.draw(g);
        box10.draw(g);
        box9.draw(g);
        box8.draw(g);
        box7.draw(g);
        box6.draw(g);
        box5.draw(g);
        box4.draw(g);
        box3.draw(g);
        box2.draw(g);
        box1.draw(g);
        g.drawRect(300, 20, 100, 770);

        // Render counters
        redCounter1.draw(g);
        redCounter2.draw(g);
        blueCounter1.draw(g);
        blueCounter2.draw(g);

        // Render info boxes
        g.setColor(Color.green.darker().darker());
        g.fillRect(10, 70, 80, 30);
        g.setColor(Color.green.darker());
        g.fillRect(10, 100, 80, 50);

        //Pause menu
            pauseBut.draw(670, 5);
            pauseButton.draw(g);
            if(PAUSED == true){
                pauseOverlay.draw(0, 0);
                resumeButton.draw(g);
                restartButton.draw(g);
                optionsButton.draw(g);
                quitToTitleButton.draw(g);
                g.drawString("Resume", 315, 310);
                g.drawString("Restart", 315, 380);
                g.drawString("Options", 315, 450);
                g.drawString("Quit to title", 290, 520);
            }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame game, int delta) throws SlickException {

        // Core game logic
            //TODO core game logic

        // Dice logic
            //TODO dice logic

        // Counter logic
            //TODO dynamic counter movement
        AbstractBoxComponent i = gameVariables.getBoxID((int) redCounter1.getBoxIn().getID() + 1);

        if(redCounter1.isClicked(gc)){
            redCounter1.setBoxIn(gameVariables.getBoxID((int) redCounter1.getBoxIn().getID() + 1));
            redCounter1.moveTo(redCounter1.getBoxIn());
            redCounter1.getBoxIn().setOccupied(true, redCounter1.getID());
        }
        if(redCounter2.isClicked(gc)){
            redCounter2.setBoxIn(gameVariables.getBoxID((int) redCounter2.getBoxIn().getID() + 1));
            redCounter2.moveTo(redCounter2.getBoxIn());
            redCounter2.getBoxIn().setOccupied(true, redCounter2.getID());
        }
        if(blueCounter1.isClicked(gc)){
            blueCounter1.setBoxIn(gameVariables.getBoxID((int) blueCounter1.getBoxIn().getID() + 1));
            blueCounter1.moveTo(blueCounter1.getBoxIn());
            blueCounter1.getBoxIn().setOccupied(true, blueCounter1.getID());
        }
        if(blueCounter2.isClicked(gc)){
            blueCounter2.setBoxIn(gameVariables.getBoxID((int) blueCounter2.getBoxIn().getID() + 1));
            blueCounter2.moveTo(blueCounter2.getBoxIn());
            blueCounter2.getBoxIn().setOccupied(true, blueCounter2.getID());
        }


        redCounter1.update(delta);
        redCounter2.update(delta);
        blueCounter1.update(delta);
        blueCounter2.update(delta);

            //Pause menu
            if(pauseButton.isMouseClicked(gc)){
                PAUSED = true;
            }
            if(PAUSED == true){
                if(resumeButton.isMouseOn(gc)){
                    resumeButton.setFillColor(Color.cyan.brighter());
                }else{
                    resumeButton.setFillColor(Color.cyan.darker());
                }
                if(restartButton.isMouseOn(gc)){
                    restartButton.setFillColor(Color.cyan.brighter());
                }else{
                    restartButton.setFillColor(Color.cyan.darker());
                }
                if(optionsButton.isMouseOn(gc)){
                    optionsButton.setFillColor(Color.cyan.brighter());
                }else{
                    optionsButton.setFillColor(Color.cyan.darker());
                }
                if(quitToTitleButton.isMouseOn(gc)){
                    quitToTitleButton.setFillColor(Color.cyan.brighter());
                }else{
                    quitToTitleButton.setFillColor(Color.cyan.darker());
                }
                if(resumeButton.isMouseClicked(gc)){
                    PAUSED = false;
                }
                if(restartButton.isMouseClicked(gc)){
                    // TODO fix bug making line width thinner
                    gc.reinit();
                    PAUSED = false;
                    game.enterState(5);
                }
                if(optionsButton.isMouseClicked(gc)){
                    game.enterState(2);
                    gameVariables.fromPause = 1;
                }
                if(quitToTitleButton.isMouseClicked(gc)){
                    game.enterState(1);
                    PAUSED = false;
                }
            }
    }

    private static class Button extends AbstractButton {

        public Button(float x, float y, float width, float height, Color fillColor) {
            super(x, y, width, height, fillColor);
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(fillColor);
            g.drawRect(x, y, width, height);
        }

        public void update(int delta) {
        }
    }

    private static class pMenuButton extends AbstractButton{

        public pMenuButton(float x, float y, float width, float height, Color fillColor) {
            super(x, y, width, height, fillColor);
        }

        @Override
        public void draw(Graphics g) {
            g.setLineWidth(3);
            g.setColor(fillColor);
            g.fillRoundRect(x, y, width, height, 15);
            g.setColor(Color.black);
            g.drawRoundRect(x, y, width, height, 15);
        }

        public void update(int delta) {
        }
    }

    private static class boxComponent extends AbstractBoxComponent{

        float nextBoxNum = 0;

        public boxComponent(float x, float y, float width, float height, float boxNum){
            super(x, y, width, height, boxNum);
        }

        @Override
        public void draw(Graphics g) {
            g.setColor(Color.black);
            g.drawRect(x, y, width, height);
            this.setboxDrawn(true);
            //this.nextBoxNum = this.nextBoxNum + 1;
        }

        // the star of riches is shinning on you

        @Override
        public void update(int delta) {
            if(this.isBoxDrawn()){
                //this.setBoxNum(nextBoxNum);
            }
        }

        @Override
        public AbstractBoxComponent nextBox() {
            if(this.id == 1){

            }
            return null;
        }

    }

    private static class CounterComponent extends AbstractCounterComponent{

        public CounterComponent(float x, float y, float width, float height, float id, Image texture, AbstractBoxComponent boxIn) {
            super(x, y, width, height, id, texture, boxIn);
        }

        @Override
        public void draw(Graphics g) {
            texture.draw(x, y, (float) 1.3);
        }
    }
}
