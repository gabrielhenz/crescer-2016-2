import java.util.Scanner;

class InputScannerSample {

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println("Hello World! - " + scanner.nextLine());
        } catch (Exception e) {
            //...
        }
    }
}