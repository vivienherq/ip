package dude.command;

import dude.Storage;
import dude.TaskList;
import dude.Ui;
import dude.task.Task;

import java.io.IOException;

/**
 * Represents a command that marks a task as done.
 */
public class MarkCommand extends Command {
    private int taskIndex;

    public MarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the command to mark a task as done.
     *
     * @param taskList List of tasks.
     * @param storage Storage containing saved tasks, and saves and loads tasks.
     * @param ui User interface of Dude.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        try {
            System.out.println("Executing Mark Command");;
            Task markedTask = taskList.markTask(taskIndex);
            ui.showMarkedTask(markedTask);
            storage.saveTasksToDisk(taskList);
        } catch (IOException e) {
            System.out.println("Error in Mark Command");
        }
    }
}
