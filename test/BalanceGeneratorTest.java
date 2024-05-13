import it.kibo.fp.lib.AnsiColors;
import it.kibo.fp.lib.RandomDraws;
import it.unibs.arnaldo.tamagolem.game.TamaGolem;
import it.unibs.arnaldo.tamagolem.graph.BalanceGenerator;
import it.unibs.arnaldo.tamagolem.main.UserInteraction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BalanceGeneratorTest {

    private static final String GENERATION_MESSAGE = "Generazione grafo - grado difficoltà: %d";
    private static final String VALID_MESSAGE = "GRAFO VALIDO";
    private static final String INVALID_MESSAGE = "GRAFO NON VALIDO";
    private static final int N_RUNS = 10000;
    private static final int MIN_NODES = 3;
    private static final int MAX_NODES = 10;

    @Test
    public void GeneratorTest() {
        for (int i = 0; i < N_RUNS; i++) {
            int nodes = RandomDraws.drawInteger(MIN_NODES, MAX_NODES);
            UserInteraction.printColoredMessage(String.format(GENERATION_MESSAGE, nodes), AnsiColors.YELLOW);
            int[][] graph = BalanceGenerator.generateBalance(nodes);
            UserInteraction.printGraph();
            if (isValid(graph)) {
                UserInteraction.printColoredMessage(VALID_MESSAGE, AnsiColors.GREEN);
            } else {
                UserInteraction.printColoredMessage(INVALID_MESSAGE, AnsiColors.RED);
                Assert.fail();
            }
        }
        assertTrue(true);
    }

    private boolean isValid(int[][] graph) {
        int size = graph.length;
        int rowSum;
        for (int i = 0; i < size; i++) {
            rowSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += graph[i][j];
                if (i == j && graph[i][j] != 0) return false; // diagonal
                if (graph[i][j] > TamaGolem.MAX_HP) return false; // single cell
            }
            if (rowSum != 0) return false; // row
        }
        return true;
    }
}
