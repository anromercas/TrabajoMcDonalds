package modelo.mcobject;

import java.io.Serializable;

public class McAuto implements Serializable{
	
	private char codMcAuto;
	private double horaApertura;
	private double horaCierre;
	protected static int cont=0;
	
	public McAuto(double apertura, double cierre)
	{
		this.codMcAuto='A';
		this.horaApertura=apertura;
		this.horaCierre=cierre;
		cont++;
	}

	public char getCodMcAuto() 
	{
		return codMcAuto;
	}

	public void setCodMcAuto(char codMcAuto) 
	{
		this.codMcAuto = codMcAuto;
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
		return "Hora apertura: " + this.horaApertura + "\nHora Cierre: " + this.horaCierre + "\n";
	}

}
