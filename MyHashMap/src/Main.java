
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MyHashMap<String, String> map = new MyHashMap<String, String>();
		map.put("anahtar", "degisken");
		map.put("anahtar1", "degisken1");
		map.put("anahtar2", "degisken2");
		map.put("anahtar3", "degisken3");
		map.put("anahtar4", "degisken4");
		map.put("anahtar5", "degisken5");
		map.remove("anahtar1");
		map.myJsonMap();
		map.myToString();
		System.out.println("eleman sayisi="+map.size());
		System.out.println(map.get("anahtar3"));
		System.out.println(map.get("anahtar1"));
		map.clear();
		Object[][]myMap=map.list();
		map.myJsonMap();
		map.myToString();
		System.out.println(map.size());
		
	}

}
