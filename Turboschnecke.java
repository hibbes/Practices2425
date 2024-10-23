public class Turboschnecke extends Rennschnecke implements Kriechbar {
    

  public Turboschnecke(String name, double vMax){
    super(name, vMax);
  }

  public void krieche(int turbo){
    setvMax(getvMax()*turbo);
    super.krieche();
    setvMax(getvMax()/turbo);

  }



}
