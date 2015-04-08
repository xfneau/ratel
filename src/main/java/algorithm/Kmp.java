package algorithm;

public class Kmp {

	private char[] str;
	private char[] s;
	private int ant[] = new int[100];
	public boolean getKmp(char[] kmp){
		ant[0] = -1;
		int i, j=0, k=-1;
		while( kmp[j] != '\0' ){
			if( k==-1 || kmp[j]==kmp[k] ){
				k++;j++;
				if( kmp[j]==kmp[k] ){
					ant[j] = k;
				}else{
					ant[j] = ant[k];
				}
				
			}else{
				k = ant[k];
			}
				
		}
		return false;
	}
	
	public static void main(String[] args){
		
	}
}
