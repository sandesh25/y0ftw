package com.system.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.system.service.ObjectService;

public abstract class ObjectServiceImpl<T> implements ObjectService<T> {
	@PersistenceContext(unitName = "TestPersistentUnit")
	protected EntityManager entityManager;

	public ObjectServiceImpl() {}

	@Override
	@Transactional
	public T add(T newObject) {
		entityManager.persist(newObject);
		return newObject;
	}

	@Override
	@Transactional
	public void update(T existingObj) {
		entityManager.merge(existingObj);
	}

	@Override
	public T get(Long id) {
		List<T> resultList = getAll(Arrays.asList(id));
		return resultList.size() > 0 ? resultList.get(0) : null;
	}

	@Override
	public List<T> getAll(List<Long> ids) {
		return entityManager.createQuery("from " + getObjectClass().getName() + " where id in(:ids)", getObjectClass()).setParameter("ids", ids).getResultList();
	}

	@Override
	public T get(String key, String keyName) {
		List<T> resultList = getAllObjects(Arrays.asList(key), keyName);
		return resultList.size() > 0 ? resultList.get(0) : null;
	}

	@Override
	public List<T> getAllObjects(List<String> keys, String keyName) {
		return entityManager.createQuery("from " + getObjectClass().getName() + " where " + keyName + " in(:keys)", getObjectClass()).setParameter("keys", keys).getResultList();
	}

	@Override
	public List<T> list() {
		return entityManager.createQuery("from " + getObjectClass().getName(), getObjectClass()).getResultList();
	}

	public List<T> search(String fieldName, String value) {
		return search(fieldName, (Object) value);
	}

	@Override
	public List<T> search(String fieldName, Object value) {
		String whereClause = fieldName + "=(:value)";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		return search(whereClause, params);
	}

	@Override
	public List<T> search(String whereClause, Map<String, Object> params) {
		TypedQuery<T> query = prepareQuery(whereClause, params);
		return query.getResultList();
	}

	@Override
	public List<T> search(String whereClause, Map<String, Object> params, int recordCount) {
		TypedQuery<T> query = prepareQuery(whereClause, params);
		query.setMaxResults(recordCount);
		return query.getResultList();
	}

	public TypedQuery<T> prepareQuery(String whereClause, Map<String, Object> params) {
		TypedQuery<T> query = entityManager.createQuery("from " + getObjectClass().getName() + " where " + whereClause, getObjectClass());
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		deleteAll(Arrays.asList(id));
	}

	@Override
	@Transactional
	public void deleteAll(List<Long> ids) {
		entityManager.createQuery("delete from " + getObjectClass().getName() + " where id in(:ids)").setParameter("ids", ids).executeUpdate();
	}

	@Override
	@Transactional
	public void delete(String key, String keyName) {
		deleteAllObjects(Arrays.asList(key), keyName);
	}

	@Override
	@Transactional
	public void deleteAllObjects(List<String> keys, String keyName) {
		entityManager.createQuery("delete from " + getObjectClass().getName() + " where " + keyName + " in(:keys)").setParameter("keys", keys).executeUpdate();
	}
}
