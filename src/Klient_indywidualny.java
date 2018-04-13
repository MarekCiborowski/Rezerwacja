/**
 * @author Marek Ciborowski
 */
public class Klient_indywidualny extends Klient {
	private String Imie;	
	private String Nazwisko;
	private String PESEL;	
	/**
	 * Konstruktor o 3 parametrach
	 * @param I Imie klienta
	 * @param N Nazwisko klienta
	 * @param P Pesel klienta
	 */
	public Klient_indywidualny(String I,String N, String P){ Imie = I; Nazwisko = N; PESEL = P;	}
	/**
	 * Metoda do wypisywania danych klienta indywidualnego
	 * @return Zwraca imie, nazwisko oraz PESEL klienta indywidualnego
	 */
	public String toString() {
		return "\nImie: " + Imie + "\nNazwisko: " + Nazwisko + "\nPESEL: " + PESEL + "\n";	 
	}
	/**
	 * Zwraca numer PESEL klienta indywidualnego
	 * @return Zwraca numer PESEL klienta indywidualnego
	 */
	public String getNumer() { return PESEL; }
	/**
	 * Zwraca imie oraz nazwisko klienta indywidualnego
	 * @return Zwraca imie i nazwisko klienta indywidualnego
	 */
	public String getNazwa() { return Imie + " " + Nazwisko; }
	/**
	 * Kontrusktor kopiuj¹cy
	 * @param k Obiekt typu Klient_indywidualny zawieraj¹cy dane klienta
	 */
	public Klient_indywidualny(Klient_indywidualny k) { Imie = k.Imie; Nazwisko = k.Nazwisko; PESEL = k.PESEL; }
	//@Override
	
	/**
	 * Metoda s³u¿y do zapisywania odpowiednio danych klienta indywidualnego do pliku 
	 * @return Zwraca imiê, nazwisko i nr PESEL klienta indywidualnego
	 */
	public String zapis_do_pliku() {
		return "K:"+ Imie+":"+ Nazwisko + ":" + PESEL + ":";
	}

}
