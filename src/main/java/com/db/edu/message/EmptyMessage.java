package com.db.edu.message;

import com.db.edu.State;

public class EmptyMessage implements Message {
    @Override
    public String decorated() {
        return null;
    }

    @Override
    public boolean isNotEmpty() {
        return false;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public Message flush() {
        return new EmptyMessage();
    }

    @Override
    public Message accumulate(Message message) {
        return new EmptyMessage();
    }

    @Override
    public boolean isStateEquals(Message message) {
        return false;
    }

    @Override
    public State getState() {
        return State.EMPTY;
    }

    @Override
    public boolean isStateNotEquals(Message message) {
        return !isStateEquals(message);
    }
}
