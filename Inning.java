public class Inning {
    private Pitcher curPitcher;
    private Hitter curHitter;
    private Hitter bases[];
    private int outs;
    private int runs;
    public Inning(Pitcher p, Hitter h) {
        curPitcher = p;
        curHitter = h;
        outs = 0;
        bases = new Hitter[3];
        runs = 0;
    }
    
    public int simInning() {
        runs = 0;
        atBat a = new atBat(curPitcher, curHitter);
        
        while(outs < 3) {
            a.newAtBat();
            String s = a.simulateAtBat();
            
            if (s.contains("Out")) {
                outs++;
            } else if (s.contains("Single")) {
                handleHit(1);
            } else if (s.contains("Double")) {
                handleHit(2);
            } else if (s.contains("Triple")) {
                handleHit(3);
            } else {
                handleHit(4); // Assuming other hit scenario
            }
        }
        
        // Reset bases and outs for next inning simulation
        bases = new Hitter[3];
        outs = 0;
        
        return runs;
    }
    
    private void handleHit(int basesAdvanced) {
        int runsScored = 0;
        
        // Adjust baserunners based on hit outcome
        for (int i = 2; i >= 0; i--) {
            if (bases[i] != null) {
                if (i + basesAdvanced >= 3) {
                    runsScored++;
                } else {
                    bases[i + basesAdvanced] = bases[i];
                }
                bases[i] = null;
            }
        }
        
        // Place current hitter on base
        if (basesAdvanced <= 3) {
            bases[basesAdvanced - 1] = curHitter;
        }
        
        // Increment runs scored
        runs += runsScored;
    }

    public static void main(String[] args) {
        Hitter h = new Hitter(70, 70, 70, "1B");
        Pitcher p = new StartingPitcher(90, 90, 90);
        Inning first = new Inning(p, h);
        int scoreChange = first.simInning();
        System.out.println("Runs scored in the inning: " + scoreChange);
    }
}
