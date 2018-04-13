/**
 * @author Marek Ciborowski
 */
public class Firma_posredniczaca extends Klient {
	private String Nazwa_firmy;
	private String KRS;
	//kontruktor 2 parametrowy z N - nazwa firmy, K - KRS firmy
	/**
	 * Konstruktor o 2 parametrach
	 * @param N Nazwa firmy
	 * @param K KRS firmy
	 */
	public Firma_posredniczaca(String N, String K) { Nazwa_firmy = N; KRS = K; }
	/**
	 * toString - do wypisywania informacji o firmie poœrednicz¹cej (nazwa firmy oraz KRS)
	 * @return Zwraca dane firmy
	 */
	public String toString() { return "\nNazwa firmy: " + Nazwa_firmy + "\nKRS: " + KRS + "\n"; }
	/**
	 * getNazwa - zwraca nazwê firmy
	 * @return Zwraca nazwe firmy
	 */
	public String getNazwa() { return Nazwa_firmy;}
	/**
	 * getNazwa - zwraca nr KRS firmy
	 * @return Zwraca nr KRS firmy
	 */
	public String getNumer() { return KRS;}
	/**
	 * Konstruktor kopiuj¹cy
	 * @param f Obiekt typu Firma_posredniczaca zawieraj¹cy dane firmy
	 */
	public Firma_posredniczaca(Firma_posredniczaca f){ Nazwa_firmy = f.Nazwa_firmy; KRS = f.KRS;}
	//@Override
	/**
	 * Metoda s³u¿y do zapisywania odpowiednio danych firmy do pliku 
	 * @return Zwraca nazwe i nr KRS firmy
	 */
	public String zapis_do_pliku() {
		return "F:" + Nazwa_firmy + ":" + KRS + ":";
	}
}
	