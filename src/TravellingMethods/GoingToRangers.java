package TravellingMethods;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Prayer;
import org.powerbot.game.api.methods.tab.Prayer.Curses;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GoingToRangers extends Node {

	private final static Area toRangers = new Area(new Tile[] {
			new Tile(2848, 5312, 0), new Tile(2850, 5318, 0),
			new Tile(2853, 5329, 0), new Tile(2851, 5332, 0),
			new Tile(2851, 5337, 0), new Tile(2872, 5345, 0),
			new Tile(2897, 5326, 0), new Tile(2902, 5284, 0),
			new Tile(2861, 5287, 0) });

	private final static Tile[] toBigdoor = new Tile[] {
			new Tile(2879, 5314, 0), new Tile(2873, 5315, 0),
			new Tile(2870, 5319, 0), new Tile(2865, 5322, 0),
			new Tile(2860, 5327, 0), new Tile(2858, 5331, 0),
			new Tile(2854, 5334, 0), new Tile(2851, 5334, 0) };

	private final static int HUGEDOOR = 75132;

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return toRangers.contains(Players.getLocal().getLocation())
				&& getHp() > 4500;
	}

	@Override
	public void execute() {
		SceneObject hugedoor = SceneEntities.getNearest(HUGEDOOR);
		Prayer.togglePrayer(Curses.DEFLECT_MAGIC, false);
		Walking.newTilePath(toBigdoor).traverse();
		
		if(Integer.parseInt(Widgets.get(750, 6).getText())>40){
			Walking.setRun(true);
		}
		

		if (hugedoor.isOnScreen() && hugedoor != null) {
			hugedoor.interact("Bang");
			Task.sleep(4000);
		}

	}

	private int getHp() {
		return Integer.parseInt(Widgets.get(748, 8).getText());
	}
}
