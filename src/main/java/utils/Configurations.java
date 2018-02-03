package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configurations {
    public static Long getTwentyNotes() {
        Config conf = ConfigFactory.load();
        return conf.getLong("notes.twenty");
    }
    public static Long getFiftyNotes() {
        Config conf = ConfigFactory.load();
        return conf.getLong("notes.fifty");
    }
    public static Long getHundredNotes() {
        Config conf = ConfigFactory.load();
        return conf.getLong("notes.hundred");
    }
    public static Long getFiveHundredNotes() {
        Config conf = ConfigFactory.load();
        return conf.getLong("notes.five_hundred");
    }
    public static Long getThousandNotes() {
        Config conf = ConfigFactory.load();
        return conf.getLong("notes.thousand");
    }
}