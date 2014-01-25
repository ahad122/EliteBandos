package TravellingMethods;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Prayer;
import org.powerbot.game.api.methods.tab.Prayer.Curses;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class GettingThereTabs extends Node {

	private final static Area TROLLHEIM_AREA = new Area(new Tile[] {
			new Tile(2885, 3760, 0), new Tile(2882, 3658, 0),
			new Tile(2937, 3657, 0), new Tile(2938, 3755, 0) });

	private final static Area WHERELANDED = new Area(new Tile[] {
			new Tile(2889, 3676, 0), new Tile(2893, 3676, 0),
			new Tile(2893, 3667, 0), new Tile(2888, 3668, 0) });

	private final static int FIRSTCLIFF = 17030;

	private final static Tile[] tosecondRock = new Tile[] {
			new Tile(2900, 3676, 0), new Tile(2904, 3678, 0),
			new Tile(2906, 3680, 0), new Tile(2908, 3685, 0) };

	private final static Area beforeSecondPart = new Area(new Tile[] {
			new Tile(2911, 3690, 0), new Tile(2916, 3690, 0),
			new Tile(2916, 3687, 0), new Tile(2917, 3687, 0),
			new Tile(2917, 3686, 0), new Tile(2919, 3686, 0),
			new Tile(2919, 3685, 0), new Tile(2920, 3685, 0),
			new Tile(2920, 3684, 0), new Tile(2922, 3684, 0),
			new Tile(2922, 3676, 0), new Tile(2911, 3676, 0) });

	private final static Area toRangers = new Area(new Tile[] {
			new Tile(2848, 5312, 0), new Tile(2850, 5318, 0),
			new Tile(2853, 5329, 0), new Tile(2851, 5332, 0),
			new Tile(2851, 5337, 0), new Tile(2872, 5345, 0),
			new Tile(2897, 5326, 0), new Tile(2902, 5284, 0),
			new Tile(2861, 5287, 0) });

	private final static Area totalSecondArea = new Area(new Tile[] {
			new Tile(2918, 3674, 0), new Tile(2924, 3674, 0),
			new Tile(2924, 3677, 0), new Tile(2926, 3677, 0),
			new Tile(2926, 3679, 0), new Tile(2924, 3681, 0),
			new Tile(2924, 3683, 0), new Tile(2923, 3684, 0),
			new Tile(2923, 3686, 0), new Tile(2918, 3689, 0),
			new Tile(2920, 3689, 0), new Tile(2920, 3691, 0),
			new Tile(2918, 3692, 0), new Tile(2918, 3697, 0),
			new Tile(2914, 3699, 0), new Tile(2912, 3701, 0),
			new Tile(2905, 3701, 0), new Tile(2903, 3708, 0),
			new Tile(2912, 3708, 0), new Tile(2929, 3697, 0),
			new Tile(2932, 3673, 0), new Tile(2927, 3662, 0),
			new Tile(2918, 3662, 0) });

	private final static Tile[] toEntranceRock = new Tile[] {
			new Tile(2920, 3673, 0), new Tile(2924, 3671, 0),
			new Tile(2926, 3674, 0), new Tile(2927, 3678, 0),
			new Tile(2926, 3682, 0), new Tile(2924, 3686, 0),
			new Tile(2922, 3690, 0), new Tile(2921, 3694, 0),
			new Tile(2918, 3698, 0), new Tile(2914, 3701, 0),
			new Tile(2909, 3703, 0), new Tile(2907, 3706, 0) };

	private final static Area TotalThirdArea = new Area(new Tile[] {
			new Tile(2902, 3710, 0), new Tile(2903, 3761, 0),
			new Tile(2927, 3760, 0), new Tile(2917, 3709, 0) });
	private final static Area AREABETWEENFIRSTSECOND = new Area(new Tile[] {
			new Tile(2897, 3673, 0), new Tile(2897, 3689, 0),
			new Tile(2908, 3687, 0), new Tile(2908, 3655, 0) });

	private final static Tile[] toGWDEntrance = new Tile[] {
			new Tile(2908, 3711, 0), new Tile(2909, 3716, 0),
			new Tile(2910, 3721, 0), new Tile(2911, 3726, 0),
			new Tile(2913, 3731, 0), new Tile(2914, 3736, 0),
			new Tile(2914, 3739, 0) };

	private final static Area Something = new Area(new Tile[] {
			new Tile(2908, 3681, 0), new Tile(2906, 3681, 0),
			new Tile(2904, 3687, 0), new Tile(2908, 3687, 0) });

	private final static Area ThirdCLiff = new Area(new Tile[] {
			new Tile(2922, 3676, 0), new Tile(2917, 3676, 0),
			new Tile(2917, 3679, 0), new Tile(2922, 3679, 0) });
	private final static Tile[] toFirstCliff = new Tile[] {
			new Tile(2890, 3671, 0), new Tile(2893, 3674, 0) };

	private final static Tile[] myTiles = new Tile[] { new Tile(2914, 3686, 0),
			new Tile(2916, 3685, 0), new Tile(2918, 3683, 0),
			new Tile(2919, 3682, 0), new Tile(2919, 3680, 0),
			new Tile(2919, 3678, 0), new Tile(2919, 3676, 0) };

	private final static int ENTRANCEROCK = 35390;
	private final static int GWDEntrance = 75452;

	@Override
	public boolean activate() {

		return TROLLHEIM_AREA.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
		SceneObject firstcliff = SceneEntities.getNearest(FIRSTCLIFF);

		if (beforeSecondPart.contains(Players.getLocal().getLocation())) {
			Walking.newTilePath(myTiles).traverse();
			if (ThirdCLiff.contains(Players.getLocal().getLocation())
					&& firstcliff.isOnScreen() && firstcliff != null) {
				firstcliff.interact("Climb");
				Task.sleep(6000);
			}
		}

		if (WHERELANDED.contains(Players.getLocal().getLocation())) {
			Walking.newTilePath(toFirstCliff).traverse();

			if (WHERELANDED.contains(Players.getLocal().getLocation())
					&& firstcliff.isOnScreen() && firstcliff != null) {
				firstcliff.interact("Climb");
				Task.sleep(1000, 1500);
			}
		}

		if (AREABETWEENFIRSTSECOND.contains(Players.getLocal().getLocation())) {
			Walking.newTilePath(tosecondRock).traverse();
			if (Something.contains(Players.getLocal().getLocation())
					&& firstcliff.isOnScreen() && firstcliff != null) {
				firstcliff.interact("Climb");
				Task.sleep(1000, 1500);
			}

		}

		if (totalSecondArea.contains(Players.getLocal().getLocation())) {
			SceneObject HugeRock = SceneEntities.getNearest(ENTRANCEROCK);
			Walking.newTilePath(toEntranceRock).traverse();

			if (HugeRock.isOnScreen() && HugeRock != null) {
				HugeRock.interact("Lift");
				Task.sleep(3000);
			}
		}

		if (TotalThirdArea.contains(Players.getLocal().getLocation())) {
			SceneObject gwdEntrance = SceneEntities.getNearest(GWDEntrance);

			Prayer.togglePrayer(Curses.DEFLECT_MELEE, true);
			Walking.newTilePath(toGWDEntrance).traverse();
			if (gwdEntrance.isOnScreen() && gwdEntrance != null) {
				Prayer.deactivateAll();
				Prayer.togglePrayer(Curses.DEFLECT_MAGIC, true);
				gwdEntrance.interact("Climb-down");
				Task.sleep(6000);
			}

		}

	}

}
