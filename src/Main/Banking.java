package Main;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.input.Mouse.Speed;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;
import org.powerbot.game.api.wrappers.node.Item;
import org.powerbot.game.api.wrappers.node.SceneObject;

import sk.action.ActionBar;
import sk.action.book.BookAbility;
import sk.action.book.magic.Spell;

public class Banking extends Node {

	Area VarrockBank = new Area(new Tile[] { new Tile(3194, 3447, 0), new Tile(3177, 3447, 0), new Tile(3177, 3431, 0), 
			new Tile(3194, 3431, 0) });

	private final static Area FallyBankArea = new Area(new Tile[] {
			new Tile(2946, 3373, 0), new Tile(2942, 3373, 0),
			new Tile(2942, 3367, 0), new Tile(2947, 3367, 0),
			new Tile(2947, 3373, 0) });

	private final static int[] BANKERS = { 782, 7897 };
	public final static int SHARK = 385;
	public final static int MONKFISH = 7946;
	public final static int ROCKTAIL = 15272;
	private static final int[] PRAYER_POTS = { 2434, 139, 141, 143 };
	private static final int[] PRAY_FLASKS = { 23243, 23245, 23247, 23249,23251, 23253 };
	private static final int[] RENEWALS = { 21630, 21632, 21634, 21636 };
	private static final int[] RENEW_FLASKS = { 23609, 23611, 23613, 23615,
			23617, 23619 };
	private static final int[] OVERLOADS = { 23531, 23532, 23533, 23534, 23535,
			23536, 15332, 15333, 15334, 15335 };
	private static final int[] EXTREME_STRENGTHS = { 15312, 15313, 15314, 15315 };
	private static final int[] SUPER_STRENGTH = { 2440, 157, 159, 161 };
	private static final int[] EXTREME_ATTACK = { 15308, 15309, 15310, 1511 };
	private static final int[] SUPER_ATTACK = { 2436, 145, 147, 149 };
	private static final int[] EXTREME_DEFENCE = { 15316, 15317, 15318, 15319 };
	private static final int[] SUPER_DEFENCE = { 2442, 163, 165, 167 };

	public final static int VARROCK_TAB = 8007;
	public final static int FALA_TAB = 8009;
	public static boolean PrayIsEnab = false;
	private static boolean BankNow = true;

	@Override
	public boolean activate() {

		return VarrockBank.contains(Players.getLocal().getLocation())
				|| FallyBankArea.contains(Players.getLocal().getLocation());
	}

	@Override
	public void execute() {
Mouse.setSpeed(Speed.FAST);
		SceneObject banker = SceneEntities.getNearest(BANKERS);
		Item TROLLTAB = Inventory.getItem(20175);
		ActionBar.setExpanded(false);

		if (banker.isOnScreen() && banker != null && BankNow == true) {
			EliteBandos.status = "Going to bank";
			Camera.turnTo(banker);
			banker.interact("Bank");
			Task.sleep(3000);

		}

		if (Bank.isOpen() ) {
			EliteBandos.status = "Depositing Inventory";
			Bank.depositInventory();
			EliteBandos.status = "Withdrawing Items";
			
			
			if(EliteBandos.WHERETOBANK == 1){
				Bank.withdraw(VARROCK_TAB, 1);
			} else if(EliteBandos.WHERETOBANK == 2){
				Bank.withdraw(FALA_TAB, 1);
			}
			
			if(EliteBandos.TRANSPORTATION == 2){
				Bank.withdraw(554, 2);
				Task.sleep(200);
				Bank.withdraw(563, 2);
			} else if(EliteBandos.TRANSPORTATION == 3){
				Bank.withdraw(20175, 1);
			}
			
			
			

			if (EliteBandos.EnableOverload == true) {
				Bank.withdraw(EliteBandos.OVERLOADTYPE,
						EliteBandos.OverloadNumber);
				Task.sleep(100,150);
			}
			if (EliteBandos.EnableRenewal == true) {
				Bank.withdraw(EliteBandos.RENEWALTYPE,
						EliteBandos.PrayerRenewalPots);
				Task.sleep(100,150);
			}

			if (EliteBandos.EnablePrayer == true) {
				Bank.withdraw(EliteBandos.PRAYERPOTSTYPE,
						EliteBandos.PrayerPots);
				Task.sleep(100,150);
			}

			if (EliteBandos.EnableFood == true) {
				Bank.withdraw(EliteBandos.FOODTYPE, EliteBandos.FoodNumber);
				Task.sleep(100,150);
				
				
			}
			
			Bank.close();
			BankNow = false;
			Task.sleep(1000);
			

		}
		ActionBar.setExpanded(true);
		
		if(EliteBandos.TRANSPORTATION == 1 ){
			ActionBar.useAbility(Spell.HOME_TELEPORT);
			
			
		Task.sleep(3000);
		if(Widgets.get(1092, 42).isOnScreen()){
			Widgets.get(1092, 42).interact("Teleport");
			
		}
		Task.sleep(12000);
		BankNow = true;
		
		}
		if(EliteBandos.TRANSPORTATION == 2 ){
		ActionBar.useAbility(Spell.STANDARD_TROLLHEIM_TELEPORT);
		Task.sleep(3000);
		BankNow = true;
		
		}  if(EliteBandos.TRANSPORTATION == 3 ){
			TROLLTAB.getWidgetChild().interact("Break");
			Task.sleep(2000);
			BankNow = true;
		

	}
	}

}
