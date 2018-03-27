package com.lucifer.reinforcement.qtable;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataContainerTest {

	@Test
	public void test() {
		DataContainer dc = new DataContainer();
		
		for (int i = 0; i < DataContainer.STATES; i++) {
			float[] raw = dc.getRaws(i);
			for (int j = 0; j < DataContainer.ACTIONS; j++) {
				System.out.println(String.format("dc[%d][%d] = %f", i, j, raw[j]));
			}
		}
	}

}
