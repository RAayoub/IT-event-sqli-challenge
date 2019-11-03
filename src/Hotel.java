import java.util.ArrayList;

public class Hotel  {

    private int standardRooms;
    private int suites;

    public int getStandardRooms() {
        return standardRooms;
    }

    public int getSuites() {
        return suites;
    }

    public int getApparts() {
        return apparts;
    }

    private int apparts;
    int cptStandardRooms=1;
    int cptSuites=101;
    int cptApparts=201;
    int deepConf=0;
    private ArrayList<Person> persons;

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public Hotel(int standardRooms, int suites, int apparts) {
        this.apparts=apparts;
        this.standardRooms=standardRooms;
        this.suites=suites;
    }

    public String checkAvailibility() {
        return "Standard rooms: "+standardRooms+"|Suites: "+suites+"|Aparts: "+apparts;
    }

    public String getRoomFor(String name) {
        for (Person person:persons){
            if (person.getName().equals(name)){
                return person.getRoom();
            }
        }
        return "";
    }

    public void setRoom(String name,int remainingRoom){

        for (Person person:persons){
            if (person.getName().equals(name)){
                if (person.getRole().equals("SPEAKER")){
                suites--;
                cptSuites++;
                person.setRoom("Suite N°"+(cptSuites-1));

            }else {
                if (standardRooms>0 && standardRooms>=remainingRoom ) {
                    if (person.getRole().equals("CONF")){
                        standardRooms = standardRooms - 1;
                        remainingRoom--;
                        cptStandardRooms++;
                        deepConf++;
                    person.setRoom("Standard room N°" + (cptStandardRooms - 1));
                }else if (person.getRole().equals("DEEP DIVE") && deepConf!=0){

                        person.setRoom("Standard room N°" + (cptStandardRooms - 1));
                    }
                    else {
                        standardRooms--;
                        remainingRoom--;
                        cptStandardRooms++;
                        person.setRoom("Standard room N°" + (cptStandardRooms - 1));
                    }
                }
                else if ( apparts>remainingRoom ){
                    apparts--;
                    remainingRoom--;
                    cptApparts++;
                    person.setRoom("Apart N°"+(cptApparts-1));

                }
            }
            }
        }
        //return "didn't enter to for Hotel  ";
    }

    public static void main(String[] args) {

        Hotel hotel=new Hotel(12,5,15);
        Event event= new Event(hotel);

        for (int i = 0; i < 12; i++) {
            String name = "Name" + i;
            event.register("TRINGA", name);
        }
        System.out.println("std :"+hotel.standardRooms+" apprts :"+hotel.apparts);
        event.register("TRINGA", "Mohammed", "Karim", "Nadia");
        System.out.println(hotel.getRoomFor("Mohammed"));
        System.out.println(hotel.getRoomFor("Karim"));
        System.out.println(hotel.getRoomFor("Nadia"));
    }


}
