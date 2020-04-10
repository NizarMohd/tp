package exception.command;

import exception.CustomException;

public class MisuseOfClearCommandException extends CustomException {

    public static final String INVALID_CLEAR_COMMAND = "Wrong command to clear events (Should be :clear )";

    public MisuseOfClearCommandException() {
        super(INVALID_CLEAR_COMMAND);
    }
}
