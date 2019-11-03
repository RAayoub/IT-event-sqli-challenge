import java.util.ArrayList;
import java.util.List;

public class Event {

    private Hotel hotel;
    private PersonFactory personFactory;
    private ArrayList<Person> persons;

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public Event(Hotel newHotel){
        persons = new ArrayList<>();
        newHotel.setPersons(persons);
        hotel=newHotel;
    }

    public boolean register(String role, String... names) {

        boolean added = false;
                for (String nm:names){
                    if (!searchByName(nm)){
                        persons.add(personFactory.create(nm,role));
                        hotel.setRoom(nm,names.length);
                        added=true;
                    }
                }
        return added;
    }

    private boolean searchByName(String name){
        boolean exist=false;
        for (int i=0;i<this.persons.size();i++){
            if (this.persons.get(i).getName().equalsIgnoreCase(name)){
                exist =true;
                break;
            }
        }

        return exist;
    }




}
