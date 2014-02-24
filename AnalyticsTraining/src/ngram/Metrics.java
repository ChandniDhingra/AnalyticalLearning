package ngram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Metrics{
	
	
	// methods for Frequency distribution 
	
	// can we create a graph??
	
	
	// method for most occurences
	public void mostOccurences(int top, NavigableSet sortedSet){
		Iterator<NGram> it = sortedSet.descendingIterator();
		int count = 0;
		while( it.hasNext() &&  count <= top){
			count ++;
			NGram gram = it.next();
			System.out.println("OneGram=" + gram.getOneGram()+ "; Occuerence=" + gram.getOccurence());		
		}
		
	}
	
	public void minOccurences(int top, NavigableSet sortedSet){
		Iterator<NGram> it = sortedSet.iterator();
		int count = 0;
		System.out.println("==Bottom==");
		while( it.hasNext() &&  count <= top){
			count ++;
			NGram gram = it.next();
			System.out.println("OneGram=" + gram.getOneGram()+ "; Occuerence=" + gram.getOccurence());		
		}
		
	}
	
	
	
	//method for least occurences
	public static void main(String[] args) throws Exception {
		String filePath = "/Users/rohitdhingra/Desktop/AnalyticsTraining/Java/Assignment1/dracula.txt";

		GramBuilder builder = new GramBuilder();
		// 1. make map of ngrams and their occurences.
		Map<String,Integer> map = builder.buidGram(filePath);
		GramBuilder grams = new GramBuilder();
		
		// 2. build NGram and sort.
		
		GramSorter sorter = new GramSorter();
		NavigableSet<NGram> set = sorter.sortNGram(map, false);
	    
		Metrics met = new Metrics();
		met.mostOccurences(10, set);
		met.minOccurences(10, set);

		}
}
