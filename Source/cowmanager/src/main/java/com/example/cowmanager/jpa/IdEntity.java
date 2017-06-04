package com.example.cowmanager.jpa;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * The entity contains ID only.
 *
 * @author bacnguyen <br>
 * @version 1.0 <br>
 */

@MappedSuperclass
public class IdEntity implements Serializable {
    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = -2629338155834093880L;
    /**
     * The ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Get the id attribute.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the id attribute.
     *
     * @param identity
     *            the id to set
     */
    public void setId(final Integer identity) {
        this.id = identity;
    }
}
