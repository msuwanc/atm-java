package utils;

import models.Atm;
import models.Notes;

public class DatabaseConnection {
    private Notes notes = new Notes(Configurations.getTwentyNotes(), Configurations.getFiftyNotes(), Configurations.getHundredNotes(), Configurations.getFiveHundredNotes(), Configurations.getThousandNotes());

    private Atm atm = new Atm(notes, Calculation.calculateAvailableCash(notes));

    public Notes getNotes() {
        return this.notes;
    }

    public void setNotes(Notes notes) { this.notes = notes; }

    public Atm getAtm() {
        return this.atm;
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }
}