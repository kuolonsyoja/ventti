import java.util.Scanner;
public class Pontoon
{
  public static void main(String[] args)
  {	
  //create Scanner
    Scanner myKeyboard = new Scanner(System.in);
  //initilize hands for player and comp at 0
    int pelaajanKasi = 0;
    int jakajanKasi
            = 0;
  
  //describe program to user
    System.out.print("Program to play the game pontoon (or 21) against the computer,"); 
    System.out.print(" if the game score");
    System.out.println(" is a tie the computer wins\n");
  //tell user what the values are
    System.out.println("The card values are as follows:");
    System.out.println("    Cards Kaksi - Ten are valued 2 - 10");
    System.out.println("    Jack, Queen and King are valued 10");
    System.out.println("    Ässä on arvoltaan 14.\n");
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
    int playerCardKaksi = value(playerSecondCard);
    System.out.println("\n"+"Your second card is: "+playerSecondCard);
    pelaajanKasi = pelaajanKasi + (playerCardOne+playerCardKaksi);
    String compSecondCard = rank();
    int compCardKaksi = value(compSecondCard);
    System.out.println("The computers second card is: *hidden*");
    jakajanKasi = jakajanKasi + (compCardOne+compCardKaksi);
   
    System.out.println("\n"+"Your score is: "+pelaajanKasi);
  //BLACKJACK (21 in first 2 cards)
    if ((playerCardOne+playerCardKaksi)==21)
    {
      System.out.println("You have BLACKJACK");
    }
 
  //deal additional cards to player
  //initilize additional card values
    String playerNextCard;
    int playerCardNext = 0;
    System.out.print("\n"+"Would you like another card (y/n)? ");
    String additionalCard = myKeyboard.nextLine();
    while ((pelaajanKasi <= 21)&&(additionalCard.equalsIgnoreCase("y")))
    {
      playerNextCard = rank();
      playerCardNext = value(playerNextCard);
      System.out.println("\n"+"Your next card is: "+playerNextCard);
      pelaajanKasi = pelaajanKasi + playerCardNext;
      System.out.println("Your new score is: "+pelaajanKasi);
      if (pelaajanKasi > 21)
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
    System.out.println("\n"+"The computers score is: "+jakajanKasi);
System.out.print("\n"+"Press enter to continue.\n");
begin = myKeyboard.nextLine();
    if ((compCardOne+compCardKaksi)==21)	
    {
      System.out.println("The computer has BLACKJACK");
    }
    while (jakajanKasi < 15)
    {
      compNextCard = rank();
      compCardNext = value(compNextCard);
      System.out.println("\n"+"The computer will take another card");
      System.out.println("The computers next card is: "+compNextCard);
      jakajanKasi = jakajanKasi + compCardNext;
      System.out.println("The computers new score is: "+jakajanKasi); 
System.out.print("\n"+"Press enter to continue.\n");
begin = myKeyboard.nextLine(); 
    }
    System.out.println();
// for testing purposes
/*
System.out.println("Please enter values for each players hand for testing");
System.out.print("players score: ");
int pelaajanKasi = myKeyboard.nextInt();
System.out.print("comps score: ");
int jakajanKasi = myKeyboard.nextInt();
*/
  //final hand totals
    System.out.println("Your final score is: "+pelaajanKasi);
    System.out.println("The computers final score is: "+jakajanKasi+"\n");
  //check if anyone is bust
    if (pelaajanKasi > 21)
    {
      System.out.println("You are bust");
    }
    if (jakajanKasi > 21)
    {
      System.out.println("The computer is bust");
    }
    if ((pelaajanKasi > 21) && (jakajanKasi > 21))
    {
      System.out.println("\n"+"Both players are bust, no winner");
    }
  //check for winner if no-one bust
    if ((jakajanKasi > 21) && (pelaajanKasi <= 21))
    {
      System.out.println("You win!");
    }
    if ((pelaajanKasi > 21) && (jakajanKasi <= 21))
    {
      System.out.println("The computer wins!");
    }
    if ((jakajanKasi == pelaajanKasi) && (jakajanKasi <= 21))
    {
      System.out.println("Hands are tied, computer wins");
    }
    if ((jakajanKasi <= 21) && (jakajanKasi > pelaajanKasi))
    {
      System.out.println("The computer wins");
    }
    if ((pelaajanKasi <= 21) && (pelaajanKasi > jakajanKasi))
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
      case 14:
      b = "Ässä";
      break;
      case 2:
      b = "Kaksi";
      break;
      case 3:
      b = "Kolme";
      break;
      case 4:
      b = "Neljä";
      break;
      case 5:
      b = "Viisi";
      break;
      case 6:
      b = "Kuusi";
      break;
      case 7:
      b = "Seitsemän";
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
    if (a.equals("Ässä"))
    {
      b = 11;
    }
    if (a.equals("Kaksi"))
    {
      b = 2;
    }
    if (a.equals("Kolme"))
    {
      b = 3;
    }   
    if (a.equals("Neljä"))
    {
      b = 4;
    }    
    if (a.equals("Viisi"))
    {
      b = 5;
    }
    if (a.equals("Kuusi"))
    {
      b = 6;
    }
    if (a.equals("Seitsemän"))
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