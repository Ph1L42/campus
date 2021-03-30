import java.util.Scanner;

public class A08_EVA {

    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in);



        int num = scanner.nextInt();
        //num++;
        System.out.println("Eingelesene Zahl: " + num);

        int num2 = scanner.nextInt();
        System.out.println("Eingelesene Zahl: " + num2);

       // int znum = num;

        int sum = num + num2;

        System.out.println("Summe: " + sum);


        scanner.close();
    }
}
