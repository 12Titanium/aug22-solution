package utils;

public class TShirt implements Comparable<TShirt>{
    private final String link;
    private final int discount;
    private final int price;

    public TShirt(final String link, final int discount, final int price) {
        this.link = link;
        this.discount = discount;
        this.price = price;
    }

    @Override
    public int compareTo(TShirt other) {
        return Double.compare(this.discount, other.discount);
    }

    @Override
    public String toString() {
        return "TShirt{" +
                "link='" + link + '\'' +
                ", discount=" + discount +
                "%, price=INR." + price +
                '}';
    }
}
