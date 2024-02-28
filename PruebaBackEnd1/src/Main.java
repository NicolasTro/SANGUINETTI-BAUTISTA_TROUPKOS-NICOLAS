import dao.BD;
import model.Odontologo;
import service.OdontologoService;

public class Main {
	public static void main(String[] args) {


		OdontologoService odontologoService = new OdontologoService();
		Odontologo odontologo1 = new Odontologo(001, "John", "Pedro");
		Odontologo odontologo2 = new Odontologo(002, "Maria", "Sanchez");

		System.out.println("Guardando los odontologos");
		odontologoService.guardar(odontologo1);
		odontologoService.guardar(odontologo2);

		System.out.println("Listando odontologos..");
		odontologoService.listarTodos();

	}
}
