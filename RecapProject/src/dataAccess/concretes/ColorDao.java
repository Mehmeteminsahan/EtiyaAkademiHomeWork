package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.ColorRepository;
import entities.concretes.Color;

public class ColorDao implements ColorRepository {
	List<Color> colors;
	
	public ColorDao() {
		colors=new ArrayList<Color>();
	}

	@Override
	public void add(Color entity) {
		colors.add(entity);
		
		
	}

	@Override
	public void delete(int id) {
		colors.remove(id);
		
	}

	@Override
	public void update(int id,Color entity) {
		colors.set( id, entity);
		
	}

	@Override
	public Color getById(int id) {
		return colors.get(id);
	}

	@Override
	public List<Color> getAll() {
		// TODO Auto-generated method stub
		return colors;
	}
}
