import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTest {
    PointRewards pointRewards = new PointRewards();

    @Test
    void exampleTest() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 2500, LocalDate.parse("2021-05-09")),
                        new Transaction("tim_hortons", 1000, LocalDate.parse("2021-05-10")),
                        new Transaction("the_bay", 500, LocalDate.parse("2021-05-10"))
                )
        );

        int points = pointRewards.getMaxPoints(transactionList);

        assertEquals(95, points);
    }

    @Test
    void sampleTest() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 21000, LocalDate.parse("2021-05-01")),
                        new Transaction("sportcheck", 8700, LocalDate.parse("2021-05-02")),
                        new Transaction("tim_hortons", 323, LocalDate.parse("2021-05-03")),
                        new Transaction("tim_hortons", 1267, LocalDate.parse("2021-05-04")),
                        new Transaction("tim_hortons", 2116, LocalDate.parse("2021-05-05")),
                        new Transaction("tim_hortons", 2211, LocalDate.parse("2021-05-06")),
                        new Transaction("subway", 1853, LocalDate.parse("2021-05-07")),
                        new Transaction("subway", 2153, LocalDate.parse("2021-05-08")),
                        new Transaction("sportcheck", 7326, LocalDate.parse("2021-05-09")),
                        new Transaction("tim_hortons", 1321, LocalDate.parse("2021-05-10"))
                )
        );

        int points = pointRewards.getMaxPoints(transactionList);

        assertEquals(1627, points);
    }

    @Test
    void zeroPoints() {
        List<Transaction> transactionList = new ArrayList<>();

        int points = pointRewards.getMaxPoints(transactionList);

        assertEquals(0, points);

        transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 0, LocalDate.parse("2021-05-01")),
                        new Transaction("tim_hortons", 3, LocalDate.parse("2021-05-06")),
                        new Transaction("subway", 99, LocalDate.parse("2021-05-07"))
                )
        );

        points = pointRewards.getMaxPoints(transactionList);

        assertEquals(0, points);
    }
}
