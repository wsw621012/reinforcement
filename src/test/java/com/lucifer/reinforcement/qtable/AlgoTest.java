package com.lucifer.reinforcement.qtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlgoTest {

	private final static int MAX_EPISODES = 13;
	private final static float ALPHA = 0.1f;
	private final static float GAMMA = 0.9f;

	@Test
	public void test() {
		DataContainer dc = new DataContainer();
		for (int episode = 0; episode < MAX_EPISODES; episode++) {
			int count = 0;
			int step = 0;
			boolean isEnd = false;
			Algo.updateEnv(step, count);

			while (!isEnd) {
				Action action = Algo.chooseAction(step, dc);

				float predict = dc.getRaws(step)[action.ordinal()];

				int[] s = new int[] { step };
				float score = Algo.getEnvFeedback(s, action);
				
				float target = 0;
				if (s[0] != DataContainer.FINAL_STEP) {
					target = score + GAMMA * dc.maxRaw(s[0]);
				} else {
					target = score;
					isEnd = true;
				}
				
				dc.getRaws(step)[action.ordinal()] += ALPHA * (target - predict);
	            
	            step = s[0];
	            Algo.updateEnv(step, ++count);
			}
			System.out.println("step count is " + Integer.toString(step));
			dc.show();
		}
	}

}
