


public class StartingPitcher implements Pitcher {

    private int Velocity;
    private int Control;
    private int Stamina;
    private int Break;
    private String[] pitchMix;

    public StartingPitcher(int Velocity, int Control, int Break) {
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
}
