


public class Hitter {

    private int Contact; //Tells how often he makes contact
    private int Power; // Helps dictate distance of hit
    private int Speed; // Helps see what balls he can get to and how many bases he takes on the base path
    private String Position;
    private String firstName;
    private String lastName;

    public Hitter(int Contact, int Power, int Speed, String Position) {
        // Set the atributes for the player
        this.Contact = Contact;
        this.Power = Power;
        this.Speed = Speed;
        this.Position = Position;
        firstName = "";
        lastName = "";
    }
    // Get players contact
    public int getContact() {
        return Contact;
    }
    // Get players power
    public int getPower() {
        return Power;
    }
    // Get players speed
    public int getSpeed() {
        return Speed;
    }
    // Get players position
    public String getPosition() {
        return Position;
    }
    public String getFirst() {
        return firstName;
    }
    public String getLast() {
        return lastName;
    }
    public void setFirst(String s) {
        firstName = s;
    }
    public void setLast(String s) {
        lastName = s;
    }
    public String display() {
        return "Contact: " + Contact + " Power: "+ Power + " Speed: " + Speed;
    }

}