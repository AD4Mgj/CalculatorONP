import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File plik = new File("expression.txt");
        runONP(plik);



    }

    public static void runONP(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Stack<Integer> stack = new Stack<>();
        RPNGenerator rpnGenerator = new RPNGenerator(256);
        RPNCalculation rpnCalculation = new RPNCalculation(stack);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String onp = rpnGenerator.generator(line);
            int result = rpnCalculation.calculate(onp);
            System.out.println(line + "    ONP:    " + onp + "    WYNIK:    " + result);
        }
    }

}