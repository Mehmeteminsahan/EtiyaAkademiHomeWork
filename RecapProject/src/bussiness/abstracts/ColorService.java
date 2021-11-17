package bussiness.abstracts;

import java.util.List;

import core.utilities.result.DataResult;
import core.utilities.result.Result;

import entities.concretes.Color;

public interface ColorService {
	DataResult<List<Color>> getAll();
	Result add(Color color);
	Result delete(int id);
	Result update(int id,Color color);
}
