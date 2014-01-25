package Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.job.state.Tree;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Timer;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Attack;
import org.powerbot.game.api.methods.tab.Prayer;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.util.Random;

import BossKills.GeneralGraardor;
import BossKills.MageMinion;
import BossKills.MeleeMinion;
import BossKills.RangeMinion;
import GettingKills.Abilities;
import GettingKills.GettingRequiredKills;
import GettingKills.Healing;
import GettingKills.PrayRestore;
import TravellingMethods.GEWalkingBank;
import TravellingMethods.GettingThereTabs;
import TravellingMethods.GettingThereWalk;
import TravellingMethods.GoingToRangers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.SwingConstants;

@Manifest(authors = "Ahad", name = "EliteBandos Pro", version = 1.0, description = "Kills General Graardor")
public class EliteBandos extends ActiveScript implements MouseListener,
		PaintListener {

	private final Sparks sparks = new Sparks();
	private Tree jobs = null;
	private final Image paint = getImage("http://i47.tinypic.com/wm1li9.png");
	private final Image hidebutton = getImage("http://i47.tinypic.com/o0ldl.png");
	private final Image NewMouse = getImage("http://i47.tinypic.com/315h64j.png");
	private final Image WhenClicked = getImage("http://i47.tinypic.com/rlgdae.png");
	private Timer runTime = new Timer(0);
	public static String status = "Loading..";
	public final double Version = 1.1;
	Rectangle close = new Rectangle(501, 372, 50, 50);
	public boolean ShowPaint = true;
	private boolean guiWait = true;
	public static boolean EnablePrayer = false;
	public static boolean EnableRenewal = false;
	public static boolean EnableFood = false;
	public static boolean EnableOverload = false;
	public static int PrayerPots = 0;
	public static int PrayerRenewalPots = 0;
	public static int FoodNumber = 0;
	public static int OverloadNumber = 0;
	public static int PRAYERPOTSTYPE = 2434;
	public static int RENEWALTYPE = 21630;
	public static int FOODTYPE;
	public static int OVERLOADTYPE = 15332;
	public static int WHERETOBANK;
	public static int TRANSPORTATION;
	public static boolean useSever = false;
	public static boolean useSmash = false;
	public static boolean useSlice = false;
	public static boolean useHurricane = false;
	public static boolean useOverpower = false;
	public static boolean useBeserk = false;
	public static boolean useSlaughter = false;
	public static boolean useMassacre = false;
	public static final int StartHpXp = Skills.getExperience(Skills.CONSTITUTION);
	public static final int StartAttackXp = Skills.getExperience(Skills.ATTACK);
	public static final int StartStrengthXp = Skills.getExperience(Skills.STRENGTH);
	public static final int StartDefenceXp = Skills.getExperience(Skills.DEFENSE);
	public static final int StartMagicXp = Skills.getExperience(Skills.MAGIC);
	public static final int StartAgilityXp = Skills.getExperience(Skills.AGILITY);
	public static boolean RETON = true;
	

	GUI g = new GUI();

	public void onStart() {
		g.setVisible(true);
	}
	
	
	public int TotalXP(){
		
		 int CurHpXp = Skills.getExperience(Skills.CONSTITUTION);
		 int CurAttackXp = Skills.getExperience(Skills.ATTACK);
		 int CurStrengthXp = Skills.getExperience(Skills.STRENGTH);
		 int CurDefenceXp = Skills.getExperience(Skills.DEFENSE);
		 int CurMagicXp = Skills.getExperience(Skills.MAGIC);
		 int CurAgilityXp = Skills.getExperience(Skills.AGILITY);
		 
		 
		 
		 
		 
		int GainedHpXp = CurHpXp - StartHpXp;
		int GainedAttackXp = CurAttackXp - StartAttackXp;
		int GainedStrengthXp = CurStrengthXp -StartStrengthXp;
		int GainedDefenceXp = CurDefenceXp- StartDefenceXp;
		int GainedMagicXp = CurMagicXp - StartMagicXp;
		int GainedAgilityXp = CurAgilityXp - StartAgilityXp;
		
		
		
		return (GainedHpXp+ GainedAttackXp+GainedStrengthXp+GainedDefenceXp+GainedMagicXp+GainedAgilityXp);
	}
	
	public int XpPerhour(int TotalXP){
		
		
		
		return TotalXP ;
		
	}

	public int loop() {
		
		
		
		if (guiWait == true) {
			do {
				Task.sleep(500);
			} while (guiWait == true);
		}
		if(Integer.parseInt(Widgets.get(750, 6).getText())>40){
			Walking.setRun(true);
		}
		
		if(Attack.isAutoRetaliateEnabled()== true && RETON == true){
			Attack.setAutoRetaliate(false);
			RETON = false;
			
		}
		
		if (jobs == null) {
			jobs = new Tree(
					new Node[] { new Banking(), new GEWalkingBank(), new GettingThereWalk(), new GettingThereTabs(),new GoingToRangers(), new GettingRequiredKills(),new GeneralGraardor(), new MageMinion(),new MeleeMinion(),new RangeMinion(), new Abilities(), new Healing(), new PrayRestore() });
		}
		final Node job = jobs.state();
		if (job != null) {
			jobs.set(job);
			getContainer().submit(job);
			job.join();
			return 0;
		}
		return 5;
	}

	public void onStop() {
		g.setVisible(false);
	}

	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Point a = e.getPoint();
		if (close.contains(a)) {
			ShowPaint = !ShowPaint;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
	

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRepaint(Graphics g) {
		int x = Mouse.getX();
		 int y = Mouse.getY();
		 
		 

		if (ShowPaint == true) {
			

			g.drawImage(paint, 0, 260, null);
			g.setColor(Color.orange);
			g.drawString(runTime.toElapsedString(), 50, 408);
			g.drawString(status, 62, 383);
			g.drawString(String.valueOf(TotalXP()),89,499);

			g.drawImage(NewMouse, x, y, null);
			//g.drawString(Double.toString(Version), 491, 502);

			sparks.handleSparkles((Graphics2D) g);
		} else if (!ShowPaint) {
			g.drawImage(hidebutton, 501, 373, null);
			Point p = Mouse.getLocation();
			g.drawImage(NewMouse, x, y, null);
			g.setColor(Color.ORANGE);
			//g.drawLine(p.x - 99999, p.y, p.x + 99999, p.y);
			//g.drawLine(p.x, p.y - 99999, p.x, p.y + 99999);
			g.drawImage(NewMouse, x, y, null);
		}

	}

	class GUI extends JFrame {

		/**
		 * Launch the application.
		 */
		public void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI frame = new GUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public GUI() {

			setBackground(Color.RED);
			setTitle("Elite Bandos");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 453, 428);

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setToolTipText("Loot");

			JButton StartButton = new JButton("Start");
			StartButton.setFont(new Font("Castellar", Font.BOLD, 11));

			JButton ExitButton = new JButton("Exit");
			ExitButton.setFont(new Font("Castellar", Font.BOLD, 11));
			ExitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					g.setVisible(false);
					stop();
				}
			});

			JLabel lblGanoelites = new JLabel("Elite Bandos");
			lblGanoelites.setForeground(Color.BLACK);
			lblGanoelites.setFont(new Font("Cooper Std Black", Font.PLAIN, 27));
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGap(81)
																			.addComponent(
																					lblGanoelites))
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGap(88)
																			.addComponent(
																					StartButton,
																					GroupLayout.PREFERRED_SIZE,
																					80,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(29)
																			.addComponent(
																					ExitButton,
																					GroupLayout.PREFERRED_SIZE,
																					80,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGap(39)
																			.addComponent(
																					tabbedPane,
																					GroupLayout.PREFERRED_SIZE,
																					336,
																					GroupLayout.PREFERRED_SIZE)))
											.addContainerGap(68,
													Short.MAX_VALUE)));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					Alignment.LEADING).addGroup(
					groupLayout
							.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblGanoelites)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tabbedPane,
									GroupLayout.PREFERRED_SIZE, 291,
									GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addGroup(
									groupLayout
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(StartButton)
											.addComponent(ExitButton))
							.addContainerGap()));

			JList list = new JList();

			JPanel panel = new JPanel();
			tabbedPane.addTab("Travelling", null, panel, null);

			JLabel lblNewLabel = new JLabel("Method to Dungeon");
			lblNewLabel.setFont(new Font("Cooper Std Black", Font.BOLD, 16));

			final JComboBox methodTodungeon = new JComboBox();
			methodTodungeon.setModel(new DefaultComboBoxModel(new String[] {
					"Walk", "Trollheim Spell", "Trollheim Tab" }));

			JLabel lblMethodToBank = new JLabel("Method to Bank");
			lblMethodToBank
					.setFont(new Font("Cooper Std Black", Font.PLAIN, 16));

			final JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] {
					"Varrock Tab", "Falador Tab" }));
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(gl_panel
					.createParallelGroup(Alignment.LEADING)
					.addGroup(
							gl_panel.createSequentialGroup()
									.addGap(81)
									.addGroup(
											gl_panel.createParallelGroup(
													Alignment.LEADING)
													.addGroup(
															gl_panel.createSequentialGroup()
																	.addGap(10)
																	.addComponent(
																			comboBox_1,
																			GroupLayout.PREFERRED_SIZE,
																			117,
																			GroupLayout.PREFERRED_SIZE))
													.addComponent(
															lblMethodToBank,
															GroupLayout.DEFAULT_SIZE,
															192,
															Short.MAX_VALUE)
													.addGroup(
															gl_panel.createParallelGroup(
																	Alignment.TRAILING)
																	.addComponent(
																			lblNewLabel)
																	.addComponent(
																			methodTodungeon,
																			GroupLayout.PREFERRED_SIZE,
																			142,
																			GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(58,
											GroupLayout.PREFERRED_SIZE)));
			gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
					Alignment.LEADING).addGroup(
					gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(methodTodungeon,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblMethodToBank)
							.addGap(4)
							.addComponent(comboBox_1,
									GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addContainerGap(163, Short.MAX_VALUE)));
			panel.setLayout(gl_panel);

			JPanel panel_2 = new JPanel();
			tabbedPane.addTab("Looting", null, panel_2, null);

			JLabel lblWhatToLoot = new JLabel("Looting Options");
			lblWhatToLoot.setFont(new Font("Cooper Std Black", Font.BOLD, 16));

			JCheckBox cbChestplate = new JCheckBox("Bandos Chestplate");

			JCheckBox cbTasset = new JCheckBox("Bandos Tassets");

			JCheckBox cbHelm = new JCheckBox("Bandos Helmet");

			JCheckBox cbBoots = new JCheckBox("Bandos Boots");

			JCheckBox cbGloves = new JCheckBox("Bandos gloves");

			JCheckBox cbWarshield = new JCheckBox("Bandos Warshield");

			JCheckBox cbRunePlate = new JCheckBox("Rune Platebody");

			JCheckBox cbCoins = new JCheckBox("Coins");

			JCheckBox cbHilt = new JCheckBox("Bandos Hilt");

			JCheckBox cbShard1 = new JCheckBox("Godshard 1");

			JCheckBox cbShard2 = new JCheckBox("Godshard 2");

			JCheckBox cbShard3 = new JCheckBox("Godshard 3");

			JCheckBox cbMagicLog = new JCheckBox("Magic Log");

			JCheckBox cbCoal = new JCheckBox("Coal");

			JCheckBox cbAdOre = new JCheckBox("Adamant Ore");
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2
					.setHorizontalGroup(gl_panel_2
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panel_2
											.createSequentialGroup()
											.addGroup(
													gl_panel_2
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panel_2
																			.createSequentialGroup()
																			.addGap(85)
																			.addComponent(
																					lblWhatToLoot))
															.addGroup(
																	gl_panel_2
																			.createSequentialGroup()
																			.addGap(21)
																			.addGroup(
																					gl_panel_2
																							.createParallelGroup(
																									Alignment.LEADING)
																							.addComponent(
																									cbChestplate)
																							.addComponent(
																									cbGloves)
																							.addComponent(
																									cbHelm)
																							.addComponent(
																									cbBoots)
																							.addComponent(
																									cbTasset))
																			.addGap(14)
																			.addGroup(
																					gl_panel_2
																							.createParallelGroup(
																									Alignment.LEADING)
																							.addComponent(
																									cbCoal)
																							.addComponent(
																									cbMagicLog)
																							.addComponent(
																									cbShard3)
																							.addComponent(
																									cbShard2)
																							.addComponent(
																									cbShard1)))
															.addGroup(
																	gl_panel_2
																			.createSequentialGroup()
																			.addGap(21)
																			.addGroup(
																					gl_panel_2
																							.createParallelGroup(
																									Alignment.LEADING)
																							.addComponent(
																									cbWarshield)
																							.addComponent(
																									cbRunePlate)
																							.addComponent(
																									cbAdOre))
																			.addGap(18)
																			.addGroup(
																					gl_panel_2
																							.createParallelGroup(
																									Alignment.LEADING)
																							.addComponent(
																									cbCoins)
																							.addComponent(
																									cbHilt))))
											.addContainerGap(100,
													Short.MAX_VALUE)));
			gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(
					Alignment.LEADING).addGroup(
					gl_panel_2
							.createSequentialGroup()
							.addGap(11)
							.addComponent(lblWhatToLoot)
							.addGap(7)
							.addGroup(
									gl_panel_2
											.createParallelGroup(
													Alignment.LEADING)
											.addComponent(cbChestplate)
											.addComponent(cbShard1))
							.addGroup(
									gl_panel_2
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbShard2)
											.addComponent(cbTasset))
							.addGroup(
									gl_panel_2
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbShard3)
											.addComponent(cbHelm))
							.addGroup(
									gl_panel_2
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbBoots)
											.addComponent(cbMagicLog))
							.addGroup(
									gl_panel_2
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbGloves)
											.addComponent(cbCoal))
							.addGroup(
									gl_panel_2
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbWarshield)
											.addComponent(cbHilt))
							.addGroup(
									gl_panel_2
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbRunePlate)
											.addComponent(cbCoins))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbAdOre).addGap(45)));
			panel_2.setLayout(gl_panel_2);

			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("Banking", null, panel_1, null);

			final JComboBox comboBox_2 = new JComboBox();
			comboBox_2.setEnabled(false);
			comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "5",
					"6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
					"16", "17" }));

			final JCheckBox Praycheck = new JCheckBox("Enable Prayer");

			final JComboBox comboBox_3 = new JComboBox(new String[] { "1", "2",
					"3", "4", "5", "6", "7", "8" });
			comboBox_3.setEnabled(false);

			final JCheckBox chckbxEnableRenewals = new JCheckBox(
					"Enable Renewals");

			final JCheckBox PrayerFlask = new JCheckBox("Flasks?");
			PrayerFlask.setEnabled(false);

			final JComboBox foodType = new JComboBox();
			foodType.setEnabled(false);
			foodType.setModel(new DefaultComboBoxModel(new String[] {
					"Monkfish", "Shark", "Manta Ray", "Rocktail" }));

			final JCheckBox renewalFlasks = new JCheckBox("Flasks?");
			renewalFlasks.setEnabled(false);

			final JCheckBox cbEnablefood = new JCheckBox("Enable Food");

			final JComboBox foodNumber = new JComboBox();
			foodNumber.setEnabled(false);
			foodNumber.setModel(new DefaultComboBoxModel(new String[] { "1",
					"2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));

			JComboBox cbAttackPot = new JComboBox();
			cbAttackPot.setModel(new DefaultComboBoxModel(new String[] {
					"Super Attack ", "Extreme Strength" }));

			JComboBox cbnumberAtt = new JComboBox();
			cbnumberAtt.setModel(new DefaultComboBoxModel(new String[] { "0",
					"1", "2", "3", "4" }));

			JSeparator separator = new JSeparator();

			JSeparator separator_1 = new JSeparator();

			JSeparator separator_2 = new JSeparator();

			JSeparator separator_3 = new JSeparator();

			JSeparator separator_4 = new JSeparator();

			JSeparator separator_5 = new JSeparator();
			separator_5.setOrientation(SwingConstants.VERTICAL);

			JSeparator separator_6 = new JSeparator();
			separator_6.setOrientation(SwingConstants.VERTICAL);

			JSeparator separator_7 = new JSeparator();
			separator_7.setOrientation(SwingConstants.VERTICAL);

			JSeparator separator_8 = new JSeparator();
			separator_8.setOrientation(SwingConstants.VERTICAL);

			JSeparator separator_9 = new JSeparator();
			separator_9.setOrientation(SwingConstants.VERTICAL);

			JComboBox cbStrengthType = new JComboBox();
			cbStrengthType.setModel(new DefaultComboBoxModel(new String[] {
					"Super Strength", "Extreme Strength" }));

			JComboBox comboBox_7 = new JComboBox();
			comboBox_7.setModel(new DefaultComboBoxModel(new String[] {
					"Super Defence", "Extreme Defence" }));

			JComboBox cbnumberStrength = new JComboBox();
			cbnumberStrength.setModel(new DefaultComboBoxModel(new String[] {
					"0", "1", "2", "3", "4" }));

			JComboBox cbnumberDef = new JComboBox();
			cbnumberDef.setModel(new DefaultComboBoxModel(new String[] { "0",
					"1", "2", "3", "4" }));

			final JComboBox cbnumOverloads = new JComboBox();
			cbnumOverloads.setEnabled(false);
			cbnumOverloads.setModel(new DefaultComboBoxModel(new String[] {
					"1", "2", "3", "4" }));

			final JCheckBox cbOverloadFlasks = new JCheckBox("Flasks?");
			cbOverloadFlasks.setEnabled(false);

			final JCheckBox cbOverloadEnable = new JCheckBox(
					"Enabled Overloads");
			cbOverloadEnable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cbnumOverloads.setEnabled(cbOverloadEnable.isSelected());
					cbOverloadFlasks.setEnabled(cbOverloadEnable.isSelected());

				}
			});
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1
					.setHorizontalGroup(gl_panel_1
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGap(6)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					Praycheck))
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					comboBox_2,
																					GroupLayout.PREFERRED_SIZE,
																					82,
																					GroupLayout.PREFERRED_SIZE))
															.addComponent(
																	PrayerFlask))
											.addGap(18)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	separator_5,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	separator_9,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(2)
																			.addComponent(
																					cbOverloadFlasks)
																			.addGap(2)
																			.addComponent(
																					separator,
																					GroupLayout.PREFERRED_SIZE,
																					1,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					cbnumOverloads,
																					GroupLayout.PREFERRED_SIZE,
																					78,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addComponent(
																					cbOverloadEnable))))
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGap(10)
											.addComponent(separator_1,
													GroupLayout.PREFERRED_SIZE,
													328,
													GroupLayout.PREFERRED_SIZE))
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGap(10)
											.addComponent(separator_2,
													GroupLayout.PREFERRED_SIZE,
													309,
													GroupLayout.PREFERRED_SIZE))
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGap(6)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	chckbxEnableRenewals)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					comboBox_3,
																					GroupLayout.PREFERRED_SIZE,
																					96,
																					GroupLayout.PREFERRED_SIZE))
															.addComponent(
																	renewalFlasks))
											.addGap(6)
											.addComponent(separator_6,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	cbAttackPot,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	cbStrengthType,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	comboBox_7,
																	GroupLayout.PREFERRED_SIZE,
																	110,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(6)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	cbnumberAtt,
																	GroupLayout.PREFERRED_SIZE,
																	47,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	cbnumberStrength,
																	GroupLayout.PREFERRED_SIZE,
																	47,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	cbnumberDef,
																	GroupLayout.PREFERRED_SIZE,
																	47,
																	GroupLayout.PREFERRED_SIZE)))
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGap(3)
											.addComponent(separator_3,
													GroupLayout.PREFERRED_SIZE,
													1,
													GroupLayout.PREFERRED_SIZE)
											.addGap(6)
											.addComponent(separator_4,
													GroupLayout.PREFERRED_SIZE,
													309,
													GroupLayout.PREFERRED_SIZE))
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGap(6)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	cbEnablefood)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					foodType,
																					GroupLayout.PREFERRED_SIZE,
																					80,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					foodNumber,
																					GroupLayout.PREFERRED_SIZE,
																					80,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(25)
											.addComponent(separator_8,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addGap(187)
											.addComponent(separator_7,
													GroupLayout.PREFERRED_SIZE,
													33,
													GroupLayout.PREFERRED_SIZE)));
			gl_panel_1
					.setVerticalGroup(gl_panel_1
							.createParallelGroup(Alignment.LEADING)
							.addGroup(
									gl_panel_1
											.createSequentialGroup()
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGroup(
																					gl_panel_1
																							.createParallelGroup(
																									Alignment.BASELINE)
																							.addComponent(
																									Praycheck)
																							.addComponent(
																									cbOverloadEnable))
																			.addGap(2)
																			.addComponent(
																					comboBox_2,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(2)
																			.addComponent(
																					PrayerFlask))
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(11)
																			.addComponent(
																					separator_5,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(6)
																			.addComponent(
																					separator_9,
																					GroupLayout.PREFERRED_SIZE,
																					50,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(25)
																			.addComponent(
																					cbnumOverloads,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					ComponentPlacement.RELATED)
																			.addGroup(
																					gl_panel_1
																							.createParallelGroup(
																									Alignment.LEADING)
																							.addComponent(
																									cbOverloadFlasks)
																							.addGroup(
																									gl_panel_1
																											.createSequentialGroup()
																											.addGap(13)
																											.addComponent(
																													separator,
																													GroupLayout.PREFERRED_SIZE,
																													GroupLayout.DEFAULT_SIZE,
																													GroupLayout.PREFERRED_SIZE)))))
											.addComponent(separator_1,
													GroupLayout.PREFERRED_SIZE,
													0,
													GroupLayout.PREFERRED_SIZE)
											.addGap(2)
											.addComponent(separator_2,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addGap(2)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(1)
																			.addComponent(
																					chckbxEnableRenewals)
																			.addGap(2)
																			.addComponent(
																					comboBox_3,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(2)
																			.addComponent(
																					renewalFlasks))
															.addComponent(
																	separator_6,
																	GroupLayout.PREFERRED_SIZE,
																	71,
																	GroupLayout.PREFERRED_SIZE)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					cbAttackPot,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(6)
																			.addComponent(
																					cbStrengthType,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(8)
																			.addComponent(
																					comboBox_7,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(4)
																			.addComponent(
																					cbnumberAtt,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(6)
																			.addComponent(
																					cbnumberStrength,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(8)
																			.addComponent(
																					cbnumberDef,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(4)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addComponent(
																	separator_3,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	separator_4,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(6)
											.addGroup(
													gl_panel_1
															.createParallelGroup(
																	Alignment.LEADING)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(1)
																			.addComponent(
																					cbEnablefood)
																			.addGap(2)
																			.addComponent(
																					foodType,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(6)
																			.addComponent(
																					foodNumber,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE))
															.addComponent(
																	separator_8,
																	GroupLayout.PREFERRED_SIZE,
																	84,
																	GroupLayout.PREFERRED_SIZE)
															.addGroup(
																	gl_panel_1
																			.createSequentialGroup()
																			.addGap(24)
																			.addComponent(
																					separator_7,
																					GroupLayout.PREFERRED_SIZE,
																					GroupLayout.DEFAULT_SIZE,
																					GroupLayout.PREFERRED_SIZE)))));
			panel_1.setLayout(gl_panel_1);
			Praycheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox_2.setEnabled(Praycheck.isSelected());
					PrayerFlask.setEnabled(Praycheck.isSelected());
				}
			});
			cbEnablefood.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					foodType.setEnabled(cbEnablefood.isSelected());
					foodNumber.setEnabled(cbEnablefood.isSelected());
				}
			});
			chckbxEnableRenewals.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox_3.setEnabled(chckbxEnableRenewals.isSelected());
					renewalFlasks.setEnabled(chckbxEnableRenewals.isSelected());

				}
			});

			JPanel panel_4 = new JPanel();
			tabbedPane.addTab("Abilities", null, panel_4, null);

			final JCheckBox cbSever = new JCheckBox("Sever");

			final JCheckBox cbSlice = new JCheckBox("Slice");

			final JCheckBox cbSmash = new JCheckBox("Smash");

			final JCheckBox cbHurricane = new JCheckBox("Hurricane");

			final JCheckBox cbOverpower = new JCheckBox("Overpower");

			final JCheckBox cbSlaughter = new JCheckBox("Slaughter");

			final JCheckBox cbMassacre = new JCheckBox("Massacre");

			final JCheckBox cbBeserk = new JCheckBox("Beserk");
			GroupLayout gl_panel_4 = new GroupLayout(panel_4);
			gl_panel_4.setHorizontalGroup(gl_panel_4.createParallelGroup(
					Alignment.LEADING)
					.addGroup(
							gl_panel_4
									.createSequentialGroup()
									.addGap(48)
									.addGroup(
											gl_panel_4
													.createParallelGroup(
															Alignment.LEADING)
													.addComponent(cbSever)
													.addComponent(cbSmash)
													.addComponent(cbOverpower)
													.addComponent(cbSlaughter))
									.addGap(14)
									.addGroup(
											gl_panel_4
													.createParallelGroup(
															Alignment.LEADING)
													.addComponent(cbMassacre)
													.addComponent(cbBeserk)
													.addComponent(cbHurricane)
													.addComponent(cbSlice))
									.addGap(119)));
			gl_panel_4.setVerticalGroup(gl_panel_4.createParallelGroup(
					Alignment.LEADING).addGroup(
					gl_panel_4
							.createSequentialGroup()
							.addContainerGap()
							.addGroup(
									gl_panel_4
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbSever)
											.addComponent(cbSlice))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(
									gl_panel_4
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbSmash)
											.addComponent(cbHurricane))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(
									gl_panel_4
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbOverpower)
											.addComponent(cbBeserk))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(
									gl_panel_4
											.createParallelGroup(
													Alignment.BASELINE)
											.addComponent(cbSlaughter)
											.addComponent(cbMassacre))
							.addContainerGap(164, Short.MAX_VALUE)));
			panel_4.setLayout(gl_panel_4);
			getContentPane().setLayout(groupLayout);
			StartButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(cbSever.isSelected()){
						useSever = true;
					}
					if(cbSlice.isSelected()){
						useSlice = true;
					}
					if(cbSmash.isSelected()){
						useSmash = true;
					}
					if(cbHurricane.isSelected()){
						useHurricane = true;
					}
					if(cbOverpower.isSelected()){
						useOverpower = true;
					}
					if (cbSlaughter.isSelected()){
						useSlaughter = true;
					}
					if (cbBeserk.isSelected()){
						useBeserk = true;
					}
					if(cbMassacre.isSelected()){
						useMassacre = true;
					}
					
					
					

					if (Praycheck.isSelected()) {
						EnablePrayer = true;

						PrayerPots = Integer.parseInt(comboBox_2
								.getSelectedItem().toString());

						if (PrayerFlask.isSelected()) {
							PRAYERPOTSTYPE = 23243;
						}

					}

					if (chckbxEnableRenewals.isSelected()) {
						EnableRenewal = true;

						PrayerRenewalPots = Integer.parseInt(comboBox_3
								.getSelectedItem().toString());

						if (renewalFlasks.isSelected()) {
							RENEWALTYPE = 23609;
						}

					}

					if (cbEnablefood.isSelected()) {
						EnableFood = true;

						FoodNumber = Integer.parseInt(foodNumber
								.getSelectedItem().toString());

						if (foodType.getSelectedItem().equals("Monkfish")) {
							FOODTYPE = Banking.MONKFISH;
						} else if (foodType.getSelectedItem().equals("Shark")) {
							FOODTYPE = Banking.SHARK;
						} else if (foodType.getSelectedItem()
								.equals("Rocktail")) {
							FOODTYPE = Banking.ROCKTAIL;
						}

					}

					if (cbOverloadEnable.isSelected()) {
						EnableOverload = true;

						OverloadNumber = Integer.parseInt(cbnumOverloads
								.getSelectedItem().toString());

						if (cbOverloadFlasks.isSelected()) {
							OVERLOADTYPE = 23531;
						}

					}
					
					if(methodTodungeon.getSelectedItem().equals("Walk")){
						TRANSPORTATION = 1;
					} else if (methodTodungeon.getSelectedItem().equals("Trollheim Spell")){
						TRANSPORTATION = 2;
					} else if(methodTodungeon.getSelectedItem().equals("Trollheim Tab")){
						TRANSPORTATION = 3;
					}
					

					 if (comboBox_1.getSelectedItem().equals(
							"Varrock Tab")) {
						WHERETOBANK = 1;
					} else if (comboBox_1.getSelectedItem().equals(
							"Falador Tab")) {
						WHERETOBANK =2;
					}

					guiWait = false;
					dispose();
				}
			});
		}

	}

}
