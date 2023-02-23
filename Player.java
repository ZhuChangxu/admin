import java.util.Scanner;

public class Player extends Person {

    public Player() {
        // TODO Auto-generated constructor stub
    }


    public int getCardAgain() {
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        if (ans.equals("Y") || ans.equals("y"))
            return 1;
        else if (ans.equals("N") || ans.equals("n"))
            return 0;
        else return -1;
    }


    public void showAllCard() {
        System.out.print("Player:");
        this.showCard();
        this.setPoint(0);
        this.calculatePoint();
        System.out.println("\t" + "Points:" + this.getPoint());
    }


    public int compareToDealer(Dealer d) {

        if (this.getPoint() > 21) {

            return -1;

        }

        else {

            if (d.getPoint() <= 21) {

                if (this.getPoint() < d.getPoint()) {
                    return -1;
                }

                else if (this.getPoint() > d.getPoint()) {
                    return 1;
                }

                else {
                    return 0;
                }
            }

            else {
                return 1;
            }
        }
    }
}

