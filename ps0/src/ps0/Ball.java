/**
 * This is part of the Problem Set 0: Introduction for 6.170 Fall 2005.
 */
package ps0;


/**
 * This is a simple object that has a capacity.
 */
public class Ball implements Comparable<Object> {

	private double weight = 0, capacity = 0;

	/**
	 * Constructor that creates a new ball object with the specified weight and
	 * capacity.
	 * 
	 * @param capacity
	 *            Capacity of the new object.
	 */
	public Ball(double weight, double capacity) {
		this.weight = weight;
		this.capacity = capacity;
	}

	/**
	 * Returns the capacity of the Ball.
	 * 
	 * @return the capacity of the Ball.
	 */
	public double getCapacity() {
		return this.capacity;
	}

	/**
	 * Returns the weight of the Ball.
	 * 
	 * @return the weight of the Ball.
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Returns true if two Balls are the same (same weight and capacity).
	 * 
	 * @return true if two Balls are the same (same weight and capacity).
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Ball))
			return false;
		Ball b = (Ball) o;
		return b.getCapacity() == this.getCapacity()
				&& b.getWeight() == this.getWeight();
	}

	/**
	 * Overriding due to override of equals method.
	 * 
	 * @return hashcode.
	 */
	@Override
	public int hashCode() {
		int result = 17;
		long c = Double.doubleToLongBits(this.getCapacity());
		int d = shift(c);
		result = 31 * result + d;
		c = Double.doubleToLongBits(this.getWeight());
		d = shift(c);
		result = 31 * result + d;
		return result;
	}

	private int shift(long l) {
		return (int) (l ^ (l >>> 32));
	}

	/**
	 * When comparing Balls, if user enters one with the same 
	 * capacity and weight, we do not want to replace the 
	 * existing Ball with the new one.
	 */
	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Ball))
			throw new IllegalArgumentException(
					"can only compare to a Ball object");
		Ball that = (Ball) o;
		int capacityDiff = Double.compare(this.getCapacity(), that.getCapacity());
		if (capacityDiff != 0 ) {
			return capacityDiff;
		}
		int weightDiff = Double.compare(this.getWeight(), that.getWeight());
		if (weightDiff != 0 ) {
			return weightDiff;
		}
		return 0;
	}

}
