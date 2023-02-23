import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StartGame {

    public StartGame() {
        // TODO Auto-generated constructor stub
    }

    public static int menu() {
        System.out.println("*****************");
        System.out.println("1.Introduction");
        System.out.println("2.Begin the Game");
        System.out.println("3.Quit");
        System.out.println("*****************");
        System.out.println("Please Enter Your Choice (1-3)");
        return 1;
    }

    public static void introGame() {
        try {

            File f = new File("C:\\Users\\dp\\Desktop\\Introduction.txt");
            InputStreamReader reader =new InputStreamReader(new FileInputStream(f));
            BufferedReader BR= new BufferedReader(reader);
            String line="";
            while((line=BR.readLine())!=null) {
                System.out.println(line);
            }
            BR.close();
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
        int choice=1;
        Deck dk=new Deck();
        Player player1 = new Player();
        Dealer dealer = new Dealer();

        player1.setScore(0);
        dealer.setScore(0);
        Card[] tempCard;
        int count = 0;
        while(choice != 3) {
            menu();
            choice = sc.nextInt();
            if(choice==1) {
                introGame();
            }
            else if(choice==2){

                count++;
                if (count==1)
                    System.out.println("-----------------The First Round-----------------");
                else if (count == 2)
                    System.out.println("-----------------The Second Round-----------------");
                else if (count == 3)
                    System.out.println("-----------------The Third Round-----------------");
                dk.shuffle();
                System.out.println();
                player1.setCard(player1.getCard(0,2,dk));
                dealer.setCard(dealer.getCard(2,4,dk));

                dealer.hideCard();
                player1.showAllCard();
                int tempcount=4;

                System.out.println("The Player choose whether to get one more card (Y/N)");
                while(player1.getCardAgain()!=0) {
                    tempCard = player1.getCard(tempcount, tempcount+1, dk);
                    player1.conncetionCard(tempCard);
                    player1.showAllCard();
                    System.out.println("The Player choose whether to get one more card (Y/N)");
                    tempcount+=1;
                }

                dealer.exposeCard();

                while(dealer.isOverSixteen()!=1) {
                    tempCard = dealer.getCard(tempcount,tempcount+1,dk);
                    dealer.conncetionCard(tempCard);
                    dealer.exposeCard();
                    tempcount+=1;
                }

                int t=player1.compareToDealer(dealer);
                if(t==1) {
                    System.out.println("Player:"+player1.getPoint()+" points  Dealer:"+dealer.getPoint()+" points");
                    System.out.println("The Player Wins!");
                    player1.setScore(player1.getScore()+1);
                    dealer.setScore(dealer.getScore()-1);
                }
                else if(t==-1) {
                    System.out.println("Player:"+player1.getPoint()+" points  Dealer:"+dealer.getPoint()+" points");
                    System.out.println("The Dealer Wins!");
                    player1.setScore(player1.getScore()-1);
                    dealer.setScore(dealer.getScore()+1);
                }
                else if(t==0) {
                    System.out.println("Player:"+player1.getPoint()+" points  Dealer:"+dealer.getPoint()+" points");
                    System.out.println("It Ends in A Draw!");
                }
                System.out.println("");
                System.out.println("Current Scores:");
                System.out.println("Player:"+player1.getScore()+", Dealer:"+dealer.getScore());
            }
        }
        count = 0;
    }

}

