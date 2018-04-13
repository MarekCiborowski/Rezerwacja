/**
 * @author Marek Ciborowski
 * @author Micha³ Kuc
 */
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
	public class System_lotow {
		private LinkedList<Klient> Klienci = new LinkedList<Klient>(); 
		private LinkedList<Samolot> Samoloty = new LinkedList<Samolot>(); 
		private LinkedList<Trasa> Trasy = new LinkedList<Trasa>(); 
		private LinkedList<Lotnisko> Lotniska = new LinkedList<Lotnisko>(); 
		private LinkedList<Lot> Loty = new LinkedList<Lot>(); 
		private Calendar Dzisiejsza_data = new GregorianCalendar(); 
		/**
		 * Konstruktor bezparametrowy
		 * Automatycznie dobiera datê do systemu
		 */
		public System_lotow (){
			Dzisiejsza_data = Calendar.getInstance();
		}
		/**
		 * Dodawanie klienta indywidualnego do systemu
		 * @param Imie Imie klienta
		 * @param Nazwisko Nazwisko klienta
		 * @param PESEL nr PESEL klienta
		 */
		public void Dodaj_klienta_indywidualnego(String Imie, String Nazwisko, String PESEL) {
			Klient K = new Klient_indywidualny(Imie, Nazwisko, PESEL);
			Klienci.add(K);
		}
		/**
		 * Dodawanie firmy poœrednicz¹cej do systemu
		 * @param Nazwa nazwa firmy
		 * @param KRS nr KRS firmy
		 */
		public void Dodaj_firme_posrednia(String Nazwa, String KRS) {
			Klient K = new Firma_posredniczaca(Nazwa, KRS);
			Klienci.add(K);
		}
		/**
		 * Zwraca listê klientów
		 * @return Zwraca listê klientów
		 */
		public LinkedList<Klient> getKlienci() {
			return Klienci;
		}
		/**
		 * Usuwanie klienta o danym indexie z systemu
		 * @param index nr indexu klienta
		 */
		public void Usun_klienta(int index) {
			index -= 1;
			Klient k = Klienci.get(index);
			Klienci.remove(index);
			for(Lot l: Loty){
				for(Miejsce m: l.getMiejsca()){ 
					if(m.getKlient().getNumer() == k.getNumer()){
						l.getMiejsca().remove(m); break;
					}
				}
			}
		}
		/**
		 * Dodawanie samolotu do listy. 
		 * Ka¿dy samolot dodany jest sortowany.
		 * @param i wybór samolotu od 1 do 4
		 * @param Nazwa nazwa samolotu
		 */
		public void Dodaj_samolot(char i, String Nazwa) {//taka sama nazwa, wyjatek
			switch(i){
			case '1':
				Samoloty.add(new Samolot_maly(Nazwa));
				break;
			case '2':
				Samoloty.add(new Samolot_sredni(Nazwa));
				break;
			case '3': 
				Samoloty.add(new Samolot_duzy(Nazwa));
				break;
			case '4':
				Samoloty.add(new Samolot_bardzo_duzy(Nazwa));
				break;
			default:
				System.out.println("\nNiepoprawny typ samolotu.");
				return;
			}
			Collections.sort(Samoloty,new Porownanie_samolotow());
		}
		/**
		 * Usuwanie samolotu z systemu. 
		 * Najpierw sprawdza, jaki jest to rodzaj samolotu.
		 * A potem go usuwa i sprawdza, czy nie naruszy³ struktury lotów.
		 * @param index index usuwanego samolotu z listy
		 */
		public void Usun_samolot(int index) {
			index -= 1;
			Samolot S = null;
			if(Samoloty.get(index) instanceof Samolot_maly){
				S = new Samolot_maly(Samoloty.get(index));
			}
			if(Samoloty.get(index) instanceof Samolot_sredni){
				S = new Samolot_sredni(Samoloty.get(index));
			}
			if(Samoloty.get(index) instanceof Samolot_duzy){
				S = new Samolot_duzy(Samoloty.get(index));
			}
			if(Samoloty.get(index) instanceof Samolot_bardzo_duzy){
				S = new Samolot_bardzo_duzy(Samoloty.get(index));
			}
			Samoloty.remove(index);
			int i = 1;
			if(Loty.size() == 0){
				return;
			}
			LinkedList<Integer> indeksy=new LinkedList<Integer>();
			for(Lot L:Loty){
				if(L.getSamolot_lotu().getNazwa_samolotu().equals(S.getNazwa_samolotu())){
					indeksy.add(i);
					}
				i++;
			}
			Collections.sort(indeksy,new Porownanie_indeksow());
			for(Integer I:indeksy){
				Usun_lot(I);
			}
		}
		/**
		 * Zwraca listê samolotów systemu
		 * @return Zwraca listê samolotów
		 */
		public LinkedList<Samolot> getSamoloty() {
			return Samoloty;
		}
		/**
		 * Dobieranie samolotu do lotu
		 * @param l Lot
		 * @return Zwraca pierwszy dostêpny samolot z listy samolotów, który jest w stanie pokonaæ odleg³oœci wszystkich tras lotu
		 */
		public Samolot Dobierz_samolot_do_lotu(Lot l) {
			int i = 0;
			Samolot Sam = null;
			for(Trasa T: l.getTrasy()){
				if(i < T.getOdleglosc())
					i = T.getOdleglosc();
			}
			for(Samolot S: Samoloty){
				if(S.getZasieg_samolotu() >= i && S.getDostepnosc()){
					Sam = S;
					S.setDostepnosc(false);
					Sam.setDostepnosc(false);
					break;	
				}
			}
			return Sam;
		}
		/**
		 * Dodawanie trasy do systemu
		 * @param Lotnisko1 pierwsze lotnisko
		 * @param Lotnisko2 drugie lotnisko
		 * @param odleglosc odleg³oœæ trasy
		 * @param czas_lotu czas lotu tej trasy
		 */
		public void Dodaj_trase(Lotnisko Lotnisko1, Lotnisko Lotnisko2, int odleglosc, int czas_lotu) {
			if(Lotnisko1.getNazwa_Lotniska() == Lotnisko2.getNazwa_Lotniska()){
				System.out.println("Nie mozna utworzyc trasy o dwoch takich samych lotniskach");
				return;
			}
			Trasa T = new Trasa(Lotnisko1, Lotnisko2, odleglosc, czas_lotu);
			for(Trasa Tr: Trasy)
			{
				if(Porownaj_trase(Tr,T))
				{
					System.out.println("\nTaka trasa istnieje");
					return;
				}
			}
			Trasy.add(T);
		}
		/**
		 * Usuwanie trasy z systemu.
		 * najpierw wyszukuje dan¹ trasê. Sprawdza, czy nie jest danym elementem lotów. 
		 * Je¿eli tak, usuwa dane loty, których jest czêœci¹.
		 * Dopiero wtedy jest usuwana.
		 * @param index nr indexu trasy do usuniêcia
		 */
		public void Usun_trase(int index) {
			index -= 1;
			Trasa Ta = new Trasa(Trasy.get(index));
			boolean trasa_jest = false; 
			int index_lotu = 0;
			LinkedList<Integer> indeksy=new LinkedList<Integer>();
			if(Loty.isEmpty()){
				Trasy.remove(index);
				return;
			}
			for(Lot L: Loty){ 
				for(Trasa T: L.getTrasy()) { 
					if(Porownaj_trase(Ta, T)) {
						trasa_jest = true; break;
					} 
				}
				if(trasa_jest) {
					indeksy.add(index_lotu+1);
					trasa_jest = false;
				}
				index_lotu++;
			}
			Collections.sort(indeksy,new Porownanie_indeksow());
			for(Integer I:indeksy){
				Usun_lot(I);
			}
			Trasy.remove(index);
		}	
		/**
		 * Metoda do porównania dwóch tras
		 * @param T1 trasa pierwsza
		 * @param T2 trasa druga
		 * @return Zwraca prawdê, gdy trasy s¹ identyczne, a fa³sz w przeciwnym wypadku.
		 */
		public boolean Porownaj_trase(Trasa T1, Trasa T2){
			if(T1.getLotnisko1().getNazwa_Lotniska().equals(T2.getLotnisko1().getNazwa_Lotniska()))
				if(T1.getLotnisko2().getNazwa_Lotniska().equals(T2.getLotnisko2().getNazwa_Lotniska()))
					return true;
		return false;
		}
		/**
		 * Zwraca listê tras systemu
		 * @return Zwraca listê tras
		 */
		public LinkedList<Trasa> getTrasy() { return Trasy; }
		/**
		 * Dodawanie lotniska do systemu
		 * @param Nazwa nazwa lotniska
		 */
		public void Dodaj_lotnisko(String Nazwa){
			for(Lotnisko l: Lotniska){ //przegl¹danie lotnisk systemu
				if(l.getNazwa_Lotniska().equals(Nazwa)){
					System.out.println("\nTakie lotnisko istnieje");
					return;
				}
			}
			Lotniska.addLast(new Lotnisko(Nazwa));
		}
		/**
		 * Zwraca listê lotnisk systemu
		 * @return zwraca listê lotnisk
		 */
		public LinkedList<Lotnisko> getLotnisko() { return Lotniska; }
		/**
		 * Usuwa lotnisko z systemu.
		 * Je¿eli lotnisko jest czêœci¹ trasy, to te trasy usuwa z systemu.
		 * @param index nr indexu lotniska do usuniêcia
		 */
		public void usunLotnisko(int index){
			index -= 1;
			int i = 0;
			if(Trasy.isEmpty()){
				Lotniska.remove(index);
				return;
			}
			LinkedList <Integer> indeksy=new LinkedList<Integer>();
			Lotnisko L = Lotniska.get(index);
			for(Trasa T: Trasy){
				if(T.getLotnisko1().getNazwa_Lotniska().equals(L.getNazwa_Lotniska())){
					indeksy.add(i+1);
				}
				if(T.getLotnisko2().getNazwa_Lotniska().equals(L.getNazwa_Lotniska())){
					indeksy.add(i+1);
				}
				i++;
			}
			Collections.sort(indeksy, new Porownanie_indeksow());
			for(Integer I:indeksy){
				Usun_trase(I);
			}
			Lotniska.remove(index);
		}
		/**
		 * Dodawanie lotu do systemu
		 * @param rok Rok wylotu
		 * @param miesiac Miesi¹c wylotu
		 * @param dzien Dzieñ wylotu
		 * @param godzina Godzina wylotu
		 * @param minuta Minuta wylotu
		 * @param T Trasa lotu
		 */
		public void Dodaj_lot(int rok, int miesiac, int dzien, int godzina, int minuta, Trasa T)
		{
			Calendar C = new GregorianCalendar();
			C = Calendar.getInstance();
			C.set(rok, miesiac, dzien, godzina, minuta);
			if(Dzisiejsza_data.compareTo(C) >= 0){
				System.out.println("Nie ogranizujemy lotow w przeszlosc. ");
				return;
			}
			Lot L = new Lot(T,C);
			Loty.addLast(L);			
			
		}
		/**
		 * Dodawanie lotu do systemu przez parametr typu Lot;
		 * @param L Obiekt typu Lot zawieraj¹cy dane o locie.
		 */
		public void Dodaj_lot(Lot L){
			if(Dzisiejsza_data.compareTo(L.getCzas_wylotu()) >= 0){
				System.out.println("Nie ogranizujemy lotow w przeszlosc. ");
				return;
			}
			if(L.getSamolot_lotu() == null){
				System.out.println("Brak samolotu spelniajacego wymogi lotu");
				return;
			}
			Loty.addLast(L);
		}
		/**
		 * Dodaje lot z pliku.
		 * @param L Obiekt typu Lot zawieraj¹cy dane lotu
		 */
		public void Dodaj_lot_z_pliku(Lot L){
			if(Dzisiejsza_data.compareTo(L.getCzas_wylotu()) >= 0){
				return;
			}
			for(Lot Lo:Loty){
				int i=0;
				if(L.getCzas_wylotu().compareTo(Lo.getCzas_wylotu())==0){
					i++;
				}
				if(Porownanie_tras_lotow(Lo,L)){
					i++;
				}
				if(i==2){
					return;
				}
			}
			Loty.addLast(L);
		}
		/**
		 * Metoda do porównywania tras danych lotów.
		 * @param L1 Lot pierwszy
		 * @param L2 Lot drugi
		 * @return Zwraca fa³sz, gdy s¹ ró¿ne trasy, a prawdê, gdy takie same.
		 */
		public boolean Porownanie_tras_lotow(Lot L1, Lot L2){
			if(L1.getTrasy().size()!=L2.getTrasy().size())
				return false;
			for(int j=0;j<L1.getTrasy().size();j++){
				if(!Porownaj_trase(L1.getTrasy().get(j),L2.getTrasy().get(j)))
					return false;
			}
			return true;
		}
		/**
		 * Usuñ lot z systemu.
		 * Przypisany samolot do lotu bêdzie zwolniony (Dostêpnoœc zmieni wartoœæ na true)
		 * @param index nr indexu lotu z listy
		 */
		public void Usun_lot(int index){
			
			index -= 1;
			if(Loty.get(index).getSamolot_lotu() == null){
				Loty.remove(index);
				return;
			}
			for(Samolot S:Samoloty){
				if(Loty.get(index).getSamolot_lotu().getNazwa_samolotu().equals(S.getNazwa_samolotu())){
					S.setDostepnosc(true);
					break;
				}
			}
			Loty.remove(index);
		}
		/**
		 * Zwraca listê lotów systemu
		 * @return Zwraca listê lotów
		 */
		public LinkedList<Lot> getLoty() { return Loty; }
		/**
		 * Metoda sprawdzaj¹ca, wykorzystywana przy dodawaniu trasy do systemu
		 * @param T Typ Trasa
		 */
		public void sprawdzenieTrasy(Trasa T){
			for(Trasa Tr: Trasy){
				if(Porownaj_trase(T,Tr))
					return;
			}
			Trasy.add(T);
		}
		/**
		 * Tworzenie lotu powrotnego.
		 * Z parametru L typu Lot pobiera trasy i samolot i nastêpnie je odwraca, aby otrzymaæ lot w drug¹ stronê.
		 * @param L Typ Lot
		 * @param rok Rok
		 * @param miesiac Miesi¹c
		 * @param dzien Dzieñ
		 * @param godzina Godzina
		 * @param minuta Minuta
		 * @return Zwraca lot powrotny
		 */
		public Lot Stworz_lot_powrotny(Lot L, int rok, int miesiac, int dzien, int godzina, int minuta){
			Calendar C = new GregorianCalendar();
			C = Calendar.getInstance();
			C.set(rok, miesiac, dzien, godzina, minuta); 
			if(Dzisiejsza_data.compareTo(C) >= 0){
				System.out.println("Nie ogranizujemy lotow w przeszlosc. ");
				return null;
			}
			Trasa T = new Trasa(L.getTrasy().getLast().getLotnisko2(),
					L.getTrasy().getLast().getLotnisko1(),L.getTrasy().getLast().getOdleglosc(),
					L.getTrasy().getLast().getCzas_lotu());  
			sprawdzenieTrasy(T);
			Lot Powrotny = new Lot(T,C);
			Powrotny.setSamolot_lotu(L.getSamolot_lotu());
			if(L.getTrasy().size() == 1)
				return Powrotny;
			for(int i = L.getTrasy().size()-2; i >= 0; --i){
				T=new Trasa(L.getTrasy().get(i).getLotnisko2(),
						L.getTrasy().get(i).getLotnisko1(),L.getTrasy().get(i).getOdleglosc(),
						L.getTrasy().get(i).getCzas_lotu());
				sprawdzenieTrasy(T);
				Powrotny.Dodaj_trase(T);
			}
			return Powrotny;
		}
		/**
		 * Tworzenie lotów codziennych do systemu 
		 * Wykorzystuje Lot podany jako parametr i na jego podstawie tworzy loty na dni kolejne.
		 * Stworzy siê tyle nowych lotów, ile zawiera zmienna ilosc_dni - parametr
		 * @param ilosc_dni Iloœæ dni powtarzania tego lotu
		 * @param Pierwszy_lot_codzienny Typ Lot
		 */
		public void Dodaj_lot_codzienny(int ilosc_dni,Lot Pierwszy_lot_codzienny){
			Calendar nowa_data = Pierwszy_lot_codzienny.getCzas_wylotu();
			for(int i = 1; i <= ilosc_dni; i++){
				nowa_data = (Calendar)(nowa_data.clone());
				Lot Codzienny = new Lot(Pierwszy_lot_codzienny);
				nowa_data.add(Calendar.DATE, 1);
				Codzienny.setCzas_wylotu(nowa_data);
				Loty.add(new Lot(Codzienny));
			}
		}
		/**
		 * Dodawanie lotów cotygodniowych do systemu 
		 * Wykorzystuje Lot podany jako parametr i na jego podstawie tworzy loty co tydzieñ.
		 * Stworzy siê tyle nowych lotów, ile zawiera zmienna ilosc_dni - parametr
		 * @param ilosc_dni
		 * @param Pierwszy_lot_cotygodniowy
		 */
		public void Dodaj_lot_cotygodniowy(int ilosc_dni,Lot Pierwszy_lot_cotygodniowy){
			Calendar nowa_data=Pierwszy_lot_cotygodniowy.getCzas_wylotu();
			for(int i=7;i<=ilosc_dni;i+=7){
				nowa_data = (Calendar)(nowa_data.clone());
				Lot Cotygodniowy=new Lot(Pierwszy_lot_cotygodniowy);
				nowa_data.add(Calendar.DATE, 7);	
				Cotygodniowy.setCzas_wylotu(nowa_data);
				Loty.add(new Lot(Cotygodniowy));
			}
		}
		/**
		 * Dodawanie klienta z pliku.
		 * @param K Klient
		 */
		public void Dodaj_klienta_z_pliku(Klient K){
			for(Klient Kl:Klienci){
				if(Kl.getNumer().equals(K.getNumer())){
					return;
				}
			}
			Klienci.add(K);
		}
		/**
		 * Dodawanie lotniska z pliku.
		 * @param L Typ Lotnisko
		 */
		public void Dodaj_lotnisko_z_pliku(Lotnisko L){
			for(Lotnisko Lo:Lotniska){
				if(Lo.getNazwa_Lotniska().equals(L.getNazwa_Lotniska())){
					return;
				}
			}
			Lotniska.add(L);
		}
		/**
		 * Dodawanie samolotu z pliku.
		 * @param S Typ Samolot
		 */
		public void Dodaj_samolot_z_pliku(Samolot S){
			for(Samolot Sa:Samoloty){
				if(S.getNazwa_samolotu().equals(Sa.getNazwa_samolotu())){
					if(S.getZasieg_samolotu()==Sa.getZasieg_samolotu()){
						return;
					}
				}
			}
			Samoloty.add(S);
		}
		/**
		 * Dodawanie trasy z pliku.
		 * @param T Typ Trasa
		 */
		public void Dodaj_trase_z_pliku(Trasa T){
			for(Trasa Tr:Trasy){
				if(Porownaj_trase(T,Tr)){
					return;
				}
			}
			Trasy.add(T);
		}
		/**
		 * Zapisywanie danych z systemu do pliku.
		 * @param Nazwa_pliku_do_zapisu Zawiera nazwê pliku, do którego zostan¹ zapisane dane systemu
		 * @throws FileNotFoundException wyj¹tek, gdyby plik nie istnia³
		 */
		public void Zapis_do_pliku(String Nazwa_pliku_do_zapisu) throws FileNotFoundException{
			PrintWriter Zapis = new PrintWriter(Nazwa_pliku_do_zapisu);
			for(Klient K: Klienci)
				Zapis.print(K.zapis_do_pliku());
			Zapis.print("End:");
			for(Lotnisko L: Lotniska)
				Zapis.print(L.zapis_do_pliku());
			Zapis.print("End:");
			for(Samolot S: Samoloty)
				Zapis.print(S.zapis_do_pliku());
			Zapis.print("End:");
			for(Trasa T: Trasy)
				Zapis.print(T.zapis_do_pliku());
			Zapis.print("End:");
			for(Lot Lo: Loty)
				Zapis.print(Lo.zapis_do_pliku());
			Zapis.close();
		}
		/**
		 * Ddczytywanie danych z pliku do systemu
		 * @param Nazwa_pliku_do_odczytu Nazwa pliku, z którego czytane s¹ dane
		 * @throws FileNotFoundException wyj¹tek, gdyby plik nie istnia³
		 */
		public void Odczyt_z_pliku(String Nazwa_pliku_do_odczytu) throws FileNotFoundException {
			
			@SuppressWarnings("resource")
			Scanner Plik = new Scanner(new File(Nazwa_pliku_do_odczytu)).useDelimiter("\\s*:\\s*");
			String odczyt;
			
			
			while(Plik.hasNext())
			{ 
				odczyt =Plik.next();
				if(odczyt.equals("K")){
				
				Dodaj_klienta_z_pliku(new Klient_indywidualny(Plik.next(), Plik.next(), Plik.next()));
				continue;
				}
				if(odczyt.equals("F")){
					
					Dodaj_klienta_z_pliku(new Firma_posredniczaca(Plik.next(), Plik.next()));
					continue;
				}
				if(odczyt.equals("End")){
				
					break;
				}
			}
			
			
			while(Plik.hasNext())
			{
				odczyt =Plik.next();
				if(odczyt.equals("Lotnisko"))
				{
				Dodaj_lotnisko_z_pliku(new Lotnisko(Plik.next()));
				continue;
				}
				if(odczyt.equals("End")) break;
			} 
			
			
			while(Plik.hasNext())
			{ 
				odczyt =Plik.next();
				if(odczyt.equals("SM")){
					Dodaj_samolot_z_pliku(new Samolot_maly(Plik.next(),Plik.next()));
					continue;
				}
				if(odczyt.equals("SS")){
					Dodaj_samolot_z_pliku(new Samolot_sredni(Plik.next(),Plik.next()));
					continue;
				}
				if(odczyt.equals("SD")){
					Dodaj_samolot_z_pliku(new Samolot_duzy(Plik.next(),Plik.next()));
					continue;
				}
				if(odczyt.equals("SBD")){
					Dodaj_samolot_z_pliku(new Samolot_bardzo_duzy(Plik.next(),Plik.next()));
					continue;
				}
				if(odczyt.equals("End")) break;
			}
			
			
			while(Plik.hasNext())
			{ 
				odczyt =Plik.next();
				if(odczyt.equals("T")){
					Dodaj_trase_z_pliku(new Trasa(new Lotnisko(Plik.next()),new Lotnisko(Plik.next()), Plik.nextInt(), Plik.nextInt()));
					continue;
				}
				if(odczyt.equals("End")) break;
			}
			
			
			odczyt=Plik.next();
			while(Plik.hasNext())
			{ 

				if(odczyt.equals("L")){
					Calendar C = new GregorianCalendar();
					C.set(Plik.nextInt(), Plik.nextInt(), Plik.nextInt(), Plik.nextInt(), Plik.nextInt());
					String x = Plik.next();
					Trasa T = new Trasa(new Lotnisko(Plik.next()), new Lotnisko(Plik.next()), Plik.nextInt(), Plik.nextInt());
					Lot L = new Lot(T, C);
					
					while(true){
						odczyt=Plik.next();
						if(odczyt.equals(x))
							L.Dodaj_trase_bez_sprawdzania(new Trasa(new Lotnisko(Plik.next()),
									new Lotnisko(Plik.next()), Plik.nextInt(), Plik.nextInt()));
						else break; 
					}
					if(odczyt.equals("SM"))  L.setSamolot_lotu(new Samolot_maly(Plik.next(), Plik.next()));
					if(odczyt.equals("SS"))  L.setSamolot_lotu(new Samolot_sredni(Plik.next(), Plik.next()));
					if(odczyt.equals("SD"))  L.setSamolot_lotu(new Samolot_duzy(Plik.next(), Plik.next()));		
					if(odczyt.equals("SBD")) L.setSamolot_lotu(new Samolot_bardzo_duzy(Plik.next(), Plik.next()));
					
					odczyt=Plik.next();
					if(!Plik.hasNext()){
						Dodaj_lot_z_pliku(L);
						break;
					}
					odczyt=Plik.next();
					if(odczyt.equals("L")){
						Dodaj_lot_z_pliku(L);
						continue;
					}
					
					
					while(Plik.hasNext())
					{ 
						
						if(odczyt.equals("K")){
							L.Zarezerwuj_miejsce(new Klient_indywidualny(Plik.next(), Plik.next(), Plik.next()));
							if(!Plik.hasNext())
								break;
							odczyt=Plik.next();
							continue;
						}
						if(odczyt.equals("F")) {
							L.Zarezerwuj_miejsce(new Firma_posredniczaca(Plik.next(), Plik.next()));
							if(!Plik.hasNext())
								break;
							odczyt=Plik.next();
							continue;
						}
						else { Dodaj_lot_z_pliku(L); break; }
					}
				}
			}
			Plik.close();
		}	
}

