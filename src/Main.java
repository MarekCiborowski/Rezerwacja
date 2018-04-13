
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import Main_options.*;

public class Main {
	public static void main(String[] args) throws Exception {
		System_lotow SL = new System_lotow();
		Scanner wybor = new Scanner(System.in);
		String opcja, opcja2, opcja3;
		int x1=0;
		do{
			Opcje.Pokaz_glowne_opcje();
			opcja = wybor.next();
			int x2=0;
			switch(opcja){
			case "1":
				do{
				Opcje.Zarzadzanie_samolotami();
				opcja2 = wybor.next();
				switch(opcja2){
				case "1":{
					Opcje.wybor_typu_samolotu();
					opcja3 = wybor.next();
					System.out.println("Podaj nazwe samolotu");
					String nazwa = wybor.next();
					switch(opcja3){
					case "1":
						SL.Dodaj_samolot('1', nazwa);
						break;
						
					case "2":
						SL.Dodaj_samolot('2', nazwa);
						break;
						
					case "3":
						SL.Dodaj_samolot('3', nazwa);
						break;
						
					case "4":
						SL.Dodaj_samolot('4', nazwa);
						break;
						
					default:
						System.out.println("Niepoprawny typ samolotu.");
						break;
					}
					break;
				}
				
				case "2":{
					if(SL.getSamoloty().size()==0){
					System.out.println("Brak samolotow");
					break;
					}
					System.out.println("Usuniecie samolotu moze spowodowac usuniecie niektorych lotow");
					System.out.println("Podaj indeks samolotu do usuniecia: ");
					int index = wybor.nextInt();
					if(index<=0||index>SL.getSamoloty().size()){
						System.out.println("Niepoprawny numer.");
						break;
					}
					SL.Usun_samolot(index);
					break;
				}
				
				
				case "3":{
					if(SL.getSamoloty().size()==0){
						System.out.println("Brak samolotow");
						break;
					}
					int i=1;
					for(Samolot S:SL.getSamoloty()){
						System.out.print(i+". "+S.toString());
						i++;
					}
					break;
				}
				
				case "4":
					x2=1;
					break;
				default:
					System.out.println("Niepoprawna opcja");
					break;
				}
				}while(x2!=1);
				break;
				
			
			case "2":
				do{
				Opcje.Zarzadzanie_lotniskami();
				opcja2=wybor.next();
				switch(opcja2){
				case "1":
					System.out.println("Podaj nazwe lotniska: ");
					String nazwa=wybor.next();
					SL.Dodaj_lotnisko(nazwa);
					break;
				case "2":
					if(SL.getLotnisko().size()==0){
						System.out.println("Brak lotnisk");
						break;
					}
					System.out.println("Usuniecie lotniska moze spowodowac usuniecie niektorych tras i lotow");
					System.out.println("Podaj indeks lotniska do usuniecia: ");
					int index=wybor.nextInt();
					if(index<=0||index>SL.getLotnisko().size()){
						System.out.println("Niepoprawny numer.");
						break;
					}
					SL.usunLotnisko(index);
					break;
				case "3":
					if(SL.getLotnisko().size()==0){
						System.out.println("Brak lotnisk");
						break;
					}
					int i=1;
					for(Lotnisko L:SL.getLotnisko()){
						System.out.print(i+". "+ L.toString());
						i++;
					}
					break;
				case "4":
					x2=1;
					break;
				default:
					System.out.println("Niepoprawna opcja.");
					break;	
				}
			}while(x2!=1);
				break;
			
			
			case "3":
				if(SL.getLotnisko().size()==0){
					System.out.println("Przed stworzeniem trasy nalezy dodac lotniska");
					break;
				}
					
				do{
					Opcje.Zarzadzaj_trasami();
					opcja2=wybor.next();
					switch(opcja2){
					case "1":
						int i=1;
						for(Lotnisko L:SL.getLotnisko()){
							System.out.println(i+". "+L.toString());
							i++;
						}
						System.out.println("Wybierz numer pierwszego lotniska: ");
						int pierwsze_lotnisko=wybor.nextInt();
						if(pierwsze_lotnisko<=0||pierwsze_lotnisko>SL.getLotnisko().size()){
							System.out.println("Niepoprawny numer.");
							break;
						}
						System.out.println("Wybierz numer drugiego lotniska: ");
						int drugie_lotnisko=wybor.nextInt();
						if(drugie_lotnisko<=0||drugie_lotnisko>SL.getLotnisko().size()){
							System.out.println("Niepoprawny numer.");
							break;
						}
						System.out.println("Podaj odleglosc lotu (w kilometrach): ");
						int odleglosc=wybor.nextInt();
						System.out.println("Podaj czas trwania lotu (w godzinach): ");
						int czas=wybor.nextInt();
						SL.Dodaj_trase(SL.getLotnisko().get(pierwsze_lotnisko-1),
								SL.getLotnisko().get(drugie_lotnisko-1), odleglosc, czas);
						break;
					case "2":
						if(SL.getTrasy().size()==0){
							System.out.println("Brak tras.");
							break;
						}
						System.out.println("Usuniecie trasy moze spowodowac usuniecie niektorych lotow");
						System.out.println("Podaj indeks trasy do usuniecia: ");
						int index=wybor.nextInt();
						if(index<=0||index>SL.getTrasy().size()){
							System.out.println("Niepoprawny numer.");
							break;
						}
						SL.Usun_trase(index);
						break;
					case "3":
						if(SL.getTrasy().size()==0){
							System.out.println("Brak tras");
							break;
						}
						int i1=1;
						for(Trasa T:SL.getTrasy()){
							System.out.print(i1+". "+ T.toString());
							i1++;
						}
						break;
						
					case "4":
						x2=1;
						break;
						
					default:
						System.out.println("Niepoprawna opcja.");
						break;		
					}	
				}while(x2!=1);
				break;
				
			case "4":
				if(SL.getTrasy().size()==0){
					System.out.println("Przed stworzeniem lotu nalezy dodac trasy.");
					break;
				}
				if(SL.getSamoloty().size()==0){
					System.out.println("Przed stworzeniem lotu nalezy dodac samoloty.");
					break;
				}
				do{
				Opcje.Zarzadzaj_lotami();
				opcja2=wybor.next();
				switch(opcja2){
				case "1":
					System.out.println("Podaj rok,miesiac,dzien,godzine i minute rozpoczecia lotu");
					int Rok=wybor.nextInt();
					int Miesiac=wybor.nextInt();
					int Dzien=wybor.nextInt();
					int Godzina=wybor.nextInt();
					int Minuta=wybor.nextInt();
					if(!Opcje.sprawdzenie_daty(Rok, Miesiac, Dzien, Godzina, Minuta)){
						System.out.println("Niepoprawna data.");
						break;
					}
					Calendar C=new GregorianCalendar();
					C.set(Rok, Miesiac, Dzien, Godzina, Minuta);
					int i1=1;
					for(Trasa T:SL.getTrasy()){
						System.out.print(i1+". "+ T.toString());
						i1++;
					}
					System.out.println("Wybierz pierwsza trase lotu");
					int index=wybor.nextInt();
					if(index<=0||index>SL.getTrasy().size()){
						System.out.println("Niepoprawny numer.");
						break;
					}
					Lot L=new Lot(SL.getTrasy().get(index-1),C);
					do{
						System.out.println("Dodaj kolejne trasy do lotu,"
								+ " wybierajac ich numer (dowolny inny znak aby zakonczyc)");
						index=wybor.nextInt();
						if(index<=0||index>SL.getTrasy().size()){
							System.out.println("Zakonczono dodawanie tras.");
							break;
						}
						L.Dodaj_trase(SL.getTrasy().get(index-1));
					}while(true);
					L.setSamolot_lotu(SL.Dobierz_samolot_do_lotu(L));
					if(L.getSamolot_lotu()==null){
						break;
					}
					SL.Dodaj_lot(L);
					Opcje.dodatkowe_loty();
					int ilosc=0;
					String x=wybor.next();
					int x3=0;
					switch(x){
					case "1":
						System.out.println("Podaj przez ile dni ma obowiazywac ten lot");
						ilosc = wybor.nextInt();
						SL.Dodaj_lot_codzienny(ilosc, L);
						x3=1;
						break;
					case "2":
						System.out.println("Podaj przez ile dni ma obowiazywac ten lot");
						ilosc = wybor.nextInt();
						SL.Dodaj_lot_cotygodniowy(ilosc, L);
						x3=2;
						break;
					default:
						break;
					}
					Opcje.dodatkowe_opcje_lotu_powrotnego();
					String v=wybor.next();
					switch(v){
					case "1":
						System.out.println("Podaj rok,miesiac,dzien,godzine"
							+ " i minute rozpoczecia lotu powrotnego");
						Rok=wybor.nextInt();
						Miesiac=wybor.nextInt();
						Dzien=wybor.nextInt();
						Godzina=wybor.nextInt();
						Minuta=wybor.nextInt();
						if(!Opcje.sprawdzenie_daty(Rok, Miesiac, Dzien, Godzina, Minuta)){
							System.out.println("Niepoprawna data.");
							break;
						}
						Lot Powrotny=SL.Stworz_lot_powrotny(L, Rok, Miesiac, Dzien, Godzina, Minuta);
						if(Powrotny==null)
							break;
						SL.Dodaj_lot(Powrotny);
						
						if(x3==1)
						{
							SL.Dodaj_lot_codzienny(ilosc, Powrotny);
							break;
						}
						if(x3==2)
						{
							SL.Dodaj_lot_cotygodniowy(ilosc, Powrotny);
							break;
						}
						default:
							break;	
					}
					break;
					
				case "2":
					if(SL.getLoty().size()==0){
						System.out.println("Brak lotow.");
						break;
					}
					System.out.println("Usuniecie lotu spowoduje usuniecie rezerwacji dla tego lotu");
					System.out.println("Podaj indeks lotu do usuniecia: ");
					index=wybor.nextInt();
					if(index<=0||index>SL.getLoty().size()){
						System.out.println("Niepoprawny numer.");
						break;
					}
					SL.Usun_lot(index);
					break;
				case "3":
					if(SL.getLoty().size()==0){
						System.out.println("Brak lotow");
						break;
					}
					int i2=1;
					for(Lot L1:SL.getLoty()){
						System.out.print(i2+". "+ L1.toString());
						i2++;
					}
					break;
					
				case "4":
					x2=1;
					break;
				default:
					System.out.println("Niepoprawna opcja.");
					break;
					
					
					
					}
					
				}while(x2!=1);
				break;
			case "5":
				do{
					Opcje.Zarzadzaj_klientami();
					opcja2=wybor.next();
					switch(opcja2){
					case "1":
						System.out.println("1.Dodaj klienta indywidualnego.");
						System.out.println("2.Dodaj firme posredniczaca.");
						opcja3=wybor.next();
						switch(opcja3){
						case "1":
							System.out.println("Podaj imie, nazwisko i numer PESEL.");
							String imie=wybor.next();
							String nazwisko=wybor.next();
							String PESEL=wybor.next();
							if(PESEL.length()!=11){
								System.out.println("Niepoprawny numer PESEL");
								break;
							}
							SL.Dodaj_klienta_indywidualnego(imie, nazwisko, PESEL);
							break;
						case "2":
							System.out.println("Podaj nazwe firmy i numer KRS.");
							String Nazwa_firmy=wybor.next();
							String KRS=wybor.next();
							if(KRS.length()!=10){
								System.out.println("Niepoprawny numer KRS");
								break;
							}
							SL.Dodaj_firme_posrednia(Nazwa_firmy, KRS);
							break;
						}
						break;
					case "2":
						if(SL.getKlienci().size()==0){
							System.out.println("Brak klientow.");
							break;
						}
						System.out.println("Usuniecie klienta spowoduje usuniecie wszystkich rezerwacji dla tego klienta");
						System.out.println("Podaj indeks klienta do usuniecia: ");
						int index=wybor.nextInt();
						if(index<=0||index>SL.getKlienci().size()){
							System.out.println("Niepoprawny numer.");
							break;
						}
						SL.Usun_klienta(index);
						break;
						
					case "3":
						if(SL.getKlienci().size()==0){
							System.out.println("Brak klientow");
							break;
						}
						int i=1;
						for(Klient K:SL.getKlienci()){
							System.out.print(i+". "+ K.toString());
							i++;
						}
						break;
						
					case "4":
						x2=1;
						break;
						
					default:
						System.out.println("Niepoprawna opcja.");
						break;
					}
					
					
				}while(x2!=1);
				break;
			case "6":
				if(SL.getLoty().size()==0){
					System.out.println("Przed stworzeniem rezerwacji nalezy dodac loty");
					break;
				}
				do{
					Opcje.Zarzadzaj_rezerwacjami();
					opcja2=wybor.next();
					switch(opcja2){
					case "1":
						if(SL.getKlienci().size()==0){
							System.out.println("Brak klientow.");
							break;
						}
						int i=1;
						for(Klient K:SL.getKlienci()){
							System.out.println(i+". "+K.toString());
							i++;
						}
						System.out.println("\nWybierz numer klienta z listy, aby zobaczyc loty"
								+ " ktore zarezerwowal.");
						int index=wybor.nextInt();
						if(index<=0&&index>SL.getKlienci().size()){
							System.out.println("Niepoprawny indeks.");
							break;
						}
						Klient K=SL.getKlienci().get(index-1);
						i=1;
						for(Lot L:SL.getLoty()){
							if(L.getZarezerwowane_miejsca()==0){
								continue;
							}
							for(Miejsce M:L.getMiejsca()){
								if(M.getKlient().getNumer().equals(K.getNumer())){
									System.out.println(i+". "+L.toString());
									i++;
								}		
							}
						}
						if(i==1)
							System.out.println("Brak rezerwacji");
						break;
					case "2":
						if(SL.getKlienci().size()==0){
							System.out.println("Brak klientow.");
							break;
						}
						i=1;
						for(Lot L:SL.getLoty()){
							if(L.getZarezerwowane_miejsca()==0){
								continue;
							}
							for(Miejsce M:L.getMiejsca()){
								if(M.getRezerwacja()){
									System.out.println(i+". " + L.toString() + M.getKlient().toString());
									i++;
								}
							}
						}
						if(i==1)
							System.out.println("Brak rezerwacji.");
						break;
					case "3":
						if(SL.getKlienci().size()==0){
							System.out.println("Brak klientow.");
							break;
						}
						i=1;
						for(Klient K1:SL.getKlienci()){
							System.out.println(i+". "+K1.toString());
							i++;
						}
						System.out.println("\nWybierz numer klienta z listy, aby zobaczyc loty"
								+ " ktore zarezerwowal.");
						index=wybor.nextInt();
						if(index<=0||index>SL.getKlienci().size()){
							System.out.println("Niepoprawny indeks.");
							break;
						}
						Klient K1=SL.getKlienci().get(index-1);
						i=1;
						for(Lot L:SL.getLoty()){
							if(L.getZarezerwowane_miejsca()==0){
								continue;
							}
							for(Miejsce M:L.getMiejsca()){
								if(M.getKlient().getNumer().equals(K1.getNumer())){
									System.out.println(i+". "+L.toString());
									i++;
								}		
							}
						}
						if(i==1){
							System.out.println("Brak rezerwacji.");
							break;
						}
						System.out.println("Podaj numer rezerwacji ktora chcesz usunac.");
						int numeer=wybor.nextInt();
						i=1;
						for(Lot L:SL.getLoty()){
							for(Miejsce M:L.getMiejsca()){
								if(M.getKlient().getNumer().equals(K1.getNumer())){
									if(i==numeer){
										L.Usun_rezerwacje(K1);
										break;
									}
									i++;
								}		
							}
						}
						break;
						
					case "4":
						if(SL.getKlienci().size()==0){
							System.out.println("Brak klientow.");
							break;
						}
						i=1;
						for(Klient K11:SL.getKlienci()){
							System.out.print(i+". "+ K11.toString());
							i++;
						}
						System.out.println("Podaj numer klienta dla ktorego chcesz dokonac rezerwacji.");
						Klient Kl=SL.getKlienci().get(wybor.nextInt()-1);
						
						i=1;
						for(Lotnisko L:SL.getLotnisko()){
							System.out.print(i+". "+ L.toString());
							i++;
						}
						System.out.println("Podaj numer lotniska z ktorego chcesz rozpoczac lot: ");
						String pierwsze_lotnisko=SL.getLotnisko().get(wybor.nextInt()-1).getNazwa_Lotniska();
						System.out.println("Podaj numer lotniska docelowego: ");
						String drugie_lotnisko=SL.getLotnisko().get(wybor.nextInt()-1).getNazwa_Lotniska();
						i=0;
						int minimalny_czas=99999;
						int index_lotu=-1;
						int czas_danego_lotu=0;
						for(Lot L:SL.getLoty()){
							int p_l=0;
							czas_danego_lotu=0;
							if(L.getSamolot_lotu().getMiejsca_samolotu()==L.getZarezerwowane_miejsca()){
								i++;
								continue;
							}
							if(!L.getMiejsca().isEmpty()){
								for(Miejsce M:L.getMiejsca()){ //przegl¹d wszystkich miejsc w celu odnalezienia rezerwacji klienta
									if(M.getKlient().getNumer().equals(Kl.getNumer())){
										p_l=2;
										break;
									}
								}
							}
							
							if(p_l==2){
								
								i++;
								continue;
							}
							
							for(Trasa T:L.getTrasy()){
								
								if(pierwsze_lotnisko.equals(T.getLotnisko1().getNazwa_Lotniska())){
									p_l=1;
								}
								if(p_l==1){
									czas_danego_lotu+=T.getCzas_lotu();
								}
								if(drugie_lotnisko.equals(T.getLotnisko2().getNazwa_Lotniska())&&p_l==1){
									if(czas_danego_lotu<minimalny_czas){
										index_lotu=i;
										minimalny_czas=czas_danego_lotu;
									}
								}
							}
							i++;
						}
						if(index_lotu==-1){
							System.out.println("Brak lotu spelniajacego kryteria");
							break;
						}
						System.out.println("Znaleziono lot: " + SL.getLoty().get(index_lotu).toString());
						System.out.println("Czas szukanej czesci lotu: "+ minimalny_czas);
						System.out.println("Aby zarezerwowac miejsce wcisnij 1, aby anulowac wcisnij"
								+ " inny dowolny przycisk");
						opcja3=wybor.next();
						switch(opcja3){
						case "1":
							SL.getLoty().get(index_lotu).Zarezerwuj_miejsce(Kl);
							break;
						default:
							break;
						}
						break;
						
						
					case "5":
						x2=1;
						break;
					default:
						System.out.println("Niepoprawna opcja");
						break;
					}	
				}while(x2!=1);
				break;
			case "7":
				Opcje.Zapisywanie();
				String nazwa=wybor.next();
				nazwa+=".txt";
				SL.Zapis_do_pliku(nazwa);
				System.out.println("Zapisano dane.");
				break;
			case "8":
				Opcje.Odczytywanie();
				String nazwa1=wybor.next();
				nazwa1+=".txt";
				SL.Odczyt_z_pliku(nazwa1);
				System.out.println("Odczytano dane.");
				break;
			case "9":
				System.out.println("Dziekujemy za skorzystanie z programu.");
				x1=1;
				break;
			default:
				System.out.println("Niepoprawna opcja.");
				break;
			}
			
		}while(x1!=1);
		wybor.close();
	}

}
