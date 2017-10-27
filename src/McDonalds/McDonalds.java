package McDonalds;

import java.io.Serializable;

public class McDonalds implements java.io.Serializable, Comparable<McDonalds> {

	//codigo tienda 
	private int codigo;
	protected String codTienda;
	//contador static
	//protected static int cont=1;
	//array dni
	private String ubicacion;
	private double metrosTienda;
	private int numTrabajadores;
	private double horaApertura;
	private double horaCierre;
	private McExpress miMcExpress;
	private McCafe miMcCafe;
	private McAuto miMcAuto;
	
	public McDonalds(int codigoIni,String ubicacion, double metrosTienda, int numTrabajadores, double horaApertura, double horaCierre)
	{
		this.ubicacion=ubicacion;
		this.metrosTienda=metrosTienda;
		this.numTrabajadores=numTrabajadores;
		this.horaApertura=horaApertura;
		this.horaCierre=horaCierre;
		//asigno al codigo de la tienda al contador
		this.codigo=codigoIni+1;
		this.codTienda=String.valueOf(this.codigo);
		this.miMcAuto=null;
		this.miMcCafe=null;
		this.miMcExpress=null;
		//incremento en uno el contador
		//cont++;
	}
	public McDonalds()
	{
		
	}
	
	public void cambiarCod(char letra){
		this.setCodTienda(this.getCodTienda()+letra);
	}
	public String getUbicacion() 
	{
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) 
	{
		this.ubicacion = ubicacion;
	}

	public double getMetrosTienda() 
	{
		return metrosTienda;
	}

	public void setMetrosTienda(double metrosTienda) 
	{
		this.metrosTienda = metrosTienda;
	}

	public int getNumTrabajadores() 
	{
		return numTrabajadores;
	}

	public void setNumTrabajadores(int numTrabajadores) 
	{
		this.numTrabajadores = numTrabajadores;
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
		return "Código Tienda: " + codTienda + "\nUbicación: " + ubicacion + "\nMetros tienda: " + metrosTienda + "\nNúmero de trabajadores: " + numTrabajadores + "\nHora Apertura: " + horaApertura + "\nHora Cierre: " + horaCierre + "\n";
	}
	public String getCodTienda() {
		return codTienda;
	}
	public void setCodTienda(String codTienda) {
		this.codTienda = codTienda;
	}
	public McExpress getMiMcExpress() {
		return miMcExpress;
	}
	public void setMiMcExpress(McExpress miMcExpress) {
		this.miMcExpress = miMcExpress;
	}
	public McCafe getMiMcCafe() {
		return miMcCafe;
	}
	public void setMiMcCafe(McCafe miMcCafe) {
		this.miMcCafe = miMcCafe;
	}
	public McAuto getMiMcAuto() {
		return miMcAuto;
	}
	public void setMiMcAuto(McAuto miMcAuto) {
		this.miMcAuto = miMcAuto;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public int compareTo(McDonalds o) {
		// TODO Auto-generated method stub
		return this.getNumTrabajadores()-o.getNumTrabajadores();
	}
}
