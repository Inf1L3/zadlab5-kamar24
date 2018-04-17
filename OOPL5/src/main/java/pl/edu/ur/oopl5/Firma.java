package pl.edu.ur.oopl5;
import java.util.Scanner;
/**
 *
 * @author LKusta
 */
public class Firma {
    private Pracownik[] listaPracownikow = new Pracownik[100];
    private int workersCounter;
    
    public Firma() {
        for (int index = 0;index<100;index++){
            listaPracownikow[index] = new Pracownik("","",0,"");
        }
        workersCounter = 0;
    }
    private boolean dodawaniePracownika(){
        Scanner in = new Scanner(System.in);
        Scanner scannerImie = new Scanner(System.in);
        Scanner scannerNazwisko = new Scanner(System.in);
        Scanner scannerStanowisko = new Scanner(System.in);
        
        if (workersCounter < listaPracownikow.length-1){
            int id = 0;
            int menuIndex = 0;            
            do{
                System.out.print("Podaj id dla nowego pracownika: ");  
                id = in.nextInt();
                
                if (id < 0 || id >= 100){
                    System.out.println("Nieprawidlowy id pracownika. Co chcesz zrobic?");
                    System.out.println("1. Zmien id");
                    System.out.println("2. Przerwij operacje");
                    menuIndex = in.nextInt();
                    
                    switch(menuIndex){
                        case 1: break;
                        case 2: return false;
                        default: break;
                    }
                }else break;
            }while(menuIndex != 0);
            
            if (listaPracownikow[id].isExist()){
                System.out.println("Pracownik o danym indeksie juz istnieje. Co chcesz zrobic?");
                System.out.println("1. Zastap pracownika (domyslne)");
                System.out.println("2.Przerwij dodawanie pracownika");
                int menu = in.nextInt();
                
                switch(menu){
                    case 1: break;
                    case 2: return false;
                    default: break;
                }
            }            
            System.out.print(" Imie: ");
            String imie = scannerImie.nextLine();
            
            System.out.print(" Nazwisko: ");
            String nazwisko = scannerNazwisko.nextLine();
            
            int wiek = -1;
            do {
                System.out.print(" Wiek: ");
                wiek = in.nextInt();                
                if (wiek < 0){
                    int menu = 1;                    
                    System.out.println("Podano nieprawidlowy wiek. Co chcesz zrobic?");
                    System.out.println("1. Popraw wartosc (domyslne)");
                    System.out.println("2. Przerwij dodawanie pracownika");
                    menu = in.nextInt();
                    
                    switch(menu){
                        case 1: break;
                        case 2: return false;
                        default: break;
                    }
                }
            }
            while(wiek < 0);
            
            System.out.print(" Stanowisko: ");
            String stanowisko = scannerStanowisko.nextLine();
            
            System.out.println(id);
            
            if (!listaPracownikow[id].isExist()) workersCounter++;
            listaPracownikow[id].setImie(imie);
            listaPracownikow[id].setNazwisko(nazwisko);
            listaPracownikow[id].setWiek(wiek);
            listaPracownikow[id].setStanowisko(stanowisko);
            listaPracownikow[id].setExist(true);
            return true;
        }
        else{
            System.out.println("Lista pelna. Nie mozna dodac pracownika");
            in.nextLine();
            return false;
        }
    }
    private boolean usuwaniePracownika(){
        Scanner in = new Scanner(System.in);
            if (workersCounter > 0){
            int menuIndex = 1;
            int id;
            
            do{
                System.out.print(" Podaj indeks pracownika do usuniecia: ");
                id = in.nextInt();
                
                if (id < 0 || id >= 100){
                    System.out.println("Nieprawidlowy indeks pracownika. Co chcesz zrobic?");
                    System.out.println("1. Zmien indeks (domyslne)");
                    System.out.println("2. Przerwij operacje");
                    menuIndex = in.nextInt();
                    
                    switch(menuIndex){
                        case 1: break;
                        case 2: return false;
                        default: break;
                    }
                }
            }while(menuIndex != 1);
            
            listaPracownikow[id].setImie("");
            listaPracownikow[id].setNazwisko("");
            listaPracownikow[id].setWiek(0);
            listaPracownikow[id].setStanowisko("");
            listaPracownikow[id].setExist(false);
            workersCounter--;
            return true;
        }
        else {
            System.out.println("Lista pusta. Nie ma pracownika do usuniecia");
            in.nextLine();
            return false;
        }
    }
    private boolean pokazListe(){        
        if (workersCounter > 0){
            for (int i=0;i<listaPracownikow.length-1;i++){
                if (listaPracownikow[i].isExist()){
                    System.out.println(" Indeks: " + i);
                    System.out.println(" Imie: " + listaPracownikow[i].getImie());
                    System.out.println(" Nazwisko: " + listaPracownikow[i].getNazwisko());
                    System.out.println(" Wiek: " + listaPracownikow[i].getWiek());
                    System.out.println(" Stanowisko: " + listaPracownikow[i].getStanowisko());
                }
            }
            return true;
        }
        else {
            System.out.println("Lista pracownikow pusta. Nie ma nic do wyswietlenia");
            return false;
        }
    }
    
    public void menu(){
        Scanner in = new Scanner(System.in);
        int menu = 1;        
        while(menu != 0){
            System.out.println("1. Dodaj pracownika");
            System.out.println("2. Usuń pracownika");
            System.out.println("3. Wyświetl spis pracowników");
            System.out.println("4. Cofnij");
            menu = in.nextInt();
            
            switch(menu){
                case 1: if (dodawaniePracownika()) System.out.println("Zrobione!");
                        else System.out.println("Coś się popsuło!");
                        break;
                        
                case 2: if (usuwaniePracownika()) System.out.println("Zrobione!");
                        else System.out.println("Coś się popsuło!");
                        break;
                        
                case 3: if (pokazListe()) System.out.println("Zrobione!");
                        else System.out.println("Coś się popsuło!");
                        break;
                        
                case 0: break;
            }
        } 
    }
}