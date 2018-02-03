package utils;

public class Validations {
    public static Boolean isValidRequest(Long cash) {
        Long remaining = cash;

        Long[] notesList = {
                Constants.THOUSAND,
                Constants.FIVE_HUNDRED,
                Constants.HUNDRED,
                Constants.FIFTY,
                Constants.TWENTY
        };

        Boolean flag = true;

        for(int i = 0; i < 5 && flag; i++) {
            remaining = remaining % notesList[i];

            if(remaining == 0) flag = false;
        }

        return remaining == 0;
    }
}