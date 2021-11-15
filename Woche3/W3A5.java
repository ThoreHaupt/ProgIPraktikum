import java.util.Scanner;

public class W3A5{

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        scanner.close();

        String[] words = {"Null","Eins","Zwei","Drei","Vier","Fünf","Sechs","Sieben","Acht","Neun","Zehn"};
        
        int i = 1;
        while(input/i > 0){
            i *= 10;
            System.out.print(words[input%i/(i/10)] + " ");
        }
    }
}
