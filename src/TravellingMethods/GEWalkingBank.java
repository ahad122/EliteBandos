package TravellingMethods;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

public class GEWalkingBank extends Node {
	
	
	private final static Area GEWalkArea = new Area(new Tile[] { new Tile(3191, 3447, 0), new Tile(3191, 3467, 0), new Tile(3153, 3470, 0), 
			new Tile(3155, 3447, 0) });
	
	private final static Area NORMALAREA = new Area(new Tile[] { new Tile(3177, 3431, 0), new Tile(3194, 3431, 0), new Tile(3197, 3438, 0), 
			new Tile(3224, 3438, 0), new Tile(3224, 3417, 0), new Tile(3178, 3417, 0) });

	
private final static 	Tile[] toBank = new Tile[] { new Tile(3165, 3460, 0), new Tile(3168, 3457, 0), new Tile(3172, 3456, 0), 
			new Tile(3175, 3454, 0), new Tile(3178, 3452, 0), new Tile(3182, 3450, 0), 
			new Tile(3185, 3448, 0), new Tile(3186, 3444, 0) };

private final static Tile[] toBankNORMAL = new Tile[] { new Tile(3207, 3428, 0), new Tile(3202, 3428, 0), new Tile(3198, 3429, 0), 
		new Tile(3193, 3429, 0), new Tile(3189, 3429, 0), new Tile(3187, 3430, 0), 
		new Tile(3185, 3434, 0) };
	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return GEWalkArea.contains(Players.getLocal().getLocation()) || NORMALAREA.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		if(GEWalkArea.contains(Players.getLocal())){
		Walking.newTilePath(toBank).traverse();
		} else if (NORMALAREA.contains(Players.getLocal().getLocation())){
			Walking.newTilePath(toBankNORMAL).traverse();
			
		}

	}

}
