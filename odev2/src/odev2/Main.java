package odev2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object arry[]= {5,4,7,9,5,3,2,5,4,2,};
		int newArray[]=new int[arry.length];
		Object num;
		int count=0;
		
		for(int i=0;i<arry.length;i++) {
			num = arry[i];
			for(int j=i+1;j<arry.length;j++) {
				if(num==arry[j]) {
					arry[j]=null;
				}
			}
		}
		for(int i=0;i<arry.length;i++) {
			if(arry[i]!=null) {
				newArray[count]=(int) arry[i];
				System.out.println("dizinin "+(count+1)+". elemanı= "+newArray[count]);
				count++;
			}
			
		}
	
	}

}
