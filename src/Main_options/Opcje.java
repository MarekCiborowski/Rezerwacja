/**
 * @author Micha³ Kuc
 * @author Marek Ciborowski
 */
package Main_options;

public class Opcje {
		public static void Pokaz_glowne_opcje(){
			 System.out.println(
		                "*******************************\n" +
		                        "Witaj w systemie rezerwacji lotow\n" +
		                        "Jak mozemy Ci pomoc?\n" +
		                        "*******************************\n");

		        System.out.println("1.Zarzadzaj samolotami.");
		        System.out.println("2.Zarzadzaj lotniskami.");
		        System.out.println("3.Zarzadzaj trasami");
		        System.out.println("4.Zarzadzaj lotami.");
		        System.out.println("5.Zarzadzaj klientami");
		        System.out.println("6.Rezerwacje.");
		        System.out.println("7.Zapisz dane.");
		        System.out.println("8.Wczytaj dane.");
		        System.out.println("9.Zakoncz program.");
		        System.out.println("Wybierz opcje:\n");
		   }
		public static void Zarzadzanie_samolotami(){
			System.out.println("*******************************\n"+
								"Zarzadzanie samolotami\n" +
								"*******************************\n");
			System.out.println("1.Dodaj samolot.");
			System.out.println("2.Usun samolot.");
			System.out.println("3.Przegladaj samoloty.");
			System.out.println("4.Powrot do glownego menu.");
			System.out.println("Wybierz opcje:\n");
		}
		public static void Zarzadzanie_lotniskami(){
			System.out.println("*******************************\n"+
								"Zarzadzanie lotniskami\n" +
								"*******************************\n");
			System.out.println("1.Dodaj lotnisko.");
			System.out.println("2.Usun lotnisko.");
			System.out.println("3.Przegladaj lotniska.");
			System.out.println("4.Powrot do glownego menu.");
			System.out.println("Wybierz opcje:\n");
		}
		public static void Zarzadzaj_trasami(){
			System.out.println("*******************************\n"+
								"Zarzadzanie trasami\n" +
								"*******************************\n");
			System.out.println("1.Dodaj trase.");
			System.out.println("2.Usun trase.");
			System.out.println("3.Przegladaj trasy.");
			System.out.println("4.Powrot do glownego menu.");
			System.out.println("Wybierz opcje:\n");
		}
		public static void Zarzadzaj_lotami(){
			System.out.println("*******************************\n"+
								"Zarzadzanie lotami\n" +
								"*******************************\n");
			System.out.println("1.Dodaj lot.");
			System.out.println("2.Usun lot.");
			System.out.println("3.Przegladaj loty.");
			System.out.println("4.Powrot do glownego menu.");
			System.out.println("Wybierz opcje:\n");
		}
		public static void Zarzadzaj_klientami(){
			System.out.println("*******************************\n"+
								"Zarzadzanie klientami\n" +
								"*******************************\n");
			System.out.println("1.Dodaj klienta.");
			System.out.println("2.Usun klienta.");
			System.out.println("3.Przegladaj klientow.");
			System.out.println("4.Powrot do glownego menu.");
			System.out.println("Wybierz opcje:\n");
		}
		public static void Zarzadzaj_rezerwacjami(){
			System.out.println("*******************************\n"+
								"Zarzadzanie rezerwacjami\n" +
								"*******************************\n");
			System.out.println("1.Wyswietlanie rezerwacji konkretnego klienta.");
			System.out.println("2.Wyswietlanie rezerwacji wszystkich klientow.");
			System.out.println("3.Anulowanie rezerwacji.");
			System.out.println("4.Dodawanie rezerwacji.");
			System.out.println("5.Powrot do glownego menu.");
			System.out.println("Wybierz opcje:\n");
		}
		public static void Zapisywanie(){
			System.out.println("*******************************\n"+
					"Zapisywanie stanu systemu\n" +
					"*******************************\n");
			System.out.println("Podaj nazwe pliku w ktorym chcesz dokonac zapisu.");
		}
		public static void Odczytywanie(){
			System.out.println("*******************************\n"+
					"Odczytywanie stanu systemu\n" +
					"*******************************\n");
			System.out.println("Podaj nazwe pliku z ktorego chcesz odczytac dane.\n");
		}
		public static void wybor_typu_samolotu(){
			System.out.println("Wybierz typ samolotu: \n\n");
			System.out.println("1. Maly samolot(100 miejsc, zasieg: 200km)");
			System.out.println("2. Sredni samolot(200 miejsc, zasieg: 500km)");
			System.out.println("3. Duzy samolot(300 miejsc, zasieg: 1000km)");
			System.out.println("4. Bardzo duzy samolot(400 miejsc, zasieg: 3000km)");
			System.out.println("Wybierz opcje.\n");
		}
		public static boolean sprawdzenie_daty(int Rok,int Miesiac, int Dzien, int Godzina, int Minuta){
			if(Miesiac<=0||Miesiac>12){
				return false;
			}
			if(Dzien<=0){
				return false;
			}
			if(Miesiac==1&&Dzien>31){
				return false;
			}
			if(Miesiac==2){
				if(Rok%4==0&&Dzien>29){
					return false;
				}
				if(Rok%4!=0&&Dzien>28){
					return false;
				}
			}
			if(Miesiac==3&&Dzien>31){
				return false;
			}
			if(Miesiac==4&&Dzien>30){
				return false;
			}
			if(Miesiac==5&&Dzien>31){
				return false;
			}
			if(Miesiac==6&&Dzien>30){
				return false;
			}
			if(Miesiac==7&&Dzien>31){
				return false;
			}
			if(Miesiac==8&&Dzien>31){
				return false;
			}
			if(Miesiac==9&&Dzien>30){
				return false;
			}
			if(Miesiac==10&&Dzien>31){
				return false;
			}
			if(Miesiac==11&&Dzien>30){
				return false;
			}
			if(Miesiac==12&&Dzien>31){
				return false;
			}
			if(Godzina<0||Godzina>23){
				return false;
			}
			if(Minuta<0||Minuta>59){
				return false;
			}
			return true;
		}
		public static void dodatkowe_loty(){
			System.out.println("Czy chcesz utworzyc loty codzienne lub cotygodniowe?");
			System.out.println("1.Dodanie lotow codziennych");
			System.out.println("2.Dodanie lotow cotygodniowych");
			System.out.println("Wpisz dowolny znak aby nie tworzyc lotow dodatkowych.");
		}
		public static void dodatkowe_opcje_lotu_powrotnego(){
			System.out.println("Czy chcesz utworzyc lot/loty powrotne do poprzednio dodanych?");
			System.out.println("1.Utworz loty powrotne.");
			System.out.println("Wpisz dowolny znak aby nie tworzyc lotow dodatkowych.");
		}
}
