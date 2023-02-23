public abstract class Person {

    public Person() {
        // TODO Auto-generated constructor stub
    }
    private int point;
    private int score;

    private Card[] cd;

    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point=point;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Card[] getCard() {
        return cd;
    }
    public void setCard(Card[] card) {
        cd=card;
    }
    public Card[] getCard(int start,int end,Deck dk) {

        Card[] cd1=new Card[end-start];

        for(int i=start,j=0;i<end;i++,j++) {
            cd1[j]=new Card();
            cd1[j].setFlower(dk.getCard()[i].getFlower());
            cd1[j].setNum(dk.getCard()[i].getNum());
        }
        return cd1;
    }

    public void conncetionCard(Card[] card) {
        //原来Card数组为空
        if(cd.length==0) {
            cd=card;
            return ;
        }
        int tempLength = cd.length + card.length;
        Card[] tempCard = new Card[tempLength];
        for(int i =0;i<cd.length;i++) {
            tempCard[i] = new Card();
            tempCard[i].setFlower(cd[i].getFlower());
            tempCard[i].setNum(cd[i].getNum());
        }
        for(int i=cd.length,j=0;i<tempLength;i++,j++) {
            tempCard[i] = new Card();
            tempCard[i].setFlower(card[j].getFlower());
            tempCard[i].setNum(card[j].getNum());
        }
        cd=tempCard;
    }

    public void showCard() {
        for(int i=0;i<cd.length;i++) {
            System.out.print(cd[i].toString()+" ");
        }
    }
    //
    public void showSomeCard() {
        if(cd.length == 0) {
            return ;
        }
        else {

            for(int i=0;i<cd.length;i++) {
                if(i==0) System.out.print("▇▇   ");
                else System.out.print(cd[i].toString()+" ");
            }
        }
    }


    public void calculatePoint() {
        boolean flag=false;
        for (Card card : cd) {
            if(card.getNum()=="A") {
                if(this.getPoint()+11>21) {
                    this.setPoint(this.getPoint()+1);
                }
                else {
                    flag=true;
                    this.setPoint(this.getPoint()+11);
                }
            }
            else if(card.getNum()=="J" || card.getNum()=="Q" || card.getNum()=="K" || card.getNum()=="10") {
                this.setPoint(this.getPoint()+10);
            }
            else {
                this.setPoint(this.getPoint()+Integer.parseInt(card.getNum()));
            }
        }

        if(flag == true&&this.getPoint()>21) {
            this.setPoint(this.getPoint()-10);
        }
    }
}
