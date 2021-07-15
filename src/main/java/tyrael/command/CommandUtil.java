package tyrael.command;

import java.io.IOException;

public class CommandUtil {
    public static void exec(String command) {
        Runtime run =Runtime.getRuntime();
        try {
            run.exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
