package interfaces;

import java.util.ArrayList;

import model.Model;

public interface Crud {
	public boolean insert(Model model);
	public boolean delete(Model model);
	public boolean update(Model model);
	public Model fetchOne(Model model);
	public ArrayList<Model> fetchAll();
}