package com.cs.payment;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.EnumSet;
import java.util.Set;

/**
 * @author Joakim Gottzén
 */
public class OperationType implements UserType {
    private final Logger logger = LoggerFactory.getLogger(OperationType.class);

    @Override
    public int[] sqlTypes() {
        return new int[]{Types.VARCHAR};
    }

    @Override
    public Class returnedClass() {
        return Set.class;
    }

    @Override
    public boolean equals(final Object x, final Object y)
            throws HibernateException {
        if (!(x instanceof Set && y instanceof Set)) {
            return false;
        }

        final Set xSet = (Set) x;
        final Set ySet = (Set) y;

        return xSet.equals(ySet);
    }

    @Override
    public int hashCode(final Object x)
            throws HibernateException {
        return x.hashCode();
    }

    @Nullable
    @Override
    public Object nullSafeGet(final ResultSet rs, final String[] names, final SessionImplementor session, final Object owner)
            throws HibernateException, SQLException {
        final String dbData = rs.getString(names[0]);
        if (Strings.isNullOrEmpty(dbData)) {
            return EnumSet.noneOf(Operation.class);
        }

        final Iterable<String> strings = Splitter.on(";").split(dbData);
        final EnumSet<Operation> operations = EnumSet.noneOf(Operation.class);
        for (final String operation : strings) {
            try {
                operations.add(Operation.valueOf(operation));
            } catch (final IllegalArgumentException | NullPointerException e) {
                logger.error("Operation {} cannot be mapped to any of the Operation values [{}]", operation, Operation.values());
            }
        }
        return operations;
    }

    @Override
    public void nullSafeSet(final PreparedStatement st, final Object value, final int index, final SessionImplementor session)
            throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.VARCHAR);
            return;
        }

        @SuppressWarnings("unchecked") final Set<Operation> operations = (Set<Operation>) value;
        final String joined = Joiner.on(";").join(operations);
        st.setString(index, joined);
    }

    @Nullable
    @Override
    public Object deepCopy(final Object value)
            throws HibernateException {
        if (value == null) {
            return null;
        }

        @SuppressWarnings("unchecked") final Set<Operation> operations = (Set<Operation>) value;
        return EnumSet.copyOf(operations);
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(final Object value)
            throws HibernateException {
        return (Serializable) value;
    }

    @Override
    public Object assemble(final Serializable cached, final Object owner)
            throws HibernateException {
        return cached;
    }

    @Override
    public Object replace(final Object original, final Object target, final Object owner)
            throws HibernateException {
        return original;
    }
}
