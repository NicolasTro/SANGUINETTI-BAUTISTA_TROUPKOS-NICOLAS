package dao.implementacion;

import dao.BD;
import dao.IDao;
import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoIDAOH2 implements IDao<Odontologo> {

	private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS (NRO_MATRICULA, NOMBRE, APELLIDO) VALUES (?,?,?)";
	private static final String SQL_SELECT = "SELECT * FROM ODONTOLOGOS";
	private static final Logger LOGGER = Logger.getLogger(OdontologoIDAOH2.class);

	@Override
	public Odontologo guardar(Odontologo odontolgo) {
		Connection conexion = null;
		try {
			conexion = BD.getConnection();
			PreparedStatement preparedStatement = conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, odontolgo.getMatricula());
			preparedStatement.setString(2, odontolgo.getNombre());
			preparedStatement.setString(3, odontolgo.getApellido());

			preparedStatement.execute();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			while (rs.next()) {
				odontolgo.setId(rs.getInt(1));
			}
			LOGGER.info("👨‍⚕ Odontologo registrado: " + odontolgo);

		} catch (Exception e) {
			LOGGER.warn("Algo ha salido mal.. ⚠️ ");
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				LOGGER.error("Error al cerrar la conexion 🤨");
			}
		}
		return odontolgo;
	}

	@Override
	public List<Odontologo> listarTodos() {

		Connection conexion = null;
		List<Odontologo> listaOdontologos = new ArrayList<>();
		try {

			conexion = BD.getConnection();
			PreparedStatement psAll = conexion.prepareStatement(SQL_SELECT);
			ResultSet rs = psAll.executeQuery();
			while (rs.next()) {
				Odontologo odontologo = new Odontologo();
				odontologo.setId(rs.getInt(1));
				odontologo.setMatricula(rs.getInt(2));
				odontologo.setNombre(rs.getString(3));
				odontologo.setApellido(rs.getString(4));
				listaOdontologos.add(odontologo);

			}
			LOGGER.info("👨‍⚕️🧑‍⚕️ Cantidad de odontologos registrados: " + listaOdontologos.size());
			LOGGER.info(listaOdontologos);

		} catch (Exception e) {
			LOGGER.warn("Algo ha salido mal.. ⚠️ ");
			e.printStackTrace();
		} finally {
			try {
				conexion.close();
			} catch (Exception ex) {
				LOGGER.error("Error al cerrar la conexion 🤨");
			}
		}
		return listaOdontologos;
	}
}
