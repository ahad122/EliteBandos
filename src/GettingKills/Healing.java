package GettingKills;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.input.Mouse.Speed;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.node.Item;

public class Healing extends Node {

	
	
	public final static int SHARK = 385;
	public final static int MONKFISH = 7946;
	public final static int ROCKTAIL = 15272;
	
	
	private final static int[] TOTALFOOD = {385,7946,15272};
	@Override
	public boolean activate() {
	
		return getHp()<4500 && Inventory.contains(TOTALFOOD);
	}

	@Override
	public void execute() {
		
		Item FOOD = Inventory.getItem(TOTALFOOD);
		Mouse.setSpeed(Speed.VERY_FAST);
		FOOD.getWidgetChild().interact("Eat");
		Task.sleep(1000);

		
		
		
	}
	
	private int getHp(){
		return Integer.parseInt(Widgets.get(748, 8).getText());
	}

}
