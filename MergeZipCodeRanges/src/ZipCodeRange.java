public class ZipCodeRange {
	/* 
	 * I am using the wrapper Integer class for lower and upper zipcodes.
	 * This is less efficient than the primitive int.
	 * But, the tradeoff is, I can use the Integer.compareTo() method 
	 * when sorting a list of zipcode ranges.
	 */
	private Integer lower; // lower zip 
	private Integer upper; // upper zip; note: both lower and upper can be same.

	public Integer getLower() {
		return lower;
	}

	public void setLower(Integer lower) {
		this.lower = lower;
	}

	public Integer getUpper() {
		return upper;
	}

	public void setUpper(Integer upper) {
		this.upper = upper;
	}

	public ZipCodeRange(Integer lower, Integer upper) {
		this.lower = lower;
		this.upper = upper;
	}

	public String toString() {
		return "[" + getLower() + "," + getUpper() + "]";
	}
}
