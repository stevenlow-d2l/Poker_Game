
enum Suit {
	Diamonds( 0 ),
	Hearts( 1 ),
	Spades( 2 ),
	Clubs( 3 );
	
	private final int m_value;
	
	private Suit( int val ){
		m_value = val	;
	}
	
	public int getValue(){
		return m_value;
	}
}
