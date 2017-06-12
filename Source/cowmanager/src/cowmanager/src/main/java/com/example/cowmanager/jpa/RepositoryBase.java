package com.example.cowmanager.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.query.QueryUtils;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.Map.Entry;


public class RepositoryBase<E extends IdEntity, ID extends Serializable>
        implements IRepository<E, ID> {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(
            RepositoryBase.class);
    /**
     * The internal repository.
     *
     * @see #{@link SimpleJpaRepository}
     */
    private SimpleJpaRepository<E, ID> repository;
    /**
     * The {@link EntityManager}.
     */
    private EntityManager entityManager;
    /**
     * The entity class.
     */
    private Class<E> entityClass;

    /**
     * <p>
     * Returns current value of entityManager attribute.
     * </p>
     *
     * @return the entityManager
     */
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * <p>
     * Sets value of entityManager attribute.
     * </p>
     *
     * @param manager the entityManager to set
     */
    @PersistenceContext
    protected void setEntityManager(final EntityManager manager) {
        this.entityManager = manager;
    }

    /**
     * <p>
     * Returns current value of entityClass attribute.
     * </p>
     *
     * @return the entityClass
     */
    protected Class<E> getEntityClass() {
        return entityClass;
    }

    /**
     * <p>
     * Initialize.
     * </p>
     */
    @SuppressWarnings("unchecked")
    @PostConstruct
    protected void init() {
        final ParameterizedType superclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        entityClass = (Class<E>) superclass.getActualTypeArguments()[0];
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initialize repository for entity: " + entityClass);
        }
        final JpaEntityInformation<E, ID> entityInfo =
                (JpaEntityInformation<E, ID>) JpaEntityInformationSupport
                        .getEntityInformation(getEntityClass(), getEntityManager());
        repository = new SimpleJpaRepository<E, ID>(entityInfo
                , getEntityManager());
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.jpa.repository.JpaRepository#deleteAllInBatch()
     */
    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.jpa.repository.JpaRepository#deleteInBatch(java
     * .lang.Iterable)
     */
    @Override
    public void deleteInBatch(final Iterable<E> entities) {
        repository.deleteInBatch(entities);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.jpa.repository.JpaRepository#findAll()
     */
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.jpa.repository.JpaRepository#findAll(org.
     * springframework.data.domain.Sort)
     */
    @Override
    public List<E> findAll(final Sort sort) {
        return repository.findAll(sort);
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.jpa.repository.JpaRepository#findAll(java.lang.
     * Iterable)
     */
    @Override
    public List<E> findAll(final Iterable<ID> ids) {
        return repository.findAll(ids);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.jpa.repository.JpaRepository#flush()
     */
    @Override
    public void flush() {
        repository.flush();
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.jpa.repository.JpaRepository#getOne(java.io.
     * Serializable)
     */
    @Override
    public E getOne(final ID id) {
        return repository.findOne(id);
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.jpa.repository.JpaRepository#save(java.lang.
     * Iterable)
     */
    @Override
    public <S extends E> List<S> save(final Iterable<S> entities) {
        return repository.save(entities);
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.jpa.repository.JpaRepository#saveAndFlush(S)
     */
    @Override
    public <S extends E> S saveAndFlush(final S entity) {
        return repository.saveAndFlush(entity);
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.repository.PagingAndSortingRepository#findAll(
     * org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<E> findAll(final Pageable pageable) {
        return repository.findAll(pageable);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.repository.CrudRepository#count()
     */
    @Override
    public long count() {
        return repository.count();
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.repository.CrudRepository#delete(java.io.
     * Serializable)
     */
    @Override
    public void delete(final ID id) {
        repository.delete(id);
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.repository.CrudRepository#delete(java.lang.
     * Object)
     */
    @Override
    public void delete(final E entity) {
        repository.delete(entity);
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.repository.CrudRepository#delete(java.lang.
     * Iterable)
     */
    @Override
    public void delete(final Iterable<? extends E> entities) {
        repository.delete(entities);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.repository.CrudRepository#deleteAll()
     */
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.repository.CrudRepository#exists(java.io.
     * Serializable)
     */
    @Override
    public boolean exists(final ID id) {
        return repository.exists(id);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.repository.CrudRepository#findOne(java.io.
     * Serializable)
     */
    @Override
    public E findOne(final ID id) {
        return repository.findOne(id);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.repository.CrudRepository#save(S)
     */
    @Override
    public <S extends E> S save(final S entity) {
        return repository.save(entity);
    }

    /*
     * (non-Javadoc)
     * @see
     * #org.springframework.data.jpa.repository.JpaSpecificationExecutor#count(
     * org.springframework.data.jpa.domain.Specification)
     */
    @Override
    public long count(final Specification<E> spec) {
        return repository.count(spec);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.jpa.repository.JpaSpecificationExecutor#
     * findAll( org.springframework.data.jpa.domain.Specification)
     */
    @Override
    public List<E> findAll(final Specification<E> spec) {
        return repository.findAll(spec);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.jpa.repository.JpaSpecificationExecutor#
     * findAll( org.springframework.data.jpa.domain.Specification,
     * org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<E> findAll(final Specification<E> spec
            , final Pageable pageable) {
        return repository.findAll(spec, pageable);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.jpa.repository.JpaSpecificationExecutor#
     * findAll( org.springframework.data.jpa.domain.Specification,
     * org.springframework.data.domain.Sort)
     */
    @Override
    public List<E> findAll(final Specification<E> spec, final Sort sort) {
        return repository.findAll(spec, sort);
    }

    /*
     * (non-Javadoc)
     * @see #org.springframework.data.jpa.repository.JpaSpecificationExecutor#
     * findOne( org.springframework.data.jpa.domain.Specification)
     */
    @Override
    public E findOne(final Specification<E> spec) {
        return repository.findOne(spec);
    }

    /**
     * <p>
     * Find one record and fetch column(s).
     * </p>
     *
     * @param spec         {@link Specification}
     * @param fetchColumns Array of strings
     * @return E
     */
    protected E findOne(final Specification<E> spec, final String...
            fetchColumns) {
        final List<E> list = findList(spec, null, fetchColumns);
        if (null != list && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    /**
     * <p>
     * Create a IQuery.
     * </p>
     *
     * @param sql {@link String}
     * @return {@link IQuery}
     */
    protected IQuery createQuery(final String sql) {
        final IQuery query = new IQuery() {
            private final StringBuilder sql = new StringBuilder();
            private final Map<String, Object> params = new HashMap<>();

            @Override
            public IQuery setParameter(final String paramName
                    , final Object paramValue) {
                params.put(paramName, paramValue);
                return this;
            }

            @Override
            public String getSql() {
                return sql.toString();
            }

            @Override
            public IQuery append(final String sql) {
                if (null != sql) {
                    this.sql.append(sql);
                }
                return this;
            }

            @Override
            public Map<String, Object> getParameters() {
                return params;
            }
        };
        query.append(sql);
        return query;
    }

    /**
     * <p>
     * Find one entity.
     * </p>
     *
     * @param query {@link IQuery}
     * @return {@link Object}
     */
    protected Object findOne(final IQuery query) {
        final Query execQuery = getEntityManager().createQuery(query.getSql());
        for (Entry<String, Object> param : query.getParameters().entrySet()) {
            execQuery.setParameter(param.getKey(), param.getValue());
        }
        return execQuery.getSingleResult();
    }

    /**
     * <p>
     * Find all records.
     * </p>
     *
     * @param query {@link IQuery}
     * @return {@link List}
     */
    @SuppressWarnings("unchecked")
    protected List<E> findAll(final IQuery query) {
        final Query execQuery = getEntityManager().createQuery(query.getSql());
        for (Entry<String, Object> param : query.getParameters().entrySet()) {
            execQuery.setParameter(param.getKey(), param.getValue());
        }
        return execQuery.getResultList();
    }

    /**
     * <p>
     * Execute update an {@link IQuery}.
     * </p>
     *
     * @param query {@link IQuery}
     * @return int
     */
    protected int executeUpdate(final IQuery query) {
        final Query execQuery = getEntityManager().createQuery(query.getSql());
        for (Entry<String, Object> param : query.getParameters().entrySet()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Bind parameter: [{}]->[{}]"
                        , param.getKey(), param.getValue());
            }
            execQuery.setParameter(param.getKey(), param.getValue());
        }
        final int result = execQuery.executeUpdate();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("result[{}]", result);
        }
        return result;
    }

    /**
     * <p>
     * Query a list of entities.
     * </p>
     *
     * @param query {@link IQuery}
     * @return {@link List}
     */
    @SuppressWarnings("unchecked")
    protected List<E> execute(final IQuery query) {
        final Query execQuery = getEntityManager().createQuery(query.getSql());
        for (Entry<String, Object> param : query.getParameters().entrySet()) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Bind parameter: [{}]->[{}]"
                        , param.getKey(), param.getValue());
            }
            execQuery.setParameter(param.getKey(), param.getValue());
        }
        return execQuery.getResultList();
    }

    /*
     * (non-Javadoc)
     * @see #dit.framework.jpa.IRepository#findOneByColumn(java.lang.String,
     * java.lang.Object, java.lang.String[])
     */
    @Override
    public E findOneByColumn(final String fieldName
            , final Object fieldValue, final String... fetchColumns) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("fieldName[{}], fieldValue[{}]", fieldName
                    , fieldValue);
            if (null != fetchColumns && fetchColumns.length > 0) {
                LOGGER.debug("fetchColumns{}", Arrays.asList(fetchColumns));
            }
        }
        final Specification<E> spec = new Specification<E>() {
            @Override
            public Predicate toPredicate(final Root<E> root
                    , final CriteriaQuery<?> query, final CriteriaBuilder cb) {
                if (String.class.equals(fieldValue.getClass())) {
                    return cb.equal(cb.lower(root.get(fieldName))
                            , fieldValue.toString().toLowerCase());
                } else {
                    return cb.equal(root.get(fieldName), fieldValue);
                }
            }
        };
        final List<E> list = findList(spec, null, fetchColumns);
        if (null != list && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * <p>
     * Find a list.
     * </p>
     *
     * @param spec         {@link Specification}
     * @param sort         {@link Sort} - It can be null
     * @param fetchColumns Array of column names.
     * @return {@link List}
     */
    protected List<E> findList(final Specification<E> spec, final Sort sort
            , final String... fetchColumns) {
        final TypedQuery<E> query = applyFetch(getEntityClass(), spec, sort
                , fetchColumns);
        return query.getResultList();
    }

    /**
     * <p>
     * Apply a specification with fetch columns.
     * </p>
     *
     * @param clazzEntity  {@link Class}
     * @param spec         {@link Specification}
     * @param sort         {@link Sort}
     * @param fetchColumns String[]
     * @param <D>          D
     * @return {@link TypedQuery}
     */
    private <D> TypedQuery<D> applyFetch(final Class<D> clazzEntity
            , final Specification<D> spec, final Sort sort,
                                         final String... fetchColumns) {
        final CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<D> cq = cb.createQuery(clazzEntity);
        final Root<D> root = cq.from(clazzEntity);
        // Fetch columns
        if (null != fetchColumns && fetchColumns.length > 0) {
            for (String column : fetchColumns) {
                final String[] array = column.split("\\.+");
                Fetch<Object, Object> fetch = null;
                for (String child : array) {
                    if (null == fetch) {
                        fetch = root.fetch(child, JoinType.LEFT);
                    } else {
                        fetch = fetch.fetch(child, JoinType.LEFT);
                    }
                }
            }
        }
        cq.select(root).where(spec.toPredicate(root, cq, cb));
        if (null != sort && null != sort.iterator()) {
            final List<javax.persistence.criteria.Order> jpaOrders
                    = QueryUtils.toOrders(sort, root, cb);
            cq.orderBy(jpaOrders);
        }
        final TypedQuery<D> query = getEntityManager().createQuery(cq);
        return query;
    }

    /**
     * Find a page.
     *
     * @param spec         {@link Specification}
     * @param pageable     {@link Pageable}
     * @param fetchColumns String[] - Array of column names. <br>
     *                     Note that if it is in format column1.column2 means fetch
     *                     column1 then column2
     * @return {@link Page}
     */
    protected Page<E> findPage(final Specification<E> spec
            , final Pageable pageable, final String... fetchColumns) {
        return findPage(getEntityClass(), spec, pageable, fetchColumns);
    }

    /**
     * <p>
     * Find a page of entities.
     * </p>
     *
     * @param clazzEntity  {@link Class}
     * @param spec         {@link Specification}
     * @param pageable     {@link Pageable}
     * @param fetchColumns array of {@link String}
     * @param <D>          D
     * @return D
     */
    protected <D> Page<D> findPage(final Class<D> clazzEntity
            , final Specification<D> spec, final Pageable pageable,
                                   final String... fetchColumns) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Entity class: {}", clazzEntity);
        }
        final long total = getCountQuery(clazzEntity, spec).getSingleResult();

        final TypedQuery<D> query = applyFetch(clazzEntity, spec
                , pageable.getSort(), fetchColumns);
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        List<D> content;
        if (total > pageable.getOffset()) {
            content = query.getResultList();
        } else {
            content = Collections.emptyList();
        }
        return new PageImpl<D>(content, pageable, total);
    }

    /**
     * <p>
     * Build count-query based on a specification.
     * </p>
     *
     * @param clazzEntity {@link Class}
     * @param spec        {@link Specification}
     * @param <D>         D
     * @return D
     */
    private <D> TypedQuery<Long> getCountQuery(final Class<D> clazzEntity
            , final Specification<D> spec) {
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<Long> query = builder.createQuery(Long.class);
        final Root<D> root = applySpecificationToCriteria(clazzEntity
                , spec, query);
        if (query.isDistinct()) {
            query.select(builder.countDistinct(root));
        } else {
            query.select(builder.count(root));
        }
        return getEntityManager().createQuery(query);
    }

    /**
     * <p>
     * Apply a specification to a criteria.
     * </p>
     *
     * @param clazzEntity {@link Class}
     * @param spec        {@link Specification}
     * @param query       {@link CriteriaQuery}
     * @param <D>         D
     * @param <S>         S
     * @return {@link Root}
     */
    private <D, S> Root<D> applySpecificationToCriteria(final Class<D>
                                                                clazzEntity, final Specification<D> spec, final
                                                        CriteriaQuery<S> query) {
        final Root<D> root = query.from(clazzEntity);
        if (spec == null) {
            return root;
        }
        final CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        final Predicate predicate = spec.toPredicate(root, query, builder);
        if (predicate != null) {
            query.where(predicate);
        }
        return root;
    }

    /**
     * <p>
     * Create a LIKE predicate then AND with inputed predicate.
     * </p>
     *
     * @param predicate  {@link Predicate}
     * @param root       {@link Root}
     * @param cb         {@link CriteriaBuilder}
     * @param columnName String
     * @param value      {@link Predicate}
     * @param ignoreCase boolean
     * @param <X>        X
     * @return {@link Predicate}
     */
    protected <X> Predicate andLikeFromEnd(final Predicate predicate
            , final Root<X> root, final CriteriaBuilder cb
            , final String columnName, final String value
            , final boolean ignoreCase) {
        Predicate pred;
        @SuppressWarnings("unchecked") final Expression<String> path = (Expression<String>) getPath(root
                , columnName);
        if (ignoreCase) {
            pred = cb.and(predicate, cb.like(cb.lower(path), "%"
                    + value.toLowerCase()));
        } else {
            pred = cb.and(predicate, cb.like(path, "%" + value));
        }
        return pred;
    }

    /**
     * <p>
     * Create a LIKE predicate then AND with inputed predicate.
     * </p>
     *
     * @param predicate  {@link Predicate}
     * @param root       {@link Root}
     * @param cb         {@link CriteriaBuilder}
     * @param columnName String
     * @param value      {@link Predicate}
     * @param ignoreCase boolean
     * @param <X>        X
     * @return {@link Predicate}
     */
    protected <X> Predicate andLike(final Predicate predicate
            , final Root<X> root, final CriteriaBuilder cb
            , final String columnName, final String value
            , final boolean ignoreCase) {
        Predicate pred;
        @SuppressWarnings("unchecked") final Expression<String> path = (Expression<String>) getPath(
                root, columnName);
        if (ignoreCase) {
            pred = cb.and(predicate, cb.like(cb.lower(path), "%"
                    + value.toLowerCase() + "%"));
        } else {
            pred = cb.and(predicate, cb.like(path, "%" + value + "%"));
        }
        return pred;
    }

    /**
     * <p>
     * Create a LIKE predicate.
     * </p>
     *
     * @param root       {@link Root}
     * @param cb         {@link CriteriaBuilder}
     * @param columnName {@link String}
     * @param value      {@link String}
     * @param ignoreCase boolean
     * @param <X>        X
     * @return {@link Predicate}
     */
    protected <X> Predicate like(final Root<X> root, final CriteriaBuilder cb
            , final String columnName, final String value
            , final boolean ignoreCase) {
        Predicate pred;
        @SuppressWarnings("unchecked") final Expression<String> path = (Expression<String>) getPath(
                root, columnName);
        if (ignoreCase) {
            pred = cb.like(cb.lower(path), "%" + value.toLowerCase() + "%");
        } else {
            pred = cb.like(path, "%" + value + "%");
        }
        return pred;
    }

    /**
     * <p>
     * Create a LIKE predicate then OR with inputed predicate.
     * </p>
     *
     * @param predicate  {@link Predicate}
     * @param root       {@link Root}
     * @param cb         {@link CriteriaBuilder}
     * @param columnName String
     * @param value      {@link Predicate}
     * @param ignoreCase boolean
     * @param <X>        X
     * @return {@link Predicate}
     */
    protected <X> Predicate orLike(final Predicate predicate, final Root<X> root
            , final CriteriaBuilder cb, final String columnName
            , final String value
            , final boolean ignoreCase) {
        Predicate pred;
        @SuppressWarnings("unchecked") final Expression<String> path = (Expression<String>) getPath(
                root, columnName);
        if (ignoreCase) {
            pred = cb.or(predicate, cb.like(cb.lower(path), "%"
                    + value.toLowerCase() + "%"));
        } else {
            pred = cb.or(predicate, cb.like(path, "%" + value + "%"));
        }
        return pred;
    }

    /**
     * <p>
     * Get a path.
     * </p>
     *
     * @param root       {@link Root}
     * @param columnName {@link String}
     * @param <X>        X
     * @return {@link Path}
     */
    private <X> Path<X> getPath(final Root<X> root, final String columnName) {
        final String[] array = columnName.split("\\.+");
        Path<X> path = null;
        for (String child : array) {
            if (null == path) {
                path = root.get(child);
            } else {
                path = path.get(child);
            }
        }
        return path;
    }

    @Override
    public <S extends E> List<S> findAll(Example<S> example) {
        return findAll(example);
    }

    @Override
    public <S extends E> List<S> findAll(Example<S> example, Sort sort) {
        return findAll(example, sort);
    }

    @Override
    public <S extends E> long count(Example<S> arg0) {
        return count(arg0);
    }

    @Override
    public <S extends E> boolean exists(Example<S> arg0) {
        return exists(arg0);
    }

    @Override
    public <S extends E> Page<S> findAll(Example<S> arg0, Pageable arg1) {
        return findAll(arg0, arg1);
    }

    @Override
    public <S extends E> S findOne(Example<S> arg0) {
        return findOne(arg0);
    }
}
