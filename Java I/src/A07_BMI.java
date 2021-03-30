import java.util.Scanner;

public class A07_BMI {


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte Gewicht in kg angeben: ");
        double m = scanner.nextDouble();

        System.out.println("Bitte Größe in cm angeben: ");
        double l = scanner.nextDouble();

        double bmi = m / (l / 100 * l / 100);

        System.out.println("Ihr BMI beträgt: " + bmi);

    }
}
