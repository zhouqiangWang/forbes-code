import java.util.Scanner;

public class Instacart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equals("q")) {
                break;
            }
            if (line.isEmpty()) {
                System.out.println("Empty Line!");
            } else {
                System.out.println(line);
            }
        }
    }
}
