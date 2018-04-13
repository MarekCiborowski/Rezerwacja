/**
 * @author Marek Ciborowski
 */
public abstract class Klient {
	/**
	 * Zwraca dane o kliencie
	 */
	public abstract String toString(); 
	/**
	 * Zwraca nazwê klienta
	 */
	public abstract String getNazwa();
	/**
	 * Zwraca nr kliencie
	 */
	public abstract String getNumer(); 
	/**
	 * Zwraca dane klienta w odpowiednim formacie do zapisu
	 */
	public abstract String zapis_do_pliku();
}