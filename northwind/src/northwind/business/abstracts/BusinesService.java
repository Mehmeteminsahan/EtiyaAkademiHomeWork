package northwind.business.abstracts;

import java.util.List;


public interface BusinesService <T>{
	
	List<T> getAll();
	void add(T businesService);

}
