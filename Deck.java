import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

public class Deck {

    private Card[] cd = new Card[52];

    public Deck() {
        // TODO Auto-generated constructor stub
        for(int i=0;i<cd.length;) {
            for (CardRank card1 : EnumSet.range(CardRank.Ace, CardRank.King)) {
                for (CardColor card : EnumSet.range(CardColor.Heart, CardColor.Black)) {
                    cd[i]=new Card();
                    cd[i].setFlower(card.getColor());
                    cd[i].setNum(card1.getNum());
                    i++;
                }
            }
        }

    }

    public Card[] getCard() {
        return cd;
    }
    public Card[] getCard(int start,int end) {
        Card[] cd1=new Card[end-start];
        for(int i=start,j=0;i<end;i++,j++) {
            cd1[j]=new Card();
            cd1[j].setFlower(this.getCard()[i].getFlower());
            cd1[j].setNum(this.getCard()[i].getNum());
        }
        return cd1;
    }

    public void shuffle() {

        List<Card> list = Arrays.asList(cd);

        Collections.shuffle(list);
    }
    public String toString() {
        for (int i = 0; i < cd.length; i++) {
            System.out.println(cd[i].toString());
        }
        return "";
    }

    public void sort() {
        Arrays.sort(cd);
    }
}
