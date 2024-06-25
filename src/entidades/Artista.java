package entidades;

public class Artista{
	
	private int idArtista;
	private String nombre;
	private String apellido;
	private String nacionalidad;
	private int cantPremios;
	
	public Artista() {
		super();
	}

	public Artista(int idArtista, String nombre, String apellido, String nacionalidad, int cantPremios) {
		super();
		this.idArtista = idArtista;
		this.nombre = nombre;
		this.apellido = apellido;
		this.nacionalidad = nacionalidad;
		this.cantPremios = cantPremios;
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getCantPremios() {
		return cantPremios;
	}

	public void setCantPremios(int cantPremios) {
		this.cantPremios = cantPremios;
	}

	
}
