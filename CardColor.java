public enum CardColor {

    Heart("\u2663"),Diamond("\u2666"),Club("\u2665"),Black("\u2660");
    private CardColor(String Color) {
        this.Color=Color;
    }
    private String Color;
    public String getColor() {
        return Color;
    }
    public void setColor(String Color) {
        this.Color=Color;
    }
}

