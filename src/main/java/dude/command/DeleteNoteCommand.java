package dude.command;

import dude.note.Note;
import dude.note.NoteList;
import dude.task.TaskList;
import dude.ui.Ui;
import dude.util.Storage;

/**
 * Represents a command that deletes note.
 */
public class DeleteNoteCommand extends Command {
    private int noteIndex;

    public DeleteNoteCommand(int noteIndex) {
        this.noteIndex = noteIndex;
    }

    /**
     * Executes the command to delete a note.
     *
     * @param taskList List of tasks.
     * @param noteList List of notes.
     * @param storage Storage containing saved tasks and notes, and handles saving and loading.
     * @param ui User interface of Dude.
     */
    @Override
    public String execute(TaskList taskList, NoteList noteList, Ui ui, Storage storage) {
        Note deletedNote = noteList.deleteNote(noteIndex);
        int nNotes = noteList.getSize();
        String output = ui.showDeletedNote(deletedNote, nNotes) + "\n";
        storage.saveToDisk(taskList, noteList);
        return output;
    }
}
