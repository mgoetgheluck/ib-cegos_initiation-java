import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String args[]) {
        //exercice1();
        //exercice2();
        //exercice3();
        //exercice4();
        //exercice5();
        //exercice6();
        exercice7();
    }
    //Exercice1
    /*Vous travaillez pour un marché local, et on vous demande de créer un programme qui aide à vérifier
    si la quantité de fruits dans le stock est suffisante pour le lendemain. Si le stock de pommes est
    supérieur à 100, alors il n'y a pas besoin d'en acheter plus. Sinon, il faudra en commander.*/
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
    /*Vous êtes en charge de la sécurité d'un musée. Le musée ne peut accueillir que des personnes
    majeures (18 ans ou plus) pendant certaines expositions. Vous devez créer un programme pour
    vérifier l'âge des visiteurs et décider s'ils peuvent entrer*/
    private static void exercice2() {
        int age;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre age ?");
        String ageRead = scanner.nextLine();
        age = parseInt(ageRead);
        if(age >= 18){
            System.out.println("Vous pouvez entrer voir les expositions");
        }
        else {
            System.out.println("Vous n'avez pas l'âge requis pour voir les expositions");
        }
    }

    /*Le gardien d'une salle des trésors vous demande de concevoir un système qui puisse afficher
    chaque jour le nombre de trésors comptabilisés. À chaque fois qu'un trésor est compté, il faut
    l'afficher sur l'écran avec une description spéciale pour les trésors comptés à des positions multiples
    de 3.*/
    private static void exercice3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien de trésors aujourd'hui ?");
        String nbeTresorsRead = scanner.nextLine();
        int nbeTresors = parseInt(nbeTresorsRead);
        int index = 0;
        while(index < nbeTresors){
            System.out.println("Quel est le trésor ?");
            String nameTresor = scanner.nextLine();
            String message = nameTresor;
            if((index +1) % 3 == 0){
                message += ". Ce trésor est un multiple de 3.";
            }
            System.out.println(message);
            index++;
        }
    }
    /*Vous travaillez pour une école qui organise un marathon de calculs. Les élèves doivent additionner
    une série de nombres entre 1 et un nombre donné par l'utilisateur. De plus, vous devez stocker
    chaque résultat partiel de la somme dans un tableau pour le réutiliser plus tard.
    Ajout : Utilisez un tableau pour stocker chaque étape de la somme.*/
    private static void exercice4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quelle est votre valeur ?");
        String numberRead = scanner.nextLine();
        int number = parseInt(numberRead);
        int[] array = new int[number];
        array[0] = 1;
        for(int i = 2; i <= number; i++){
            array[i-1] = array[i-2] + i;
        }
    }

    /*Un coffre-fort contient un trésor, mais il ne s'ouvrira que si un certain mot de passe est trouvé. Ce
    mot de passe est une chaîne de caractères spécifique que l'utilisateur doit deviner. Le programme
    doit également stocker chaque tentative de mot de passe dans un tableau et afficher toutes les
    tentatives incorrectes à la fin.
    Ajout : Utilisez un tableau pour stocker chaque tentative de mot de passe incorrecte*/
    private static void exercice5() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est le mot de passe ?");
        String motDePasse = scanner.nextLine();
        List<String> motDePasseErrones = new ArrayList<String>();
        boolean isEqual = false;
        while(!isEqual) {
            System.out.println("Saurez-vous trouver le mot de passe");
            String testMotDePasse = scanner.nextLine();
            if(testMotDePasse.equals(motDePasse)){
                isEqual = true;
            }
            else{
                motDePasseErrones.add(testMotDePasse);
            }
        }
        System.out.println("Bravo. Vous avez trouvé. Voici la liste de vos tentatives erronées.");
        for (String motDePasseErrone : motDePasseErrones) {
            System.out.println(motDePasseErrone);
        }
    }

    /*Vous êtes chargé de concevoir un programme pour une école qui veut automatiser le calcul des
    moyennes de plusieurs élèves. Chaque élève a plusieurs notes, et le programme doit calculer la
    moyenne de chaque élève, ainsi que la moyenne générale de toute la classe.*/
    public static void exercice6() {
        List<List<Double>> notes = new ArrayList<List<Double>>();
        Scanner scanner = new Scanner(System.in);
        boolean isNextEleve = true;
        int eleveNumber = 1;
        while(isNextEleve){
            System.out.println("Eleve n°"+eleveNumber);
            boolean isNextNote = true;
            List<Double> notesCol = new ArrayList<Double>();
            while(isNextNote) {
                System.out.println("Quelle Note ? Type 'next' for next student");
                String noteRead = scanner.nextLine();
                if(noteRead.equals("next")){
                    isNextNote = false;
                }
                else {
                    double note = parseDouble(noteRead);
                    notesCol.add(note);
                }
            }
            notes.add(notesCol);
            System.out.println("End of student n°"+eleveNumber+". Type exit for ending. Type next for next student");
            String nextStudent = scanner.nextLine();
            if(nextStudent.equals("exit")){
                isNextEleve = false;
            }
            else {
                eleveNumber++;
            }
        }
        //Calculating averages here.
        int i = 1;
        double sumClass = 0d;
        for(List<Double> notesEleve : notes){
            double sum = 0d;
            for(Double note: notesEleve){
                sum+=note;
            }
            double average = sum/notesEleve.size();
            System.out.println("Moyenne de l'eleve n°"+i+" est :"+average);
            i++;
            sumClass+=average;
        }
        double averageClass = sumClass / notes.size();
        System.out.println("Moyenne de la classe est :"+averageClass);
    }

    /*Un nombre parfait est un nombre qui est égal à la somme de ses diviseurs propres (les diviseurs
    strictement inférieurs à lui-même). Par exemple, 6 est un nombre parfait, car ses diviseurs propres
    sont 1, 2 et 3, et 1 + 2 + 3 = 6. Votre programme doit déterminer si un nombre donné par l'utilisateur
    est un nombre parfait.*/
    public static void exercice7(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre nombre ?");
        int number = scanner.nextInt();
        List<Integer> dividersList = new ArrayList<Integer>();
        for(int i = 1; i < number; i++){
            if(number % i == 0){
                dividersList.add(i);
            }
        }
        int sum=0;
        for(int divider: dividersList){
            sum+=divider;
        }
        if(sum == number){
            System.out.println(number+" est un nombre parfait !");
        }
        else {
            System.out.println(number+" n'est pas un nombre parfait.");
        }

    }

}
