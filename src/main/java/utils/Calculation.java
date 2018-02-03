package utils;

import models.Notes;

public class Calculation {
    public static Notes calculateNotes(Notes currentNotes, Notes reducedNotes) {
        return new Notes(
                currentNotes.getTwenty() - reducedNotes.getTwenty(),
                currentNotes.getFifty() - reducedNotes.getFifty(),
                currentNotes.getHundred() - reducedNotes.getHundred(),
                currentNotes.getFiveHundred() - reducedNotes.getFiveHundred(),
                currentNotes.getThousand() - reducedNotes.getThousand());
    }

    public static Long calculateAvailableCash(Notes notes) {
        return (notes.getTwenty() * Constants.TWENTY) +
                (notes.getFifty() * Constants.FIFTY) +
                (notes.getHundred() * Constants.HUNDRED) +
                (notes.getFiveHundred() * Constants.FIVE_HUNDRED) +
                (notes.getThousand() * Constants.THOUSAND);
    }
}