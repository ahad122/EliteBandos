package GettingKills;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.input.Mouse.Speed;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.tab.Prayer;
import org.powerbot.game.api.wrappers.node.Item;

public class PrayRestore extends Node {
	
	 private final static int[ ]PRAYERPOTS     =  {23243, 23245, 23247, 23249,23251, 23253 ,2434, 139, 141, 143};

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Prayer.getPoints()<=350 && Inventory.getCount(PRAYERPOTS)!=0;
	}

	@Override
	public void execute() {
		Item PrayersPots = Inventory.getItem(PRAYERPOTS);
		Mouse.setSpeed(Speed.VERY_FAST);
		PrayersPots.getWidgetChild().interact("Drink");
		Task.sleep(200,300);
		
		
	

	}
	


}
