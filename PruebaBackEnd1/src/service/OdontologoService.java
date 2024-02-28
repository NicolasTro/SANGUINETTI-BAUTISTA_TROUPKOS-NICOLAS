package service;

import dao.IDao;
import dao.implementacion.OdontologoIDAOH2;
import dao.implementacion.OdontologoIDAOList;
import model.Odontologo;

import java.util.List;

public class OdontologoService {
private IDao<Odontologo> odontologoIDao;
public OdontologoService(){
//	this.odontologoIDao = new OdontologoIDAOList();
	this.odontologoIDao = new OdontologoIDAOH2();
}

	public IDao<Odontologo> getOdontologoIDao() {
		return odontologoIDao;
	}

	public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
		this.odontologoIDao = odontologoIDao;
	}

	public Odontologo guardar(Odontologo odontologo){
	return this.odontologoIDao.guardar(odontologo);
}
public List<Odontologo> listarTodos(){
	return this.odontologoIDao.listarTodos();
}

}
