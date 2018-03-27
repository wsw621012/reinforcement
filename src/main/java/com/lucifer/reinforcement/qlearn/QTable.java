package com.lucifer.reinforcement.qlearn;

import com.lucifer.reinforcement.qtable.maze.ActionLine;

public abstract class QTable {

	private float[][] qTable;
	
	protected QTable(float[][] qTable) {
		this.qTable = qTable;
	}
	
	public float[] getRaws(int th) {
		return qTable[th];
	}
	
	public void setRaw(int th, float[] raw) {
		qTable[th] = raw;
	}
	
	public float maxRaw(int th) {
		float maxValue = 0;
		for (float v : qTable[th]) {
			maxValue = Math.max(v, maxValue);
		}
		return maxValue;
	}
	
	public void show(Action[] actions) {
		for (Action a : actions) {
			System.out.print(String.format("\t%s", a.toString()));
		}
		System.out.println();
		int i = 0;
		for (float[] raws : qTable) {
			System.out.print(String.format("%02d", i++)); 
			for (float v : raws) {
				System.out.print("\t" + String.format("%.6f", v));
			}
			System.out.println();
		}
			
	}
}
