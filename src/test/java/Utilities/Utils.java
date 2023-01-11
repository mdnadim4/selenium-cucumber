package Utilities;

import java.util.Date;

public class Utils {
    public static String generateTimeStamp() {
        Date date = new Date();
        String timestamp = date.toString().replace(" ", "_").replace(":", "_");
        return timestamp;
    }
}
