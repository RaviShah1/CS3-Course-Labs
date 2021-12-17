public class Word
{
	private String theValue;
	
	/**
	 * Constructs and object of the Word class
	 * @param str is the word
	 */
	public Word(String str)
	{
		theValue = str;
	}
	
	/**
	 * Gets the value of the word class
	 * @return the word
	 */
	public String getValue()
	{
		return theValue;
	}
	
	/**
	 * Determines if two words are equal
	 * @param other is the other word
	 * @return true if the words are equals, else false
	 */
	public boolean equals(Object other)
	{
		Word word2 = (Word) other;
		return theValue.equals(word2.theValue);
	}
	
	
	/**
	 * Gets the hash code of the word
	 */
	public int hashCode()
	{
		//vowel count
		int vowelCount = 0;
		for(int i=0; i<theValue.length(); i++)
			if(theValue.substring(i, i+1).matches("[AEIOUaeiou]"))
				vowelCount++;
		return ( vowelCount * theValue.length() ) % 10;
	}
	
	
	/**
	 * Gets a string representation of the word
	 * @return a string representation of the word
	 */
	public String toString()
	{
		return theValue;
	}
	
}

