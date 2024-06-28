public class simGame {
    private Team home;
    private Team away;
    private int inningHalf;
    private int inningTotal;
    private int homeScore;
    private int awayScore;
    private boolean gameOver;
    private Team winner;
    private Team loser;
    private int homeOrder;
    private int awayOrder;
    private Pitcher homePitcher;
    private Pitcher awayPitcher;

    public simGame(Team t1, Team t2) {
        homeScore = 0;
        awayScore = 0;
        inningTotal = 1;
        inningHalf = 0;
        home = t1;
        away = t2;
        gameOver = false;
        winner = null;
        loser = null;
        homePitcher = t1.getStarter();
        awayPitcher = t2.getStarter();
    }
    public Pitcher getHomePitcher() {
        return homePitcher;
    }
    public Pitcher getAwayPitcher() {
        return awayPitcher;
    }

    public void changeHalf() {
        if (inningHalf == 0) {inningHalf++;}
        else {
            inningHalf = 0;
            inningTotal++;
        }
    }
    public int getHalf() {
        return inningHalf;
    }
    public void incrementOrder() {
        if (inningHalf == 0) {
            if (awayOrder == 8) {
                awayOrder = 0;
            }
            else {
                awayOrder++;
            }
        }
        else {
            if (homeOrder == 8) {
                homeOrder = 0;
            }
            else {
                homeOrder++;
            }
        }
    }
    public int getOrder() {
        if (inningHalf == 0) {return awayOrder;} 
        else {return homeOrder;}
    }
    public void simulate() {
        while(gameOver == false) {
            if (inningTotal >=9 && inningHalf >0 && homeScore > awayScore) {
                gameOver = true;
                winner = home;
                loser = away;
                System.out.println("The " + home.getCity() + " " + home.getName() + " have beat the " + away.getCity() + " " + away.getName() + " by a score of " + homeScore + "-" + awayScore);
                home.nextPitcher();
                away.nextPitcher();
                break;
            }
            else if (inningTotal >9 && inningHalf == 0 && awayScore > homeScore) {
                gameOver = true;
                winner = away;
                loser = home;
                System.out.println("The " + away.getCity() + " " + away.getName() + " have beat the " + home.getCity() + " " + home.getName() + " by a score of " + awayScore + "-" + homeScore);
                home.nextPitcher();
                away.nextPitcher();
                break;
            }
            if(inningHalf == 0) {
                Inning currentInning = new Inning(home, away, this);
                awayScore+= currentInning.simInning();
                this.changeHalf();
            }
            else {
                Inning currentInning = new Inning(home, away, this);
                homeScore+= currentInning.simInning();
                this.changeHalf();
            }
        } 
    }
    


    public static void main(String[] args) {
        Team t = new Team("Chicago", "Cubs");
        t.generateStats();
        t.save();

        Team t1 = new Team("St.Louis", "Cardinals");
        t1.generateStats();
        t1.save();
        simGame sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        sg = new simGame(t, t1);
        System.out.println(t1.getStarter().getName());
        sg.simulate();
        

    }
}
