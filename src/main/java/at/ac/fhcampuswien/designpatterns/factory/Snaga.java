package at.ac.fhcampuswien.designpatterns.factory;

public class Snaga extends Orc {

    @Override
    public double attack(double strength) {
        return strength * 2;
    }

    @Override
    public void attackRoar() {
        System.out.println("oiiizzz grunz");
    }
}
