import com.google.inject.Guice;
import com.google.inject.Injector;
import models.Notes;
import services.AtmService;
import utils.CustomException;
import utils.Validations;

import java.util.Scanner;

public class Main {
    public static void println(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Module());
        AtmService atmService = injector.getInstance(AtmService.class);

        Scanner scan= new Scanner(System.in);

        println("We have many type of notes.(thousand, five hundred, hundred, fifty and twenty)");
        println("You can config them in application.conf file");
        println("");

        try {
            Boolean flag = true;

            while(flag) {
                println("How much do you want to withdraw?(positive number without decimal only): ");
                Long wantedCash = scan.nextLong();
                println("");

                if(Validations.isValidRequest(wantedCash)) {
                    try {
                        Notes notes = atmService.withdraw(wantedCash);

                        String message = "You've got " + notes.getThousand() + " thousand notes, " + notes.getFiveHundred() + " five hundred notes, " + notes.getHundred() + " hundred notes, " + notes.getFifty() + " fifty notes and " + notes.getTwenty() + " twenty notes.";

                        println(message);
                        println("Thank you.");
                        println("");
                    } catch (Exception e) {
                        flag = false;
                    }
                } else {
                    throw new CustomException("In an ATM with only 20, 50, 100, 500 and 1000 notes, it is not possible to dispense " + wantedCash);
                }
            }
        } catch (CustomException e){
            println(e.getMessage());
        } catch (Exception e){
            println("Positive number without decimal only!");
        }
    }
}