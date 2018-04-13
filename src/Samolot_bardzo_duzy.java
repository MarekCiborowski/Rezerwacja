/**
 * 
 * @author Micha³ Kuc
 *
 */
public class Samolot_bardzo_duzy extends Samolot {
	/**
	 * Kontruktor jednoparametrowy
	 * @param N nazwa samolotu
	 */
	public Samolot_bardzo_duzy(String N){
		super(N);Ilosc_miejsc_samolotu = 400; Zasieg_samolotu = 3000;
		}
	/**
	 * Konstruktor dwuparametrowy
	 * @param N nazwa samolotu
	 * @param dost dostêpnoœæ samolotu
	 */
	public Samolot_bardzo_duzy(String N, String dost){
		super(N);
		Ilosc_miejsc_samolotu = 400; Zasieg_samolotu = 3000;
		if(dost.equals("Dostepny"))
			Dostepnosc=true;
		else
			Dostepnosc=false;
	}
	/**
	 * Zwraca informacje o samolocie bardzo du¿ym
	 * @return Zwraca dane o samolocie bardzo du¿ym
	 */
	public String toString() {
		return "\nTyp samolotu: Bardzo duzy samolot. \nNazwa samolotu: " + Nazwa_samolotu + "\nZasieg samolotu: " + Zasieg_samolotu +
				"\nIlosc miejsc samolotu: " + Ilosc_miejsc_samolotu + "\n" + strDostepnosc();
	}
	/**
	 * Konstruktor kopiuj¹cy
	 * @param S Obiekt typu Samolot_bardzo_duzy zawieraj¹cy dane o samolocie bardzo du¿ym
	 */
	public Samolot_bardzo_duzy(Samolot S){
		super(S.getNazwa_samolotu());
		Ilosc_miejsc_samolotu = 400;
		Zasieg_samolotu = 3000;
		}
	/**
	 * Metoda wywo³ywana przy zapisie do pliku danych o samolocie bardzo du¿ym
	 * @return Zwraca dane o samolocie bardzo du¿ym
	 */
	public String zapis_do_pliku() {
		return "SBD:" + Nazwa_samolotu + ":" + strDostepnosc() + ":";
	}
}
