/**
 * 
 * @author Marek Ciborowski
 *
 */
public class Trasa { 
	private Lotnisko Lotnisko1, Lotnisko2; 
	private int Odleglosc, Czas_lotu;
	/**
	 * Zwraca Lotnisko pierwsze jako obiekt
	 * @return Zwraca Lotnisko pierwsze jako obiekt
	 */
	public Lotnisko getLotnisko1() { return Lotnisko1; }
	/**
	 * Zwraca Lotnisko drugie jako obiekt
	 * @return Zwraca Lotnisko drugie jako obiekt
	 */
	public Lotnisko getLotnisko2() { return Lotnisko2; } 
	/**
	 * Zwraca odleg³oœæ miêdzy lotniskami
	 * @return Zwraca odleg³oœæ miêdzy lotniskami
	 */
	public int getOdleglosc() { return Odleglosc; }
	/**
	 * Zwraca czas lotu miêdzy lotniskiem pierwszym a drugim
	 * @return  Zwraca czas lotu miêdzy lotniskami
	 */
	public int getCzas_lotu() { return Czas_lotu; }
	/**
	 * kontruktor 4-parametrowy
	 * @param LOTNISKO1 pierwsze lotnisko (typ Lotnisko)
	 * @param LOTNISKO2 drugie lotnisko (typ Lotnisko)
	 * @param o odlegloœæ
	 * @param c czas lotu
	 */
	public Trasa(Lotnisko LOTNISKO1, Lotnisko LOTNISKO2, int o, int c ) {
		Lotnisko1 = LOTNISKO1; Lotnisko2 = LOTNISKO2;
		Odleglosc = o; Czas_lotu = c;
	}
	/**
	 * kontruktor kopiujacy
	 * @param t Obiekt typu Trasa zawieraj¹cy informacje o trasie
	 */
	public Trasa(Trasa t){
		Lotnisko1=t.Lotnisko1; Lotnisko2=t.Lotnisko2;
		Odleglosc=t.Odleglosc; Czas_lotu=t.Czas_lotu;
	}
	/**
	 * Zwraca informacje o trasie
	 * @return Zwraca dane trasy
	 */
	public String toString() {
		return "\nTrasa: " + Lotnisko1.getNazwa_Lotniska() + 
				" - " + Lotnisko2.getNazwa_Lotniska() + 
				"\nOdleglosc: " + Odleglosc + "\nCzas lotu: " + 
				Czas_lotu + "\n";
				
	}
	/**
	 * Metoda u¿ywana przy zapisywaniu do pliku danych o trasie
	 * @return Zwraca dane o trasie w odpowiednim formacie
	 */
	public String zapis_do_pliku(){
		return "T:" + Lotnisko1.getNazwa_Lotniska() + ":" + Lotnisko2.getNazwa_Lotniska() + ":" + 
				Odleglosc + ":" + Czas_lotu + ":";
	}
	
}
