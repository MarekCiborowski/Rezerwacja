/**
 * 
 * @author Micha³ Kuc
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
	 * Zwraca iloœæ miejsc samolotu
	 * @return Zwraca iloœæ miejsc w samolocie
	 */
	public int getMiejsca_samolotu() { return Ilosc_miejsc_samolotu; }
	/**
	 * Zwraca zasiêg samolotu
	 * @return Zwraca zasiêg samolotu
	 */
	public int getZasieg_samolotu() { return Zasieg_samolotu; }
	/**
	 * Zwraca nazwê samolotu
	 * @return Zwraca nazwê samolotu
	 */
	public String getNazwa_samolotu() { return Nazwa_samolotu; }
	/**
	 * Zwraca dostepnoœæ samolotu, czyli czy jest przypisany do lotu czy nie
	 * @return Zwraca pole Dostêpnosc
	 */
	public boolean getDostepnosc() { return Dostepnosc; }
	/**
	 * Zawiera parametr, który zmienia wartoœæ pola Dostepnosc
	 * @param dost jest parametrem typu boolean
	 */
	public void setDostepnosc(boolean dost) { Dostepnosc = dost; }
	/**
	 * Zwraca informacje o samolocie
	 */
	public abstract String toString();
	/**
	 * Konstruktor kopiujacy
	 * @param s parametr typu Samolot zawieraj¹cy inforamcje o samolocie
	 */
	public Samolot(Samolot s) { Ilosc_miejsc_samolotu = s.Ilosc_miejsc_samolotu;
	Zasieg_samolotu = s.Zasieg_samolotu; Nazwa_samolotu = s.Nazwa_samolotu; Dostepnosc = true;}
	
	/**
	 * Metoda wywo³ywana przy zapisywaniu do pliku danych o samolocie
	 */
	public abstract String zapis_do_pliku();
	/**
	 * zwraca informacje, czy samolot jest dostêpny czy nie
	 * @return Zwraca informacje o tym, czy jest ten samolot dostêpny
	 */
	public String strDostepnosc(){
		if(Dostepnosc)
			return "Dostepny\n";
		else
			return "Niedostepny\n";
	}
}
