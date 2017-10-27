package vista;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.listas.ListaMcAuto;
import modelo.listas.ListaMcCafe;
import modelo.listas.ListaMcDonalds;
import modelo.listas.ListaMcExpress;
import modelo.listas.ListaPersonal;
import modelo.personas.Encargado;
import modelo.personas.Personal;
import modelo.personas.Trabajador;



public class TestPersonal{
	
	
	
Scanner teclado = new Scanner(System.in);

	public void llamada(ListaMcDonalds listaMcDonalds, ListaMcExpress listaMcExpress, ListaMcAuto listaMcAuto, ListaMcCafe listaMcCafe, ListaPersonal listaPersonal) throws IOException, ClassNotFoundException
	{
		int mp =0;
		listaPersonal.leer("c:\\ficheros\\personalE.txt", "c:\\ficheros\\personalT.txt");
		listaMcDonalds.leer("c:\\ficheros\\mcdonalds.txt");
		listaMcAuto.leer("c:\\ficheros\\mcauto.txt");
		listaMcCafe.leer("c:\\ficheros\\mccafe.txt");
		listaMcExpress.leer("c:\\ficheros\\mcexpress.txt");
		do{
			menuPrincipal();
			mp = OpcMenuPrincipal();
			switch(mp)
			{
				case 1:
					int mt=0;
					do{
						menuTienda();
						mt=OpcMenuTienda();
						switch(mt)
						{
							case 1:
								//crear mcdonald's
								listaMcDonalds.crearMcDonalds();
								break;
							case 2:
								//crear mcexpress
								listaMcExpress.crearMcExpress(listaMcDonalds);
								break;
							case 3:
								//crear mccafe
								listaMcCafe.crearMcCafe(listaMcDonalds);
								break;
							case 4:
								//crear mcauto
								listaMcAuto.crearMcAuto(listaMcDonalds);
								break;
							case 5:
								//listar Mc
								listaMcDonalds.listaMc();
								break;
							case 6:
								//listar por numTrabajadores
								listaMcDonalds.listaComparable();
								break;
							case 7:
								//listar por codTienda y metros cuadrados
								listaMcDonalds.listaComparator();
								break;
							case 8:
								//borrar Mc
								listaMcDonalds.borrarTienda();
								break;
						}
					}while(mt != 9);
					break;
				case 2:
					int mper=0;
					do{
						menuPersonal();
						mper=OpcMenuPersonal();
						switch(mper)
						{
							case 1:
								//crear persona
								listaPersonal.crearPersonal(listaMcDonalds);
								break;
							case 2:
								//ir al menu trabajador
								int opcTrab=0;
								do{
									menuTrabajador();
									opcTrab = OpcMenuTrabajador();
									switch(opcTrab)
									{
									case 1:
										//introducir horas de la semana
										boolean flag=false;
										do{
											String dni;
												//pregunto el dni para buscar a la persona
												System.out.println("Introduce el dni");
												dni = teclado.next();
											//busco persona por dni
											Personal trabajador = listaPersonal.buscarPersona(dni, "Trabajador");
											if(trabajador != null)
											{
												//introducir horas de la semana
												((Trabajador)trabajador).setHorasSemana(listaPersonal.addHorasSemana());
											}
											else
											{
												flag=true;
											}
											if(flag==true)
												System.out.println("Esa persona no trabaja en esta empresa");
										}while(flag == true);
										break;
									case 2:
										//calcular las horas del mes
										boolean flag2=false;
										do{
											String dni;
												//pregunto el dni para buscar a la persona
												System.out.println("Introduce el dni");
												dni = teclado.next();
											//busco persona por dni
											Personal trabajador = listaPersonal.buscarPersona(dni, "Trabajador");
											if(trabajador != null)
											{
												//calculo las horas del mes
												System.out.println("Las horas totales del mes son: " + ((Trabajador)trabajador).calculaHoraMes() + " Horas");
											}
											else
											{
												flag2=true;
											}
											if(flag2==true)
												System.out.println("Esa persona no trabaja en esta empresa");
										}while(flag2 == true);
										break;
									case 3:
										//calcular el salario mensual
										boolean flag3=false;
										do{
											String dni;
												//pregunto el dni para buscar a la persona
												System.out.println("Introduce el dni");
												dni = teclado.next();
											//busco persona por dni
											Personal trabajador = listaPersonal.buscarPersona(dni, "Trabajador");
											if(trabajador != null)
											{
												//calculo el salario mensual
												System.out.println("El salario mensual es: " + ((Trabajador)trabajador).calculaSalario() + "€");
											}
											else
											{
												flag3=true;
											}
											if(flag3==true)
												System.out.println("Esa persona no trabaja en esta empresa");
										}while(flag3 == true);
										break;
									case 4:
										//Listar Trabajadores
										listaPersonal.listaTrabajadores();
										break;
									}
								}while(opcTrab != 5);
								break;
							case 3:
								//ir al menu encargado
								int opcEnc=0;
								do{
									menuEncargado();
									opcEnc = OpcMenuEncargado();
									switch(opcEnc)
									{
									case 1:
										//calcular el salario mensual
										boolean flag4=false;
										do{
											String dni;
												//pregunto el dni para buscar a la persona
												System.out.println("Introduce el dni");
												dni = teclado.next();
											//busco persona por dni
											Personal trabajador = listaPersonal.buscarPersona(dni, "Encargado");
											if(trabajador != null)
											{
												//calculo el salario mensual
												System.out.println("El salario mensual es: " + ((Encargado)trabajador).calculaSalario() + "€");
											}
											else
											{
												flag4=true;
											}
											if(flag4==true)
												System.out.println("Esa persona no trabaja en esta empresa");
										}while(flag4 == true);
										break;
									case 2:
										//cambiar el plus de encargado
										boolean flag5=false;
										do{
											String dni;
												//pregunto el dni para buscar a la persona
												System.out.println("Introduce el dni");
												dni = teclado.next();
											//busco persona por dni
											Personal trabajador = listaPersonal.buscarPersona(dni, "Encargado");
											if(trabajador != null)
											{
												double plus=0;
												System.out.println("Introduce el nuevo plus del Encargado");
												plus = teclado.nextDouble();
												//cambio el plus de encargado
												((Encargado)trabajador).setPlusEncargado(plus);
											}
											else
											{
												flag5=true;
											}
											if(flag5==true)
												System.out.println("Esa persona no trabaja en esta empresa");
										}while(flag5 == true);
										break;
									case 3:
										//listar encargados
										listaPersonal.listaEncargados();
										break;
									}
								}while(opcEnc != 4);
								break;
						}
					}while(mper != 4);
					break;
				case 3:
					int mc=0;
					do{
						menuContratacion();
						mc=OpcMenuContratacion();
						switch(mc)
						{
							case 1:
								//ascender trabajador
								boolean flag4=false;
								do{
									String dni;
										//pregunto el dni para buscar a la persona
										System.out.println("Introduce el dni");
										dni = teclado.next();
									//busco persona por dni
									Personal trabajador = listaPersonal.buscarPersona(dni, "Trabajador");
									if(trabajador != null)
									{
										//si el trabajador existe lo asciendo
										trabajador.setCargo("Encargado");
									}
									else
									{
										flag4=true;
									}
									if(flag4==true)
										System.out.println("Esa persona no trabaja en esta empresa");
								}while(flag4 == true);
								break;
							case 2:
								//despedir trabajador
								listaPersonal.despedir();
								break;
							case 3:
								//listado completo
								listaPersonal.listadoCompleto();
								break;
								
						}
					}while(mc != 4);
					break;
				case 4:
					listaPersonal.guardar("c:\\ficheros\\personalE.txt", "c:\\ficheros\\personalT.txt");
					listaMcDonalds.guardar("c:\\ficheros\\mcdonalds.txt");
					listaMcAuto.guardar("c:\\ficheros\\mcauto.txt");
					listaMcCafe.guardar("c:\\ficheros\\mccafe.txt");
					listaMcExpress.guardar("c:\\ficheros\\mcexpress.txt");
					break;
			}
		}while(mp != 4);
		System.out.println();
		System.out.println("¡Hasta la próxima!\nSoftware realizado por Nuria Romero");
	}

	public void menuPrincipal()
	{
		System.out.println("MENÚ PRINCIPAL");
		System.out.println();
		System.out.println("1.- GESTIÓN TIENDA");
		System.out.println("2.- GESTIÓN PERSONAL");
		System.out.println("3.- GESTIÓN CONTRATACIÓN");	
		System.out.println("4.- Salir del programa");
	}
	
	public int OpcMenuPrincipal()
	{
		int opc=0;
		do{
			System.out.println();
			System.out.println("Introduce una opción");
			opc=teclado.nextInt();
			if(opc < 1 || opc > 4)
				System.out.println("No has introducido una opción válida");
		}while(opc < 1 || opc > 4);	
		return opc;
	}
	public void menuTienda()
	{
		System.out.println("MENÚ GESTIÓN TIENDA");
		System.out.println();
		System.out.println("1.- Crear McDonald's");
		System.out.println("2.- Crear McExpress");
		System.out.println("3.- Crear McCafé");
		System.out.println("4.- Crear McAuto");
		System.out.println("5.- Listar McDonad's");
		System.out.println("6.- Listar por numero de trabajadores");
		System.out.println("7.- Listar por metros tienda y hora apertura");
		System.out.println("8.- Borrar MdDonalds");
		System.out.println("9.- Salir al menú PRINCIPAL");
	}
	
	public int OpcMenuTienda()
	{
		int opc=0;
		do{
			System.out.println();
			System.out.println("Introduce una opción");
			opc=teclado.nextInt();
			if(opc < 1 || opc > 9)
				System.out.println("No has introducido una opción válida");
		}while(opc < 1 || opc > 9);	
		return opc;
	}
	
	
	
	public void menuPersonal()
	{
		System.out.println("MENÚ GESTIÓN PERSONAL");
		System.out.println();
		System.out.println("1.- Crear persona");
		System.out.println("2.- Ir al menú Trabajador");
		System.out.println("3.- Ir al menú Encargado");
		System.out.println("4.- Salir al menú PRINCIPAL");
	}
	
	public int OpcMenuPersonal()
	{
		int opc=0;
		do{
			System.out.println();
			System.out.println("Introduce una opción");
			opc=teclado.nextInt();
			if(opc < 1 || opc > 4)
				System.out.println("No has introducido una opción válida");
		}while(opc < 1 || opc > 4);	
		return opc;
	}
	
	public void menuContratacion()
	{
		System.out.println("MENÚ GESTIÓN CONTRATACIÓN");
		System.out.println();
		System.out.println("1.- Ascender trabajador");
		System.out.println("2.- Despedir Personal");
		System.out.println("3.- Listado completo del personal");
		System.out.println("4.- Salir al menú PRINCIPAL");
	}
	
	public int OpcMenuContratacion()
	{
		int opc=0;
		do{
			System.out.println();
			System.out.println("Introduce una opción");
			opc=teclado.nextInt();
			if(opc < 1 || opc > 4)
				System.out.println("No has introducido una opción válida");
		}while(opc < 1 || opc > 4);	
		return opc;
	}
	
	public void menuTrabajador()
	{
		System.out.println("MENÚ TRABAJADOR");
		System.out.println("1.- Introducir horas de la semana");
		System.out.println("2.- Calcular las horas del mes");
		System.out.println("3.- Calcular el salario mensual");
		System.out.println("4.- Listar Trabajadores");
		System.out.println("5.- Salir al menú GESTIÓN PERSONAL");
	}
	
	public int OpcMenuTrabajador()
	{
		int opc=0;
		do{
			System.out.println();
			System.out.println("Introduce una opción");
			opc=teclado.nextInt();
			if(opc < 1 || opc > 5)
				System.out.println("No has introducido una opción válida");
		}while(opc < 1 || opc > 5);	
		return opc;
	}
	
	public void menuEncargado()
	{
		System.out.println("MENÚ ENCARGADO");
		System.out.println("1.- Calcular salario mensual");
		System.out.println("2.- Cambiar Plus de Encargado");
		System.out.println("3.- Listar Encargados");
		System.out.println("4.- Salir al menú GESTIÓN PERSONAL");
	}
	
	public int OpcMenuEncargado()
	{
		int opc=0;
		do{
			System.out.println();
			System.out.println("Introduce una opción");
			opc=teclado.nextInt();
			if(opc < 1 || opc > 4)
				System.out.println("No has introducido una opción válida");
		}while(opc < 1 || opc > 4);	
		return opc;
	}



	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ListaMcDonalds Mc =new ListaMcDonalds();
		ListaMcExpress McE = new ListaMcExpress();
		ListaMcAuto McA = new ListaMcAuto();
		ListaMcCafe McC = new ListaMcCafe();
		ListaPersonal personal = new ListaPersonal();
		Personal[] persona = new Personal[100];
		TestPersonal test = new TestPersonal();
		
		test.llamada(Mc, McE, McA, McC, personal);
		
		
				
	}

}
