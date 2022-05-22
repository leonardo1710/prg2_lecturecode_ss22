package at.ac.fhcampuswien.designpatterns.factory;

public abstract class Orc {
    public void walk(int length) {
        System.out.println("walk " + length);
    }

    public abstract double attack(double strength);

    public abstract void attackRoar();
}
