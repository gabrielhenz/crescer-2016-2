import java.io.Console;

class InputConsoleSample {

    public static void main(String[] args) {
        final Console console = System.console();
        System.out.println("Hello World! - " + console.readLine());
    }
}