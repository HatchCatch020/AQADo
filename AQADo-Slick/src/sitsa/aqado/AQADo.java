package sitsa.aqado;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class AQADo extends StateBasedGame {
	
	public final int Main_Menu = 1;
	public final int Name_Input = 2;
	public final int In_Game = 3;
    public final int How_To = 4;

	public AQADo(String gamename) {
		super(gamename);
		this.addState(new MainMenu(Main_Menu));
		this.addState(new NameInput(Name_Input));
		this.addState(new InGame(In_Game));
        this.addState(new HowTo(How_To));
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.getState(Main_Menu).init(container, this);
		this.getState(Name_Input).init(container, this);
		this.getState(In_Game).init(container, this);
        this.getState(How_To).init(container, this);
		
		this.enterState(Main_Menu);
	}
	
	public static void main(String[] args){
		try{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new AQADo("AQADo"));
			appgc.setDisplayMode(700,  800, false);
			appgc.setShowFPS(false);
			appgc.start();
		}catch(SlickException ex){
			Logger.getLogger(AQADo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}