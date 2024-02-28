package dao.implementacion;

import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoIDAOList implements IDao<Odontologo> {
	private List<Odontologo> listaOdontologosEnMemoria = new ArrayList<>();

	private static Integer contador= 0;

	private static final Logger LOGGER = Logger.getLogger(OdontologoIDAOH2.class);
	@Override
	public Odontologo guardar(Odontologo odontologo) {
		contador+=1;
		odontologo.setId(contador);
		this.listaOdontologosEnMemoria.add(odontologo);
		LOGGER.info("👨‍⚕ Odontologo registrado: " + odontologo);
		return odontologo;
	}

	@Override
	public List<Odontologo> listarTodos() {
		LOGGER.info("👨‍⚕️🧑‍⚕️ Cantidad de odontologos registrados " + listaOdontologosEnMemoria.size());
		return listaOdontologosEnMemoria;
	}
}
