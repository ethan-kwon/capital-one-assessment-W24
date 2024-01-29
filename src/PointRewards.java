import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Class to handle calculating point rewards for the month
public class PointRewards {
    private final String SPORTCHECK = "sportcheck";
    private final String TIMHORTONS = "tim_hortons";
    private final String SUBWAY = "subway";
    private final int CENTS_TO_DOLLAR = 100;

    public int findMaxPoints(List<Transaction> transactionList) {
        int sportcheckCents = 0;
        int timHortonsCents = 0;
        int subwayCents = 0;
        int otherCents = 0;

        for (Transaction t : transactionList) {
            switch (t.getName()) {
                case SPORTCHECK:
                    sportcheckCents += t.getAmount_cents();
                    break;
                case TIMHORTONS:
                    timHortonsCents += t.getAmount_cents();
                    break;
                case SUBWAY:
                    subwayCents += t.getAmount_cents();
                    break;
                default:
                    otherCents += t.getAmount_cents();
                    break;
            }
        }

        int sportCheckDollars = sportcheckCents / CENTS_TO_DOLLAR;
        int timHortonsDollars = timHortonsCents / CENTS_TO_DOLLAR;
        int subwayDollars = subwayCents / CENTS_TO_DOLLAR;
        int otherDollars = otherCents / CENTS_TO_DOLLAR;

        int points = recursive(sportCheckDollars, timHortonsDollars, subwayDollars, 0);
        points += otherDollars;

        return points;
    }

    public int recursive(int sportCheckDollars, int timHortonsDollars, int subwayDollars, int points) {
        List<Integer> list = new ArrayList<>();

        if (sportCheckDollars == 0 && timHortonsDollars == 0 && subwayDollars == 0) {
            return points;
        }

        if (sportCheckDollars >= 75 && timHortonsDollars >= 25 && subwayDollars >= 25) {
            list.add(recursive(
                    sportCheckDollars - 75,
                    timHortonsDollars - 25,
                    subwayDollars - 25,
                    points + 500));
        }

        if (sportCheckDollars >= 20) {
            list.add(recursive(sportCheckDollars - 20, timHortonsDollars, subwayDollars,
                    points + 75));
        }

        if (sportCheckDollars >= 25 && timHortonsDollars >= 10 && subwayDollars >= 10) {
            list.add(recursive(sportCheckDollars - 25,
                    timHortonsDollars - 10,
                    subwayDollars - 10,
                    points + 150));
        }

        if (sportCheckDollars >= 75 && timHortonsDollars >= 25) {
            list.add(recursive(sportCheckDollars - 75,
                    timHortonsDollars - 25,
                    subwayDollars,
                    points + 300));
        }

        list.add(points + sportCheckDollars + timHortonsDollars + subwayDollars);

        return Collections.max(list);
    }
}
