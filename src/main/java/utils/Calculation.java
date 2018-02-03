package utils;

import models.Atm;
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

    public static Notes calculateNotesFromCashBasedOnAtm(Long cash, Atm atm) throws CustomException {
        Boolean flag = true;

        Long[] notesValueList = {
                Constants.THOUSAND,
                Constants.FIVE_HUNDRED,
                Constants.HUNDRED,
                Constants.FIFTY,
                Constants.TWENTY
        };

        Long[] notesInAtm = {
                atm.getNotes().getThousand(),
                atm.getNotes().getFiveHundred(),
                atm.getNotes().getHundred(),
                atm.getNotes().getFifty(),
                atm.getNotes().getTwenty()
        };

        Long remaining = cash;
        Long[] newNotesList = { 0L, 0L, 0L, 0L, 0L };

        for(int i = 0; i < notesValueList.length && flag; i++) {
            // Handle twenty note problem when 50 round occur
            // Ex. Wanted 60 but get 50 with remaining that make error occurred.
            if(i == 3) {
                if(remaining == 20 || remaining == 40 || remaining == 60 || remaining == 80) remaining = remaining;
                else {
                    newNotesList[i] = remaining / notesValueList[i];

                    if(newNotesList[i] > notesInAtm[i]) {
                        newNotesList[i] = notesInAtm[i];

                        if(newNotesList[i] != 0) remaining = remaining - (newNotesList[i] * notesValueList[i]);
                    } else {
                        if(newNotesList[i] != 0) remaining = remaining - (newNotesList[i] * notesValueList[i]);
                    }

                    if(remaining == 0) flag = false;
                }
            } else {
                newNotesList[i] = remaining / notesValueList[i];

                if(newNotesList[i] > notesInAtm[i]) {
                    newNotesList[i] = notesInAtm[i];

                    if(newNotesList[i] != 0) remaining = remaining - (newNotesList[i] * notesValueList[i]);
                } else {
                    if(newNotesList[i] != 0) remaining = remaining - (newNotesList[i] * notesValueList[i]);
                }

                if(remaining == 0) flag = false;
            }
        }

        if(remaining == 0) {
            return new Notes(newNotesList[4], newNotesList[3], newNotesList[2], newNotesList[1], newNotesList[0]);
        }
        else {
            if(cash > atm.getCash()) {
                throw new CustomException("Currently, We've run out of cash(we only have " + atm.getCash() + "). Please come back later.");
            } else if(remaining % 20 == 0) {
                throw new CustomException("Currently, We've run out of twenty notes(we only have " + atm.getNotes().getTwenty() + "). Please come back later.");
            } else if(remaining % 50 == 0) {
                throw new CustomException("Currently, We've run out of fifty notes(we only have " + atm.getNotes().getFifty() + "). Please come back later.");
            } else {
                throw new CustomException("Currently, We've run out of cash(we only have " + atm.getCash() + "). Please come back later.");
            }
        }
    }
}