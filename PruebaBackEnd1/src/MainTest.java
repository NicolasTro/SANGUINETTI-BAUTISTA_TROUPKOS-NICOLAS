import dao.implementacion.OdontologoIDAOH2;
import dao.implementacion.OdontologoIDAOList;
import model.Odontologo;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

	@Test
	public void listadoOdontologosH2() {
		Odontologo odontologo1 = new Odontologo(001, "John", "Pedro");
		Odontologo odontologo2 = new Odontologo(002, "Maria", "Sanchez");
		Odontologo odontologo3 = new Odontologo(003, "Eric", "Rodriguez");



		OdontologoService servicioOdontologico = new OdontologoService();
		servicioOdontologico.setOdontologoIDao(new OdontologoIDAOH2());
		servicioOdontologico.guardar(odontologo1);
		servicioOdontologico.guardar(odontologo2);
		servicioOdontologico.guardar(odontologo3);

		List<Odontologo> lista = servicioOdontologico.listarTodos();
		assertEquals(lista.size(), 3);
	}

@Test
	public void listadoOdontologosMemoria(){
		Odontologo odontologo1 = new Odontologo(011, "John", "Pedro");
		Odontologo odontologo2 = new Odontologo(022, "Maria", "Sanchez");
		Odontologo odontologo3 = new Odontologo(033, "Eric", "Martinez");
		Odontologo odontologo4 = new Odontologo(004, "Kamila", "Rodriguez");
		Odontologo odontologo5 = new Odontologo(005, "Lucille", "Perez");



		OdontologoService servicioOdontologico = new OdontologoService();
		servicioOdontologico.setOdontologoIDao(new OdontologoIDAOList());
		servicioOdontologico.guardar(odontologo1);
		servicioOdontologico.guardar(odontologo2);
		servicioOdontologico.guardar(odontologo3);
		servicioOdontologico.guardar(odontologo4);
		servicioOdontologico.guardar(odontologo5);

		List<Odontologo> lista = servicioOdontologico.listarTodos();
		assertEquals(lista.size(), 5);


	}


}