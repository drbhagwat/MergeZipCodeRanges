import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ZipCodeRanges {
	private List<ZipCodeRange> zipCodeRanges;

	public List<ZipCodeRange> getListOfRanges() {
		return zipCodeRanges;
	}

	public void setListOfRanges(List<ZipCodeRange> zipCodeRanges) {
		this.zipCodeRanges = zipCodeRanges;
	}

	public ZipCodeRanges(List<ZipCodeRange> ranges) {
		this.zipCodeRanges = ranges;
	}

	/*
	 * This is the heart of the program. Merging is required when first range (of
	 * zip codes) overlaps with the next range. It removes the first range from the
	 * list and updates the second range (shrinking the list size by one in the
	 * process). I am using doubly linked list (versus array list) for performance
	 * reasons.
	 */
	public List<ZipCodeRange> mergeOverlappingRanges() {
		int size = getListOfRanges().size();

		if (size == 1) {
			return zipCodeRanges; // if there is just one element, return the list
		}

		int currentIndex = 0; // point to the first range in the list
		int nextIndex = currentIndex + 1; // point to the next range in the list

		while (nextIndex < size) {
			ZipCodeRange current = zipCodeRanges.get(currentIndex);
			ZipCodeRange next = zipCodeRanges.get(nextIndex);

			if (current.getUpper() >= next.getLower()) {
				// when there is an overlap, update lower bound of the next range
				next.setLower(current.getLower());
				// remove the current range from the list
				zipCodeRanges.remove(current);
				// recompute the size of the list
				size = zipCodeRanges.size();
			} else {
				// advance the ranges
				currentIndex = nextIndex;
				nextIndex = currentIndex + 1;
			}
		}
		return zipCodeRanges;
	}

	/*
	 * This is a utility to function to print all the elements in the list.
	 */
	public void print() {
		int size = zipCodeRanges.size();

		for (int i = 0; i < size; i++) {
			System.out.println(zipCodeRanges.get(i));
		}
	}

	/*
	 * This is a utility method to sort all elements in the list.
	 */
	public void sort() {
		// sort ranges in the ascending order of their lower zip code
		Collections.sort(getListOfRanges(), new Comparator<ZipCodeRange>() {
			@Override
			public int compare(ZipCodeRange range1, ZipCodeRange range2) {
				return (range1.getLower().compareTo(range2.getLower()));
			}
		});
	}
}
