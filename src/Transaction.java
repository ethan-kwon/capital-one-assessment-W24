import java.time.LocalDate;

public class Transaction {
    private int amount_cents;
    private String name;
    private LocalDate date;

    Transaction(String name, int amount_cents, LocalDate date) {
        this.date = date;
        this.name = name;
        this.amount_cents = amount_cents;
    }

    Transaction(String name, int amount_cents) {
        this.name = name;
        this.amount_cents = amount_cents;
    }

    public int getAmount_cents() {
        return amount_cents;
    }

    public String getName() {
        return name;
    }
}
