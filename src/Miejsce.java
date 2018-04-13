/**
 * 
 * @author Micha³ Kuc
 *
 */
public class Miejsce {
	private boolean Rezerwacja = false; 
	private Klient Klient_rezerwacja;
	/**
	 * Zwraca informacje o rezerwacji danego miejsca
	 * @return Zwraca pole Rezerwacja
	 */
	public boolean getRezerwacja() { return Rezerwacja; } 
	/**
	 * Zwraca Klienta, który zajmuje dane miejsce
	 * @return Zwraca pole Klient_rezerwacja
	 */
	public Klient getKlient() { return Klient_rezerwacja; }
	/**
	 * Kontruktor dwuparametrowy
	 * @param R rezerwacja
	 * @param K klient
	 */
	public Miejsce(boolean R, Klient K) {
		Rezerwacja = R; Klient_rezerwacja = K;
	}
	/**
	 * Metoda wywo³ywana przy zapisywaniu danych do pliku o miejscu
	 * @return Zwraca pole Klient_rezerwacja
	 */
	public String zapis_do_pliku(){
		return Klient_rezerwacja.zapis_do_pliku();
	}
}
