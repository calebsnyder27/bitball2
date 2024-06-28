public class ReliefPitcher implements Pitcher{
    
    private int Velocity;
    private int Control;
    private int Stamina;
    private int Break;
    private String[] pitchMix;
    private String firstName;
    private String lastName;

    public ReliefPitcher(int Velocity, int Control, int Break) {
        this.Velocity = Velocity;
        this.Control = Control;
        this.Stamina = 100;
        this.Break = Break;
        pitchMix = new String[5];
        pitchMix[0] = "Fastball";
        pitchMix[1] = "Curveball";
        pitchMix[2] = "Slider";
        pitchMix[3] = "Sinker";
        pitchMix[4] = "Change-up";
        firstName = "";
        lastName = "";
    }
    public int getVelocity() {
        return Velocity;
    }
    public int getControl() {
        return Control;
    }
    public int getStamina() {
        return Stamina;
    }
    public int getBreak() {
        return Break;
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
        return "Velocity: " + Velocity + " Control: "+ Control + " Break: " + Break + " Stamina: " + Stamina;
    }
}