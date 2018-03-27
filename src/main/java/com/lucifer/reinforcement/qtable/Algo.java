package com.lucifer.reinforcement.qtable;

import java.util.Random;

public class Algo {

	private final static double EPSILON = 0.9f;
	
	private final static Random r = new Random();
	
	public static Action chooseAction(int step, DataContainer dc) {
		float[] raw = dc.getRaws(step);
		if ((Math.random() > EPSILON) || (raw[0] == 0.0 && raw[1] == 0.0)) {
			return r.nextBoolean() ? Action.Left : Action.Right;
		}
		return ( raw[0] > raw[1] ) ? Action.Left : Action.Right;
	}
	
	public static float getEnvFeedback(int[] step, Action action) {
		if (action == Action.Right) {
			
			if (step[0] == (DataContainer.STATES - 2)) {
				step[0] = DataContainer.FINAL_STEP;
				return 1;
			}
			step[0]++;
			return 0;
		}
		// Left
		
		if (step[0] > 0) {
			step[0]--;
			return 0;
		}
		return -1;
	}
	
	public static void updateEnv(int step, int count) {
		char[] env = "-----T".toCharArray();
		if (step == DataContainer.FINAL_STEP) {
			System.out.println("===== end with count:" + Integer.toString(count));
		}
		else {
			env[step] = 'O';
			System.out.println(new String(env) + " with count:" + Integer.toString(count));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
