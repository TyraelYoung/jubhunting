package tyrael.android;

public class AndroidStringFileNameUtil {
    public static String getValueDirName(String language) {
        if ("default".equals(language)) {
            return "values";
        } else {
            return String.format("values-%s", language);
        }
    }

    public static String getLanguage(String name) {
        if (name.equals("values")) {
            return "default";
        } else {
            int index = name.indexOf("-");
            return name.substring(index + 1);
        }
    }
}
