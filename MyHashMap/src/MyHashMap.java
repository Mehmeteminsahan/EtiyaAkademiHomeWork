
public class MyHashMap<K, V> {

	Object[][] myHashMap;

	public MyHashMap() {
		super();
	}

	public void put(K key, V value) {
		if (myHashMap == null) {
			myHashMap = new Object[1][2];
			myHashMap[0][0] = key;
			myHashMap[0][1] = value;
		} else {
			Object[][] tmpHashMap = myHashMap;
			myHashMap = new Object[myHashMap.length + 1][2];
			for (int i = 0; i < tmpHashMap.length; i++) {
				myHashMap[i][0] = tmpHashMap[i][0];
				myHashMap[i][1] = tmpHashMap[i][1];
			}
			myHashMap[tmpHashMap.length][0] = key;
			myHashMap[tmpHashMap.length][1] = value;
		}
	}

	public Object get(K key) {
		for (int i = 0; i < myHashMap.length; i++) {
			if (myHashMap[i][0] == key) {
				return myHashMap[i][1];
			}
		}
		return "Anahtar Bulunamadi";
	}

	public void remove(K key) {
		int j = 0;
		Object[][] tmpHashMap = new Object[myHashMap.length - 1][2];
		for (int i = 0; i < tmpHashMap.length; i++) {
			if (myHashMap[i][0] == key) {
				j = 1;
				tmpHashMap[i][0] = myHashMap[i + j][0];
				tmpHashMap[i][1] = myHashMap[i + j][1];
			} else {
				tmpHashMap[i][0] = myHashMap[i + j][0];
				tmpHashMap[i][1] = myHashMap[i + j][1];
			}
		}
		myHashMap = tmpHashMap;
	}

	public void myToString() {
		if (myHashMap == null || myHashMap.length == 0) {
			System.out.println("HashMap Bos");
		} else {

			for (int i = 0; i < myHashMap.length; i++) {
				System.out.println("Key = " + myHashMap[i][0] + "    Value = " + myHashMap[i][1]);
			}
		}
	}

	public void myJsonMap() {

		if (myHashMap == null || myHashMap.length == 0) {
			System.out.println("HashMap Bos");
		} else {

			System.out.print("{");
			for (int i = 0; i < myHashMap.length; i++) {
				System.out.print(myHashMap[i][0] + "=" + myHashMap[i][1]);
				System.out.print(",");
			}
			System.out.println("}");
		}
	}

	public int size() {
		if (myHashMap == null) {
			return 0;
		} else {
			return myHashMap.length;
		}
	}

	public void clear() {
		myHashMap = new Object[0][0];
	}
	
	public Object[][] list() {
		return myHashMap;
	}

}
