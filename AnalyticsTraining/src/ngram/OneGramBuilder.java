// Chandni Dhingra 02/20/2014
//  1 gram builder using strTokenizer 
// Q1 a. Create 1-gram from the file

package ngram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class OneGramBuilder {

	// Reading a file:
	// (http://alvinalexander.com/java/java-bufferedreader-readline-string-examples)
	/**
	 * 
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	private List<String> readFile(String fileName) throws Exception {
		String line = null;
		List<String> records = new ArrayList<String>();

		// wrap a BufferedReader around FileReader
		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				fileName));

		// BufferReader returns null when there is nothing to read
		while ((line = bufferedReader.readLine()) != null) {
			records.add(line);
		}

		// close the BufferedReader
		bufferedReader.close();
		return records;
	}

	public Map<String, Integer> buidGram(String source) throws Exception {
		List<String> sentenceList = readFile(source);
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// GramBuilder grams = new GramBuilder();
		// List<String> sentenceList = grams.readFile(filePath);

		// int sentenceListsize = sentenceListsize.size
		// for int k=0, k < sentenceListsize , k++)
		// String sentenceList = sentenceList.get(k)

		for (String sentenceLine : sentenceList) {
			StringTokenizer tokens = new StringTokenizer(sentenceLine);
			while (tokens.hasMoreElements()) {
				String word = tokens.nextToken();

				if (map.containsKey(word)) {
					int count = map.get(word);
					map.put(word, ++count);

				} else {
					map.put(word, 1);
				}
			}

		}

		System.out.println(map.size());
		return map;

	}

	public static void main(String[] args) throws Exception {

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String filePath = "/Users/rohitdhingra/Desktop/AnalyticsTraining/Java/Assignment1/dracula.txt";

		OneGramBuilder grams = new OneGramBuilder();
		List<String> sentenceList = grams.readFile(filePath);

		// int sentenceListsize = sentenceListsize.size
		// for int k=0, k < sentenceListsize , k++)
		// String sentenceList = sentenceList.get(k)

		for (String sentenceLine : sentenceList) {
			StringTokenizer tokens = new StringTokenizer(sentenceLine);
			while (tokens.hasMoreElements()) {
				String word = tokens.nextToken();

				if (map.containsKey(word)) {
					int count = map.get(word);
					map.put(word, ++count);

				} else {
					map.put(word, 1);
				}
			}

		}
		System.out.println(map);

	}

}
