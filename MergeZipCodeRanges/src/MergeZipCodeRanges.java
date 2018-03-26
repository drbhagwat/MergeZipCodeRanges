import java.util.LinkedList;
import java.util.List;

public class MergeZipCodeRanges {
	public static void main(String[] args) {
		ZipCodeRange zipCodeRange1 = new ZipCodeRange(94133, 94133);
		ZipCodeRange zipCodeRange2 = new ZipCodeRange(94200, 94299);
		ZipCodeRange zipCodeRange3 = new ZipCodeRange(94600, 94699);

		List<ZipCodeRange> zipCodes = new LinkedList<ZipCodeRange>();
		zipCodes.add(zipCodeRange1);
		zipCodes.add(zipCodeRange2);
		zipCodes.add(zipCodeRange3);

		ZipCodeRanges zipCodeRanges = new ZipCodeRanges(zipCodes);
		zipCodeRanges.sort();

		System.out.println("Input is");
		zipCodeRanges.print();
		ZipCodeRanges mergedZipCodes = new ZipCodeRanges(zipCodeRanges.mergeOverlappingRanges());

		System.out.println("Output is");
		mergedZipCodes.print();
		System.out.println("************************************************");
	
		ZipCodeRange zipCodeRange4 = new ZipCodeRange(94133, 94133);
		ZipCodeRange zipCodeRange5 = new ZipCodeRange(94200, 94299);
		ZipCodeRange zipCodeRange6 = new ZipCodeRange(94226, 94399);

		List<ZipCodeRange> zipCodes2 = new LinkedList<ZipCodeRange>();
		zipCodes2.add(zipCodeRange4);
		zipCodes2.add(zipCodeRange5);
		zipCodes2.add(zipCodeRange6);

		ZipCodeRanges zipCodeRanges2 = new ZipCodeRanges(zipCodes2);
		zipCodeRanges2.sort();
		
		System.out.println("Input is");
		zipCodeRanges2.print();
		
		ZipCodeRanges mergedZipCodes2 = new ZipCodeRanges(zipCodeRanges2.mergeOverlappingRanges());
		System.out.println("Output is");
		mergedZipCodes2.print();
	}
}
