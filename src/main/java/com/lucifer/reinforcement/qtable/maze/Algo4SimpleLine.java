package com.lucifer.reinforcement.qtable.maze;

import java.util.Random;

public class Algo4SimpleLine {

	private final static double EPSILON = 0.9f;
	
	private final static Random r = new Random();
	
	public static ActionLine chooseAction(int step, SimpleLineTable dc) {
		float[] raw = dc.getRaws(step);
		if ((Math.random() > EPSILON) || (raw[0] == 0.0 && raw[1] == 0.0)) {
			return r.nextBoolean() ? ActionLine.Left : ActionLine.Right;
		}
		return ( raw[0] > raw[1] ) ? ActionLine.Left : ActionLine.Right;
	}
	
	public static float getEnvFeedback(int[] step, ActionLine action) {
		if (action == ActionLine.Right) {
			
			if (step[0] == (SimpleLineTable.STATES - 2)) {
				step[0] = SimpleLineTable.FINAL_STEP;
				return 1;
			}
			step[0]++;
			return 0;
		}
		// Left
		
		if (step[0] > 0) {
			step[0]--;
			//return 0;
		}
		//return -1;
		return 0;
	}
	
	public static void updateEnv(int step, int count) {
		char[] env = "-----T".toCharArray();
		if (step == SimpleLineTable.FINAL_STEP) {
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
