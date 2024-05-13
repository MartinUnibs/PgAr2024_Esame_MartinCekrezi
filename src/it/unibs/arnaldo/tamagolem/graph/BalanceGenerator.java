package it.unibs.arnaldo.tamagolem.graph;

import java.util.HashMap;
import java.util.Map;

//TODO: DOC - solo metodi statici
public class BalanceGenerator {

    private static final String ROW_SUM = "R/%d";
    private static final String ROW_POSITIVES = "RP/%d";
    private static final String ROW_NEGATIVES = "RN/%d";
    private static final String COL_SUM = "C/%d";
    private static final String COL_POSITIVES = "CP/%d"; //TODO: useless??
    private static final String COL_NEGATIVES = "CN/%d"; //TODO: useless??
    private static final String TARGET = "T/%d";
    private static final int MIN_VALUE = 10;
    private static final int MAX_VALUE = 100;

    public static int[][] generateBalance(int size) {
        Map<String, Integer> map = new HashMap<>();
        initMap(map, size);
        int[][] graph = new int[size][size];
        for (int i = 0; i < size; i++) {
            if (map.get(String.format(ROW_SUM, i)) == 0 ||
                    (map.get(String.format(ROW_POSITIVES, i)) != 2 &&
                     map.get(String.format(ROW_NEGATIVES, i)) != 2)
                ) {
                //TODO: SET TARGET -> 10
            } else {
                //TODO: CALCULATE ACTUAL TARGET -> ES. 9 + 4 -> TARGET = 13
            }
            for (int j = 0; j < size; j++) {
                if (i == j) graph[i][j] = 0;
                else {
                    //TODO: generazione grafo
                    /*
                    * - generazione valore rispetto a:
                    * 1. target e somma della riga
                    * 2. somma della colonna
                    * 3. numero di positivi e negativi per riga e per colonna
                    *
                    * - aggiornamento mappa
                    *
                    * - aggiunta valore a graph[j][i] e aggiornamento mappa
                    * */
                }
            }
        }
        return graph;
    }

    private static void initMap(Map<String, Integer> map, int size) {
        for (int i = 0; i < size; i++) {
            map.put(String.format(ROW_SUM, i), 0);
            map.put(String.format(COL_SUM, i), 0);
            map.put(String.format(ROW_POSITIVES, i), 0);
            map.put(String.format(COL_POSITIVES, i), 0);
            map.put(String.format(ROW_NEGATIVES, i), 0);
            map.put(String.format(COL_NEGATIVES, i), 0);
        }
    }
}
