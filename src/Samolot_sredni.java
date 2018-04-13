/**
 * 
 * @author Micha� Kuc
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
	 * @param dost dost�pno�� samolotu
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
	 * Zwraca informacje o samolocie �rednim
	 * @return Zwraca dane o samolocie �rednim
	 */
	public String toString() {
		return "\nTyp samolotu: Sredni samolot. \nNazwa samolotu: " + Nazwa_samolotu + "\nZasieg samolotu: " + Zasieg_samolotu +
				"\nIlosc miejsc samolotu: " + Ilosc_miejsc_samolotu + "\n" + strDostepnosc();
	}
	/**
	 * konstruktor kopiuj�cy
	 * @param S Obiekt typu Samolot_sredni zawieraj�cy dane o samolocie �rednim
	 */
	public Samolot_sredni(Samolot S){
		super(S.getNazwa_samolotu());
		Ilosc_miejsc_samolotu = 200;
		Zasieg_samolotu = 500;
	}
	/**
	 * Metoda wywo�ywana przy zapisie do pliku danych o samolocie �rednim
	 * @return Zwraca dane o samolocie �rednim w odpowiednim formacie
	 */
	public String zapis_do_pliku() {
		return "SS:" + Nazwa_samolotu + ":" + strDostepnosc()+":";
	}
}
