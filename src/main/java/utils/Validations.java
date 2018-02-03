package utils;

import fj.data.Array;

import static fj.data.Array.array;

public class Validations {
    public static Boolean isValidRequest(Long cash) {
        final Array<Long> listValidValue = array(
            Constants.TWENTY,
            Constants.FIFTY,
            Constants.HUNDRED,
            Constants.FIVE_HUNDRED,
            Constants.THOUSAND);

        return !listValidValue.forall(validValue -> (cash % validValue) != 0);
    }
}