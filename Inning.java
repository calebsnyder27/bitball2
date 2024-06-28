public class Inning {
    private Team t1;
    private Team t2;
    private Hitter bases[];
    private int outs;
    private int runs;
    private simGame sg;
    private Hitter[] homeOrder;
    private Hitter[] awayOrder;
    private Hitter curHitter;
    public Inning(Team t1, Team t2, simGame s) {
        sg = s;
        outs = 0;
        bases = new Hitter[3];
        runs = 0;
        homeOrder = t1.getOrder();
        awayOrder = t2.getOrder();
        curHitter = null;
    }
    
    public int simInning() {
        Pitcher curPitcher = null;
        Hitter curHitter = null;
        if (sg.getHalf() == 0) {
            curPitcher = sg.getHomePitcher();
            curHitter = awayOrder[sg.getOrder()];
        }
        else {
            curPitcher = sg.getAwayPitcher();
            curHitter = homeOrder[sg.getOrder()];
        }

        runs = 0;
        
        while(outs < 3) {
            atBat a = new atBat(curPitcher, curHitter);
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
            sg.incrementOrder();
            if (sg.getHalf() == 0) {
                curHitter = awayOrder[sg.getOrder()];
            }
            else {
                curHitter = homeOrder[sg.getOrder()];
            }
        }
        
        // Reset bases and outs for next inning simulation
        bases = new Hitter[3];
        outs = 0;
        
        return runs;
    }
    
    private void handleHit(int basesAdvanced) {
        int runsScored = 0;
        if (sg.getHalf() == 0) {
            curHitter = awayOrder[sg.getOrder()];
        }
        else {
            curHitter = homeOrder[sg.getOrder()];
        }
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
        /**Inning first = new Inning(p, h);
        int scoreChange = first.simInning();
        System.out.println("Runs scored in the inning: " + scoreChange);
        */
    }
}
