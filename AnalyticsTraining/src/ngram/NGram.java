package ngram;

public class NGram {
	private String nGram;
	private int occurence;
	
	/**
	 * 
	 * @param oneGram
	 * @param occurence
	 */
	public  NGram(final String nGram, final int occurence){
		this.nGram = nGram;
		this.occurence = occurence;
	}

	public String getOneGram() {
		return nGram;
	}

	public void setOneGram(String ngram) {
		this.nGram = ngram;
	}

	public int getOccurence() {
		return occurence;
	}

	public void setOccurence(int occurence) {
		this.occurence = occurence;
	}
	

}
