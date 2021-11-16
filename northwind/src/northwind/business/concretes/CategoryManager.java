package northwind.business.concretes;

import java.util.List;

import northwind.business.abstracts.CategoryService;
import northwind.dataAccess.abstracts.CategoryRepository;
import northwind.entites.concretes.Category;

public class CategoryManager implements CategoryService {

	private CategoryRepository categoryRepository;
	
	
	
	public CategoryManager(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return this.categoryRepository.getAll();
	}

	@Override
	public void add(Category businesService) {
		// TODO Auto-generated method stub
		this.categoryRepository.add(businesService);
	}

}
