package McDonalds;

import java.io.Serializable;

public class McExpress implements Serializable{
	
	private char codMcExpress;
	private double horaApertura;
	private double horaCierre;
	protected static int cont=0;
	
	public McExpress(double apertura, double cierre)
	{
		this.codMcExpress='E';
		this.horaApertura=apertura;
		this.horaCierre=cierre;
		cont++;
	}

	public char getCodMcExpress() 
	{
		return codMcExpress;
	}

	public void setCodMcExpress(char codMcExpress) 
	{
		this.codMcExpress = codMcExpress;
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
