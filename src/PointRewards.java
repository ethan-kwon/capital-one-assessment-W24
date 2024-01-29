import java.util.List;

// Class to handle calculating point rewards for the month
public class PointRewards {

    private final String SPORTCHECK = "sportcheck";
    private final String TIMHORTONS = "tim_hortons";
    private final String SUBWAY = "subway";

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
                case SUBWAY:
                    subwayCents += t.getAmount_cents();
                default:
                    otherCents += t.getAmount_cents();
            }
        }



        return points;
    }
}
