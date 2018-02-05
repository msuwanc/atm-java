package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configurations {
    static Config conf = ConfigFactory.load();

    public static Long getTwentyNotes() {
        return conf.getLong("notes.twenty");
    }
    public static Long getFiftyNotes() {
        return conf.getLong("notes.fifty");
    }
    public static Long getHundredNotes() {
        return conf.getLong("notes.hundred");
    }
    public static Long getFiveHundredNotes() {
        return conf.getLong("notes.five_hundred");
    }
    public static Long getThousandNotes() {
        return conf.getLong("notes.thousand");
    }
}