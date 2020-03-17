import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class driver {
    public static void main (String[] args) throws FileNotFoundException {
        File file = new File("../kargerMinCut.txt");
        //File file = new File("test.txt");
        Graph graph = new Graph(file); 
        MinCut cut = new MinCut();
        int trial = 0;

        Random rand = new Random();
        int seed; //seed value to be used in individual trials;
        int n = graph.size();
        int total = (int)Math.ceil(Math.pow(n, 2) * Math.log(n)); //default: try n^2log(n) times to find minimum
        int[] minReg = new int[2]; //track value and occurences of new minimum value to pause at a reasonable time;
        minReg[0] = Integer.MAX_VALUE;

        while (trial <= total) {
            seed = rand.nextInt(); //generate random seed value for each trial;
            int minCut = minReg[0];
            int newCut = cut.kargerMinCut(graph, seed);
            //update minCut to the smallest number seen;
            if (minCut > newCut) {
                minReg[0] = newCut;
                minReg[1] = 1;
            } else if (minCut == newCut) minReg[1]++;
            graph = new Graph(file); //refresh graph;
            seed = rand.nextInt(); //use a different seed for next trial;
            trial++;

            System.out.println("trial# " + trial + ": min = " + minReg[0] + ", new val = " + newCut); //for monitoring;
            int instance = minReg[1];
            if ( instance == 100) {
                System.out.println("trial ended, found minimum cut: " + minReg[0]);
                break;
            }
        }
    }
}
