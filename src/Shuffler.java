import java.util.Random;
import java.util.Vector;

final class Shuffler {
	
	private final Random m_random;
	
	public Shuffler( Random random ){
		m_random = random;
	}
		
	public Vector<Card> Shuffle( Vector<Card> cards, int numShuffles ){
			
		for( int i = 0; i < numShuffles; i++ ){
			
			int size = cards.size();
			int switchIndex1 = m_random.nextInt( size );
			int switchIndex2 = m_random.nextInt( size );
			
			switchCards( cards, switchIndex1, switchIndex2 );		
		}
			
		return cards;			
	}
	
	void switchCards( Vector<Card> cards, int index1, int index2 ){
		
		Card tmp = cards.get(index1);
		cards.set(index1, cards.get(index2 ) );
		cards.set(index2, tmp );		
	}
	
	

}
