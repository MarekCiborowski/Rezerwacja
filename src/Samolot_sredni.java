/**
 * 
 * @author Micha³ Kuc
 *
 */
public class Samolot_sredni extends Samolot{
	/**
	 * Kontruktor jednoparametrowy
	 * @param N nazwa samolotu
	 */
	public Samolot_sredni(String N){
		super(N); Ilosc_miejsc_samolotu = 200; Zasieg_samolotu = 500;
	}
	/**
	 * konstruktor dwuparametrowy
	 * @param N nazwa samolotu
	 * @param dost dostêpnoœæ samolotu
	 */
	public Samolot_sredni(String N, String dost){
		super(N);
		Ilosc_miejsc_samolotu = 200; 
		Zasieg_samolotu = 500;
		if(dost.equals("Dostepny"))
			Dostepnosc=true;
		else
			Dostepnosc=false;
	}
	/**
	 * Zwraca informacje o samolocie œrednim
	 * @return Zwraca dane o samolocie œrednim
	 */
	public String toString() {
		return "\nTyp samolotu: Sredni samolot. \nNazwa samolotu: " + Nazwa_samolotu + "\nZasieg samolotu: " + Zasieg_samolotu +
				"\nIlosc miejsc samolotu: " + Ilosc_miejsc_samolotu + "\n" + strDostepnosc();
	}
	/**
	 * konstruktor kopiuj¹cy
	 * @param S Obiekt typu Samolot_sredni zawieraj¹cy dane o samolocie œrednim
	 */
	public Samolot_sredni(Samolot S){
		super(S.getNazwa_samolotu());
		Ilosc_miejsc_samolotu = 200;
		Zasieg_samolotu = 500;
	}
	/**
	 * Metoda wywo³ywana przy zapisie do pliku danych o samolocie œrednim
	 * @return Zwraca dane o samolocie œrednim w odpowiednim formacie
	 */
	public String zapis_do_pliku() {
		return "SS:" + Nazwa_samolotu + ":" + strDostepnosc()+":";
	}
}
