package com.lucifer.reinforcement.qtable.maze2;

import com.lucifer.reinforcement.qlearn.QTable;

public class Maze2DTable extends QTable {

	public final static int LEN = 4;
	
	public final static int FINAL = Integer.MIN_VALUE;
	
	protected final static int STATES = LEN * LEN;
	
	
	public Maze2DTable() {
		super(new float[STATES][Action2D.values().length]);
	}
	
	public Action2D bestAction(int th) {
		Action2D bestAct = Action2D.values()[0];
		float[] raws = getRaws(th);
		float maxValue = raws[0];
		
		for (int i = 1; i < Action2D.values().length; i++) {
			if (raws[i] > maxValue) {
				maxValue = raws[i];
				bestAct = Action2D.values()[i];
			}
		}
		return bestAct;
	}
		
}
