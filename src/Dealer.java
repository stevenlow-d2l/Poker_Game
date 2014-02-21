import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;


final class Dealer {
	
	private final Deck m_deck;
	
	public Dealer(){
		
		m_deck = new Deck();
		
	}
	
	
	public void Deal( int numHands ){
		
		Vector<Card> cards = m_deck.GetCards();
		
		Random r = new Random();
		Shuffler shuffler = new Shuffler( r );
		
		cards = shuffler.Shuffle( cards, 500 );
		
		Queue<Card> cardQueue = new LinkedList<Card>( cards );
		
		Hand[] hands = new Hand[numHands];
		
		
		for( int i = 0; i < 5; i++ ){
			for( int j=0; j < numHands; j++ ){
				hands[j] = cardQueue.remove();
				
			}
		}
		
		
		
	}

}
