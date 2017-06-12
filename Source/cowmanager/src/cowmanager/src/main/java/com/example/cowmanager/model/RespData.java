package com.example.cowmanager.model;

/**
 * Common response structure.
 *
 * @param <D> the generic class
 * @author duynt <br>
 * @version 1.0 <br>
 * @see #(Related item)
 */
public class RespData<D> {

    /**
     * Result data.
     */
    private Integer result;

    /**
     *
     */
    private String message;

    /**
     * Response data.
     */
    private D data;

    /**
     * Get the content attribute.
     *
     * @return the content
     */
    public D getData() {
        return data;
    }

    /**
     * Set the data attribute.
     *
     * @param dt the data to set
     */
    public void setData(final D dt) {
        this.data = dt;
    }

    /**
     * Get the result attribute.
     *
     * @return the result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * Set the result attribute.
     *
     * @param res the result to set
     */
    public void setResult(final Integer res) {
        this.result = res;
    }

    /**
     * Get the message attribute.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message attribute.
     *
     * @param mess the message to set
     */
    public void setMessage(final String mess) {
        this.message = mess;
    }

}