package modelo.personas;

import java.io.Serializable;


public class Encargado extends Personal implements java.io.Serializable{
	
	private double plusEncargado; 
	private double horasMes;
	
	public Encargado()
	{
		
	}
	
	public Encargado(String dni, String nombre, String apellido, String cargo, double horasMes, double salario) 
	{
		super(dni, nombre, apellido, cargo, salario);
		this.plusEncargado=50;
		this.horasMes=horasMes;
	}
	
	public double calculaSalario()
	{
		double salario=0;
		salario=horasMes * salarioHora + this.plusEncargado;
		return salario;
	}

	public double getPlusEncargado() 
	{
		return plusEncargado;
	}

	public void setPlusEncargado(double plusEncargado) 
	{
		this.plusEncargado = plusEncargado;
	}

	public double getHorasMes() 
	{
		return horasMes;
	}

	public void setHorasMes(double horasMes) 
	{
		this.horasMes = horasMes;
	}
	
	public String toString()
	{
		return super.toString() + "\nLas horas que has trabajado este mes han sido: " + horasMes + "\nEl plus de encargado es: " + this.plusEncargado + "€\nLo que va a cobrar este mes es: " + calculaSalario()+"€";
	}
}
