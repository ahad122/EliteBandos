package GettingKills;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.input.Mouse.Speed;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Prayer;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.tab.Prayer.Curses;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.client.Skill;

public class GettingRequiredKills extends Node {
	
	private final static Area WhereToGetKills = new Area(new Tile[]{
			new Tile(2884,5318,0), new Tile(2870,5315,0), new Tile(2875,5344,0), new Tile(2886,5332,0)});

	
	
	private final static int WHATTOKILL = 6276;
	private final static int VIAL =229;
	
	@Override
	public boolean activate() {
		NPC KillingStuff = NPCs.getNearest(WHATTOKILL);
		
		
		
		return Players.getLocal().getInteracting()== null && Players.getLocal().getInteracting()!=KillingStuff   && getHp() >=4500 && Integer.parseInt(Widgets.get(601, 19).getText())<40 && Prayer.getPoints()>350;
	}

	
	
	
	@Override
	public void execute() {
		Item vial = Inventory.getItem(VIAL);
		
		
		
		
		if(Inventory.getCount(VIAL)!=0){
			vial.getWidgetChild().interact("Drop");
		}
		
		NPC KillingStuff = NPCs.getNearest(WHATTOKILL);
		Mouse.setSpeed(Speed.FAST);
		
		if(KillingStuff.isOnScreen() && KillingStuff!=null){
			Camera.turnTo(KillingStuff);
			KillingStuff.interact("Attack");
			Task.sleep(1000, 2000);
		}
		
		
		if(KillingStuff.isOnScreen() && KillingStuff!=null && Players.getLocal().getInteracting()!=KillingStuff){
			Camera.turnTo(KillingStuff);
			KillingStuff.interact("Attack");
			Task.sleep(1000, 2000);
			
		}
		
		if(Skills.getLevel(Skills.PRAYER)>=92 && getHp()<5000){
			Prayer.togglePrayer(Curses.SOUL_SPLIT, true);
			
		}
		if((Skills.getLevel(Skills.PRAYER)>=92 && getHp()<6500)){
			Prayer.togglePrayer(Curses.SOUL_SPLIT, false);
		}
		
		
		

	}
	
	
	private int getHp(){
		return Integer.parseInt(Widgets.get(748, 8).getText());
	}

}
