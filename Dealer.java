public class Dealer extends Person {

    public Dealer() {
        // TODO Auto-generated constructor stub
    }

    public void exposeCard() {
        System.out.print("Dealer:");
        this.showCard();
        this.setPoint(0);
        this.calculatePoint();
        System.out.print("\t");
        System.out.println("Points:" + this.getPoint());
    }

    public void hideCard() {
        System.out.print("Dealer:");
        this.showSomeCard();
        System.out.println();
    }

    public int isOverSixteen() {
        this.setPoint(0);
        this.calculatePoint();
        if (this.getPoint() <= 16) {
            return 0;
        } else return 1;
    }
}
