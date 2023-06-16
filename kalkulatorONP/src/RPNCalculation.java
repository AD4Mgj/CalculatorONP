import java.util.Stack;

public class RPNCalculation {
    private Stack<Integer> stos = new Stack<>();

    public RPNCalculation(Stack<Integer> stos) {
        this.stos = stos;
    }

    public int calculate(String onp) {
        for (String s : onp.split(" ")) {
            if (isNumeric(s)) {
                stos.push(Integer.parseInt(s));
            } else {
                switch (s) {
                    case "+" -> {
                        int skladnik2 = stos.pop();
                        int skladnik1 = stos.pop();
                        stos.push(skladnik1 + skladnik2);
                    }
                    case "-" -> {
                        int odjemnik = stos.pop();
                        int odjemna = stos.pop();
                        stos.push(odjemna - odjemnik);
                    }
                    case "*" -> {
                        int czynnik2 = stos.pop();
                        int czynnik1 = stos.pop();
                        stos.push(czynnik1 * czynnik2);
                    }
                    case "/" -> {
                        int dzielnik = stos.pop();
                        int dzielna = stos.pop();
                        stos.push(dzielna / dzielnik);
                    }
                    case "%" -> {
                        int dzielnikM = stos.pop();
                        int dzielnaM = stos.pop();
                        stos.push(dzielnaM % dzielnikM);
                    }
                    default -> stos.push(Integer.parseInt(s));
                }
            }
        }

        return stos.peek();
    }

    private boolean isNumeric(String numer) {
        if (numer == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(numer);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
