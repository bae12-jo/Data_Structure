//간선이 많은 경우 인접 행렬이 유리하고, 간선이 적은 경우 인접 리스트가 유리하다

public class BitOperation{

	public static boolean getBit(int num, int i){
		return (num & (1<<i))!=0;
	}
	
	public static int setBit(int num, int i){
		return num | (1<<i);
	}
	
	public static int clearBit(int num, int i){
		return num & ~(1<<i);
	}
	
	/* num 앞의 비트를 모두 지우기 */
	public static int clearLeftBit(int num, int i){
		return num & ((1<<i+1)-1);
	}
	
	/* num부터 뒤의 비트를 모두 지우기 */
	public static int clearRightBit(int num, int i){
		 return num & ~((1<<i+1)-1);
		 
		// return num & (-1<<i+1);
	}
	
	/* num을 원하는 비트로 변경 */
	public static int updateBit(int num, int i, boolean val){
		return num & ~(1<<i) | ((val? 1:0) <<i);
	}

	public static void main(String[] args){
		
		System.out.println(getBit(9, 3));
		System.out.println(1>>5);
		System.out.println(clearLeftBit(15, 2));
		System.out.println(clearRightBit(169, 3));
		System.out.println(updateBit(169, 3, false));
	}

}
