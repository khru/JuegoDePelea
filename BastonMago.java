package pelea;

public class BastonMago 
{
	//-----------------------------------------------------------------------------------------------
	//							Variables globales de la clase BastonMago
	//-----------------------------------------------------------------------------------------------
	
	private int danyo;
	private int durabilidad;
	
	//-----------------------------------------------------------------------------------------------
	//									Constructores de BastonMago
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Constructor de la clase BastonMago
	 * @param danyo
	 * @param durabilidad
	 */
	public BastonMago(int danyo, int durabilidad)
	{
		this.danyo = danyo;
		this.durabilidad = durabilidad;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Metodo constructor que permite 
	 */
	public BastonMago()
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
