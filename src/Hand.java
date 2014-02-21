import java.util.HashMap; 
import java.util.Arrays;

final class Hand {
	
	private final Card[] m_cards;
	
	public Hand(
			Card[] cards
			){
		
		Arrays.sort( cards );
		m_cards = cards;
	}

	public Card[] get_Cards() {
		return m_cards;
	}

	public HandResult GetHandResult(){
		
		HashMap<Integer,Integer> kindCounts = new HashMap<Integer,Integer>();
		
		boolean isStraight = ( m_cards[4].getValue() - m_cards[0].getValue() ) == 4;  
		boolean isFlush = true;
		boolean isRoyalFlush = true;
		
		Suit flushSuit = m_cards[0].getSuit();
		for( int i=0; i < m_cards.length; i++ ){
			Card card = m_cards[i];
			
			if( isFlush ){
				if( isRoyalFlush ){
					if( i == 0 ){
						isRoyalFlush = card.getValue() == 1;
					}else{
						isRoyalFlush = card.getValue() == i + 9;
					}
				}
				
				isFlush = card.getSuit() == flushSuit;
			}
			
			int val = 0;
			if( kindCounts.containsKey( card.getValue() ) ){
				val = kindCounts.get( card.getValue() );
			}
			val = val + 1;
			kindCounts.put(card.getValue(), val + 1 );
		}
		
		if( isRoyalFlush ){
			return new HandResult( HandType.RoyalFlush, kindCounts );
		}
		
		HandType handType = HandType.HighCard;
		
		if( isFlush ){
			if( isStraight ){
				handType = HandType.StraightFlush;
			}else{
				handType = HandType.Flush;
			}
		}else if( isStraight ){
			handType = HandType.Straight;
		}
		
		for( Integer i : kindCounts.values() ){
			
			if( i == 4 ){
				handType = HandType.FourOfAKind;
				break;
			}
			
			if( i == 3 ){
				if( handType == HandType.OnePair ){
					handType = HandType.FullHouse;
					break;
				}
				handType = HandType.ThreeOfAKind;
			}
			
			if( i == 2 ){
				if( handType == HandType.ThreeOfAKind ){
					handType = HandType.FullHouse;
					break;
				}
				
				if( handType == HandType.OnePair ){
					handType = HandType.TwoPair;
					break;
				}
				
				handType = HandType.OnePair;
			}
			
		}
		
		return new HandResult( handType, kindCounts );		
	}	
}
