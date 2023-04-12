import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Utils.displayHome();
    }
    
    public static Scanner getScanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
