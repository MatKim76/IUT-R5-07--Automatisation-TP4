import java.util.Stack;

public class Calculette {

    private Stack<Double> pile;

    public Calculette() {
        this.pile = new Stack<>();
    }

    // Méthode pour additionner
    public void addition() {
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a + b);
    }

    // Méthode pour soustraire
    public void soustraction() {
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a - b);
    }

    // Méthode pour multiplier
    public void multiplication() {
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a * b);
    }

    // Méthode pour diviser
    public void division() {
        double b = pile.pop();
        double a = pile.pop();
        pile.push(a / b);
    }

    // Méthode pour lire une chaîne de caractères en notation polonaise inverse
    public void calculer(String expression) {
        String[] tokens = expression.split(" ");
        for (String token : tokens) {
            switch (token) {
                case "+":
                    addition();
                    break;
                case "-":
                    soustraction();
                    break;
                case "*":
                    multiplication();
                    break;
                case "/":
                    division();
                    break;
                default:
                    pile.push(Double.parseDouble(token));
                    break;
            }
        }
    }

    // Méthode pour obtenir le résultat
    public double resultat() {
        return pile.peek();
    }

    public static void main(String[] args) {
        Calculette calc = new Calculette();
        String expression = "1.0 3 + 2 3.2 / +";  // Correspond à (1.0 + 3) + (2 / 3.2)
        calc.calculer(expression);
        System.out.println("Résultat: " + calc.resultat());
    }
}

