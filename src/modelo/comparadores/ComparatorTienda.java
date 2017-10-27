package modelo.comparadores;

import java.util.Comparator;

import modelo.mcobject.McDonalds;

public class ComparatorTienda implements Comparator<McDonalds>{

	@Override
	public int compare(McDonalds arg0, McDonalds arg1) {
		// Ordenacion segun metros tienda y hora de apertura
		int res=0;
		if((arg0.getMetrosTienda()- arg1.getMetrosTienda()) == 0)
		{
			res = (int)(arg0.getHoraApertura() - arg1.getHoraApertura());
		}
		else
		{
			res=(int) (arg0.getMetrosTienda()- arg1.getMetrosTienda());
		}
		return res;
	}


}
