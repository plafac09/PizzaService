package beans;

/**
 * Created by Christoph on 04.12.2014.
 */
public class Pizza {

    private String name;
    private String zutaten;
    private double preis;

    public Pizza(String name, String zutaten, double preis) {
        this.name = name;
        this.zutaten = zutaten;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZutaten() {
        return zutaten;
    }

    public void setZutaten(String zutaten) {
        this.zutaten = zutaten;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return String.format("%s %4.2f € %s", name, preis, zutaten);
    }
}
