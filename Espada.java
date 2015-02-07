package pelea;

public class Espada 
{
	//-----------------------------------------------------------------------------------------------
	//									Variables globales de Espada
	//-----------------------------------------------------------------------------------------------
	private int danyo;
	private int durabilidad;
	
	//-----------------------------------------------------------------------------------------------
	//									Constructores de Espada
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Constructor de la clase Espada
	 * @param danyo
	 * @param durabilidad
	 */
	public Espada(int danyo, int durabilidad)
	{
		this.danyo = danyo;
		this.durabilidad = durabilidad;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Metodo de constructor
	 */
	public Espada()
	{
		
	}
	
	//-----------------------------------------------------------------------------------------------
	//										toString
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * @return del estado actual de las variables de una instancia de esta clase
	 */
	public String toString()
	{
		return "danyo: "+danyo+" durabilidad: "+durabilidad;
	}
	
	//-----------------------------------------------------------------------------------------------
	//										SETTERS
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setDanyo
	 * @param danyo
	 */
	public void setDanyo(int danyo)
	{
		this.danyo = danyo;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * setDurabilidad
	 * @param durabilidad
	 */
	public void setDurabilidad(int durabilidad)
	{
		this.durabilidad = durabilidad;
	}
	
	//-----------------------------------------------------------------------------------------------
	//										GETTERS
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getDanyo
	 * @return danyo
	 */
	public int getDanyo()
	{
		return danyo;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * getDurabilidad
	 * @return durabilidad
	 */
	public int getDurabilidad()
	{
		return durabilidad;
	}
}
