package pelea;

/**
 * Esta clase representa un hechicero sus caracteristicas, habilidades, objetos y sus comportamientos.
 * @author khru
 * @version 1.0
 */

public class Hechicero 
{
	//-----------------------------------------------------------------------------------------------
	//							Variables globales de la clase Hechicero
	//-----------------------------------------------------------------------------------------------
	private String nombre;
	private int salud; //No puede ser más de 100 y podria ser una variable global (HERENCIA)
	private int agilidad;
	private int destreza;
	private int fuerza;
	private int sabiduria;
	private int percepcion;
	private BastonMago bastonMago;
	
	//-----------------------------------------------------------------------------------------------
	//							     		Constructores
	//-----------------------------------------------------------------------------------------------
	/**
	 * Este Constructor permite darle valor a todas las variebles de esta clase salvo al baston que pertenece
	 * 
	 * @param nombre
	 * @param salud
	 * @param agilidad
	 * @param destreza
	 * @param fuerza
	 * @param sabiduria
	 * @param percepcion
	 */
	public Hechicero(String nombre, int salud, int agilidad, int destreza, int fuerza, int sabiduria, int percepcion, BastonMago bastonMago)
	{
		this.nombre = nombre;
		this.salud = salud;
		this.agilidad = agilidad;
		this.destreza = destreza;
		this.fuerza = fuerza;
		this.sabiduria = sabiduria;
		this.percepcion = percepcion;
		this.bastonMago = bastonMago;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Metodo constructor en blanco
	 */
	public Hechicero()
	{
		
	}
	
	//-----------------------------------------------------------------------------------------------
	//											toString
	//-----------------------------------------------------------------------------------------------
	/**
	 * @return El estado de una instancia de esta clase
	 */
	public String toString()
	{
		return "Nombre: " + nombre + 
				"\nsalud: " + salud + 
				"\tagilidad: " + agilidad +
				"\ndestreza: " + destreza +
				"\tfuerza: " + fuerza +
				"\nsabiduria: " + sabiduria +
				"\tpercepcion: " + percepcion + 
				"\nbastonMago("+ bastonMago + ")";
	}
	
	//-----------------------------------------------------------------------------------------------
	//											clone
	//-----------------------------------------------------------------------------------------------
	/**
	 * Metodo de clonado de objetos de clase Hechicero
	 * @return new Hechicero
	 */
	public Hechicero clone()
	{
		BastonMago bastonMago = new BastonMago();
		return new Hechicero(this.getNombre(), this.getSalud(), this.getAgilidad(), this.getDestreza(), this.getFuerza(), this.getSabiduria(), this.getPercepcion(), this.getEstadoBastonMago());
	}
	
	//-----------------------------------------------------------------------------------------------
	//											SETTERS
	//-----------------------------------------------------------------------------------------------
	/**
	 * setNombre
	 * @param nombre
	 */
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setSalud
	 * @param salud
	 */
	public void setSalud(int salud)
	{
		this.salud = salud;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setAgilidad
	 * @param agilidad
	 */
	public void setAgilidad(int agilidad)
	{
		this.agilidad = agilidad;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setDestreza
	 * @param destreza
	 */
	public void setDestreza(int destreza)
	{
		this.destreza = destreza;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setFuerza
	 * @param fuerza
	 */
	public void setFuerza (int fuerza)
	{
		this.fuerza = fuerza;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setSabiduria
	 * @param sabiduria
	 */
	public void setSabiduria(int sabiduria)
	{
		this.sabiduria = sabiduria;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setPercepcion
	 * @param percepcion
	 */
	public void setPercepcion(int percepcion)
	{
		this.percepcion = percepcion;
	}
	
	//-----------------------------------------------------------------------------------------------
	//											GETTERS
	//-----------------------------------------------------------------------------------------------
	/**
	 * getNombre
	 * @return nombre
	 */
	public String getNombre()
	{
		return nombre;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getSalud
	 * @return salud
	 */
	public int getSalud()
	{
		return salud;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getAgilidad
	 * @return agilidad
	 */
	public int getAgilidad()
	{
		return agilidad;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getDestreza
	 * @return destreza
	 */
	public int getDestreza()
	{
		return destreza;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getFuerza
	 * @return fuerza
	 */
	public int getFuerza()
	{
		return fuerza;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getSabiduria
	 * @return sabiduria
	 */
	public int getSabiduria()
	{
		return sabiduria;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getPercepcion
	 * @return percepcion
	 */
	public int getPercepcion()
	{
		return percepcion;
	}
	
	//-----------------------------------------------------------------------------------------------
	//										Métodos de Baston
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param danyo
	 * @param durabilidad
	 */
	public void setBastonMago(int danyo, int durabilidad )
	{
		this.bastonMago = new BastonMago(danyo, durabilidad);
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * MEtodo que crea una instancia vacia de un Baston de mago
	 */
	public void setBastonMago()
	{
		this.bastonMago = new BastonMago();
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getDanyoBastonMago
	 * @return bastonMago.getDanyo()
	 */
	public int getDanyoBastonMago()
	{
		return bastonMago.getDanyo();
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getDurabilidadBastonMago
	 * @return bastonMago.getDurabilidad()
	 */
	public int getDurabilidadBastonMago()
	{
		return bastonMago.getDurabilidad();
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getEstadoBastadoMago
	 * @return bastonMago
	 */
	public BastonMago getEstadoBastonMago()
	{
		return bastonMago;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	//Metodos de habilidades
	/**
	 * Este metódo realiza una estocada
	 * @return danyo
	 */
	
	//-----------------------------------------------------------------------------------------------
	//									Métodos de la clase Hechicero
	//-----------------------------------------------------------------------------------------------
	
	public int bolaDeFuego()
	{
		int danyo;
		if (bastonMago.getDurabilidad() >= 12)
		{
			danyo = (bastonMago.getDanyo() + (fuerza * 4));
			bastonMago.setDurabilidad(bastonMago.getDurabilidad() - 12);
			return danyo;
		}
		else
		{
			danyo = fuerza;
			return danyo;
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo cura al hechicero la mitad de la durabilidad de su espada
	 * @return curar
	 */
	public int cura()
	{
		int curar;
		if (bastonMago.getDurabilidad() > 0)
		{
			curar = (bastonMago.getDurabilidad() / 2);
			return curar;
		}
		else
		{
			return 0;
		}
	}
}
