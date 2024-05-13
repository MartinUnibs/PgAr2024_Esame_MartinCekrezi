package it.unibs.arnaldo.tamagolem.graph;

//TODO: DOC - l'indice della matrice è quello della lista elements
public class BalanceManager {
    //TODO: everything

    private int[][] graph = { //TODO: to remove
            {0, 1, -4, -6, 9},
            {-1, 0, -9, 9, 1},
            {4, 9, 0, -10, -3},
            {6, -9, 10, 0, -7},
            {-9, -1, 3, 7, 0},
    };

    public BalanceManager(int nodes) {
        //TODO: da fare
        //this.graph = BalanceGenerator.generateBalance(nodes);
    }

    public int getDamage(int p1, int p2) {
        //TODO: ritorna la mat[p1][p2];
        return 0;
    }

}
