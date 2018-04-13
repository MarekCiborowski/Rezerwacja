/**
 * @author Marek Ciborowski
 */
import java.util.Comparator;
class Porownanie_samolotow implements Comparator<Samolot> { 
	/**
	 * Metoda compare o porównuje 2 parametry typu Samolot
	 * S³u¿y do porównania samolotów pod wzglêdem zasiêgu
	 * @return Zwraca 1, gdy pierwszy samolot ma wiêkszy zasiêg od drugiego. 
	 * Zwraca 0, gdy zasiêgi obu samolotów s¹ równe. 
	 * Zwraca 1 w pozosta³ych przypadkach
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
