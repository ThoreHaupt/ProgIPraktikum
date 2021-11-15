import java.util.Scanner;

public class W4A1{

    public static main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        
        int jahre = input/(24*360*365);
        int tage = (input/(24*360))%(24*360*365);
        int seks = input%(24*360);
        int stunden = seks/(24*360);
        int minuten = seks%(24*360)/60;
        int sekunden = seks/%(24*360);


        System.out.println("Jahre: " + jahre);
        System.out.println("Tage: " + tage);
        System.out.println("Stunden: " + stunden);
        System.out.println("Minuten: " + minuten);
        System.out.println("Sekunden: " + sekunden);

        scanner.close();

    }
}