package at.ac.fhcampuswien.designpatterns.factory;

public class Demo {
    public static void main(String[] args) {
        OrcFactory factory = new OrcFactory();
        Orc urukhai1 = factory.getOrc("URUKHAI");
        Orc urukhai2 = factory.getOrc("URUKHAI");
        Orc snaga = factory.getOrc("SNAGA");

        urukhai1.attackRoar();
        snaga.attackRoar();
    }
}
