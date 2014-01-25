package Main;

import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.util.Random;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Point;
import java.util.*;

import java.util.ArrayList;

public class Sparks {
	
	private final int MAX_PARTICLE = 8;
	
	private final int MAX_LENGTH = 6;
	
	private Spark[] spark = new Spark[MAX_PARTICLE];
	
	private List<Spark[]> sparkList = new ArrayList<>();
	
	private Point lastPoint;
	
	private void addSparks(int numSparks) {
		if (Mouse.getLocation().equals(lastPoint))return;
		lastPoint = Mouse.getLocation();
		if (sparkList.size() > MAX_LENGTH) {
			sparkList.remove(0);
		}
		spark = new Spark[MAX_PARTICLE];
		for (int i = 0; i < numSparks; i++) {
			for (int j = 0; j < MAX_PARTICLE; j++) {
				if (spark[j] == null) {
					spark[j] = new Spark();
					break;
				}
			}
		}
		if (!sparkList.contains(spark))
			sparkList.add(spark);
		lastPoint = Mouse.getLocation();
	}
	
	public void handleSparkles(Graphics2D g) {
		addSparks(Random.nextInt(50, 100));
		for (Spark[] spark : sparkList) {
			for (int j = 0; j < spark.length; j++) {
				if (spark[j] != null) {
					spark[j].drawSpark(g);
				}
			}
		}
	}
	
	private class Spark {
		
		private Point start;
		
		private double x, y;
		private double mx, my;
		private double heat, cool;

		private Spark() {
			double strength = Random.nextInt(2, 2);
			x = (double) Mouse.getX();
			y = (double) Mouse.getY();
			start = new Point((int)x, (int)y);
			mx = (Random.nextDouble() * strength) - (strength / 2);
			my = (Random.nextDouble() * strength) - (strength / 2);
			heat = 255;
			cool = Random.nextDouble() * 8;
		}

		private boolean checkSpark() {
			x += mx;
			y += my;
			my += 0.1;
			heat -= cool;
			Point p = new Point((int)x, (int)y);
			int dist = p.equals(Mouse.getLocation()) ? 0 : 50;
			if (!Calculations.isOnScreen(p) || Calculations.distance(start.x, start.y, p.x, p.y) > dist)
				return false;
			if (heat <= 0)
				return false;
			return true;
		}

		public void drawSpark(Graphics2D g2d) {
			if (checkSpark()) {
				g2d.setColor(new Color((int)Random.nextInt(30, 30), (int)Random.nextInt(1, 255), (int)Random.nextInt(1, 255)));
				g2d.setStroke(new BasicStroke(Random.nextInt(0, 5)));
				g2d.drawLine((int) x, (int) y, (int) (x + 1), (int) (y + 1));
			}
		}

	}
	
}