package com.example.cowmanager.jpa;

import java.util.Map;

public interface IQuery {
    /**
     * <p>
     * Get SQL/HQL.
     * </p>
     *
     * @return {@link String}
     */
    String getSql();

    /**
     * <p>
     * Append a specific sql.
     * </p>
     *
     * @param sql {@link String}
     * @return {@link IQuery}
     */
    IQuery append(String sql);

    /**
     * <p>
     * Set a parameter.
     * </p>
     *
     * @param paramName  {@link String}
     * @param paramValue {@link Object}
     * @return {@link IQuery}
     */
    IQuery setParameter(String paramName, Object paramValue);

    /**
     * <p>
     * Get parameters.
     * </p>
     *
     * @return {@link Map}
     */
    Map<String, Object> getParameters();
}
