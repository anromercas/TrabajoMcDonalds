package McDonalds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaMcExpress {

private ArrayList lista;
	
	Scanner teclado = new Scanner(System.in);
	public ListaMcExpress()
	{
		this.lista = new ArrayList<McExpress>(); 
	}
	
	public void crearMcExpress(ListaMcDonalds listaMcDonalds)
	{
		System.out.println("CREACI�N DE McExpress");
		System.out.println();
		int cod=0;
		//valido el codigo de la tienda buscandolo en con el m�todo buscarTienda de la clase listaMcDonalds
		do{
			System.out.println("Introduce el c�digo de la tienda en la que vas a a�adir el McExpress");
			cod = teclado.nextInt();
			if(listaMcDonalds.buscarTienda(cod).getCodigo() != cod)
				System.out.println("No has metido una tienda v�lida");
		}while(listaMcDonalds.buscarTienda(cod).getCodigo() != cod);
		
		System.out.println("Introduce la hora de apertura del McExpress");
		double apertura = teclado.nextDouble();
		System.out.println("Introduce la hora de cierre del McExpress");
		double cierre = teclado.nextDouble();
		
		McExpress express = new McExpress(apertura, cierre);
		//busco la tienda correspondiente a ese codigo
		McDonalds miTienda=listaMcDonalds.buscarTienda(cod);
		//valido si la tienda no tiene ya McExpress
		if(miTienda.getMiMcExpress() == null)
		{
			//a�ado el nuevo McExpress a su tienda
			miTienda.setMiMcExpress(express);
			//cambiar el codigo de la tienda, a�adiendo el McExpress
			miTienda.cambiarCod(express.getCodMcExpress());		
		}
		else
		{
			System.out.println("Los siento pero esta tienda ya tiene McExpress");
		}
		
		
		this.lista.add(express);
	}
	
	public void guardar(String name) 
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
	public void leer(String name) 
	{
		try{
			//esto es para que lea del archivo
			FileInputStream fichero=new FileInputStream(name);
			//
			ObjectInputStream flujoEntrada=new ObjectInputStream(fichero);
			//meto en una variable entero con un cast un objeto de tipo objeto
			McExpress e=(McExpress)flujoEntrada.readObject();
			while(e!=null){
				this.lista.add(e);
				e=(McExpress)flujoEntrada.readObject();
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
}
