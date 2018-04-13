/**
 * 
 * @author Marek Ciborowski
 *
 */
public class Lotnisko {
	private String nazwa_Lotniska;
	/**
	 * Zwraca informacje o lotnisku
	 * @return Zwraca nazw� lotniska
	 */
	public String toString() { return "Nazwa lotniska: " + nazwa_Lotniska + "\n"; }
	/**
	 * Zwraca nazw� lotniska
	 * @return Zwraca nazw� lotniska
	 */
	public String getNazwa_Lotniska() { return nazwa_Lotniska; }
	/**
	 * Konstruktor jednoparametrowy zawieraj�cy nazw� lotniska
	 * @param NAZWA_LOTNISKA zawiera nazw� lotniska
	 */
	public Lotnisko(String NAZWA_LOTNISKA) { nazwa_Lotniska = NAZWA_LOTNISKA; }
	/**
	 * Kontruktor kopiuj�cy
	 * @param l Obiekt typu Lotnisko zawieraj�cy nazw� lotniska
	 */
	public Lotnisko(Lotnisko l) { nazwa_Lotniska = l.nazwa_Lotniska; }
	/**
	 * Metoda wywo�ywana przy zapisywaniu do pliku danych o lotnisku
	 * @return Zwraca nazw� lotniska
	 */
	public String zapis_do_pliku() { return "Lotnisko:" + nazwa_Lotniska + ":"; }
}
