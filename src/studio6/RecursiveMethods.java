package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		 
		if (n == 0) {
			return 0; 
		} else {
			return Math.pow(0.5, n) + geometricSum(n-1); 
		}
		
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
		if (p%q == 0) {
			return q;
		} else if (q%p == 0){
			return p; 
		} else {
			int temp = q;
			q = p % q;
			p = temp;
			return gcd(p,q);
		}			
		
	}	

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	
	public static int [] index(int i, int [] array, int [] newArray) {
		
		if (i < 0) {
			return newArray; 
		} else {
			int temp = array[i];
			newArray[array.length - i -1] = temp;
			return index(i - 1, array, newArray) ;
		}
		
	}
	
	public static int[] toReversed(int[] array) {
		int [] newArray = new int [array.length];
		int i = array.length - 1; 
		
		
		return index(i - 1, array, newArray); 
		
		
		
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius, double radiusMinimumDrawingThreshold) {
		
		double bound = 5.0;
		StdDraw.setXscale(-bound, bound);
		StdDraw.setYscale(-bound, bound);
		

		if (radius < radiusMinimumDrawingThreshold) {
			
		} else {
			
			StdDraw.circle(xCenter, yCenter, radius);

			circlesUponCircles(xCenter+radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter-radius, yCenter, radius/3.0, radiusMinimumDrawingThreshold) ;
			circlesUponCircles(xCenter, yCenter+radius, radius/3.0, radiusMinimumDrawingThreshold) ;
			circlesUponCircles(xCenter, yCenter-radius, radius/3.0, radiusMinimumDrawingThreshold) ;

		}
		
		
		
	}

}
