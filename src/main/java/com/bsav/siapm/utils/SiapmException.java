package com.bsav.siapm.utils;

public final class SiapmException extends Exception {
    private static final long serialVersionUID = 1L;
    private static final String nullMessage = "null parameter";
    private ReturnMessage message = null;

    public SiapmException(final Throwable e, final ReturnMessage msg) {
        super(e);
        assert e != null || msg != null : nullMessage;
        message = msg;
    }

    public SiapmException(final ReturnMessage msg) {
        super(msg.toString());
        message = msg;
    }

    public final ReturnMessage getReturnMessage() {
        return message;
    }

    public final void setMessage(final ReturnMessage msg) {
        assert msg != null : nullMessage;
        message = msg;
    }

    @Override
    public final String toString() {
        return "GestException " + message + ", [" + super.toString()
                + "]";
    }

}
