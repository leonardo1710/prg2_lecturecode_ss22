package at.ac.fhcampuswien.designpatterns.factory;

public class Snuffler extends Orc{
    @Override
    public void walk(int length) {
        super.walk(length/2);
    }

    @Override
    public double attack(double strength) {
        return strength;
    }

    @Override
    public void attackRoar() {
        System.out.println("grrr");
    }
}
