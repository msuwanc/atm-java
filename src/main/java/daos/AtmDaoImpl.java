package daos;

import com.google.inject.Inject;
import models.Atm;
import models.Notes;
import utils.Calculation;
import utils.DatabaseConnection;

public class AtmDaoImpl implements AtmDao {
    private final DatabaseConnection databaseConnection;

    @Inject
    public AtmDaoImpl(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    @Override
    public Atm remove(Notes notes) {
        Notes newNotes = Calculation.calculateNotes(databaseConnection.getAtm().getNotes(), notes);
        Long newCash = Calculation.calculateAvailableCash(newNotes);

        Atm newAtm = new Atm(newNotes, newCash);

        databaseConnection.setAtm(newAtm);

        return newAtm;
    }
}