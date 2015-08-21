public class Main{
	public static void main(String[] args){
		for(int i = 0; i < 10; i++){
			switch(i){
			case 0:
			case 1:
			case 2:
				System.out.format("%d: A\n",i);
				break;
			case 3: ;
			case 4: ;
				System.out.format("%d: B\n",i);
				break;
			case 5: ;
			case 6: ;
				System.out.format("%d: C\n",i);
				if(i%2 != 0){
					break;
				}
			case 7: ;
			default:
				System.out.format("%d: D\n",i);
			}
		}
		
	}
}