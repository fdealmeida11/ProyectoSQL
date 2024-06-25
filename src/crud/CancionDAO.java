package crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConexionBD;
import entidades.Artista;
import entidades.Cancion;

public class CancionDAO {

	public void insertarCancion(Cancion cancion) {
		String sql = "INSERT INTO cancion (nombre, duracion, fechaEstreno, idArtista) VALUES (?, ?, ?,?)";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			stmt.setString(1, cancion.getNombreCancion());
			stmt.setInt(2, cancion.getDuracion());
			stmt.setDate(3, cancion.getFechaEstreno());
			stmt.setInt(4, cancion.getIdArtista());

			int filasInsertadas = stmt.executeUpdate();

			if (filasInsertadas > 0) {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					cancion.setIdCancion(generatedKeys.getInt(1));
				}
				System.out.println("Canción insertada correctamente con id: " + cancion.getIdCancion());
			} else {
				System.out.println("No se pudo insertar la canción.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cancion buscarCancionPorId(String idCancion) {
		String sql = "SELECT cancion.idCancion, cancion.nombre, cancion.duracion, cancion.fechaEstreno, "
				+ "cancion.idArtista, artista.nombre AS nombreArtista " + "FROM cancion "
				+ "JOIN artista ON cancion.idArtista = artista.idArtista " + "WHERE cancion.nombre = ?";

		Cancion cancion = null;

		try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, idCancion);

			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					cancion = new Cancion();
					cancion.setIdCancion(rs.getInt("idCancion"));
					cancion.setNombreCancion(rs.getString("nombre"));
					cancion.setDuracion(rs.getInt("duracion"));
					cancion.setFechaEstreno(rs.getDate("fechaEstreno"));
					cancion.setIdArtista(rs.getInt("idArtista"));

					// Crear un objeto Artista y establecer su nombre
					Artista artista = new Artista();
					artista.setNombre(rs.getString("nombreArtista"));

					// Asignar el artista a la canción
					cancion.setArtista(artista);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cancion;
	}

	public void actualizarCancion(Cancion cancion) {
		/*String sqlDeleteArtista = "UPDATE cancion SET idArtista = -1 WHERE idCancion = ?";*/
		String sql = "UPDATE cancion SET nombre = ?, duracion = ?, fechaEstreno = ? WHERE idCancion = ?";

		try (Connection conn = ConexionBD.getConnection(); 
			/*PreparedStatement stmtDeleteArtista = conn.prepareStatement(sqlDeleteArtista);*/
			PreparedStatement stmt = conn.prepareStatement(sql)) {
			
		/*	stmtDeleteArtista.setInt(1, cancion.getIdCancion());
			stmtDeleteArtista.executeUpdate();*/

			stmt.setString(1, cancion.getNombreCancion());
			stmt.setInt(2, cancion.getDuracion());
			stmt.setDate(3, cancion.getFechaEstreno());
			stmt.setInt(4, cancion.getIdCancion());

			int filasActualizadas = stmt.executeUpdate();

			if (filasActualizadas > 0) {
				System.out.println("Canción actualizada correctamente.");
				
			} else {
				System.out.println("No se encontró ninguna canción con el ID proporcionado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void eliminarCancion(int idCancion) {
		String sqlDeleteArtista = "UPDATE cancion SET idArtista = -1 WHERE idCancion = ?";
		String sql = "DELETE FROM cancion WHERE idCancion = ?";

		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement stmtDeleteArtista = conn.prepareStatement(sqlDeleteArtista);
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmtDeleteArtista.setInt(1, idCancion);
			stmtDeleteArtista.executeUpdate();

			stmt.setInt(1, idCancion);

			int filasEliminadas = stmt.executeUpdate();

			if (filasEliminadas > 0) {
				System.out.println("Canción eliminada correctamente.");
			} else {
				System.out.println("No se encontró ninguna canción con el ID proporcionado.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public Artista buscarArtistaid(int idArtista) { String sql =
	 * "SELECT nombre FROM artista WHERE idArtista = ?"; Artista artista = null;
	 * 
	 * try (Connection conn = ConexionBD.getConnection(); PreparedStatement stmt =
	 * conn.prepareStatement(sql)) {
	 * 
	 * stmt.setInt(1, idArtista);
	 * 
	 * try (ResultSet rs = stmt.executeQuery()) { if (rs.next()) { String
	 * nombreArtista = rs.getString("nombre"); artista = new Artista();
	 * artista.setNombre(nombreArtista); } }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * return artista; }
	 */

}
