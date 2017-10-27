package modelo.personas;
import java.io.Serializable;
import java.util.Scanner;

import modelo.mcobject.McDonalds;


public abstract class Personal implements java.io.Serializable{

	protected double salarioHora;
	private String nombre;
	private String apellido;
	private String dni;
	private String cargo;
	private McDonalds miTienda;
	private String [] turnoPreferente = {"Mañana", "Tarde", "Mañana-tarde"};
	
	public abstract double calculaSalario();
	
	Scanner teclado = new Scanner(System.in);
	
	
	public Personal()
	{
		
	}
	public Personal(String dni, String nombre, String apellido, String cargo, double salario)
	{
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.cargo=cargo;
		this.miTienda=null;
	}
	public McDonalds getMiTienda() {
		return miTienda;
	}

	public void setMiTienda(McDonalds miTienda) {
		this.miTienda = miTienda;
	}

	public double getSalarioHora() 
	{
		return salarioHora;
	}

	public void setSalarioHora(double salarioHora) 
	{
		this.salarioHora = salarioHora;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getApellido() 
	{
		return apellido;
	}

	public void setApellido(String apellido) 
	{
		this.apellido = apellido;
	}

	public String getDni() 
	{
		return dni;
	}

	public void setDni(String dni)
	{
		this.dni = dni;
	}

	public String getCargo()
	{
		return cargo;
	}

	public void setCargo(String cargo) 
	{
		this.cargo = cargo;
	}
	
	public String toString()
	{
		return "El empleado " + this.nombre + " " + this.apellido + " con DNI "+ this.dni + " por hora es: " + this.salarioHora;
	}
}

