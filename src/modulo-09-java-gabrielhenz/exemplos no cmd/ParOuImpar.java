import java.util.Scanner;

class ParOuImpar {

    public static void main(String[] args) {
		try (final Scanner scanner = new Scanner(System.in)) {
			int num = Integer.parseInt(scanner.nextLine());
            System.out.println(num % 2 == 0 ? "Par" : "Impar");
        } catch (Exception e) {
            //...
        }
    }
}