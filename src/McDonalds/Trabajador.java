package McDonalds;

import java.io.Serializable;


public class Trabajador extends Personal implements java.io.Serializable{
	
	private double[] horasSemana = new double[4];

	public Trabajador()
	{
		
	}
	public Trabajador(String dni, String nombre, String apellido, String cargo) 
	{
		super(dni, nombre, apellido, cargo);
	}

	
	public double calculaHoraMes()
	{
		double suma=0;
		
		for (int i = 0; i < this.horasSemana.length; i++) 
		{
			suma=suma+this.horasSemana[i];
		}
		return suma;
	}
	
	public double calculaSalario()
	{
		double salarioSemana=0;
		double salarioTotal=0;
		for (int i = 0; i < this.horasSemana.length; i++)
		{
			if(this.horasSemana[i] > 36)
			{
				salarioSemana=this.horasSemana[i]*(salarioHora*2);
				salarioTotal=salarioTotal+salarioSemana;
			}
			else
			{
				salarioSemana=this.horasSemana[i]*salarioHora;
				salarioTotal=salarioTotal+salarioSemana;
			}
		}
			
		return salarioTotal;
	}

	public double[] getHorasSemana() 
	{
		return horasSemana;
	}


	public void setHorasSemana(double[] horasSemana) 
	{
		this.horasSemana = horasSemana;
	}
	
	public String toString()
	{
		return super.toString() + "\nLas horas que has trabajado este mes han sido: " + calculaHoraMes() + "\nLo que va a cobrar este mes es: " + calculaSalario()+"€";
	}
}
