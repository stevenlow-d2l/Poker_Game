import java.util.*;

final class Deck {
	
	public Vector<Card> GetCards(){
		
		Vector<Card> cards = new Vector<Card>();
		
		for( int j = 0; j < 4; j++ ){		
			for( int i = 1; i < 14; i++ ){
				Suit suit = Suit.values()[j];
				Card card = new Card( suit, i );
				cards.add(card);				
			}
		}
		
		return cards;
		
	}

}
