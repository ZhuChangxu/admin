public enum CardRank {
    Ace("A"),Two("2"),Three("3"),Four("4"),Five("5"),Six("6"),
    Seven("7"),Eight("8"),Nine("9"),Ten("10"),Jack("J"),Queen("Q"),King("K");

    private CardRank(String Num) {
        this.Num=Num;
    }

    private String Num;
    public String getNum(){
        return Num;
    }
    public void setNum(String Num) {
        this.Num=Num;
    }
}
