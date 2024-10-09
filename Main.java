import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String args[]) {
        //exercice1();
    }
    //Exercice1
    private static void exercice1(){
        int stock_pommes;
        Scanner scanner = new Scanner (System.in);
        System.out.println("Quel est le stock de pommes ?");
        String stockPommesRead = scanner.nextLine();
        stock_pommes = parseInt(stockPommesRead);
        if(stock_pommes < 100) {
            System.out.println("Il faut commander des pommes");
        }
        else {
            System.out.println("Il y a assez de pommes. Pas besoin d'en recommander");
        }
    }

    //Exercice 2:
    
}
