package utils;

import models.Notes;

import java.util.function.Function;

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

    public static java.util.Map.Entry<Long, Long> calculateNotesAndRemains(Long cashValue, Long noteType) {
        Function<Long, java.util.Map.Entry<Long, Long>> calculateHelper = noteTypeValue -> {
            if(cashValue > noteTypeValue) {
                return new java.util.AbstractMap.SimpleEntry<Long, Long>(cashValue / noteTypeValue, cashValue % noteTypeValue);
            } else {
                return new java.util.AbstractMap.SimpleEntry<Long, Long>(0L, cashValue);
            }
        };

        java.util.Map.Entry<Long, Long> result = new java.util.AbstractMap.SimpleEntry<Long, Long>(0L, cashValue);

        switch (noteType.intValue()) {
            case 20: result = calculateHelper.apply(20L);
                break;
            case 50: result = calculateHelper.apply(50L);
                break;
            case 100: result = calculateHelper.apply(100L);
                break;
            case 500: result = calculateHelper.apply(500L);
                break;
            case 1000: result = calculateHelper.apply(1000L);
                break;
            default: result = result;
                break;
        }

        return result;
    }

    public static Notes calculateNotesFromCash(Long cash) {
        java.util.Map.Entry<Long, Long> thousandNotesAndRemains = calculateNotesAndRemains(cash,1000L);
        java.util.Map.Entry<Long, Long> fiveHundredNotesAndRemains = calculateNotesAndRemains(thousandNotesAndRemains.getValue(),500L);
        java.util.Map.Entry<Long, Long> hundredNotesAndRemains = calculateNotesAndRemains(fiveHundredNotesAndRemains.getValue(),100L);
        java.util.Map.Entry<Long, Long> fiftyNotesAndRemains = calculateNotesAndRemains(hundredNotesAndRemains.getValue(),50L);
        java.util.Map.Entry<Long, Long> twentyNotesAndRemains = calculateNotesAndRemains(fiftyNotesAndRemains.getValue(),20L);

        return new Notes(twentyNotesAndRemains.getKey(), fiftyNotesAndRemains.getKey(), hundredNotesAndRemains.getKey(), fiveHundredNotesAndRemains.getKey(), thousandNotesAndRemains.getKey());
    }
}