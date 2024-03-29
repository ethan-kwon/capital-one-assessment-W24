import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Class to test my solution
public class TransactionTest {
    PointRewards pointRewards = new PointRewards();

    // Example 4 from the Problem Statement
    @Test
    void exampleTest() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 2500, LocalDate.parse("2021-05-09")),
                        new Transaction("tim_hortons", 1000, LocalDate.parse("2021-05-10")),
                        new Transaction("the_bay", 500, LocalDate.parse("2021-05-10"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(95, points);
    }

    // Sample Test from the Problem Statement
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

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(1677, points);
    }

    // Test for Rule 1
    @Test
    void rule1() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 7500, LocalDate.parse("2021-05-01")),
                        new Transaction("tim_hortons", 2500, LocalDate.parse("2021-05-03")),
                        new Transaction("subway", 2500, LocalDate.parse("2021-05-03"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(500, points);
    }

    // Test for Rule 2
    @Test
    void rule2() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 7500, LocalDate.parse("2021-05-01")),
                        new Transaction("tim_hortons", 2500, LocalDate.parse("2021-05-03"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(300, points);
    }

    // Test for Rule 3. Note that the amount is larger due to the use of other rules
    @Test
    void rule3() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 7500, LocalDate.parse("2021-05-01"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(240, points);
    }

    // Test for Rule 4
    @Test
    void rule4() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 2500, LocalDate.parse("2021-05-01")),
                        new Transaction("tim_hortons", 1000, LocalDate.parse("2021-05-03")),
                        new Transaction("subway", 1000, LocalDate.parse("2021-05-03"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(150, points);
    }

    // Test for Rule 5. Note that the points is larger since we can get a larger point value using other rules
    @Test
    void rule5() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 2500, LocalDate.parse("2021-05-01")),
                        new Transaction("tim_hortons", 1000, LocalDate.parse("2021-05-03"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(90, points);
    }

    // Test for Rule 6
    @Test
    void rule6() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 2000, LocalDate.parse("2021-05-01"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(75, points);
    }

    // Test for Rule 7
    @Test
    void rule7() {
        List<Transaction> transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 500, LocalDate.parse("2021-05-01")),
                        new Transaction("tim_hortons", 300, LocalDate.parse("2021-05-03")),
                        new Transaction("subway", 200, LocalDate.parse("2021-05-03"))
                )
        );

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(10, points);
    }



    @Test
    void zeroPoints() {
        List<Transaction> transactionList = new ArrayList<>();

        int points = pointRewards.findMaxPoints(transactionList);

        assertEquals(0, points);

        transactionList = new ArrayList<>(
                Arrays.asList(
                        new Transaction("sportcheck", 0, LocalDate.parse("2021-05-01")),
                        new Transaction("tim_hortons", 3, LocalDate.parse("2021-05-06")),
                        new Transaction("subway", 99, LocalDate.parse("2021-05-07"))
                )
        );

        points = pointRewards.findMaxPoints(transactionList);

        assertEquals(0, points);
    }
}
