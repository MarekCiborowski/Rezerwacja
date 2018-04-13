/**
 * @author Micha³ Kuc
 */
import java.util.Calendar;
import java.util.LinkedList;

public class Lot {
	private LinkedList<Trasa> Trasa_lotu; 
	private Calendar Czas_wylotu;
	private LinkedList<Miejsce> Miejsca_lotu; 
	private Samolot Samolot_lotu; 
	private int  Zarezerwowane_miejsca = 0;
	/**
	 * Kontruktor o trzech parametrach
	 * @param T Typ Trasa
	 * @param C Czas wylotu typu Calendar
	 */
	public Lot(Trasa T, Calendar C){
		Trasa_lotu = new LinkedList<Trasa>();
		Trasa_lotu.addLast(T);
		Czas_wylotu = C;
		Miejsca_lotu = new LinkedList<Miejsce>();
		
	}
	/**
	 * Kontruktor kopiujacy
	 * @param l Obiekt typu Lot zawieraj¹cy dane o locie
	 */
	public Lot(Lot l){
		Trasa_lotu = new LinkedList<Trasa>();
		for(Trasa t: l.getTrasy()){ 
			Trasa_lotu.addLast(t);
		}
		
		Czas_wylotu = l.getCzas_wylotu();
		
		if(l.getSamolot_lotu() instanceof Samolot_maly){
			Samolot_lotu=new Samolot_maly(l.getSamolot_lotu());
		}
		if(l.getSamolot_lotu() instanceof Samolot_sredni){
			Samolot_lotu=new Samolot_sredni(l.getSamolot_lotu());
		}
		if(l.getSamolot_lotu() instanceof Samolot_duzy){
			Samolot_lotu=new Samolot_duzy(l.getSamolot_lotu());
		}
		if(l.getSamolot_lotu() instanceof Samolot_bardzo_duzy){
			Samolot_lotu=new Samolot_bardzo_duzy(l.getSamolot_lotu());
		}
	}
	/**
	 * Zwraca czas wylotu
	 * @return Zwraca pole Czas_wylotu
	 */
	public Calendar getCzas_wylotu() {return Czas_wylotu;}
	/**
	 * Zwraca czas ca³kowity lotu (czyli suma wszystkich czasów podró¿y tras)
	 * @return Zwraca czas ca³kowity lotu
	 */
	public int getCalkowity_czas_lotu() {
		int Calkowity_czas = 0;
		for(Trasa t: Trasa_lotu){
			Calkowity_czas += t.getCzas_lotu();
		}
		return Calkowity_czas;
	}
	/**
	 * Zwraca trasy lotu
	 * @return Zwraca listê tras
	 */
	public LinkedList<Trasa> getTrasy() { return Trasa_lotu; }
	/**
	 * Metoda do przypisywania samolotu do lotu
	 * @param S Obiekt typu Samolot
	 */
	public void setSamolot_lotu(Samolot S) {
		Samolot_lotu = S;
		if(S == null) return;
	}
	/**
	 * Zwraca rezerwacjê miejsc lotu
	 * @return Zwraca listê miejsc lotu
	 */
	public LinkedList<Miejsce> getMiejsca() { return Miejsca_lotu; }
	/**
	 * Zwraca informacje o locie
	 * @return Zwraca dane o locie w danym formacie
	 */
	public String toString() {
		String S = "";
		for(Trasa t: Trasa_lotu)
			S += t.getLotnisko1() + " - " + t.getLotnisko2() + "\n";
		return S + "\nCzas wylotu: " + Czas_wylotu.get(Calendar.YEAR)+"."+
					Czas_wylotu.get(Calendar.MONTH)+"."+Czas_wylotu.get(Calendar.DAY_OF_MONTH)+
					" " + Czas_wylotu.get(Calendar.HOUR_OF_DAY)+":"+Czas_wylotu.get(Calendar.MINUTE)+"\n"+
				"\nCalkowity czas lotu: " + getCalkowity_czas_lotu() + "\n" +  
				"\nSamolot: " + Samolot_lotu.getNazwa_samolotu() + "\n";
	}
	/**
	 * Zwraca dane o locie bez samolotu
	 * @return Zwraca dane o locie w danym formacie
	 */
	public String toString2() {
		String S = "";
		for(Trasa t: Trasa_lotu)
			S += t.getLotnisko1() + " - " + t.getLotnisko2() + "\n";
		return S + "\nCzas wylotu: " + Czas_wylotu.get(Calendar.YEAR)+"."+
					Czas_wylotu.get(Calendar.MONTH)+"."+Czas_wylotu.get(Calendar.DAY_OF_MONTH)+
					" " + Czas_wylotu.get(Calendar.HOUR_OF_DAY)+":"+Czas_wylotu.get(Calendar.MINUTE)+"\n"+
				"\nCalkowity czas lotu: " + getCalkowity_czas_lotu() + "\n";
	}
	/**
	 * Dodaje trase do lotu
	 * @param T Typ Trasa
	 */
	public void Dodaj_trase(Trasa T) {
		for(Trasa Tr:Trasa_lotu)
		{
			if(Tr.getLotnisko1().getNazwa_Lotniska().equals(T.getLotnisko1().getNazwa_Lotniska()))
				if(Tr.getLotnisko2().getNazwa_Lotniska().equals(T.getLotnisko2().getNazwa_Lotniska())){
					System.out.println("Lot zawiera juz ta trase.");
					return;
				}
		}
		if(!Trasa_lotu.getLast().getLotnisko2().getNazwa_Lotniska().equals(T.getLotnisko1().getNazwa_Lotniska())){
			System.out.println("Trasa ktora chcesz dodac nie jest kompatybilna z obecna trasa.");
			return;
		}
		Trasa_lotu.addLast(T);
	}
	/**
	 * Dodaje trasê do lotu bez sprawdzenia jej
	 * @param T Typ Trasa
	 */
	public void Dodaj_trase_bez_sprawdzania(Trasa T){
		Trasa_lotu.addLast(T);
	}
	/**
	 * Rezerwuje miejsce w locie danemu klientowi 
	 * @param k Klient
	 */
	public void Zarezerwuj_miejsce(Klient k){
		Miejsca_lotu.add(new Miejsce(true,k));
		Zarezerwowane_miejsca++;
	}
	/**
	 * Usuwanie rezerwacji danego klienta
	 * @param k Klient
	 */
	public void Usun_rezerwacje(Klient k){
		int i = 0;
		for(Miejsce m: Miejsca_lotu){
			if(m.getKlient().getNumer().equals(k.getNumer()))
				break;
			i++;
		}
		Miejsca_lotu.remove(i);
		Zarezerwowane_miejsca--;
	}
	/**
	 * Zwraca samolot przyporz¹dkowany do lotu
	 * @return Zwraca pole Samolot_lotu
	 */
	public Samolot getSamolot_lotu(){return Samolot_lotu;}
	/**
	 * Zwraca odleg³oœæ ca³ego lotu
	 * @return Zwraca ca³¹ odleg³oœæ lotu
	 */
	public int getOdleglosc_lotu(){
		int Calkowita_odleglosc = 0;
		for(Trasa t: Trasa_lotu){
			Calkowita_odleglosc += t.getOdleglosc();
		}
		return Calkowita_odleglosc;		
	}
	/**
	 * Przyporz¹dkowanie czasu wylotu
	 * @param nowa_data Data do przyporz¹dkowania
	 */
	public void setCzas_wylotu(Calendar nowa_data) {
		Czas_wylotu = nowa_data;
	}
	/**
	 * Metoda wywo³ywana przy zapisywaniu do pliku danych o locie
	 * @return Zwraca dane o locie w odpowiednim formacie
	 */
	public String zapis_do_pliku(){
		String save="L:";
		save += Czas_wylotu.get(Calendar.YEAR)+ ":" + Czas_wylotu.get(Calendar.MONTH) + ":" +
		Czas_wylotu.get(Calendar.DAY_OF_MONTH) + ":" + Czas_wylotu.get(Calendar.HOUR_OF_DAY) + ":" +
		Czas_wylotu.get(Calendar.MINUTE) + ":";
		for(Trasa T: Trasa_lotu)
			save+=T.zapis_do_pliku();
		save+=Samolot_lotu.zapis_do_pliku();
		save+="M:";
		if(Zarezerwowane_miejsca==0)
			return save;
		for(Miejsce M:Miejsca_lotu){
			if(M.getRezerwacja())
				save+=M.zapis_do_pliku();
		}
		return save;
	}
	/**
	 * Zwraca iloœæ zarezerwowanych miejsc dla danego lotu
	 * @return Zwraca iloœæ zarezerwowanych miejsc
	 */
	public int getZarezerwowane_miejsca(){return Zarezerwowane_miejsca;}
}