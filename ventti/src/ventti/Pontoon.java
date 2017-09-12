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
    System.out.print("Tämä on ohjelma Venttin pelaamiseen, Tetokonetta vastaan,"); 
    System.out.print(" jos pelin pistemäärä");
    System.out.println(" on tasapeli, tietokone voittaa\n");
  //tell user what the values are
    System.out.println("Korttien arvot ovat seuraavat:");
    System.out.println("    Kortit Kaksi - Kymmenen ovat arvoltaan 2 - 10");
    System.out.println("    Jätkä, Kuningatar ja Kuningas ovat arvoltaan 10");
    System.out.println("    Ässä on arvoltaan 14.\n");
  //begin when user is ready
System.out.print("\n"+"Paina entteriä jatkaaseen.");
String begin = myKeyboard.nextLine();
  //deal initial hands
    String playerFirstCard = rank();
    int playerCardOne = value(playerFirstCard);
    System.out.println("\n"+"Sinun esimmäinen kortti on: "+playerFirstCard);
    String compFirstCard = rank();
    int compCardOne = value(compFirstCard);
    System.out.println("Tietokoneen ensimmäinen kortti on: "+compFirstCard);
System.out.print("\n"+"Paina entteriä jatkaakseen.");
begin = myKeyboard.nextLine();
    String playerSecondCard = rank();
    int playerCardKaksi = value(playerSecondCard);
    System.out.println("\n"+"Sinun toinen kortti on: "+playerSecondCard);
    pelaajanKasi = pelaajanKasi + (playerCardOne+playerCardKaksi);
    String compSecondCard = rank();
    int compCardKaksi = value(compSecondCard);
    System.out.println("Tietokoneen toinen kortti on: *Pilotettu*");
    jakajanKasi = jakajanKasi + (compCardOne+compCardKaksi);
   
    System.out.println("\n"+"Sinun pistemäärä on: "+pelaajanKasi);
  //BLACKJACK (21 in first 2 cards)
    if ((playerCardOne+playerCardKaksi)==21)
    {
      System.out.println("Sait VENTTIN");
    }
 
  //deal additional cards to player
  //initilize additional card values
    String playerNextCard;
    int playerCardNext = 0;
    System.out.print("\n"+"Haluaisitko toisen kortin (k/e)? ");
    String additionalCard = myKeyboard.nextLine();
    while ((pelaajanKasi <= 21)&&(additionalCard.equalsIgnoreCase("k")))
    {
      playerNextCard = rank();
      playerCardNext = value(playerNextCard);
      System.out.println("\n"+"sinun seuraava kortti on: "+playerNextCard);
      pelaajanKasi = pelaajanKasi + playerCardNext;
      System.out.println("Sinun uusi pistemäärä on: "+pelaajanKasi);
      if (pelaajanKasi > 21)
      {
	System.out.println("Sinä olet yli, kortteja ei enään jaeta");
      }
      else
      {
      System.out.print("\n"+"Haluaistkko sinä toisen kortin (k/e)? ");
      additionalCard = myKeyboard.nextLine();
      }       
    }
  //pause in the game
System.out.print("\n"+"Nyt on tietokoneen vuoro, paina entteriä jatkaaseen.");
begin = myKeyboard.nextLine();
		
  //deal additional cards to computer
  //initilize additional card values
    String compNextCard;
    int compCardNext = 0;
    System.out.println("\n"+"Tietokoneen toinen kortti on: "+compSecondCard);
    System.out.println("\n"+"Tietokoneen pistemäärä on: "+jakajanKasi);
System.out.print("\n"+"Paina entteriä jatkaakseen.\n");
begin = myKeyboard.nextLine();
    if ((compCardOne+compCardKaksi)==21)	
    {
      System.out.println("Tietokone sai VENTTIN");
    }
    while (jakajanKasi < 15)
    {
      compNextCard = rank();
      compCardNext = value(compNextCard);
      System.out.println("\n"+"Tieto kone ottaa toisen kortin");
      System.out.println("Tietokoneen seuraava kortti on: "+compNextCard);
      jakajanKasi = jakajanKasi + compCardNext;
      System.out.println("Tietokoneen uudet pisteet ovat: "+jakajanKasi); 
System.out.print("\n"+"Paina entteriä jatkaakseen.\n");
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
    System.out.println("Sinun loppu tulos on: "+pelaajanKasi);
    System.out.println("Tietokoneen loppu tulos on: "+jakajanKasi+"\n");
  //check if anyone is bust
    if (pelaajanKasi > 21)
    {
      System.out.println("Sinä ylitit");
    }
    if (jakajanKasi > 21)
    {
      System.out.println("Tietokone ylitti");
    }
    if ((pelaajanKasi > 21) && (jakajanKasi > 21))
    {
      System.out.println("\n"+"Molemmat ylittivät, kumpikaan ei voita");
    }
  //check for winner if no-one bust
    if ((jakajanKasi > 21) && (pelaajanKasi <= 21))
    {
      System.out.println("Sinä voitat!");
    }
    if ((pelaajanKasi > 21) && (jakajanKasi <= 21))
    {
      System.out.println("Tietokone voittaa!");
    }
    if ((jakajanKasi == pelaajanKasi) && (jakajanKasi <= 21))
    {
      System.out.println("Tilanne on tasan, Jakaja voittaa");
    }
    if ((jakajanKasi <= 21) && (jakajanKasi > pelaajanKasi))
    {
      System.out.println("Tietokone voittaa!");
    }
    if ((pelaajanKasi <= 21) && (pelaajanKasi > jakajanKasi))
    {
      System.out.println("Sinä voitat!");
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
      b = "Kahdeksan";
      break;
      case 9:
      b = "Yhdeksän";
      break;
      case 10:
      b = "Kymmenen";
      break;
      case 11:
      b = "Jätkä";
      break;
      case 12:
      b = "Kuningatar";
      break;
      case 13:
      b = "Kuningas";
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
    if (a.equals("Kahdeksan"))
    {
      b = 8;
    }
    if (a.equals("Yhdeksän"))
    {
      b = 9;
    }
    if (a.equals("Kymmenen"))
    {
      b = 10;
    }
    if (a.equals("Jätkä"))
    {
      b = 10;
    }
    if (a.equals("Kunigatar"))
    {
      b = 10;
    }
    if (a.equals("Kuningas"))
    {
      b = 10;
    }
    return b;
  }
}