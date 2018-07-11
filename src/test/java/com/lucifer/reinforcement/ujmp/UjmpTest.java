package com.lucifer.reinforcement.ujmp;

import static org.junit.Assert.*;

import org.junit.Test;

import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

public class UjmpTest {

	@Test
	public void mathTest() {
		System.out.println(String.format("16**0.25 = %f",Math.pow(16, 0.25)));
	}
	
	@Test
	public void matrixTest() {

		// 4*4 matrix
		Matrix dense = DenseMatrix.Factory.zeros(4, 4);
		System.out.println(dense);
		/*
		 * 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000
		 * 0.0000 0.0000 0.0000 0.0000 0.0000
		 */

		// dense(3, 4) = 5.0
		dense.setAsDouble(5.0, 2, 3);
		// others
		dense.setAsDouble(1.0, 0, 0);
		dense.setAsDouble(3.0, 1, 1);
		dense.setAsDouble(4.0, 2, 2);
		dense.setAsDouble(-2.0, 3, 3);
		dense.setAsDouble(-2.0, 1, 3);
		System.out.println(dense);
		/*
		 * 1.0000 0.0000 0.0000 0.0000 0.0000 3.0000 0.0000 -2.0000 0.0000 0.0000 4.0000
		 * 5.0000 0.0000 0.0000 0.0000 -2.0000
		 */

		// dense^T
		Matrix transpose = dense.transpose();
		System.out.println(transpose);
		/*
		 * 1.0000 0.0000 0.0000 0.0000 0.0000 3.0000 0.0000 0.0000 0.0000 0.0000 4.0000
		 * 0.0000 0.0000 -2.0000 5.0000 -2.0000
		 */

		// dense + transpose
		System.out.println(dense.plus(transpose));
		/*
		 * 2.0000 0.0000 0.0000 0.0000 0.0000 6.0000 0.0000 -2.0000 0.0000 0.0000 8.0000
		 * 5.0000 0.0000 -2.0000 5.0000 -4.0000
		 */

		// dense - transpose
		System.out.println(dense.minus(transpose));
		/*
		 * 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000 0.0000 -2.0000 0.0000 0.0000 0.0000
		 * 5.0000 0.0000 2.0000 -5.0000 0.0000
		 */

		// dense * transpose
		Matrix matrixProduct = dense.mtimes(transpose);
		System.out.println(matrixProduct);
		/*
		 * 1.0000 0.0000 0.0000 0.0000 0.0000 13.0000 -10.0000 4.0000 0.0000 -10.0000
		 * 41.0000 -10.0000 0.0000 4.0000 -10.0000 4.0000
		 */

		// dense * 2
		Matrix scaled = dense.times(2);
		System.out.println(scaled);
		/*
		 * 2.0000 0.0000 0.0000 0.0000 0.0000 6.0000 0.0000 -4.0000 0.0000 0.0000 8.0000
		 * 10.0000 0.0000 0.0000 0.0000 -4.0000
		 */

		// denses' inverse matrix
		System.out.println(dense.inv());
		/*
		 * 1.0000 0.0000 0.0000 0.0000 0.0000 0.3333 0.0000 -0.3333 0.0000 0.0000 0.2500
		 * 0.6250 -0.0000 -0.0000 -0.0000 -0.5000
		 */

		// 4*4 random matrix,value range: [0¡A1]
		Matrix rand = Matrix.Factory.rand(4, 4);
		System.out.println(rand);
		/*
		 * 0.5478 0.5100 0.7078 0.0600 0.8316 0.4039 0.2553 0.0173 0.4354 0.7132 0.7865
		 * 0.7006 0.0394 0.4839 0.4374 0.6241
		 */

		// 4*4 random matrix, value range: [-1¡A1]
		Matrix randn = Matrix.Factory.randn(4, 4);
		System.out.println(randn);
		/*
		 * 0.8655 0.6231 -0.4234 0.0802 0.7217 -0.7399 -0.5692 0.6421 -1.5557 0.4745
		 * 2.1110 1.5489 -0.8520 -0.7722 0.9025 -0.4664
		 */

		// matrix 2*3 with 1.0000
		Matrix ones = Matrix.Factory.ones(2, 3);
		System.out.println(ones);
		/*
		 * 1.0000 1.0000 1.0000 1.0000 1.0000 1.0000
		 */
	}

}
