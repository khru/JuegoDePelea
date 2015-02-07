package pelea;
/**
 * Esta clase representa a un guerrero, con sus cualidades, armas y comportamiento.
 * @author khru
 * @version 1.0
 */
public class Guerrero 
{
	//-----------------------------------------------------------------------------------------------
	//									Variables de la clase Guerrero
	//-----------------------------------------------------------------------------------------------
	
	private String nombre;
	private int salud; //No puede ser más de 100 y podria ser una variable global (HERENCIA)
	private int agilidad;
	private int destreza;
	private int fuerza;
	private int sabiduria;
	private int percepcion;
	private Espada espada;
	
	//-----------------------------------------------------------------------------------------------
	//											Constructores
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Método constructor de una instancia de esta clase
	 * @param nombre
	 * @param salud
	 * @param agilidad
	 * @param destreza
	 * @param fuerza
	 * @param sabiduria
	 * @param percepcion
	 */
	public Guerrero(String nombre, int salud, int agilidad, int destreza, int fuerza, int sabiduria, int percepcion, Espada espada)
	{
		this.nombre = nombre;
		this.salud = salud;
		this.agilidad = agilidad;
		this.destreza = destreza;
		this.fuerza = fuerza;
		this.sabiduria = sabiduria;
		this.percepcion = percepcion;
		this.espada = espada;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	public Guerrero()
	{
		
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * @return El estado de una instancia de esta clase
	 */
	public String toString()
	{
		//Formateamos el String de forma que salga en 2 columnas mediante el \n y el \t
		return "Nombre: " + nombre + 
				"\nsalud: " + salud + 
				"\tagilidad: "+ agilidad + 
				"\ndestreza: "+ destreza + 
				"\tfuerza: " + fuerza + 
				"\nsabiduria: " + sabiduria + 
				"\tpercepcion: " + percepcion+ 
				"\nespada("+espada+")";
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Metodo de clonado de objetos de clase Guerrero
	 * @return new Guerrero
	 */
	public Guerrero clone()
	{
		Espada espada = new Espada();
		return new Guerrero(this.getNombre(), this.getSalud(), this.getAgilidad(), this.getDestreza(), this.getFuerza(), this.getSabiduria(),this.getPercepcion(),this.getEstadoEspada());
	}
	
	//-----------------------------------------------------------------------------------------------
	//                                           SETTERS
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
	//                                              GETTERS
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
	//                                       Metódos para Espada
	//-----------------------------------------------------------------------------------------------
	/**
	 * getEspada
	 * @return espada
	 */
	public Espada getEspadadanyo()
	{
		return espada;
	}
	//-----------------------------------------------------------------------------------------------
	/**
	 * setEspada
	 * @param espada the espada to set
	 */
	public void setEspada(int danyo, int durabilidad )
	{
		this.espada = new Espada(danyo, durabilidad);
	}
	//-----------------------------------------------------------------------------------------------
	/**
	 * Metodo  que crea una Espada vacia
	 */
	public void setEspada()
	{
		this.espada = new Espada();
	}
	//-----------------------------------------------------------------------------------------------
	/**
	 * getDanyoEspada
	 * @return espada.getDanyo()
	 */
	public int getDanyoEspada()
	{
		return espada.getDanyo();
	}
	//-----------------------------------------------------------------------------------------------
	/**
	 * getDurabilidadEspada
	 * @return espada.getDurabilidad()
	 */
	public int getDurabilidadEspada()
	{
		return espada.getDurabilidad();
	}
	//-----------------------------------------------------------------------------------------------
	/**
	 * getEstadoEspada
	 * @return espada
	 */
	public Espada getEstadoEspada()
	{
		return espada;
	}
	//-----------------------------------------------------------------------------------------------
	// 										Métodos de Guerrero
	//-----------------------------------------------------------------------------------------------
	/**
	 * Este metódo realiza una estocada
	 * @return danyo
	 */
	public int estocada()
	{
		int danyo;
		if (espada.getDurabilidad() >= 12)
		{
			danyo = (espada.getDanyo() + (fuerza * 4));
			espada.setDurabilidad(espada.getDurabilidad() - 12);
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
	 * Este metodo cura al guerrero la mitad de la durabilidad de su espada
	 * @return curar
	 */
	public int vendarHeridas()
	{
		int curar;
		if (espada.getDurabilidad() > 0)
		{
			curar = (espada.getDurabilidad() / 2);
			return curar;
		}
		else
		{
			return 0;
		}
	}
}
