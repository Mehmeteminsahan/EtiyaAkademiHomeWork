package loto;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int kolonSayisi=scan.nextInt();
		int kolonlar[][]=new int[kolonSayisi][6];
		boolean esitmi=false;
		for(int i=0;i<kolonSayisi;i++) {
			int j=0;
			
			while (j<5) {
				Random random=new Random();
				int randomSayi=random.nextInt(50);
				for(int k=j;k<0;k--) {
					if(randomSayi==kolonlar[i][k]) {
						esitmi=true;
					}
				}
				if(esitmi==false) {
					kolonlar[i][j]=randomSayi;
					j++;
				}
				
			}
		}
		
		for(int i=0;i<kolonSayisi;i++) {
			System.out.println("\n"+(i+1)+". kolon");
			for(int j=0;j<6;j++) {
				System.out.print(kolonlar[i][j]+" ");
			}
		}

	}

}
