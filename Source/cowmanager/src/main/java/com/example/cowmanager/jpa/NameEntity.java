package com.example.cowmanager.jpa;

import javax.persistence.MappedSuperclass;

/**
 * The entity has ID and name.
 *
 * @author bacnguyen <br>
 * @version 1.0 <br>
 * @see #{@link IdEntity}
 */

@MappedSuperclass
public class NameEntity extends IdEntity {
    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 7558265456045836262L;
    /**
     * The name.
     */
    private String name;

    /**
     * Get the name attribute.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name attribute.
     *
     * @param value
     *            the name to set
     */
    public void setName(final String value) {
        this.name = value;
    }
}
