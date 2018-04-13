/**
 * @author Marek Ciborowski
 */
import java.util.Comparator;
class Porownanie_samolotow implements Comparator<Samolot> { 
	/**
	 * Metoda compare o por�wnuje 2 parametry typu Samolot
	 * S�u�y do por�wnania samolot�w pod wzgl�dem zasi�gu
	 * @return Zwraca 1, gdy pierwszy samolot ma wi�kszy zasi�g od drugiego. 
	 * Zwraca 0, gdy zasi�gi obu samolot�w s� r�wne. 
	 * Zwraca 1 w pozosta�ych przypadkach
	 */
	public int compare(Samolot s, Samolot x){
		if(s.getZasieg_samolotu() > x.getZasieg_samolotu())
			return 1;
		if(s.getZasieg_samolotu() == x.getZasieg_samolotu())
			return 0;
		else
			return (-1);
	}

	
}
