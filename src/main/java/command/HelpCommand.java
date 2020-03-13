package command;

import event.EventList;
import ui.Ui;

/**
 * Command is used to print the list of commands supported.
 */
public class HelpCommand extends Command {

    /**
     * Constructor for the HelpCommand object.
     * Creates a new object if the correct format is used.
     *
     * @param isOneWordCommand Denotes whether the user given input is single or multi worded.
     * @throws Exception If the wrong format is used.
     */
    public HelpCommand(boolean isOneWordCommand) throws Exception {
        if (!isOneWordCommand) {
            throw new Exception("Wrong command used to view command list (Should be :help )");
        }
    }

    @Override
    public void executeCommand(EventList eventList, Ui ui) {
        ui.printHelp();
    }
}
