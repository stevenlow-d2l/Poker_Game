import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.*;

import java.util.Random;
import java.util.Vector;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ShufflerTests {

	@Test
	public void switchCards_Test(){
		
		Deck d = new Deck();
		Vector<Card> cards = d.GetCards();
		
		Card card1 = cards.get(10);
		Card card2 = cards.get(20);
		
		Shuffler shuffler = new Shuffler( null );
		shuffler.switchCards( cards, 10, 20 );
		
		assertEquals( card1, cards.get( 20 ) );
		assertEquals( card2, cards.get( 10 ) );		
		
	}
	
	@Test
	public void shuffle_Test(){
		
		Deck d = new Deck();
		Vector<Card> cards = d.GetCards();
		
		Random r = createMock( Random.class );
		expect( r.nextInt( cards.size() ) )
			.andReturn( 10 )
			.andReturn( 20 )
			.andReturn( 30 )
			.andReturn( 40 );
		
		replay( r );
		
		Card c1 = cards.get( 10 );
		Card c2 = cards.get( 20 );
		Card c3 = cards.get( 30 );
		Card c4 = cards.get( 40 );
		
		Shuffler shuffler = new Shuffler( r );
		Vector<Card> shuffledCards = shuffler.Shuffle( cards, 2 );
		
		assertEquals( c1, shuffledCards.get( 20 ) );
		assertEquals( c2, shuffledCards.get( 10 ) );
		assertEquals( c3, shuffledCards.get( 40 ) );
		assertEquals( c4, shuffledCards.get( 30 ) );		
		
	}
	
}
