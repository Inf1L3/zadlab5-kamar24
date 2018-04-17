package pl.edu.ur.oopl5;

import java.util.Scanner;
/**
 *
 * @author LKusta
 */
public class Main {

    private static void zadanie3(){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Podaj rozmiar stosu: ");
        int rozStosu = in.nextInt();
        zad3 Stak = new zad3(rozStosu);
        Stak.menu();
    }
    private static void zadanie5() {
        Firma company1 = new Firma();
        company1.menu();
    }

    private static void zadanie6() {
        zad6 zad6 = new zad6();
        zad6.menu();
    }
    public static void main(String[] args) {
        // TODO zad 3, 5, 6
        Scanner in = new Scanner(System.in);
        int menu = 1;
        
        while(menu != 0){
            System.out.println("1. Zadanie 3");
            System.out.println("2. Zadanie 5");
            System.out.println("3. Zadanie 6");
            System.out.println("0. Wyjscie");
            menu = in.nextInt();
            
            switch(menu){
                case 1: zadanie3(); break;
                case 2: zadanie5(); break;
                case 3: zadanie6(); break;
                case 0: break;                
            }
        }    
    }
    
}