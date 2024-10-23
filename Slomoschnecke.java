public class Slomoschnecke extends Rennschnecke implements Kriechbar {

    int counter = 0;

    public Slomoschnecke(String name, double vMax) {
        super(name, vMax);
    }

    public void krieche(int turbo) {
        if (counter < 10) {
            setvMax(getvMax() / 2);
            super.krieche();
            setvMax(getvMax() * 2);
            counter++;
        } else {
            setvMax(getvMax() * turbo * 100);
            super.krieche();
            setvMax(getvMax() / turbo / 100);
            counter = 0;
        }
    }
}
