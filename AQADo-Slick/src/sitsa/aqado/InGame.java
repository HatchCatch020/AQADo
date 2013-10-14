package sitsa.aqado;

import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import java.awt.Font;
import java.util.Random;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.Transition;
import sitsa.aqado.GUI.AbstractButton;
import sitsa.aqado.GUI.AbstractCounter;
import sitsa.aqado.GUI.AbstractboxGameComponent;
import sitsa.aqado.GUI.Box;

public class InGame extends BasicGameState {
	
	private int state, dieLandedNum;
    private Image bg, pauseBut, pauseOverlay, redCounterTex, blueCounterTex;
    private Button pauseButton;
    private Counter redCounter1, redCounter2, blueCounter1, blueCounter2;
    private pMenuButton quitToTitleButton, resumeButton, optionsButton, restartButton;
    private boolean PAUSED = false;
    private TrueTypeFont font, font2;
    public boolean comeFromPause = false;
    private Random rand = new Random();
    private boolean hasDieLanded = false;



    public InGame(int state) {
		this.state = state;
	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
        // Load images
        bg = new Image("tex/bg300x400.png");
        pauseBut = new Image("tex/pause.png");
        pauseOverlay = new Image("tex/overlay.png");
        redCounterTex = new Image("tex/redCounter.png");
        blueCounterTex = new Image("tex/blueCounter.png");
        // Load buttons
        pauseButton = new Button(665, 0, 29, 31, Color.transparent);
        resumeButton = new pMenuButton(245, 290, 200, 60, Color.cyan.darker());
        restartButton = new pMenuButton(245, 360, 200, 60, Color.cyan.darker());
        optionsButton = new pMenuButton(245, 430, 200, 60, Color.cyan.darker());
        quitToTitleButton = new pMenuButton(245, 500, 200, 60, Color.cyan.darker());
        // Load counters
        redCounter1 = new Counter(130, 730, redCounterTex, box1);
        redCounter2 = new Counter(218, 730, redCounterTex, box1);
        blueCounter1 = new Counter(430, 730, blueCounterTex, box1);
        blueCounter2 = new Counter(518, 730, blueCounterTex, box1);
        box11 = new Box(100, 20, 500, 70);
        box10 = new Box(100, 90, 500, 70);
        box9 = new Box(100, 160, 500, 70);
        box8 = new Box(100, 230, 500, 70);
        box7 = new Box(100, 300, 500, 70);
        box6 = new Box(100, 370, 500, 70);
        box5 = new Box(100, 440, 500, 70);
        box4 = new Box(100, 510, 500, 70);
        box3 = new Box(100, 580, 500, 70);
        box2 = new Box(100, 650, 500, 70);
        box1 = new Box(100, 720, 500, 70);
        // Initialize font
        Font awtFont = new Font("Arial", Font.BOLD, 24);
        font = new TrueTypeFont(awtFont, false);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g) throws SlickException {
        bg.draw(-600, -800);
        pauseBut.draw(670, 5);
        pauseButton.draw(g);

        // Draw Board
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
        font.drawString(337, 40, "11", Color.black);
        font.drawString(337, 40, "10", Color.black);

        // Draw counters
        redCounter1.draw(g);
        redCounter2.draw(g);
        blueCounter1.draw(g);
        blueCounter2.draw(g);

        // Draw die
        if(hasDieLanded == true){
            font.drawString(10, 40, ""+dieLandedNum, Color.black);
        }

        // Draw pause menu
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
        if(pauseButton.isMouseClicked(gc)){
            PAUSED = true;
        }

        // Board logic
            // define box numbers
        box11.setBoxNum(11);
        box10.setBoxNum(10);
        box9.setBoxNum(9);
        box8.setBoxNum(8);
        box7.setBoxNum(7);
        box6.setBoxNum(6);
        box5.setBoxNum(5);
        box4.setBoxNum(4);
        box3.setBoxNum(3);
        box2.setBoxNum(2);
        box1.setBoxNum(1);
        box11.setSpecialBox(true); // define if it is a safe/special box
        box5.setSpecialBox(true);
        box1.setSpecialBox(true);

        // Die logic
            //TODO die logic

        // Pause menu logic
        delta = getDelta();
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
            // TODO reset the board
        }
        if(optionsButton.isMouseClicked(gc)){
            game.enterState(2);
            gameVariables.fromPause = 1;
        }
        if(quitToTitleButton.isMouseClicked(gc)){
            game.enterState(1);
            PAUSED = false;
        }

        // Counter logic
            // TODO counter logic
        if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
            redCounter1.moveByF(1);
        }

        redCounter1.update(delta);
        redCounter2.update(delta);
        blueCounter1.update(delta);
        blueCounter2.update(delta);


	}

	@Override
	public int getID() {
		return this.state;
	}

    private static class Button extends AbstractButton{

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

    private static class Counter extends AbstractCounter{

        public Counter(float x, float y, Image texture, AbstractboxGameComponent box) {
            super(x, y, texture, box);
        }

        @Override
        public void draw(Graphics g) {
            texture.draw(x, y, (float) 1.3);
        }
    }

    private long lastFrame;

    private long getTime(){
        return (Sys.getTime() * 1000) / Sys.getTimerResolution();
    }

    private int getDelta(){
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
    }

}
