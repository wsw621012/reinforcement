package com.lucifer.reinforcement.qtable.maze2;

import java.util.Random;

import com.lucifer.reinforcement.qtable.maze.SimpleLineTable;
import com.lucifer.reinforcement.qtable.maze2.Action2D;

public class Algo4Maze2D {

	private final static double EPSILON = 0.9f;

	private final static Random r = new Random();

	public static Action2D chooseAction(int step, Maze2DTable tbl) {
		float[] raw = tbl.getRaws(step);
		if ((Math.random() > EPSILON) || (raw[0] == 0.0 && raw[1] == 0.0)) {
			return Action2D.values()[r.nextInt(Action2D.values().length)];
		}
		return tbl.bestAction(step);
	}

	public static float getEnvFeedback(int[] step, Action2D action) {
		int x = step[0] / Maze2DTable.LEN;
		int y = step[0] % Maze2DTable.LEN;

		if (action == Action2D.Right) {
			if (step[0] == 5 || step[0] == 8) {
				step[0] = Maze2DTable.FINAL;
				return -1;
			}

			if (y < 3) {
				++y;
			}
			step[0] = x * Maze2DTable.LEN + y;
			return 0;
		}

		if (action == Action2D.Left) {
			if (step[0] == 11) {
				step[0] = Maze2DTable.FINAL;
				return 1;
			}

			if (step[0] == 7) {
				step[0] = Maze2DTable.FINAL;
				return -1;
			}

			if (y > 0) {
				--y;
			}
			step[0] = x * Maze2DTable.LEN + y;
			return 0;
		}

		if (action == Action2D.Up) {
			if (step[0] == 14) {
				step[0] = Maze2DTable.FINAL;
				return 1;
			}

			if (step[0] == 13) {
				step[0] = Maze2DTable.FINAL;
				return -1;
			}

			if (x > 0) {
				--x;
			}
			step[0] = x * Maze2DTable.LEN + y;
			return 0;
		}

		// down
		if (step[0] == 2 || step[0] == 5) {
			step[0] = Maze2DTable.FINAL;
			return -1;
		}

		if (x < 3) {
			++x;
		}
		step[0] = x * Maze2DTable.LEN + y;
		return 0;
	}

	public static void updateEnv(int step, int count) {
		char[][] env = { "----".toCharArray(), "--X-".toCharArray(), "-XT-".toCharArray(), "----".toCharArray() };
		if (step == Maze2DTable.FINAL) {
			System.out.println("===== end with count:" + Integer.toString(count));
		} else {
			env[step / Maze2DTable.LEN][step % Maze2DTable.LEN] = 'O';
			for (char[] line : env) {
				System.out.println(new String(line));
			}
			
			System.out.println();
		}
	}
}
