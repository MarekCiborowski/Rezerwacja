/**
 * 
 * @author Marek Ciborowski
 *
 */
public class Lotnisko {
	private String nazwa_Lotniska;
	/**
	 * Zwraca informacje o lotnisku
	 * @return Zwraca nazwê lotniska
	 */
	public String toString() { return "Nazwa lotniska: " + nazwa_Lotniska + "\n"; }
	/**
	 * Zwraca nazwê lotniska
	 * @return Zwraca nazwê lotniska
	 */
	public String getNazwa_Lotniska() { return nazwa_Lotniska; }
	/**
	 * Konstruktor jednoparametrowy zawieraj¹cy nazwê lotniska
	 * @param NAZWA_LOTNISKA zawiera nazwê lotniska
	 */
	public Lotnisko(String NAZWA_LOTNISKA) { nazwa_Lotniska = NAZWA_LOTNISKA; }
	/**
	 * Kontruktor kopiuj¹cy
	 * @param l Obiekt typu Lotnisko zawieraj¹cy nazwê lotniska
	 */
	public Lotnisko(Lotnisko l) { nazwa_Lotniska = l.nazwa_Lotniska; }
	/**
	 * Metoda wywo³ywana przy zapisywaniu do pliku danych o lotnisku
	 * @return Zwraca nazwê lotniska
	 */
	public String zapis_do_pliku() { return "Lotnisko:" + nazwa_Lotniska + ":"; }
}
