import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static void main(String[] args) {
        ArrayList<String[]> playerCards = new ArrayList<>();
        playerCards.add(getCard());
        playerCards.add(getCard());
        int playerTotal = Integer.parseInt(playerCards.get(0)[0]) + Integer.parseInt(playerCards.get(1)[0]);

        ArrayList<String[]> dealerCards = new ArrayList<>();
        dealerCards.add(getCard());
        dealerCards.add(getCard());
        int dealerTotal = Integer.parseInt(dealerCards.get(0)[0]) + Integer.parseInt(dealerCards.get(1)[0]);


        Boolean playerBust = false;
        Boolean dealerBust = false;

        System.out.println("-----" + "Player" + "-----");
        System.out.println("You got a " + playerCards.get(0)[0] + " and " + playerCards.get(1)[0]);
        System.out.println(playerCards.get(0)[1] + "   " + playerCards.get(1)[1] );
        System.out.println("Your total is " + playerTotal);

        System.out.println("-----" + "Dealer" + "-----");
        System.out.println("They got " + dealerCards.get(0)[0]);
        System.out.println(dealerCards.get(0)[1] + "   " + dealerCards.get(1)[1] );
        System.out.println("Their total is " + dealerTotal);

        if((playerTotal>21) && (dealerTotal>21)){
            System.out.println("You both went bust so neither win");
        }else if(playerTotal>21){
            System.out.println("You went bust so the dealer wins");
        }else if(dealerTotal>21){
            System.out.println("The dealer went bust so you win");
        }else{
            if(playerTotal == dealerTotal){
                System.out.println("The values are the same so it's a draw.");
            }else if(playerTotal>dealerTotal){
                System.out.println("Your total is larger, so you win.");
            }else{
                System.out.println("The dealer has the highest score so you win.");
            }
        }

        Scanner in  = new Scanner(System.in);
        in.nextLine();
        in.close();


    }

    public static String[] getCard(){
        int value = ThreadLocalRandom.current().nextInt(1,12);
        char[] suite = {'♠','♥','♦','♣'};
        int choiceSuite = ThreadLocalRandom.current().nextInt(0,4);
        String val = "" + value;
        char suiteChosen = suite[choiceSuite];

        String card = "----------".concat("\n").concat(val)
                .concat("\n").concat("\n").concat("\n")
                .concat("    " + suiteChosen+ "     ")
                .concat("\n").concat("\n").concat("\n").concat("        " + val).concat("\n")
                .concat("----------");

        String[] toReturn = {val, card};
        return  toReturn;
    }

    public static String hidden(){
        return   "----------".concat("\n")
                .concat("\n").concat("\n").concat("\n")
                .concat("    " + "     ")
                .concat("\n").concat("\n").concat("\n").concat("\n").concat("\n")
                .concat("-----------");
    }
}
