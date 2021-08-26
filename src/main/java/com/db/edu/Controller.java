package com.db.edu;

import com.db.edu.message.EmptyMessage;
import com.db.edu.message.Message;
import com.db.edu.save.Saver;

public class Controller {
    private Message buffer = new EmptyMessage();
    private final Saver saver;

    public Controller(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if(!message.isStateEquals(buffer.getState())) {
            if(buffer.isNotEmpty()){
                saver.save(buffer.decorated());
                buffer.flush();
            }
            buffer = message;
        } else {
            if(!buffer.accumulate(message)) {
                saver.save(buffer.decorated());
                buffer = message;
                buffer.accumulate(message);
            }
        }
    }

    void flush() {
        if (buffer.isNotEmpty()) {
            saver.save(buffer.decorated());
            buffer.flush();
        }
    }
}
