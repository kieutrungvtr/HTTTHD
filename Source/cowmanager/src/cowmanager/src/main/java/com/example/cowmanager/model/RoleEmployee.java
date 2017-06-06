package com.example.cowmanager.model;

import java.io.Serializable;

public class RoleEmployee implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7115602981710815355L;

    private Integer id;

    private String description;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


}
