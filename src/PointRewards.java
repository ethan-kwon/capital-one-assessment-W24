import java.util.List;

// Class to handle calculating point rewards for the month
public class PointRewards {

    private final String SPORTCHECK = "sportcheck";
    private final String TIMHORTONS = "tim_hortons";
    private final String SUBWAY = "subway";
    private final int CENTS_TO_DOLLAR = 100;

    public int getMaxPoints(List<Transaction> transactionList) {
        int sportcheckCents = 0;
        int timHortonsCents = 0;
        int subwayCents = 0;
        int otherCents = 0;
        int points = 0;

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


        while (sportCheckDollars >= 75 && timHortonsDollars >= 25 && subwayDollars >= 25) {
            sportCheckDollars -= 75;
            timHortonsDollars -= 25;
            subwayDollars -= 25;
            points += 500;
        }

        while (sportCheckDollars >= 20) {
            sportCheckDollars -= 20;
            points += 75;
        }

        while (sportCheckDollars >= 25 && timHortonsDollars >= 10 && subwayDollars >= 10) {
            sportCheckDollars -= 25;
            timHortonsDollars -= 10;
            subwayDollars -= 10;
            points += 150;
        }

        while (sportCheckDollars >= 75 && timHortonsDollars >= 25) {
            sportCheckDollars -= 75;
            timHortonsDollars -= 25;
            points += 300;
        }

        while (sportCheckDollars >= 75) {
            sportCheckDollars -= 75;
            points += 200;
        }

        while (sportCheckDollars >= 25 && timHortonsDollars >= 10) {
            sportCheckDollars -= 25;
            timHortonsDollars -= 10;
            points += 75;
        }

        points += sportCheckDollars;
        points += timHortonsDollars;
        points += subwayDollars;
        points += otherDollars;

        return points;
    }
}
