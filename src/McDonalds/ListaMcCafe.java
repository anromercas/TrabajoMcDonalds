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


public class ListaMcCafe {
	
private ArrayList lista;
	
	Scanner teclado = new Scanner(System.in);
	public ListaMcCafe()
	{
		this.lista = new ArrayList<McCafe>(); 
	}
	public void crearMcCafe(ListaMcDonalds listaMcDonalds)
	{
		System.out.println("CREACIÓN DE McCafé");
		System.out.println();
		int cod=0;
		//valido el codigo de la tienda buscandolo en con el método buscarTienda de la clase listaMcDonalds
		do{
			System.out.println("Introduce el código de la tienda en la que vas a añadir el McCafe");
			cod = teclado.nextInt();
			if(listaMcDonalds.buscarTienda(cod).getCodigo() != cod)
				System.out.println("No has metido una tienda válida");
		}while(listaMcDonalds.buscarTienda(cod).getCodigo() != cod);
		
		System.out.println();
		System.out.println("Introduce la hora de apertura del McCafé");
		double apertura = teclado.nextDouble();
		System.out.println("Introduce la hora de cierre del McCafé");
		double cierre = teclado.nextDouble();
		
		McCafe cafe = new McCafe(apertura, cierre);
		//busco la tienda correspondiente a ese codigo
		McDonalds miTienda=listaMcDonalds.buscarTienda(cod);
		//valido si la tienda no tiene ya McCafe
		if(miTienda.getMiMcCafe() == null)
		{
			//añado el nuevo McExpress a su tienda
			miTienda.setMiMcCafe(cafe);
			//cambiar el codigo de la tienda, añadiendo el McExpress
			miTienda.cambiarCod(cafe.getCodMcCafe());	
		}
		else
		{
			System.out.println("Los siento pero esta tienda ya tiene McExpress");
		}
		
		this.lista.add(cafe);
		
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
			McCafe e=(McCafe)flujoEntrada.readObject();
			while(e!=null){
				this.lista.add(e);
				e=(McCafe)flujoEntrada.readObject();
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
