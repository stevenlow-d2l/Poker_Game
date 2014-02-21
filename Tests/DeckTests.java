import java.util.Vector;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Test;

@RunWith(JUnit4.class)
public class DeckTests {

	@Test
	public void getCards_Test(){
		
		Deck d = new Deck();
		Vector<Card> cards = d.GetCards();
		
		assertEquals( 52, cards.size() );
		
		for( int j = 0; j < 4; j++ ){		
			for( int i = 1; i < 14; i++ ){
				
				Suit suit = Suit.values()[j];
				int indexer = ( j * 13 ) + ( i - 1 );
				Card card = cards.get( indexer );
				
				assertEquals( suit, card.getSuit() );				
			}
		}
		
	}
	
	
}
