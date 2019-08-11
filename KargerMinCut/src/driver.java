import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class driver {
    public static void main (String[] args) throws FileNotFoundException {
        File file = new File("kargerMinCut.txt");
        Graph graph = new Graph(file);
        MinCut cut = new MinCut();
        ArrayList<Integer> results = new ArrayList<>();
        int minCut = Integer.MAX_VALUE;
        int trial = 0;

        Random rand = new Random();
        int seed; //seed value to be used in individual trials;
        int n = graph.size();
        int total = (int)Math.ceil(Math.pow(n, 2) * Math.log(n));

        while (trial <= total) {
            seed = rand.nextInt(); //generate random seed value for each trial;
            int newCut = cut.kargerMinCut(graph, seed);
            minCut = Math.min(minCut, newCut); //update minCut to the smallest number seen;
            if (!results.contains(newCut)) results.add(newCut);
            graph = new Graph(file); //refresh graph;
            seed = rand.nextInt(); //use a different seed;
            trial++;

            System.out.println("trial# " + trial + ": " + minCut + "," + newCut); //for monitoring;
        }
    }
}
