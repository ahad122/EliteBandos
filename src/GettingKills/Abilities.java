package GettingKills;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.interactive.NPC;

import Main.EliteBandos;

import sk.action.ActionBar;
import sk.action.book.BookAbility;

public class Abilities extends Node {

	private final static int WHATTOKILL = 6276;
	@Override
	public boolean activate() {
		NPC KillingStuff = NPCs.getNearest(WHATTOKILL);
		
		return Players.getLocal().isInCombat() && getHp() >4000 && ((BookAbility.SEVER.available() && EliteBandos.useSever == true) || (BookAbility.SLICE.available() && EliteBandos.useSlice == true) || (BookAbility.SMASH.available() && EliteBandos.useSmash == true) || (BookAbility.HURRICANE.available() && EliteBandos.useHurricane == true) || (BookAbility.OVERPOWER.available() && EliteBandos.useOverpower == true) || (BookAbility.BERSERK.available() && EliteBandos.useBeserk == true) || (BookAbility.MASSACRE.available() && EliteBandos.useMassacre == true) ||(BookAbility.SLAUGHTER.available() && EliteBandos.useSlaughter == true));
	}

	@Override
	public void execute() {
		NPC KillingStuff = NPCs.getNearest(WHATTOKILL);
		
		if(Players.getLocal().getInteracting()!=null &&Players.getLocal().getInteracting()!=KillingStuff){
			KillingStuff.interact("Attack");
			Task.sleep(1000);
		}
		
		if(BookAbility.SEVER.available() && EliteBandos.useSever == true){
			ActionBar.useAbility(BookAbility.SEVER);
			EliteBandos.status = "Using Ability Sever";
		}
		
		if(BookAbility.SLICE.available() && EliteBandos.useSlice == true){
			ActionBar.useAbility(BookAbility.SLICE);
			EliteBandos.status = "Using Ability Slice";
		}
		
		if(BookAbility.SMASH.available() && EliteBandos.useSmash == true){
			ActionBar.useAbility(BookAbility.SMASH);
			EliteBandos.status = "Using Ability Smash";
		}
		
		if(BookAbility.HURRICANE.available() && EliteBandos.useHurricane == true &&Integer.parseInt(Widgets.get(601, 19).getText())>40){
			ActionBar.useAbility(BookAbility.HURRICANE);
			EliteBandos.status = "Using Ability Hurricane";
		}
		
		if(BookAbility.OVERPOWER.available() && EliteBandos.useOverpower == true){
			ActionBar.useAbility(BookAbility.OVERPOWER);
			EliteBandos.status = "Using Ability Overpower";
		}
		
		if(BookAbility.BERSERK.available() && EliteBandos.useBeserk == true){
			ActionBar.useAbility(BookAbility.BERSERK);
			EliteBandos.status = "Using Ability Beserk";
		}
		
		if(BookAbility.MASSACRE.available() && EliteBandos.useMassacre == true){
			ActionBar.useAbility(BookAbility.MASSACRE);
			EliteBandos.status = "Using Ability Massacre";
		}
		
		if(BookAbility.SLAUGHTER.available() && EliteBandos.useSlaughter == true){
			ActionBar.useAbility(BookAbility.SLAUGHTER);
			EliteBandos.status = "Using Ability Slaughter";
		}
		
		

	}
	
	
	private int getHp(){
		return Integer.parseInt(Widgets.get(748, 8).getText());
	}

}
