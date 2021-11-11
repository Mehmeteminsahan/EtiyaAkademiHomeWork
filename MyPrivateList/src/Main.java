
public class Main {

	public static void main(String[] args) {
		
		MyList list = new MyList();
		list.add("deneme");
		list.add("deneme1");
		list.add("deneme2");
		System.out.println(list.get(0));
		list.myToString();
		boolean contains=list.contain("deneme");
		System.out.println("varmı " + contains );
		list.remove(2);
		list.myToString();
		list.remove("deneme");
		list.myToString();
	}

}
