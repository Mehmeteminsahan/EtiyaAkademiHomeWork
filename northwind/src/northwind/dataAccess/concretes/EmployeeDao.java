package northwind.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import northwind.dataAccess.abstracts.EmployeeRepository;
import northwind.entites.concretes.Employee;

public class EmployeeDao implements EmployeeRepository{

	
	List<Employee> employees;
	
	public EmployeeDao() {
		employees= new ArrayList<Employee>();
	}
	
	@Override
	public void add(Employee entity) {
		// TODO Auto-generated method stub
		employees.add(entity);
	}

	@Override
	public void delete(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Employee entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employees;
	}

}
