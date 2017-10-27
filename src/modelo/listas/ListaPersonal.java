package modelo.listas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.mcobject.McDonalds;
import modelo.personas.Encargado;
import modelo.personas.Personal;
import modelo.personas.Trabajador;

public class ListaPersonal{
	
	private ArrayList<Personal> lista;
	
	Scanner teclado = new Scanner(System.in);
	
	public ListaPersonal()
	{
		this.lista=new ArrayList<Personal>();
	}
	
	public void crearPersonal(ListaMcDonalds listaMcDonalds)
	{
		McDonalds nodo = new McDonalds();
		boolean bandera = true;
		System.out.println("INSERCIÓN DE PERSONAL");
		System.out.println();
		int cod=0;
		//valido el codigo de la tienda buscandolo en con el método buscarTienda de la clase listaMcDonalds
		do{
			System.out.println("Introduce el código de la tienda en la que vas a añadir el personal");
			cod = teclado.nextInt();
			
			nodo=listaMcDonalds.buscarTienda(cod);
			if(listaMcDonalds.buscarTienda(cod).getCodigo() != cod)
				System.out.println("No has metido una tienda válida");
		}while(listaMcDonalds.buscarTienda(cod).getCodigo() != cod);
		String dni;
		boolean flag=false;
		do{
			
				//pregunto el dni para buscar a la persona
				System.out.println("Introduce el dni");
				dni = teclado.next();
			//busco persona por dni
			Personal trabajador = buscarPersona(dni, "Trabajador");
			if(trabajador != null)
			{
				System.out.println("Esa persona ya trabaja en esta empresa");
				flag=true;
			}	
		}while(flag == true);
		System.out.println("Introduce el nombre");
		String nombre = teclado.next();
		System.out.println("Introduce el apellido");
		String apellido=teclado.next();
		String cargo;
		do{
			System.out.println("Introduce el cargo (Encargado o Trabajador)");
			cargo=teclado.next();
			if(cargo.compareTo("Encargado") != 0 && cargo.compareTo("Trabajador") != 0 && cargo.compareTo("encargado") != 0 && cargo.compareTo("trabajador") != 0)
			{
				bandera = false;
				System.out.println("No has introducido el cargo correctamente");
			}
		}while(bandera == false);
		if(cargo.compareTo("Encargado") == 0 || cargo.compareTo("encargado") == 0)
		{
			double horasMes = addHorasMes();
			Encargado persona = new Encargado(dni, nombre, apellido, "Encargado", horasMes);
			persona.setMiTienda(nodo);
			//añado la persona a la lista de esta misma clase
			this.lista.add(persona);
		}
		else
		{
			//creo un array para introducir las horas de las semanas del trabajador
			double[] horasSem = new double[4];
			//igualo el array al método addHorasSemana() que me devuelve un array con las horas de las semanas
			horasSem=addHorasSemana();
			//creo el objeto trabajador 
			Trabajador persona = new Trabajador(dni,nombre,apellido,"Trabajador");			
			//cambio mediante el método setHorasSemana() de la clase Trabajador las horas de la semana
			persona.setHorasSemana(horasSem);
			persona.setMiTienda(nodo);
			//añado la persona a la lista de esta misma clase
			this.lista.add(persona);
		

		}
		
		
		/*
		Personal t = new Trabajador("28843406a", "Nuria", "Romero", "Trabajador");
		Personal e = new Encargado("11111111a", "Pepe", "Ramero", "Encargado", 40);
		
		this.lista.add(t);
		this.lista.add(e);
		*/
	}
	
	public void despedir()
	{
		boolean encontrado=false;
		
		System.out.println("Introduzca Numero de DNI: ");
		String dni=teclado.next();
		
		for(int i=0;i<this.lista.size() && encontrado==false;i++)
		{
			if(((Personal)this.lista.get(i)).getDni().compareTo(dni) == 0)
			{
				if(this.lista.remove(this.lista.get(i)))
				{
					System.out.println("EL EMPLEADO " + ((Personal) this.lista.get(i)).getNombre() + " " + ((Personal) this.lista.get(i)).getApellido() + " CON DNI " + ((Personal) this.lista.get(i)).getDni() + " HA SIDO DESPEDIDO");
					encontrado=true;
				}
			}
		}
		
		if (encontrado==false)
		{
			System.out.println("EMPLEADO NO ENCONTRADO");
		}
	}
	
	public void leer(String nameE,String nameT) throws IOException, ClassNotFoundException
	{	
		try{
		//esto es para que lea del archivo
		FileInputStream ficheroE=new FileInputStream(nameE);
		ObjectInputStream flujoEntradaE=new ObjectInputStream(ficheroE);
		
		FileInputStream ficheroT=new FileInputStream(nameT);
		ObjectInputStream flujoEntradaT=new ObjectInputStream(ficheroT);
		//meto en una variable entero con un cast un objeto de tipo objeto
		Encargado e=(Encargado)flujoEntradaE.readObject();
		while(e!=null){
			this.lista.add(e);
			e=(Encargado)flujoEntradaE.readObject();
		}
		Trabajador t=(Trabajador)flujoEntradaT.readObject();
		while(t!=null){
			this.lista.add(e);
			t=(Trabajador)flujoEntradaT.readObject();
		}
		flujoEntradaE.close();
		flujoEntradaT.close();
		}
		catch (IOException e) 
		{
			System.out.println(" error entrada salida");
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Clase no encontrada");
		}
		catch(Exception e)
		{
			System.out.println("archivo no encontrado");
		}
	}
	
	public void guardar(String nameE,String nameT) throws IOException
	{
		try{
		FileOutputStream ficheroE=new FileOutputStream(nameE);
		ObjectOutputStream flujoSalidaE=new ObjectOutputStream(ficheroE);
		FileOutputStream ficheroT=new FileOutputStream(nameT);
		ObjectOutputStream flujoSalidaT=new ObjectOutputStream(ficheroT);
		for(int i=0;i<this.lista.size();i++)
		{
			if(((Personal)this.lista.get(i)).getCargo().compareTo("Encargado") == 0)
			{
				Encargado e = new Encargado();
				e=(Encargado) this.lista.get(i);
				flujoSalidaE.writeObject(e);
			}
			else
			{
				
				flujoSalidaT.writeObject((Trabajador)this.lista.get(i));
			}
			
		}
		flujoSalidaE.close();
		flujoSalidaT.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("El fichero no existe");
		}
		catch(NotSerializableException e)
		{
			System.out.println("No serializable");
		}
		catch(Exception e)
		{
			System.out.println("archivo no encontrado");
		}
	}
	
	public void listaTrabajadores()
	{
		//hay que validar que sean trabajadores
		//	if(((Personal) this.lista.get(i)).getCargo().compareTo("Trabajador") == 0 && ((Personal) this.lista.get(i)).getCargo().compareTo("trabajador") == 0)
		Iterator<Personal> it =	lista.iterator();
		
		while(it.hasNext())
		{
			if(it != null)
			{
				Trabajador e = (Trabajador)it.next();	
				System.out.println(e.toString());
			}
			else
				System.out.println("No existen trabajadores aún");
		}
	}
	
	public void listaEncargados()
	{
		//hay que validar que sean Encargados
	//		if(((Personal) this.lista.get(i)).getCargo().compareTo("Encargado") == 0)
		Iterator<Personal> it =	lista.iterator();
		
		while(it.hasNext())
		{
			if(it != null)
			{
				Encargado e = (Encargado)it.next();
				System.out.println(e.toString());
			}
			else
				System.out.println("No existen encargados aún");
		}
	}
	
	public void listadoCompleto()
	{
		Iterator<Personal> it =	lista.iterator();
		
		while(it.hasNext())
		{
			Personal p = (Personal)it.next();
			System.out.println(p.toString());
		}
	}
	
	public double[] addHorasSemana()
	{
		System.out.println("Introduce las horas trabajadas en cada semana");
		double[] horasSem = new double[4];
		for (int i = 1; i <= horasSem.length; i++) 
		{
			System.out.println("introduce la semana " + i);
			horasSem[i-1]=teclado.nextDouble();
		}
		return horasSem;
	}
	
	public double addHorasMes()
	{
		System.out.println("Introduce las horas trabajadas en el mes");
		double horasMes=teclado.nextDouble();
		
		return horasMes;
	}
	

	public Personal buscarPersona(String dni, String cargo)
	{
		if(cargo.compareTo("Encargado") == 0)
		{
			Personal encargado = new Encargado();
			boolean flag=false;
			for (int i = 0; i < this.lista.size() && flag == false; i++) 
			{
				encargado= (Personal) this.lista.get(i);
				if(((Personal) this.lista.get(i)).getDni().compareTo(dni)==0)
				{
					flag=true;
				}
				
			}
			if(flag == false)
				return null;
			else
				return encargado;
			
		}
		else
		{
			Personal trabajador = new Trabajador();
			boolean flag=false;
			for (int i = 0; i < this.lista.size() && flag == false; i++) 
			{
				trabajador= (Personal) this.lista.get(i);
				if(((Personal) this.lista.get(i)).getDni().compareTo(dni)==0)
				{
					flag=true;
				}
				
			}
			if(flag == false)
				return null;
			else
				return trabajador;
		}
		
		
	}
}
