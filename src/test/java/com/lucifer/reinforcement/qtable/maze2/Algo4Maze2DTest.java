package com.lucifer.reinforcement.qtable.maze2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lucifer.reinforcement.qtable.maze2.Action2D;

public class Algo4Maze2DTest {

	private final static int MAX_EPISODES = 100;
	private final static float ALPHA = 0.1f;
	private final static float GAMMA = 0.9f;

	@Test
	public void test() {
		Maze2DTable tbl = new Maze2DTable();
		
		for (int episode = 0; episode < MAX_EPISODES; episode++) {
			int count = 0;
			int step = 0;
			boolean isEnd = false;
			Algo4Maze2D.updateEnv(step, count);

			while (!isEnd) {
				Action2D action = Algo4Maze2D.chooseAction(step, tbl);

				float predict = tbl.getRaws(step)[action.ordinal()];

				int[] s = new int[] { step };
				float score = Algo4Maze2D.getEnvFeedback(s, action);
				
				float target = 0;
				if (s[0] != Maze2DTable.FINAL) {
					target = score + GAMMA * tbl.maxRaw(s[0]);
				} else {
					target = score;
					isEnd = true;
				}
				
				tbl.getRaws(step)[action.ordinal()] += ALPHA * (target - predict);
	            
	            step = s[0];
	            Algo4Maze2D.updateEnv(step, ++count);
	            
	            try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("step count is " + Integer.toString(step));
			tbl.show(Action2D.values());
		}

	}

}
