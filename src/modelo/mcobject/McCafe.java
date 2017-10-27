package modelo.mcobject;

import java.io.Serializable;

public class McCafe implements Serializable{
	
	private char codMcCafe;
	private double horaApertura;
	private double horaCierre;
	protected static int cont=0;
	
	public McCafe(double apertura, double cierre)
	{
		this.codMcCafe='C';
		this.horaApertura=apertura;
		this.horaCierre=cierre;
		cont++;
	}

	public char getCodMcCafe() 
	{
		return codMcCafe;
	}

	public void setCodMcCafe(char codMcCafe) 
	{
		this.codMcCafe = codMcCafe;
	}

	public double getHoraApertura() 
	{
		return horaApertura;
	}

	public void setHoraApertura(double horaApertura) 
	{
		this.horaApertura = horaApertura;
	}

	public double getHoraCierre() 
	{
		return horaCierre;
	}

	public void setHoraCierre(double horaCierre)
	{
		this.horaCierre = horaCierre;
	}
	
	public String toString()
	{
		return "Hora apertura: " + this.horaApertura + "\nHora Cierre: " + this.horaCierre+ "\n";
	}

}
