package seedu.address.ui;

import static org.junit.Assert.assertTrue;
import static seedu.address.testutil.TypicalFlashcards.getTypicalFlashcards;

import org.junit.Test;

import guitests.guihandles.QuizPanelHandle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.flashcard.Flashcard;

public class QuizPanelTest extends GuiUnitTest {
    private static final ObservableList<Flashcard> TYPICAL_FLASHCARDS =
        FXCollections.observableList(getTypicalFlashcards());

    private static final ObservableValue<Integer> INTEGER_ZERO =
        new SimpleObjectProperty<>(0);

    private static final ObservableValue<Integer> INTEGER_ONE =
        new SimpleObjectProperty<>(1);

    @Test
    public void display() {
        QuizPanel panel = new QuizPanel(TYPICAL_FLASHCARDS, INTEGER_ONE, INTEGER_ZERO);
        uiPartRule.setUiPart(panel);
        assertCorrectDisplay(panel, TYPICAL_FLASHCARDS.size() + 1, 1, 0);
    }

    /**
     * Checks whether the panel given displays the expected numbers.
     *
     * @param panel the QuizPanel to check
     * @param size  the expected size of remaining cards
     * @param good  the expected number of good feedback
     * @param bad   the expected number of bad feedback
     */
    private void assertCorrectDisplay(QuizPanel panel, int size, int good, int bad) {
        guiRobot.pauseForHuman();

        QuizPanelHandle handle = new QuizPanelHandle(panel.getRoot());

        assertTrue(handle.equals(size, good, bad));
    }
}
