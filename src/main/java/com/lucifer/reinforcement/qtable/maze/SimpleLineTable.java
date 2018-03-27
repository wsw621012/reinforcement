package com.lucifer.reinforcement.qtable.maze;

import com.lucifer.reinforcement.qlearn.QTable;
import com.lucifer.reinforcement.qtable.maze.ActionLine;

public class SimpleLineTable extends QTable {

	protected final static int STATES = 6;
	protected final static int ACTIONS = ActionLine.values().length;
	
	public final static int FINAL_STEP = STATES - 1;
	
	public SimpleLineTable() {
		super(new float[STATES][ACTIONS]);
	}
	
	
}
