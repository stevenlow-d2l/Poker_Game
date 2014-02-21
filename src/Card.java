
final class Card {
	
	private int m_value;
	private Suit m_suit;
	
	public Card(
			Suit suit,
			int value
			){
		
		m_value = value;
		m_suit = suit;		
	}
	
	public Suit getSuit(){
		return m_suit;
	}
	
	public int getValue(){
		return m_value;
	}

}
