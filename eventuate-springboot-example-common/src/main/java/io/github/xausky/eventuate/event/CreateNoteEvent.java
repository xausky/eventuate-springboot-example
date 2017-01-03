package io.github.xausky.eventuate.event;

/**
 * Created by xausky on 12/28/16.
 */
public class CreateNoteEvent extends NoteEvent {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
