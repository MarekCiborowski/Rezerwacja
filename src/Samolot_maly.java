/**
 * 
 * @author Micha� Kuc
 *
 */
public class Samolot_maly extends Samolot {
	/**
	 * kontruktor jednoparametrowy
	 * @param N nazwa samolotu
	 */
	public Samolot_maly(String N){
		super(N);
		Ilosc_miejsc_samolotu = 100; 
		Zasieg_samolotu = 200;
	}
	/**
	 * konstruktor dwuparametrowy
	 * @param N nazwa samolotu
	 * @param dost dost�pno�� samolotu
	 */
	public Samolot_maly(String N, String dost){
		super(N);
		Ilosc_miejsc_samolotu = 100; 
		Zasieg_samolotu = 200;
			if(dost.equals("Dostepny"))
				Dostepnosc=true;
			else
				Dostepnosc=false;
	}
	/**
	 * Zwraca informacje o samolocie ma�ym
	 * @return Zwraca dane o ma�ym samolocie
	 */
	public String toString() {
			return "\nTyp samolotu: Maly samolot. \nNazwa samolotu: " + Nazwa_samolotu + "\nZasieg samolotu: " + Zasieg_samolotu +
					"\nIlosc miejsc samolotu: " + Ilosc_miejsc_samolotu + "\n" + strDostepnosc();
	}
	/**
	 * konstruktor kopiuj�cy
	 * @param S Obiekt typu Samolot_maly zawieraj�cy informacje o samolocie ma�ym
	 */
	public Samolot_maly(Samolot S){
		super(S.getNazwa_samolotu());Ilosc_miejsc_samolotu = 100; Zasieg_samolotu = 200;
	}
	//@Override
	/**
	 * Metoda wywo�ywana przy zapisie do pliku danych o samolocie ma�ym
	 * @return Zwraca dane o ma�ym samolocie w odpowiednim formacie
	 */
	public String zapis_do_pliku() {
		return "SM:" + Nazwa_samolotu + ":" + strDostepnosc()+":";
	}	
}
