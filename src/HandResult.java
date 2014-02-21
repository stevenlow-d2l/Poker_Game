import java.util.HashMap; 

final class HandResult {

	private HandType m_handType;
	private HashMap<Integer,Integer> m_typeCounts;
	
	public HandResult(
			HandType handType,
			HashMap<Integer,Integer> typeCounts
			){
		
		m_handType = handType;
		m_typeCounts = typeCounts;		
	}
	
	public HandType getHandType(){
		return m_handType;
	}
	
	public HashMap<Integer,Integer> getTypeCounts(){
		return m_typeCounts;
	}
	
}
