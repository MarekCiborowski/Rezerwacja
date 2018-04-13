/**
 * @author Micha³ Kuc
 */
		
public class Samolot_duzy extends Samolot {
	/**
	 * Kontruktor jednoparametrowy
	 * @param N nazwa samolotu
	 */
	public Samolot_duzy(String N){
		super(N); Ilosc_miejsc_samolotu = 300; Zasieg_samolotu = 1000;
	}
	/**
	 * Konstruktor dwuparametrowy
	 * @param N nazwa samolotu
	 * @param dost dostêpnoœæ samolotu
	 */
	public Samolot_duzy(String N, String dost){
		super(N);
		Ilosc_miejsc_samolotu = 300; Zasieg_samolotu = 1000;
		if(dost.equals("Dostepny"))
			Dostepnosc = true;
		else
			Dostepnosc = false;
	}
	/**
	 * Zwraca informacje o samolocie du¿ym
	 * @return Zwraca dane o samolocie du¿ym
	 */
	public String toString() {
		return "\nTyp samolotu: Duzy samolot. \nNazwa samolotu: " + Nazwa_samolotu + "\nZasieg samolotu: " + Zasieg_samolotu +
				"\nIlosc miejsc samolotu: " + Ilosc_miejsc_samolotu + "\n" + strDostepnosc();
	}
	/**
	 * Konstruktor kopiuj¹cy
	 * @param S Obiekt typu Samolot zawieraj¹cy dane o samolocie
	 */
	public Samolot_duzy(Samolot S){
		super(S.getNazwa_samolotu());
		Ilosc_miejsc_samolotu = 300; 
		Zasieg_samolotu = 1000;
		}
	/**
	 * Metoda wywo³ywana przy zapisie do pliku danych o samolocie du¿ym
	 * @return Zwraca dane o samolocie du¿ym w odpowiednim formacie
	 */
	public String zapis_do_pliku() {
		return "SD:" + Nazwa_samolotu + ":" + strDostepnosc()+":";	
	}
}
