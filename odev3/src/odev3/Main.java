package odev3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arry[]= {5,6,2,8};
		//           6 5 2 8
		//           8 5 2 6
		
		int kep;
		
		for(int i=0;i<arry.length;i++) {
			for(int j=i;j<arry.length;j++) {
			
				if(arry[j]>arry[i]) {
					kep=arry[i];
					arry[i]=arry[j];
					arry[j]=kep;
				}
			}
		}
		for(int i=0;i<arry.length;i++) {
			System.out.println((i+1)+".eleman="+arry[i]);
		}
	}

}
