package models;

public class Atm {
    private Notes notes;
    private Long cash;

    public Atm(Notes notes, Long cash) {
        this.notes = notes;
        this.cash = cash;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        notes = notes;
    }
    public Long getCash() {
        return cash;
    }

    public void setCash(Long cash) {
        cash = cash;
    }
}