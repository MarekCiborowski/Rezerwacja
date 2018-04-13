/**
 * @author Marek Ciborowski
 */
import java.util.Comparator;

class Porownanie_indeksow implements Comparator<Integer> { 
	/**
	 * Metoda compare o porównuje 2 parametry typu Integer.
	 * Zwraca -1 gdy argument pierwszy jest wiêkszy od drugiego.
	 * Zwraca 0 gdy oba argumenty s¹ sobie równe.
	 * Zwraca 1 gdy argument pierwszy jest wiêkszy od drugiego.
	 */
	public int compare(Integer arg0, Integer arg1) {
		if(arg0 > arg1)
			return -1;
		if(arg0 == arg1)
			return 0;
		else
			return 1;
	}
}
