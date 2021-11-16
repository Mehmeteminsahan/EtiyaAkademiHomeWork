package northwind.dataAccess.abstracts;

import java.util.List;

public interface DaoRepository<T> {
	
	void add(T entity);

	void delete(T entity);

	void update(T entity);

	T getById(int id);

	List<T> getAll();
}
