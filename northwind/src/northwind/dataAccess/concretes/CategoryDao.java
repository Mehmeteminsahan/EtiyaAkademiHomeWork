package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.dataAccess.abstracts.CategoryRepository;
import northwind.entites.concretes.Category;

public class CategoryDao implements CategoryRepository {

	List<Category> categories;
	
	
	public CategoryDao() {
		categories=new ArrayList<Category>();
	}
	

	@Override
	public void add(Category entity) {
		// TODO Auto-generated method stub
		categories.add(entity);
		
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return categories;
	}

}
