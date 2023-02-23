public class Card {
    private String flower;
    private String num;
    public Card() {
        // TODO Auto-generated constructor stub
    }

    public Card(String flower,String num) {
        this.flower=flower;
        this.num=num;
    }
    public String toString() {
        return flower + num;
    }
    public String getFlower() {
        return flower;
    }
    public void setFlower(String flower) {
        this.flower=flower;
    }
    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num=num;
    }
}

