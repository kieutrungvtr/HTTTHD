package com.example.cowmanager.model;

/**
 * @author duynt
 */
public class CowManagerException extends Exception {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 636067642159417291L;

    /**
     * Constructor.
     *
     * @param message {@link String}
     */
    public CowManagerException(final String message) {
        this(message, null);
    }

    /**
     * Constructor.
     *
     * @param cause {@link Throwable}
     */
    public CowManagerException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructor.
     *
     * @param message {@link String}
     * @param cause   {@link Throwable}
     */
    public CowManagerException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
