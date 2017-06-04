package com.example.cowmanager.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * The basic APIs for accessing tables.
 *
 * @author bacnguyen <br>
 * @version 1.0 <br>
 * @param <E>
 *            E
 * @param <ID>
 *            ID
 * @see #{@link JpaRepository}
 * @see #{@link JpaSpecificationExecutor}
 */

public interface IRepository<E, ID extends Serializable> extends
        JpaRepository<E, ID>, JpaSpecificationExecutor<E> {
    /**
     * <p>
     * Find one entity by a specific field name.
     * </p>
     *
     * @param fieldName
     *            {@link String}
     * @param fieldValue
     *            {@link Object}
     * @param fetchColumns
     *            array of columns to be fetched
     * @return <E> E
     */
    E findOneByColumn(String fieldName, Object fieldValue, String...
            fetchColumns);

}
