import java.sql.Date;
import java.util.Scanner;

import crud.CancionDAO;
import entidades.Artista;
import entidades.Cancion;

public class ejecutable {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean continuar;
		while (continuar = true) {
		System.out.println("Escribir Añadir, Buscar, Actualizar, Borrar, Finalizar");
		String funcion = scan.nextLine();
		CancionDAO cancionDAO = new CancionDAO();

		switch (funcion) {
		case "Añadir":

			Cancion cancion = new Cancion();
			System.out.print("Ingrese el nombre de la canción: ");
			String nombreCancion = scan.nextLine();
			System.out.print("Ingrese la duración de la canción (en segundos): ");
			int duracion = scan.nextInt();
			System.out.println("ingrese el id del artista");
			int idArt = scan.nextInt();
			
			cancion.setNombreCancion(nombreCancion);
			cancion.setDuracion(duracion);
			cancion.setFechaEstreno(new Date(System.currentTimeMillis()));
			cancion.setIdArtista(idArt);;
			cancionDAO.insertarCancion(cancion);
			break;
			
		 case "Buscar":
		    System.out.print("Ingrese el nombre de la canción que desea buscar: ");
		   String idCancion = scan.nextLine();
		    Cancion cancionEncontrada = cancionDAO.buscarCancionPorId(idCancion);
		    
		    if (cancionEncontrada != null) {
		        System.out.println("Canción encontrada:");
		        System.out.println("ID: " + cancionEncontrada.getIdCancion());
		        System.out.println("Nombre: " + cancionEncontrada.getNombreCancion());
		        System.out.println("Duración: " + cancionEncontrada.getDuracion() + " segundos");
		        System.out.println("Fecha de Estreno: " + cancionEncontrada.getFechaEstreno());
		        System.out.println("Artista: " + cancionEncontrada.getArtista().getNombre());
		    } else {
		        System.out.println("No se encontró ninguna canción con el ID proporcionado.");
		    }
		    break;

		case "Actualizar":
			System.out.print("Ingrese el ID de la canción que desea actualizar: ");
			int idCancion1 = scan.nextInt();
			scan.nextLine();
			System.out.print("Ingrese el nuevo nombre de la canción: ");
			String nuevoNombre = scan.nextLine();

			System.out.print("Ingrese la nueva duración de la canción (en segundos): ");
			int nuevaDuracion = scan.nextInt();

			System.out.print("Ingrese la nueva fecha de estreno (Formato: yyyy-mm-dd): ");
			String nuevaFechaEstrenoStr = scan.next();
			
			// Crear un objeto Date a partir de la cadena ingresada
			Date nuevaFechaEstreno = Date.valueOf(nuevaFechaEstrenoStr);
			// Crear un objeto Cancion con los datos actualizados
			Cancion cancionActualizada = new Cancion();
			cancionActualizada.setIdCancion(idCancion1);
			cancionActualizada.setNombreCancion(nuevoNombre);
			cancionActualizada.setDuracion(nuevaDuracion);
			cancionActualizada.setFechaEstreno(nuevaFechaEstreno);
			cancionDAO.actualizarCancion(cancionActualizada);
			break;
			
		case "Borrar":
			System.out.print("Ingrese el ID de la canción que desea eliminar: ");
			int idCancionBorrar = scan.nextInt();
			cancionDAO.eliminarCancion(idCancionBorrar);
			break;
		case "Finalizar":
			System.out.println("Finalizando programa");
			continuar = false;
			break;
		}
		
		}
		scan.close();
	}
}
