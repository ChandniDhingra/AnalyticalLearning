
// Chandni Dhingra 02/21/2014
//  Generate n-m grams
// Q2 a. Create 1-gram from the file

package ngram;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class NGramsBuilder {

	//@param args
	 private int lowerBound;
	 private int upperBound;
	 private boolean isIgnoreSentence;

	
	public NGramsBuilder(int lowerBound, int upperBound, boolean isIgnoreSentence) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.isIgnoreSentence = isIgnoreSentence;
	}


	public Map<String, Integer> buildGram(List<String> list) {

		Map<String, Integer> map = new  HashMap<String, Integer>();
		for ( String line : list) {
			String[] tokenizer = line.split("\\s");
			int len = tokenizer.length;
			String gram = "";			
			int outerLower = lowerBound;
			int lower = outerLower;
			int upper = upperBound;
			//int range = upperBound - lowerBound;
			int temp = 0;
			int k = temp;
			while (outerLower <= upper) {
				while (lower <= len) {
					for (k = temp; k <= lower - 1; k++) {
						gram = gram + " " + tokenizer[k];
					}
					lower++;
					temp++;
					if (map.containsKey(gram)) {
						int count = map.get(gram);
						map.put(gram, ++count);
					} else {
						map.put(gram, 1);
					}
					gram = "";
				}
				outerLower++;
				lower = outerLower;
				temp=0;
			}

		}
		return map;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList();
		list.add("The Google Books Ngram Viewer is optimized for quick inquiries into the usage of small sets of phrases. ");
		list.add("If you're interested in performing a large scale analysis on the underlying data, you might prefer to download a portion of the corpora yourself.");
	

		NGramsBuilder builder = new NGramsBuilder(3, 5, false);
		Map map = builder.buildGram(list);
		System.out.println(map);

	}

}
