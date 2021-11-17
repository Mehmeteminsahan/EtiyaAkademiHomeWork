package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.BrandRepository;
import entities.concretes.Brand;


public class BrandDao implements BrandRepository {
	List<Brand> brands;
	
	public BrandDao() {
		brands=new ArrayList<Brand>();
	}

	@Override
	public void add(Brand entity) {
		brands.add(entity);
		
	}

	@Override
	public void delete(int id ) {
		brands.remove(id);
		
	}

	@Override
	public void update(int id,Brand entity) {
		brands.set( id, entity);
		
	}

	@Override
	public Brand getById(int id) {
		return brands.get(id);
	}

	@Override
	public List<Brand> getAll() {
		return brands;
	}

}
