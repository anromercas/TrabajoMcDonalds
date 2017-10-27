package McDonalds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class ListaMcDonalds {
	private ArrayList<McDonalds> lista;
	
	Scanner teclado = new Scanner(System.in);
	public ListaMcDonalds()
	{
		this.lista = new ArrayList<McDonalds>(); 
	}
	public void crearMcDonalds()
	{
		System.out.println("CREACIÓN DE McDonald's");
		System.out.println();
		System.out.println("Introduce su ubicación");
		String ubicacion=teclado.next();
		System.out.println("Introduce los metros de la tienda");
		int metros = teclado.nextInt();
		System.out.println("Introduce el número de trabajadores");
		int trabajadores = teclado.nextInt();
		System.out.println("Introduce la hora de apertura de la tienda");
		double horaApertura=teclado.nextDouble();
		System.out.println("Introduce la hora de cierre de la tienda");
		double horaCierre = teclado.nextDouble();
		
	
		McDonalds mac = new McDonalds(this.lista.size(),ubicacion, metros, trabajadores, horaApertura, horaCierre);

		this.lista.add(mac);
/*
		McDonalds mac = new McDonalds("Sierpes", 50, 10, 11, 1);
		McDonalds mac1 = new McDonalds("Campana", 100, 20, 11, 2);
		McDonalds mac2 = new McDonalds("ciclismo", 70, 15, 11, 1);
		McDonalds mac3 = new McDonalds("flores", 120, 120, 11, 5);
		
		this.lista.add(mac);
		this.lista.add(mac1);
		this.lista.add(mac2);
		this.lista.add(mac3);
		*/
	}
	
	public void borrarTienda()
	{
		boolean encontrado=false;
		
		System.out.println("Introduzca código de la Tienda: ");
		int cod=teclado.nextInt();
		
		for(int i=0;i<this.lista.size() && encontrado==false;i++)
		{
			if(((McDonalds) this.lista.get(i)).getCodigo() == cod)
			{
				McDonalds nodo = new McDonalds();
				nodo = this.lista.get(i);
				//pregunto si tiene mcexpres, mccafe o mcauto para borrarlos
				if(nodo.getMiMcAuto()!=null){
					//hay McAuto: borrarlo
					this.lista.remove(this.lista.get(i).getMiMcAuto());
				}
				if(nodo.getMiMcCafe()!=null){
					//hay McAuto: borrarlo
					this.lista.remove(this.lista.get(i).getMiMcCafe());
				}
				if(nodo.getMiMcExpress()!=null){
					//hay McAuto: borrarlo
					this.lista.remove(this.lista.get(i).getMiMcExpress());
				}
				
				if(this.lista.remove(this.lista.get(i)))
				{
					System.out.println("El McDonald's \n " + nodo.toString()+ "ha sido BORRADO");
					encontrado=true;
				}
			}
		}
		
		if (encontrado==false)
		{
			System.out.println("TIENDA NO ENCONTRADA");
		}
	}
	public void leer(String name) throws IOException, ClassNotFoundException
	{	
		try{
		//esto es para que lea del archivo
		FileInputStream fichero=new FileInputStream(name);
		//
		ObjectInputStream flujoEntrada=new ObjectInputStream(fichero);
		//meto en una variable entero con un cast un objeto de tipo objeto
		McDonalds e=(McDonalds)flujoEntrada.readObject();
		while(e!=null){
			this.lista.add(e);
			e=(McDonalds)flujoEntrada.readObject();
		}
		flujoEntrada.close();
		
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
	
	public void guardar(String name) throws IOException
	{
		try{
		FileOutputStream fichero2=new FileOutputStream(name);
		ObjectOutputStream flujoSalida=new ObjectOutputStream(fichero2);
		
		for(int i=0;i<lista.size();i++)
		{
			flujoSalida.writeObject(this.lista.get(i));
		}
		flujoSalida.close();
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
	public void listaMc()
	{
		Iterator<McDonalds> t = this.lista.iterator();
		while(t.hasNext())
		{
			McDonalds nodo=new McDonalds();
			nodo=t.next();
			System.out.println(nodo.toString());
			if(nodo.getMiMcAuto()!=null){
				//hay McAuto: listarlo
				System.out.println("McAuto\n");
				System.out.println();
				System.out.println(nodo.getMiMcAuto().toString());
			}
			if(nodo.getMiMcCafe()!=null){
				//hay McAuto: listarlo
				System.out.println("McCafe\n");
				System.out.println();
				System.out.println(nodo.getMiMcCafe().toString());
			}
			if(nodo.getMiMcExpress()!=null){
				//hay McAuto: listarlo
				System.out.println("McExpress\n");
				System.out.println();
				System.out.println(nodo.getMiMcExpress().toString());
			}
		}
	}
	//listado ordenado segun numero de trabajadores: Comparable
	
	public void listaComparable()
	{
		Collections.sort(lista);
		for (int i = 0; i < this.lista.size(); i++) 
		{
			System.out.println(this.lista.get(i));
		}
	}
	
	//listado ordenado segun cod tienda y metros cuadrados
	//public static void sort(List list,new ComparatorTienda)
	public void listaComparator()
	{
		Collections.sort(lista, new ComparatorTienda());
		for (int i = 0; i < this.lista.size(); i++) 
		{
			System.out.println(this.lista.get(i));
		}
	}
	
	public McDonalds buscarTienda(int cod)
	{
		McDonalds mc = new McDonalds();
		boolean flag=false;
		for (int i = 0; i < this.lista.size() && flag == false; i++) 
		{
			mc=(McDonalds) this.lista.get(i);
			
			if(((McDonalds) this.lista.get(i)).getCodigo() == cod)
			{
				flag=true;
			}
			
		}
		if(flag == false)
			return null;
		else
			return mc;
		
		
	}
}
