
public class MyList {
	String[] city;

	public void add(String s) {

		if (city == null ) {
			city = new String[1];
			city[0] = s;
		} else {
			String[] tmpCity = new String[city.length];
			tmpCity = city;
			city = new String[city.length + 1];
			for (int i = 0; i < tmpCity.length; i++) {
				city[i] = tmpCity[i];
			}
			city[tmpCity.length] = s;
		}
	}

	public String get(int id) {
		return city[id];
	}
	
	public Boolean contain (String s) {
		for(int i=0;i<city.length;i++) {
			if(city[i]==s) {
				return true;
			}
		}
		return false;
	}
	public void remove(String s) {
		boolean isFind=false;
		for(int i=0;i<city.length;i++) {
			if(city[i]==s) {
				remove(i);
				isFind=true;
				break;
			}
		}
		if(isFind==false) {
			System.out.println(s+ " elemanı bulunamadı.");
		}
	}
	
	// 0 1 2 3 4 5
	// 1 2 3 4 5 6
	public void remove(int id) {
		int j=0;
		String[] tmpCity = new String[city.length-1];
		for(int i=0;i<tmpCity.length;i++) {
			if(i==id) {
				j=1;
				tmpCity[i]=city[i+j];
			}else {
				tmpCity[i]=city[i+j];
			}
		}
		city=tmpCity;
	}

	public void myToString() {

		for (int i = 0; i < city.length; i++) {
			System.out.println((i+1)+". eleman --"+city[i]);
		}
	}

}
