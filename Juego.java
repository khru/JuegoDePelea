package pelea;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author khru
 * @version 1.0
 */

public class Juego 
{
	//-----------------------------------------------------------------------------------------------
	//							Variables globales de la clase Principal
	//-----------------------------------------------------------------------------------------------
	/**
	 * Declaración de variables globales del método main, muchas son instanciadas pero no inicializadas, de forma que no 
	 * se emplee memoria para ellas
	 */
	public static Scanner teclado = new Scanner(System.in);
	public static Scanner tecladoString = new Scanner(System.in);
	//Creo una variable global para poder emplearla en diferentes metodos
	public static boolean salir = false;
	//DECLARACION DE HEROES SIN RESERVAR ESPACIO EN MEMORIA
	public static Guerrero luchador;
	public static Hechicero mago;
	//DECLARACION DE ENEMIGOS SIN RESERVAR ESPACIO EN MEMORIA
	public static Hechicero enemigoMago;
	public static Guerrero enemigoLuchador;
	//DECLARACION CONSTANTE GLOBAL PARA LA MUERTE
	public static final int muerte = 0;
	public static final int salud = 100;
	
	//-----------------------------------------------------------------------------------------------
	//										MAIN
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Metdo principal
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			Object jugador, enemigo;
			jugador = selecionDePersonajes();
			if (jugador == null)//guestionar el caso de que la seleccion de personajes devuelva un null
			{
				errorFatal();
			}
			else // por el contrario (aunque esto crea una parada en la CPU es justificable simplemente para que el programa no explote)
			{	
				enemigo = crearEnemigo0(jugador);
				if(menuDeacciones(jugador, enemigo) == true)
				{
					
				}
				else
				{
					menuDeJuego();
				}
			}
			teclado.close();
			tecladoString.close();
		}
		catch (InputMismatchException noInteger)
		{
			System.out.println("Usted ha introducido un String o un char en donde debería haber puesto un int");
		}
		catch (RuntimeException NullPointerException)
		{
			nullPointerError();
		}
		catch(Exception errorFatal)
		{
			errorFatal();
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	//						Métodos de error y de salida por pantalla
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Método para gestionar punteros nullos
	 */
	public static void nullPointerError()
	{
		System.out.println("Puntero nulo");
	}
	
	/**
	 * Este método muestra por pantalla un error ocurrido por un parametro erroneo
	 */
	public static void errorParametro()
	{
		System.out.println("El parametro introducido es erroneo, porfavor introduzca un parametro adecuado");
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Método de gestión de errores desconocidos
	 */
	public static void errorFatal()
	{
		System.out.println("Error fatal");
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Este método recoge un booleano y gestiona una salida por pantalla, y devolverá lo que ha recivido, para que otro método lo gestione
	 * @param tf
	 * @return true || false
	 */
	public static boolean mensajeHuir(boolean tf)
	{
		if(tf == true)
		{
			System.out.println("El heroe a conseguido huir");
			return true;
		}
		else
		{
			System.out.println("El heroe no ha conseguido huir");
			return false;
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	// 							Métodos que usan el factor aleatorio
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Metodo que devuelve un boleano con las dependiendo del resultado de la funcion aleatoria
	 * @return true or false
	 */
	public static boolean huir()
	{
		if(aleatorio() == 10 || aleatorio() == 12)
		{
			return  true;
		}
		else
		{
			return false;
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo genera un numero aleatorio del 10 al 15
	 * @return numero aleatorio
	 */
	public static int aleatorio()
	{
		 return (int)(Math.random() * 6)+10;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Metodo de Selecion de personajes
	 */
	public static Object selecionDePersonajes()
	{
		int opc;
		salir = false;
		String confirmacion = "";
		do
		{
			System.out.println("Bienvenido al juego del guerrero y el hechicero");
			System.out.println("+-----------------------+");
			System.out.println("| selecion de personaje |");
			System.out.println("| 1 - Guerrero          |");
			System.out.println("| 2 - Hechicero         |");
			System.out.println("+-----------------------+");
			System.out.println("Selecione su personaje: ");
			opc = teclado.nextInt();
			switch (opc)
			{
				case 1: 
					luchador = new Guerrero();
					System.out.println("Introduce el nombre que deseas ponerle a tu guerrero: ");
					luchador.setNombre(tecladoString.nextLine()); //no uso teclado porque el buffer de java da errores con los String y los enteros
					//Creacion de atributos del luchador
					luchador.setSalud(salud);
					luchador.setAgilidad(aleatorio());
					luchador.setDestreza(aleatorio());
					luchador.setFuerza(aleatorio());
					luchador.setSabiduria(aleatorio());
					luchador.setPercepcion(aleatorio());
					//Constructor de la Espada
					luchador.setEspada(aleatorio(), 100);
					System.out.println();
					System.out.print("Estas seguro de que esta informacion es correcta\n"+luchador.getNombre()+"\n(S/N): ");
					confirmacion = tecladoString.nextLine().toUpperCase();// no uso teclado porque el buffer de java da errores con los String y los enteros
					if(confirmacion.equals("S"))
					{
						return  luchador; //Significa que el enemigo un mago
					}
					
				break;
				case 2:
					mago = new Hechicero();
					System.out.println("Introduce el nombre que deseas ponerle a tu hechicero: ");
					mago.setNombre(tecladoString.nextLine()); //no uso teclado porque el buffer de java da errores con los String y los enteros
					//Creacion de atributos del luchador
					mago.setSalud(salud);
					mago.setAgilidad(aleatorio());
					mago.setDestreza(aleatorio());
					mago.setFuerza(aleatorio());
					mago.setSabiduria(aleatorio());
					mago.setPercepcion(aleatorio());
					//Constructor de la BastonMago
					mago.setBastonMago(aleatorio(), 100);
					System.out.println();
					//comprobación de la informaon
					//System.out.print(mago.toString());
					System.out.print("Estas seguro de que esta informacion es correcta\n"+mago.getNombre()+"\n(S/N): ");
					confirmacion = tecladoString.nextLine().toUpperCase();// no uso teclado porque el buffer de java da errores con los String y los enteros
					if(confirmacion.equals("S"))
					{
						return  mago; //Significa que el enemigo un mago
					}
				break;
				default:
					//Mensaje de error por parametro erroneo
					errorParametro();
				break;
			}
		}while(salir != true);
		return null; //Nunca llegará aqui
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo genera enemigos dependiendo de que tipo de personaje hayas creado
	 * @param tipoDeEnemigo
	 */
	public static Object crearEnemigo0(Object enemigo)
	{
		if(enemigo.equals(luchador))
		{
			enemigoMago = new Hechicero();
			enemigoMago.setNombre("Enemigo Mago");
			enemigoMago.setSalud(100);
			enemigoMago.setAgilidad(aleatorio());
			enemigoMago.setDestreza(aleatorio());
			enemigoMago.setFuerza(aleatorio());
			enemigoMago.setSabiduria(aleatorio());
			enemigoMago.setPercepcion(aleatorio());
			//Constructor del BastonMago
			enemigoMago.setBastonMago(aleatorio(), 100);
			//Comprobacion de la creacion del enmigo
			//System.out.println(enemigoMago.toString());
			return enemigoMago;
		}
		else
		{
			enemigoLuchador = new Guerrero();
			enemigoLuchador.setNombre("Enemigo Guerrero");
			enemigoLuchador.setSalud(100);
			//creación de valores aleatorios
			enemigoLuchador.setAgilidad(aleatorio());
			enemigoLuchador.setDestreza(aleatorio());
			enemigoLuchador.setFuerza(aleatorio());
			enemigoLuchador.setSabiduria(aleatorio());
			enemigoLuchador.setPercepcion(aleatorio());
			//Constructor de la Espada
			enemigoLuchador.setEspada(aleatorio(), 100);
			//Comprobacion de la creacion del enmigo
			//System.out.println(enemigoLuchador.toString());
			return enemigoLuchador;
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo lo que hace es despliega el menu para jugar una vez selecionado el tipo de pronaje
	 */
	public static void menuDeJuego()
	{
		salir = false;
		{
			int opc;
			do
			{
				System.out.println("+------------------+");
				System.out.println("|    GAME OVER     |");
				System.out.println("+------------------+");
				System.out.println("| 1 - Jugar        |");
				System.out.println("| 2 - Salir        |");
				System.out.println("+------------------+");
				opc = teclado.nextInt();
				switch(opc)
				{
					case 1: 
						
					break;
					case 2:
						salir = true;
					break;
					default:
						errorParametro();
					break;
				}
			}while(salir != true);
		}		
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Método que genera espacios
	 */
	public static void generaEspacio()
	{
		for(int i = 0; i < 20;i++)
		{
			System.out.println();
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * 
	 * @param jugador
	 * @param enemigo
	 * @return true || false
	 */
	public static boolean menuDeacciones(Object jugador, Object enemigo)
	{
		salir = true;
		int opc;
		if(jugador.equals(luchador))
			do
			{
				// ¿Sigue el enemigo vivo? (El enemigo es "enemigoMago")
				if(comprobacionSalud(enemigoMago) == -1)
				{
					System.out.println("El enemigo a sido eliminado");
					return true;
				}
				else
				{
					generaEspacio();
					System.out.println("=========================");
					System.out.println("Informacion del enemigo: ");
					System.out.println("=========================");
					System.out.println(enemigo.toString());
					System.out.println("=========================");
					System.out.println("Tu informacion: ");
					System.out.println("=========================");
					System.out.println(jugador.toString());
					System.out.println("=========================");
					System.out.println("+--------------------------------------------+");
					System.out.println("|               Menu de acciones             |");
					System.out.println("+--------------------------------------------+");
					System.out.println("| 1 - Basico	        2 - Estocada         |");
					System.out.println("| 3 - Vendar Heridas	4 - Huir             |");
					System.out.println("+--------------------------------------------+");	
					opc = teclado.nextInt();
					switch(opc)
					{
						case 1:
							if (comprobacionSalud(enemigo) == 0)
							{
								enemigoMago.setSalud(enemigoMago.getSalud() + enemigoMago.cura());
							}
							if(comprobacionSalud(enemigo) == -1)
							{
								System.out.println("El enemigo a sido eliminado");
								//Clonamos al luchador para hacer que luche contra sí mismo
								luchador.clone();
								//salir = true;
								return true;
							}
							if(comprobacionSalud(jugador) == 1)
							{
								basico(jugador,enemigoMago);
							}
							if (comprobacionSalud(jugador) == 0)
							{
								luchador.setSalud(luchador.getSalud() + luchador.vendarHeridas());
							}
							if(comprobacionSalud(jugador) == -1)
							{
								System.out.println("Tu personaje a muerto");
								//salir = true;
								return false;
							}
						break;
						
						case 2:
							/*
							 * Cuando se emplea una habilidad como bolaDeFuego el enemigo también pega y es posible morir de un golpe
							 * se ha de tener cuidado debido a que si te curas no pegas, es decir, este juego es complicado.
							 */
							if(comprobacionSalud(enemigo) == 1)
							{
								//para bajarle dificultad le he añadido u factor aleatorio a la bola del enemigo aún así se puede perder
								if(aleatorio() == 10 || aleatorio() == 12)
								{
									luchador.setSalud(luchador.getSalud() - enemigoMago.bolaDeFuego());
								}
								else
								{
									
								}
							}
							if (comprobacionSalud(enemigo) == 0)
							{
								enemigoMago.setSalud(enemigoMago.getSalud() + enemigoMago.cura());
							}
							if(comprobacionSalud(enemigo) == -1)
							{
								System.out.println("El enemigo a sido eliminado");
								System.out.println("El daño infringido por la estocada es de: " + luchador.estocada());
								//salir = true;
								return true;
							}
							if(comprobacionSalud(jugador) == 1)
							{
								enemigoMago.setSalud(enemigoMago.getSalud() - luchador.estocada());

							}
							if (comprobacionSalud(jugador) == 0)
							{
								luchador.setSalud(luchador.getSalud() + luchador.vendarHeridas());
							}
							if(comprobacionSalud(jugador) == -1)
							{
								System.out.println("Tu personaje a muerto");
								System.out.println("El daño recivido por la Bola de fuego es de: " + enemigoMago.bolaDeFuego());
								//salir = true;
								return false;
							}
						break;
						case 3:
							luchador.setSalud(luchador.getSalud() + luchador.vendarHeridas());
						break;
						case 4:
							if(mensajeHuir(huir()) == true)
							{
								return false;
							}
						break;
						default:
							errorParametro();
						break;
					}
				}
			}while(salir != false);
		
		else if (jugador.equals(mago))
		{
			do
			{
				// ¿Sigue el enemigo vivo? (El enemigo es "enemigoLuchador")
				if(comprobacionSalud(enemigoLuchador) == -1)
				{
					System.out.println("El enemigo a sido eliminado");
					return true;
				}
				generaEspacio();
				System.out.println("=========================");
				System.out.println("Informacion del enemigo: ");
				System.out.println("=========================");
				System.out.println(enemigo.toString());
				System.out.println("=========================");
				System.out.println("Tu informacion: ");
				System.out.println("=========================");
				System.out.println(jugador.toString());
				System.out.println("=========================");;
				System.out.println("+--------------------------------------------+");
				System.out.println("|               Menu de acciones             |");
				System.out.println("+--------------------------------------------+");
				System.out.println("| 1 - Basico	        2 - Estocada         |");
				System.out.println("| 3 - Vendar Heridas	4 - Huir             |");
				System.out.println("+--------------------------------------------+");	
				opc = teclado.nextInt();
				switch(opc)
				{
					case 1: 
						if (comprobacionSalud(enemigo) == 0)
						{
							enemigoLuchador.setSalud(enemigoLuchador.getSalud() + enemigoLuchador.vendarHeridas());
						}
						if(comprobacionSalud(enemigo) == -1)
						{
							System.out.println("El enemigo a sido eliminado");
							//Clonamos al luchador para hacer que luche contra sí mismo
							mago.clone();
							//salir = true;
							return true;
						}
						if(comprobacionSalud(jugador) == 1)
						{
							basico(jugador,enemigo);
						}
						if (comprobacionSalud(jugador) == 0)
						{
							mago.setSalud(mago.getSalud() + mago.cura());
						}
						if(comprobacionSalud(jugador) == -1)
						{
							System.out.println("Tu personaje a muerto");
							//salir = true;
							return false;
						}
					break;
					case 2: 
						/*
						 * Cuando se emplea una habilidad como bolaDeFuego el enemigo también pega y es posible morir de un golpe
						 * se ha de tener cuidado debido a que si te curas no pegas, es decir, este juego es complicado.
						 */
						if(comprobacionSalud(enemigo) == 1)
						{
							//para bajarle dificultad le he añadido u factor aleatorio a la bola del enemigo aún así se puede perder
							if(aleatorio() == 10 || aleatorio() == 12)
							{
								mago.setSalud(mago.getSalud() - enemigoLuchador.estocada());
							}
							else
							{
								
							}
						}
						if (comprobacionSalud(enemigo) == 0)
						{
							enemigoLuchador.setSalud(enemigoLuchador.getSalud() + enemigoLuchador.vendarHeridas());
						}
						if(comprobacionSalud(enemigo) == -1)
						{
							System.out.println("El enemigo a sido eliminado");
							System.out.println("El daño infringido por la estocada es de: " + mago.bolaDeFuego());
							//salir = true;
							return true;
						}
						if(comprobacionSalud(jugador) == 1)
						{
							enemigoLuchador.setSalud(enemigoLuchador.getSalud() - mago.bolaDeFuego());

						}
						if (comprobacionSalud(jugador) == 0)
						{
							mago.setSalud(mago.getSalud() + mago.cura());
						}
						if(comprobacionSalud(jugador) == -1)
						{
							System.out.println("Tu personaje a muerto");
							System.out.println("El daño recivido por la Bola de fuego es de: " + enemigoLuchador.estocada());
							//salir = true;
							return false;
						}
					break;
					case 3:
						mago.setSalud(mago.getSalud() + mago.cura());
					break;
					case 4:
						if(mensajeHuir(huir()) == true)
						{
							return false;
						}
					break;
					default:
						errorParametro();
					break;
				}
			}while(salir != false);
		}
		return salir;
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Este metodo realiza una decrementación en la vida de los personajes corresponde con un ataque basico
	 * @param jugador
	 * @param enemigo
	 */
	public static void basico(Object jugador, Object enemigo)
	{
		if(jugador.equals(luchador) == true)
		{
			if((luchador.getAgilidad() >= enemigoMago.getAgilidad()) && (luchador.getSabiduria() >= enemigoMago.getSabiduria()) || (luchador.getAgilidad() >= enemigoMago.getAgilidad() && luchador.getDestreza() >= enemigoMago.getDestreza()) || (luchador.getDestreza() >= enemigoMago.getDestreza()) && (luchador.getSabiduria() >= enemigoMago.getSabiduria()))
			{
				enemigoMago.setSalud(enemigoMago.getSalud() - luchador.getFuerza());
				luchador.setSalud(luchador.getSalud() - enemigoMago.getFuerza());
			}
			else
			{
				luchador.setSalud(luchador.getSalud() - enemigoMago.getFuerza());
				enemigoMago.setSalud(enemigoMago.getSalud() - luchador.getFuerza());
			}
		}
		else
		{
			if((mago.getAgilidad() >= luchador.getAgilidad()) && (mago.getSabiduria() >= luchador.getSabiduria()) || (mago.getAgilidad() >= luchador.getAgilidad() && mago.getDestreza() >= luchador.getDestreza()) || (mago.getDestreza() >= luchador.getDestreza()) && (mago.getSabiduria() >= luchador.getSabiduria()))
			{
				enemigoLuchador.setSalud(enemigoLuchador.getSalud() - mago.getFuerza());
				mago.setSalud(mago.getSalud() - enemigoLuchador.getFuerza());
			}
			else
			{
				mago.setSalud(mago.getSalud() - enemigoLuchador.getFuerza());
				enemigoLuchador.setSalud(enemigoLuchador.getSalud() - mago.getFuerza());
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Gestion de la salud de los personajes e enemigos
	 * @param jugador
	 * @return valor numerico para conocer el estdo de la salud del personaje
	 */
	public static int comprobacionSalud(Object jugador)
	{
		if(jugador.equals(luchador))
		{
			if(luchador.getSalud() > muerte)
			{
				if(luchador.getSalud() > 40)
				{
					return 1;//por encima de 40 puntos de vida
					
				}
				else
				{
					return 0;//bajo 40 puntos de vida
					
				}
			}
			else
			{
				return -1;//muerto
			}
		}
		if(jugador.equals(mago))
		{
			if(mago.getSalud() > muerte)
			{
				if(mago.getSalud() > 40)
				{
					return 1;//por encima de 40 puntos de vida
				}
				else
				{
					return 0;//bajo 40 puntos de vida
				}
			}
			else
			{
				return -1;//muerto
			}
		}
		if(jugador.equals(enemigoMago))
		{
			if(enemigoMago.getSalud() > muerte)
			{
				if(enemigoMago.getSalud() > 40)
				{
					return 1;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return -1;
			}
		}
		if(jugador.equals(enemigoLuchador))
		{
			if(enemigoLuchador.getSalud() > muerte)
			{
				if(enemigoLuchador.getSalud() > 40)
				{
					return 1;//por encima de 40 puntos de vida
				}
				else if(enemigoLuchador.getSalud() < 40)
				{
					return 0;//bajo 40 puntos de vida
				}
				else
				{
					return -1;
				}
			}
			else
			{
				return -1; //muerto
			}
		}
		return -100; //no existe el rol del personaje (Es un parche hay que uscar una buena solución)
	}
}
