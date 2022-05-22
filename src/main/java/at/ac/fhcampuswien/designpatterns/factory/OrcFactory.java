package at.ac.fhcampuswien.designpatterns.factory;

    public class OrcFactory {
        public Orc getOrc(String type){
            if(type.equalsIgnoreCase("URUKHAI")){
                return new Urukhai();
            } else if(type.equalsIgnoreCase("SNAGA")){
                return new Snaga();
            } else if(type.equalsIgnoreCase("SNUFFLER")){
                return new Snuffler();
            } else {
                throw new IllegalArgumentException("Type of Orc not supported: " + type);
            }
        }
    }


