public class atBat {
    private Pitcher sp;
    private Hitter h;
    private String outcome;
    private int balls;
    private int strikes;

    public atBat(Pitcher p, Hitter h) {
        this.sp = p;
        this.h = h;
        outcome = "";
        balls = 0;
        strikes = 0;
    }
    public void newAtBat() {
        strikes =0;
        balls = 0;
        outcome = "";
    }
    
    public String simulateAtBat() {
        while(strikes != 3 && balls != 4){
        String s = this.simulatePitch();
        if (s.equals("Ball")) {
            balls++;
        }
        else if (s.equals("Swing and Miss")) {
            strikes++;
        }
        else if (s.equals("Line Drive Foul Ball") || s.equals("Ground Ball Foul Ball") || s.equals("Fly Ball Foul Ball") || s.equals("Infield Fly Foul Ball")) {
            // Answer for all foul balls
            if (strikes < 2) {
                strikes++;
            }
        }
        else {
            return s;
        }
    }
    if (balls == 4) {
        return "Walk";
    }
    if (strikes == 3) {
        return "Strike Out!";
    }
    return "";
    }

    public String simulatePitch() {
        String pitch = "";
        int pitchSelect1 = (0 + (int)(Math.random() * 99));
            //Picked a pitch based on Velocity
            if (pitchSelect1 < 60) {
                //System.out.println("Velocity");
                // Number for selecting a velocity-based pitch
                pitchSelect1 = (0 + (int)(Math.random() * 99));
                if (pitchSelect1 < 50) {
                    //System.out.println("Fastball");
                    pitch = "Fastball";
                }
                else if (pitchSelect1 >50 && pitchSelect1 < 90) {
                    //System.out.println("Sinker");
                    pitch = "Sinker";
                }
                else {
                    //System.out.println("Slider");
                    pitch = "Slider";
                }
            }
            //Picked a pitch based on Break
            else {
                //System.out.println("OffSpeed");
                // Number for selecting a breaking-ball pitch
                pitchSelect1 = (0 + (int)(Math.random() * 99));
                if (pitchSelect1 < 50) {
                    //System.out.println("Curveball");
                    pitch = "Curveball";
                }
                else if (pitchSelect1 >50 && pitchSelect1 < 90) {
                    //System.out.println("Change-Up");
                    pitch = "Change-Up";
                }
                else {
                    //System.out.println("Slider");
                    pitch = "Slider";
                }
            }

            int SoB = 0;
            // 2. Ball or Strike
            if (pitch.equals("Fastball")) {
                double temp = (sp.getVelocity() + sp.getStamina() + sp.getControl()) / 350 * 100;
                SoB = (int) temp;
            }
            else if(pitch.equals("Curveball")) {
                double temp = (sp.getBreak() + sp.getStamina() + sp.getControl()) / 350 * 100;
                SoB = (int) temp;
            }
            else if(pitch.equals("Slider")) {
                double temp = ((sp.getVelocity()+sp.getBreak()* .5) + sp.getStamina() + sp.getControl()) / 350 * 100;
                SoB = (int) temp;
            }
            else if(pitch.equals("Sinker")) {
                double temp = ((sp.getVelocity()*.75)+ (sp.getBreak()*.25) + sp.getStamina() + sp.getControl()) / 350 * 100;
                SoB = (int) temp;
            }
            else {
                double temp = ((sp.getVelocity()*.25)+ (sp.getBreak()*.75) + sp.getStamina() + sp.getControl()) / 350 * 100;
                SoB = (int) temp;
            }
            int StrikeOrBall = (0 + (int)(Math.random() * 99));
            int checkContact = (0 + (int)(Math.random() * 99));
            // Checks if pitch is ball or strike
            if (SoB >= StrikeOrBall) {
                //System.out.println("Strike Thrown");
                // Checks if he swung or not
                if (checkContact < 80) {
                    checkContact = (0 + (int)(Math.random() * 99));
                    // Checks if he made contact
                    if (checkContact < 65) {
                        //System.out.println("Made contact with pitch");
                        String typeH = "";
                        //PICK UP HERE (WE NEED TO DICTATE FAIR OR FOUL, THEN DICTATE HIT TYPE USING CONTACT RATING, THEN DISTANCE USING SPEED AND POWER)
                        int typeHit = (0 + (int)(Math.random() * 99));
                        if (typeHit < 21) {
                            //System.out.println("Line Drive");
                            typeH = "Line Drive";
                        }
                        else if (typeHit >=21 && typeHit <65) {
                            //System.out.println("Ground Ball");
                            typeH = "Ground Ball";
                        }
                        else if (typeHit >=65 && typeHit <90) {
                            //System.out.println("Fly Ball");
                            typeH = "Fly Ball";
                        }
                        else {
                            //System.out.println("Infield Pop Out");
                            typeH = "Infield Pop Out";
                        }
                        
                        if (typeH.equals("Line Drive")) {
                            int fof = (0 + (int)(Math.random() * 99));
                            if (fof < 60) {
                               int hitRate = 30 + h.getContact()/3;
                               int hor = (0 + (int)(Math.random() * 99));
                               if (hitRate > hor) {
                                //System.out.println("Hit!");
                                int rangeHit = (0 + (int)(Math.random() * 50));
                                int hitPower = (h.getPower() + h.getSpeed())/3;
                                rangeHit += hitPower;
                                if (rangeHit <= 50) {
                                    //System.out.println("Single");
                                    return "Line Drive Single";
                                }
                                else if (rangeHit >50 && rangeHit <=90) {
                                    //System.out.println("Double");
                                    return "Line Drive Double";
                                }
                                else if (rangeHit >90 && rangeHit <=94) {
                                    //System.out.println("Triple");
                                    return "Line Drive Triple";
                                }
                                else {
                                    //System.out.println("Home-Run!");
                                    return "Line Drive Home Run";
                                }
                               }
                               else {
                                //System.out.println("Out");
                                return "Line Out";
                               }
                               
                            }
                            else {
                                //System.out.println("Foul Ball");
                                return "Line Drive Foul Ball";
                            }
                        }
                        else if (typeH.equals("Ground Ball")) {
                            int fof = (0 + (int)(Math.random() * 99));
                            if (fof < 75) {
                               int hitRate = 15 + h.getContact()/3;
                               int hor = (0 + (int)(Math.random() * 99));
                               if (hitRate > hor) {
                                //System.out.println("Hit!");
                                int rangeHit = (0 + (int)(Math.random() * 50));
                                int hitPower = (h.getPower() + h.getSpeed())/3;
                                rangeHit += hitPower;
                                if (rangeHit <= 40) {
                                    //System.out.println("Single");
                                    return "Ground Ball Single";
                                }
                                else if (rangeHit >40 && rangeHit <=80) {
                                    //System.out.println("Double");
                                    return "Ground Ball Double";
                                }
                                else if (rangeHit >80) {
                                    //System.out.println("Triple");
                                    return "Ground Ball Triple";
                                }
                               }
                               else {
                                //System.out.println("Out");
                                return "Ground Out";
                               }
                            }
                            else {
                                //System.out.println("Foul Ball");
                                return "Ground Ball Foul Ball";
                            }
                        }
                        else if (typeH.equals("Fly Ball")) {
                            int fof = (0 + (int)(Math.random() * 99));
                            if (fof < 60) {
                               int hitRate = 20 + h.getContact()/3;
                               int hor = (0 + (int)(Math.random() * 99));
                               if (hitRate > hor) {
                                //System.out.println("Hit!");
                                int rangeHit = (0 + (int)(Math.random() * 50));
                                int hitPower = (h.getPower() + h.getSpeed())/3;
                                rangeHit += hitPower;
                                if (rangeHit <= 40) {
                                    //System.out.println("Single");
                                    return "Fly Ball Single";
                                }
                                else if (rangeHit >40 && rangeHit <=70) {
                                    //System.out.println("Double");
                                    return "Fly Ball Double";
                                }
                                else if (rangeHit >70 && rangeHit <=80) {
                                    //System.out.println("Triple");
                                    return "Fly Ball Triple";
                                }
                                else {
                                    //System.out.println("Home Run");
                                    return "Fly Ball Home Run";
                                }
                               }
                               else {
                                //System.out.println("Out");
                                return "Fly Out";
                               }
                            }
                            else {
                                //System.out.println("Foul Ball");
                                return "Fly Ball Foul Ball";
                            }
                        }
                        else {
                            int fof = (0 + (int)(Math.random() * 99)); 
                            if (fof < 50) {
                                int slim = (0 + (int)(Math.random() * 99));
                                if (slim > 97) {
                                    //System.out.println("Infield Single");
                                    return "Infield Single";
                                }
                                else {
                                    //System.out.println("Infield Fly out");
                                    return "Infield Fly Out";
                                }
                            }
                            else {
                                //System.out.println("Infield Fly Foul Ball");
                                return "Infield Fly Foul Ball";
                            }
                        }
                    
                    }
                    else {
                        //System.out.println("Swing and Miss");
                        return "Swing and Miss";
                    }
                }
                else {
                    return "Swing and Miss";
                    
                }


            }
            else {
                //System.out.println("Ball Thrown");
                // Checks if he swung or not
                if (checkContact < 80) {
                    //System.out.println("Ball taken");
                    return "Ball";
                }
                else {
                    //System.out.println("Swing and Miss");
                    return "Swing and Miss";
                }
            }

        return "";
    }

    public static void main(String args[]) {
        Pitcher p  = new StartingPitcher(90, 90, 90);
        Hitter h = new Hitter(70, 70, 70, "1B");
        atBat a = new atBat(p, h);
        String s = a.simulateAtBat();
        //System.out.println(s);
    }
}
