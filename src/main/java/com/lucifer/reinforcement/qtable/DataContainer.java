package com.lucifer.reinforcement.qtable;

public class DataContainer {

	protected final static int STATES = 6;
	protected final static int ACTIONS = Action.values().length;
	
	public final static int FINAL_STEP = STATES - 1;
	
	private float[][] container;
	
	public DataContainer() {
		container = new float[STATES][ACTIONS];
	}
	
	public float[] getRaws(int th) {
		return container[th];
	}
	
	public float maxRaw(int th) {
		float maxValue = 0;
		for (float v : container[th]) {
			maxValue = Math.max(v, maxValue);
		}
		return maxValue;
	}
	
	public void setRaw(int th, float[] raw) {
		container[th] = raw;
	}
	
	public void show() {
		for (float[] raws : container) {
			for (float v : raws) {
				System.out.print("\t" + Float.toString(v));
			}
			System.out.println();
		}
	}
}
