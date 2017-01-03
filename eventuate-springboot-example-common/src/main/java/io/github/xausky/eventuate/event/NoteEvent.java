package io.github.xausky.eventuate.event;

import io.eventuate.Event;
import io.eventuate.EventEntity;

/**
 * Created by xausky on 12/28/16.
 */
@EventEntity(entity = "io.github.xausky.eventuate.NoteAggregate")
public abstract class NoteEvent implements Event{
}
