package com.lucifer.reinforcement.qtable.maze;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lucifer.reinforcement.qtable.maze.ActionLine;
import com.lucifer.reinforcement.qtable.maze.Algo4SimpleLine;
import com.lucifer.reinforcement.qtable.maze.SimpleLineTable;

public class Algo4SimpleLineTest {

	private final static int MAX_EPISODES = 13;
	private final static float ALPHA = 0.1f;
	private final static float GAMMA = 0.9f;

	@Test
	public void test() {
		SimpleLineTable tbl = new SimpleLineTable();
		for (int episode = 0; episode < MAX_EPISODES; episode++) {
			int count = 0;
			int step = 0;
			boolean isEnd = false;
			Algo4SimpleLine.updateEnv(step, count);

			while (!isEnd) {
				ActionLine action = Algo4SimpleLine.chooseAction(step, tbl);

				float predict = tbl.getRaws(step)[action.ordinal()];

				int[] s = new int[] { step };
				float score = Algo4SimpleLine.getEnvFeedback(s, action);
				
				float target = 0;
				if (s[0] != SimpleLineTable.FINAL_STEP) {
					target = score + GAMMA * tbl.maxRaw(s[0]);
				} else {
					target = score;
					isEnd = true;
				}
				
				tbl.getRaws(step)[action.ordinal()] += ALPHA * (target - predict);
	            
	            step = s[0];
	            Algo4SimpleLine.updateEnv(step, ++count);
			}
			System.out.println("step count is " + Integer.toString(step));
			tbl.show(ActionLine.values());
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
