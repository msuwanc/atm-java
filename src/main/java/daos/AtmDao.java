package daos;

import models.Atm;
import models.Notes;

public interface AtmDao {
    public Atm remove(Notes notes);
}