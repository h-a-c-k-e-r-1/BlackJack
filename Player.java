import java.util.Scanner;
import java.util.ArrayList;

public class Player
{
   Scanner scan = new Scanner (System.in);
   ArrayList<Card> hand = new ArrayList<>();
   DeckOfCards deck = new DeckOfCards();
   Dealer d = new Dealer(deck);
   String name = "";
   int money = 100;
   int bet = 0;
   String hitOrStay = "";
   public void play() {
     String hitOrStay = "";
     deck.shuffle();
     System.out.println("Welcome to blackjack, your starting balance is 100");
     System.out.println("Please enter your name");
     name = scan.next();
     System.out.println("Welcome " + name);
     System.out.println("How much would you like to bet?(integer values only)");
     bet = scan.nextInt();
     System.out.println("Your bet is: " + bet);
     money = money - bet;
     System.out.println("Your balance is now: " + money);
     System.out.println("Your draw is: ");
        hand.add(deck.drawCard());
        hand.add(deck.drawCard());
     System.out.println(hand);
     System.out.print("The Dealer has shown:  ");
     d.showFirstCard();
     hitStay();
     d.checkBlackJack();
     d.wantsToHit();
     d.takeTurn(deck);
    }
   
   public void hitStay() {
       System.out.println("would you like to hit or stay?");
       hitOrStay = scan.next();
       if(hitOrStay.equals("hit")) {
           hand.add(deck.drawCard());
           System.out.println("You've chosen to hit");
           System.out.println(hand);
           hitStay();
        }
       else if(hitOrStay.equals("stay")) {
           System.out.println("You've chosen to stay");
           System.out.println("The dealer has: ");
           d.showHand();
        }
       else {
           System.out.println("Please enter only hit or stay");
           hitOrStay = scan.next();
           hitStay();
        }
    }
}
