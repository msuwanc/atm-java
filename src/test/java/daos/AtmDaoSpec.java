package daos;

import daos.AtmDao;
import daos.AtmDaoImpl;
import models.Atm;
import models.Notes;
import org.junit.Test;
import utils.Calculation;
import utils.DatabaseConnection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtmDaoSpec {
    @Test
    public void removeSuccess() {
        // Mock
        DatabaseConnection fakeDatabaseConnection = mock(DatabaseConnection.class);

        Long twentyNotes = 5l;
        Long fiftyNotes = 2l;
        Long hundredNotes = 8l;
        Long fiveHundredNotes = 2l;
        Long thousandNotes = 98l;

        Notes fakeNotes = new Notes(twentyNotes, fiftyNotes, hundredNotes, fiveHundredNotes, thousandNotes);
        Atm fakeAtm = new Atm(fakeNotes, Calculation.calculateAvailableCash(fakeNotes));

        when(fakeDatabaseConnection.getAtm()).thenReturn(fakeAtm);

        AtmDao atmDao = new AtmDaoImpl(fakeDatabaseConnection);

        // Arguments
        Notes reducedNotes = new Notes(1l, 1l, 1l, 1l, 1l);

        Notes newNotes = Calculation.calculateNotes(fakeNotes, reducedNotes);

        Long newCash = Calculation.calculateAvailableCash(newNotes);

        // Test
        Atm expectedResult = new Atm(newNotes, newCash);
        Atm result = atmDao.remove(reducedNotes);

        assertEquals(expectedResult.getCash(), result.getCash());
        assertEquals(result.getNotes().getTwenty(), expectedResult.getNotes().getTwenty());
        assertEquals(result.getNotes().getFifty(), expectedResult.getNotes().getFifty());
        assertEquals(result.getNotes().getHundred(), expectedResult.getNotes().getHundred());
        assertEquals(result.getNotes().getFiveHundred(), expectedResult.getNotes().getFiveHundred());
        assertEquals(result.getNotes().getThousand(), expectedResult.getNotes().getThousand());
    }
}