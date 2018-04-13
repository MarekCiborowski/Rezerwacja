/**
 * 
 * @author Micha� Kuc
 *
 */
public abstract class Samolot {	
	protected int Ilosc_miejsc_samolotu, Zasieg_samolotu=0;	
	protected String Nazwa_samolotu;
	protected boolean Dostepnosc;	
	/**
	 * Kontruktor bezparametrowy
	 */
	public Samolot(){	
		Ilosc_miejsc_samolotu = 0;
		Zasieg_samolotu = 0;
		Nazwa_samolotu = " ";
		Dostepnosc = true;
	}
	/**
	 * Kontruktor o jednym parametrze
	 * @param N nazwa samolotu
	 */
	public Samolot(String N){
	Nazwa_samolotu = N; Dostepnosc = true;
	}
	/**
	 * Zwraca ilo�� miejsc samolotu
	 * @return Zwraca ilo�� miejsc w samolocie
	 */
	public int getMiejsca_samolotu() { return Ilosc_miejsc_samolotu; }
	/**
	 * Zwraca zasi�g samolotu
	 * @return Zwraca zasi�g samolotu
	 */
	public int getZasieg_samolotu() { return Zasieg_samolotu; }
	/**
	 * Zwraca nazw� samolotu
	 * @return Zwraca nazw� samolotu
	 */
	public String getNazwa_samolotu() { return Nazwa_samolotu; }
	/**
	 * Zwraca dostepno�� samolotu, czyli czy jest przypisany do lotu czy nie
	 * @return Zwraca pole Dost�pnosc
	 */
	public boolean getDostepnosc() { return Dostepnosc; }
	/**
	 * Zawiera parametr, kt�ry zmienia warto�� pola Dostepnosc
	 * @param dost jest parametrem typu boolean
	 */
	public void setDostepnosc(boolean dost) { Dostepnosc = dost; }
	/**
	 * Zwraca informacje o samolocie
	 */
	public abstract String toString();
	/**
	 * Konstruktor kopiujacy
	 * @param s parametr typu Samolot zawieraj�cy inforamcje o samolocie
	 */
	public Samolot(Samolot s) { Ilosc_miejsc_samolotu = s.Ilosc_miejsc_samolotu;
	Zasieg_samolotu = s.Zasieg_samolotu; Nazwa_samolotu = s.Nazwa_samolotu; Dostepnosc = true;}
	
	/**
	 * Metoda wywo�ywana przy zapisywaniu do pliku danych o samolocie
	 */
	public abstract String zapis_do_pliku();
	/**
	 * zwraca informacje, czy samolot jest dost�pny czy nie
	 * @return Zwraca informacje o tym, czy jest ten samolot dost�pny
	 */
	public String strDostepnosc(){
		if(Dostepnosc)
			return "Dostepny\n";
		else
			return "Niedostepny\n";
	}
}
