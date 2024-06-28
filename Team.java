import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Team {
    private Hitter[] hitters;
    private Hitter[] bench;
    private Pitcher[] rotation;
    private Pitcher[] bullpen;
    private String TeamName;
    private String CityName;
    private int wins;
    private int losses;
    private int currentRotation;

    public Team(String location, String name) { 
        currentRotation = 0;
        TeamName = name;
        CityName = location;
        wins = 0;
        losses = 0;
        rotation = new StartingPitcher[5];
        hitters = new Hitter[9];
        bullpen = new ReliefPitcher[9];
        bench = new Hitter[9];
    }
    public void nextPitcher() {
        if (currentRotation==4) {
            currentRotation=0;
        }
        else {
            currentRotation++;
        }
    }
    public void generateStats() {
        for (int i = 0; i < 9; i++) {
            int stat1 = (int)(30+Math.random()*69);
            int stat2 = (int)(30+Math.random()*69);
            int stat3 = (int)(30+Math.random()*69);
            hitters[i] = new Hitter(stat1, stat2, stat3, "");
            stat1 = (int)(30+Math.random()*69);
            stat2 = (int)(30+Math.random()*69);
            stat3 = (int)(30+Math.random()*69);
            bench[i] = new Hitter(stat1, stat2, stat3, "");
            stat1 = (int)(30+Math.random()*69);
            stat2 = (int)(30+Math.random()*69);
            stat3 = (int)(30+Math.random()*69);
            bullpen[i] = new ReliefPitcher(stat1, stat2, stat3);
        }
        for (int i = 0; i< 5; i++) {
            int stat1 = (int)(30+Math.random()*69);
            int stat2 = (int)(30+Math.random()*69);
            int stat3 = (int)(30+Math.random()*69);
            rotation[i] = new StartingPitcher(stat1, stat2, stat3);
        }
        // Naming the players
        try{
        for (int i = 0; i < 9; i++) {
            try {
                InputStream is = new FileInputStream("names/first.txt");
                InputStream is1 = new FileInputStream("names/last.txt");
                Scanner sc = new Scanner(is);
                Scanner sc1 = new Scanner(is1);
                int first1 = (int) (1 + Math.random() * 500);
                int last1 = (int) (1 + Math.random() * 500);

                for (int j = 1; j <= first1 && sc.hasNextLine(); j++) {
                    hitters[i].setFirst(sc.nextLine());
                }
                for (int j = 1; j <= last1 && sc1.hasNextLine(); j++) {
                    hitters[i].setLast(sc1.nextLine());
                }
                sc.close();
                sc1.close();
            } catch(Exception e) {}
        }
        for (int i = 0; i < 9; i++) {
            try {
                InputStream is = new FileInputStream("names/first.txt");
                InputStream is1 = new FileInputStream("names/last.txt");
                Scanner sc = new Scanner(is);
                Scanner sc1 = new Scanner(is1);
                int first1 = (int) (1 + Math.random() * 500);
                int last1 = (int) (1 + Math.random() * 500);

                for (int j = 1; j <= first1 && sc.hasNextLine(); j++) {
                    bench[i].setFirst(sc.nextLine());
                }
                for (int j = 1; j <= last1 && sc1.hasNextLine(); j++) {
                    bench[i].setLast(sc1.nextLine());
                }
                sc.close();
                sc1.close();
            } catch(Exception e) {}
        }
        for (int i = 0; i < 5; i++) {
            try {
                InputStream is = new FileInputStream("names/first.txt");
                InputStream is1 = new FileInputStream("names/last.txt");
                Scanner sc = new Scanner(is);
                Scanner sc1 = new Scanner(is1);
                int first1 = (int) (1 + Math.random() * 500);
                int last1 = (int) (1 + Math.random() * 500);

                for (int j = 1; j <= first1 && sc.hasNextLine(); j++) {
                    rotation[i].setFirst(sc.nextLine());
                }
                for (int j = 1; j <= last1 && sc1.hasNextLine(); j++) {
                    rotation[i].setLast(sc1.nextLine());
                }
                sc.close();
                sc1.close();
            } catch(Exception e) {}
        }
        for (int i = 0; i < 9; i++) {
            try {
                InputStream is = new FileInputStream("names/first.txt");
                InputStream is1 = new FileInputStream("names/last.txt");
                Scanner sc = new Scanner(is);
                Scanner sc1 = new Scanner(is1);
                int first1 = (int) (1 + Math.random() * 500);
                int last1 = (int) (1 + Math.random() * 500);

                for (int j = 1; j <= first1 && sc.hasNextLine(); j++) {
                    bullpen[i].setFirst(sc.nextLine());
                }
                for (int j = 1; j <= last1 && sc1.hasNextLine(); j++) {
                    bullpen[i].setLast(sc1.nextLine());
                }
                sc.close();
                sc1.close();
            } catch(Exception e) {}
        }
            // Handle or log the exception for each iteration
    } catch(Exception e) {}
} 

    public void displayPlayers() {
        System.out.println("Lineup for the " + CityName + " " + TeamName);
        System.out.println("=========================================");
        System.out.println("Starting Lineup: ");
        for(int i = 0; i<9; i++) {
            System.out.print(hitters[i].getFirst()+ " " +hitters[i].getLast() + "\t");
            hitters[i].display();
        }
        System.out.println("");
        System.out.println("Starting Rotation: ");
        for (int i = 0; i<5; i++) { 
            System.out.print(rotation[i].getFirst()+ " " + rotation[i].getLast() + "\t");
            rotation[i].display();
        }
        System.out.println("");
        System.out.println("Bullpen: ");
        for(int i = 0; i<9; i++) {
            System.out.print(bullpen[i].getFirst()+ " " +bullpen[i].getLast() + "\t");
            bullpen[i].display();
        }
        System.out.println("");
        System.out.println("Bench: ");
        for (int i = 0; i < 9; i++) {
            System.out.print(bench[i].getFirst() + " " + bench[i].getLast() + "\t");
            bench[i].display();
        }
    }
    public void load() {
        
    }
    public void save() {
        PrintWriter writer = null; // Initialize PrintWriter outside try block
        try {
            File f = new File("teams/" + TeamName + ".txt");
            writer = new PrintWriter(f, "UTF-8");

            writer.println("Lineup for the " + CityName + " " + TeamName);
            writer.println("=========================================");
            writer.println("Starting Lineup: ");
            
            for (int i = 0; i < 9; i++) {
                writer.print(hitters[i].getFirst() + " " + hitters[i].getLast() + "\t");
                writer.println(hitters[i].display());
            }
            
            writer.println("");
            writer.println("Starting Rotation: ");
            
            for (int i = 0; i < 5; i++) {
                writer.print(rotation[i].getFirst() + " " + rotation[i].getLast() + "\t");
                writer.println(rotation[i].display());
            }
            
            writer.println("");
            writer.println("Bullpen: ");
            
            for (int i = 0; i < 9; i++) {
                writer.print(bullpen[i].getFirst() + " " + bullpen[i].getLast() + "\t");
                writer.println(bullpen[i].display());
            }
            
            writer.println("");
            writer.println("Bench: ");
            
            for (int i = 0; i < 9; i++) {
                writer.print(bench[i].getFirst() + " " + bench[i].getLast() + "\t");
                writer.println(bench[i].display());
            }

            } catch (FileNotFoundException e) {
                e.printStackTrace(); // Handle file not found exception
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace(); // Handle unsupported encoding exception
            } finally {
            if (writer != null) {
                writer.close(); // Close PrintWriter in the finally block to ensure it's always closed
            }
        }

    }

    public void changeStarter() {
        if (currentRotation == 4) {
            currentRotation = 0;
        }
        else {
            currentRotation++;
        }
    }
    public StartingPitcher getStarter() {
        return (StartingPitcher)rotation[currentRotation];
    }
    public Hitter[] getOrder() {
        return hitters;
    }
    public String getCity() {
        return CityName;
    }
    public String getName() {
        return TeamName;
    }

    public static void main(String[] args) {
        
    }
}
