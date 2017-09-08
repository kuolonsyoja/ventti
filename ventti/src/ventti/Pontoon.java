import java.util.Scanner;
public class Pontoon
{
  public static void main(String[] args)
  {	
  //create Scanner
    Scanner myKeyboard = new Scanner(System.in);
  //initilize hands for player and comp at 0
    int playerHand = 0;
    int compHand = 0;
  
  //describe program to user
    System.out.print("Program to play the game pontoon (or 21) against the computer,"); 
    System.out.print(" if the game score");
    System.out.println(" is a tie the computer wins\n");
  //tell user what the values are
    System.out.println("The card values are as follows:");
    System.out.println("    Cards Two - Ten are valued 2 - 10");
    System.out.println("    Jack, Queen and King are valued 10");
    System.out.println("    Ässä on arvoltaan pelaajalle joko 1 tai 14, jakajalle 1.\n");
  //begin when user is ready
System.out.print("\n"+"Press enter to begin.");
String begin = myKeyboard.nextLine();
  //deal initial hands
    String playerFirstCard = rank();
    int playerCardOne = value(playerFirstCard);
    System.out.println("\n"+"Your first card is: "+playerFirstCard);
    String compFirstCard = rank();
    int compCardOne = value(compFirstCard);
    System.out.println("The computers first card is: "+compFirstCard);
System.out.print("\n"+"Press enter to continue.");
begin = myKeyboard.nextLine();
    String playerSecondCard = rank();
    int playerCardTwo = value(playerSecondCard);
    System.out.println("\n"+"Your second card is: "+playerSecondCard);
    playerHand = playerHand + (playerCardOne+playerCardTwo);
    String compSecondCard = rank();
    int compCardTwo = value(compSecondCard);
    System.out.println("The computers second card is: *hidden*");
    compHand = compHand + (compCardOne+compCardTwo);
   
    System.out.println("\n"+"Your score is: "+playerHand);
  //BLACKJACK (21 in first 2 cards)
    if ((playerCardOne+playerCardTwo)==21)
    {
      System.out.println("You have BLACKJACK");
    }
 
  //deal additional cards to player
  //initilize additional card values
    String playerNextCard;
    int playerCardNext = 0;
    System.out.print("\n"+"Would you like another card (y/n)? ");
    String additionalCard = myKeyboard.nextLine();
    while ((playerHand <= 21)&&(additionalCard.equalsIgnoreCase("y")))
    {
      playerNextCard = rank();
      playerCardNext = value(playerNextCard);
      System.out.println("\n"+"Your next card is: "+playerNextCard);
      playerHand = playerHand + playerCardNext;
      System.out.println("Your new score is: "+playerHand);
      if (playerHand > 21)
      {
	System.out.println("You are bust, no more cards dealt");
      }
      else
      {
      System.out.print("\n"+"Would you like another card (y/n)? ");
      additionalCard = myKeyboard.nextLine();
      }       
    }
  //pause in the game
System.out.print("\n"+"It is now the computers turn, please press enter to continue.");
begin = myKeyboard.nextLine();
		
  //deal additional cards to computer
  //initilize additional card values
    String compNextCard;
    int compCardNext = 0;
    System.out.println("\n"+"The computers second card is: "+compSecondCard);
    System.out.println("\n"+"The computers score is: "+compHand);
System.out.print("\n"+"Press enter to continue.\n");
begin = myKeyboard.nextLine();
    if ((compCardOne+compCardTwo)==21)	
    {
      System.out.println("The computer has BLACKJACK");
    }
    while (compHand < 15)
    {
      compNextCard = rank();
      compCardNext = value(compNextCard);
      System.out.println("\n"+"The computer will take another card");
      System.out.println("The computers next card is: "+compNextCard);
      compHand = compHand + compCardNext;
      System.out.println("The computers new score is: "+compHand); 
System.out.print("\n"+"Press enter to continue.\n");
begin = myKeyboard.nextLine(); 
    }
    System.out.println();
// for testing purposes
/*
System.out.println("Please enter values for each players hand for testing");
System.out.print("players score: ");
int playerHand = myKeyboard.nextInt();
System.out.print("comps score: ");
int compHand = myKeyboard.nextInt();
*/
  //final hand totals
    System.out.println("Your final score is: "+playerHand);
    System.out.println("The computers final score is: "+compHand+"\n");
  //check if anyone is bust
    if (playerHand > 21)
    {
      System.out.println("You are bust");
    }
    if (compHand > 21)
    {
      System.out.println("The computer is bust");
    }
    if ((playerHand > 21) && (compHand > 21))
    {
      System.out.println("\n"+"Both players are bust, no winner");
    }
  //check for winner if no-one bust
    if ((compHand > 21) && (playerHand <= 21))
    {
      System.out.println("You win!");
    }
    if ((playerHand > 21) && (compHand <= 21))
    {
      System.out.println("The computer wins!");
    }
    if ((compHand == playerHand) && (compHand <= 21))
    {
      System.out.println("Hands are tied, computer wins");
    }
    if ((compHand <= 21) && (compHand > playerHand))
    {
      System.out.println("The computer wins");
    }
    if ((playerHand <= 21) && (playerHand > compHand))
    {
      System.out.println("You win!");
    }
  }
//method for random number generator 1-13
  public static int random()
  {
    int number = (int)(Math.random()*13)+1;
    return number;   
  }
//method to turn random number between 1-13 into a card name
  public static String rank()
  {
    int a = random();
    String b = "a";
    switch (a)
    {
      case 1:
      b = "Ace";
      break;
      case 2:
      b = "Two";
      break;
      case 3:
      b = "Three";
      break;
      case 4:
      b = "Four";
      break;
      case 5:
      b = "Five";
      break;
      case 6:
      b = "Six";
      break;
      case 7:
      b = "Seven";
      break;
      case 8:
      b = "Eight";
      break;
      case 9:
      b = "Nine";
      break;
      case 10:
      b = "Ten";
      break;
      case 11:
      b = "Jack";
      break;
      case 12:
      b = "Queen";
      break;
      case 13:
      b = "King";
      break;
    }
    return b;
  }
//method to turn the rank into a value depending on the card name
  public static int value(String a)
  {
    //random number between 1 - 13 
    int b = 0;
    if (a.equals("Ace"))
    {
      b = 11;
    }
    if (a.equals("Two"))
    {
      b = 2;
    }
    if (a.equals("Three"))
    {
      b = 3;
    }   
    if (a.equals("Four"))
    {
      b = 4;
    }    
    if (a.equals("Five"))
    {
      b = 5;
    }
    if (a.equals("Six"))
    {
      b = 6;
    }
    if (a.equals("Seven"))
    {
      b = 7;
    }
    if (a.equals("Eight"))
    {
      b = 8;
    }
    if (a.equals("Nine"))
    {
      b = 9;
    }
    if (a.equals("Ten"))
    {
      b = 10;
    }
    if (a.equals("Jack"))
    {
      b = 10;
    }
    if (a.equals("Queen"))
    {
      b = 10;
    }
    if (a.equals("King"))
    {
      b = 10;
    }
    return b;
  }
}