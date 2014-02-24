package ngram;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListSet;

public class GramSorter implements Comparator {
	
	
	public NavigableSet<NGram>  sortNGram(Map<String,Integer> mapGram, boolean isDescending){
		
		
		NavigableSet sortedSet = new ConcurrentSkipListSet(this);
		Set<String> keySet = mapGram.keySet();
		for( String oneGram : keySet){
			 int occurence = mapGram.get(oneGram);
			 NGram gram = new NGram(oneGram, occurence);			
			 sortedSet.add(gram);
		}
		if(isDescending){
			sortedSet.descendingSet();
		}

		return sortedSet;
	}
	

	
	public int compare(Object o1, Object o2) {
		NGram nGram1 = (NGram) o1;
		NGram nGram2 = (NGram) o2;

		int o1Occurence = nGram1.getOccurence();
		int o2Occurence = nGram2.getOccurence();

		if (o1Occurence == o2Occurence)
			return 0;
		if (o1Occurence < o2Occurence)
			return -1;
		else  
			return 1;	
		
	}

}
