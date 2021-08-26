package com.db.edu.message;

import com.db.edu.State;

public class CharMessage implements Message {
    private static final String CHAR_PREFIX = "char: ";
    private Character value = null;

    public CharMessage(Character value) {
        this.value = value;
    }

    @Override
    public String decorated() {
        return CHAR_PREFIX + value;
    }

    @Override
    public boolean isNotEmpty() {
        return value != null;
    }

    @Override
    public String getValue() {
        return String.valueOf(value);
    }

    @Override
    public void flush() {
    }

    @Override
    public boolean accumulate(Message message) {
        return false;
    }

    @Override
    public boolean isStateEquals(State state) {
        return state.equals(State.CHAR);
    }

    @Override
    public State getState() {
        return State.CHAR;
    }
}
