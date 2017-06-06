package com.example.cowmanager.jpa;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Locale;

public class EntityNamingStrategy extends PhysicalNamingStrategyStandardImpl implements Serializable {
    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = -8986781235158263017L;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EntityNamingStrategy.class);
    /**
     * The suffix.
     */
    private static final String CLASS_SUFFIX = "_entity";

    /*
     * (non-Javadoc)
     *
     * @see #org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl#
     * toPhysicalTableName( org.hibernate.boot.model.naming.Identifier,
     * org.hibernate.engine.jdbc.env.spi.JdbcEnvironment)
     */
    @Override
    public Identifier toPhysicalTableName(final Identifier name, final JdbcEnvironment context) {
        String txt = addUnderscores(name.getText());
        if (txt.endsWith(CLASS_SUFFIX)) {
            txt = txt.substring(0, txt.indexOf(CLASS_SUFFIX));
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Class[{}] is converted to table[{}]", name.getText(), txt);
        }
        return new Identifier(txt, name.isQuoted());
    }

    /*
     * (non-Javadoc)
     *
     * @see #org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl#
     * toPhysicalColumnName( org.hibernate.boot.model.naming.Identifier,
     * org.hibernate.engine.jdbc.env.spi.JdbcEnvironment)
     */
    @Override
    public Identifier toPhysicalColumnName(final Identifier name, final JdbcEnvironment context) {
        String txt = addUnderscores(name.getText());
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Class property[{}] is converted to column[{}]", name.getText(), txt);
        }
        return new Identifier(txt, name.isQuoted());
    }

    /**
     * <p>
     * Convert a name.
     * </p>
     *
     * @param name {@link String}
     * @return {@link String}
     */
    protected String addUnderscores(final String name) {
        final StringBuilder buf = new StringBuilder(name.replace('.', '_'));
        for (int i = 1; i < buf.length() - 1; i++) {
            if (Character.isLowerCase(buf.charAt(i - 1)) && Character.isUpperCase(buf.charAt(i))
                    && Character.isLowerCase(buf.charAt(i + 1))) {
                buf.insert(i++, '_');
            }
        }
        return buf.toString().toLowerCase(Locale.ROOT);
    }
}
