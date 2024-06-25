package entidades;

import java.sql.Date;

public class Cancion extends Artista {
	private int idCancion;
	private String nombreCancion;
	private int duracion;
	private Date fechaEstreno;
    private Artista Artista;

	public Cancion() {
		super();
	}
	

	public Cancion(int idArtista, String nombre, String apellido, String nacionalidad, int cantPremios, int idCancion,
			String nombreCancion, int duracion, Date fechaEstreno, entidades.Artista artista) {
		super(idArtista, nombre, apellido, nacionalidad, cantPremios);
		this.idCancion = idCancion;
		this.nombreCancion = nombreCancion;
		this.duracion = duracion;
		this.fechaEstreno = fechaEstreno;
		Artista = artista;
	}
	

	public Artista getArtista() {
		return Artista;
	}


	public int getIdCancion() {
		return idCancion;
	}

	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public void setArtista(Artista artista) {
        this.Artista = artista;
    }
		
}
