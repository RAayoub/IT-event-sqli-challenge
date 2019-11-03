public class PersonFactory {

    public static Person  create(String name, String role){

        Person person=null;

        switch (role){
            case "DEEP DIVE" : { return new DeepDive(name); }

            case "STAFF": return new Staff(name);

            case "CONF" : return new Conference(name);

            case "TRINGA" : return new Tringa(name);

            case "SPEAKER" : return new Speaker(name);

            default: return null;

        }
    }
}
