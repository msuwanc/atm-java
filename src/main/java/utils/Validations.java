package utils;

import java.util.function.Function;

public class Validations {
    public static Boolean isValidRequest(Long cash) {
        Function<Long[], Long> helper = notesList -> {
            Boolean flag = true;
            Long remaining = cash;

            for(int i = 0; i < 2 && flag; i++) {
                remaining = remaining % notesList[i];

                if(remaining == 0) flag = false;
            }

            return remaining;
        };

        Long[] notesList = { Constants.TWENTY, Constants.FIFTY };
        Long[] notesList2 = { Constants.FIFTY, Constants.TWENTY };

        return helper.apply(notesList) == 0 || helper.apply(notesList2) == 0;
    }
}