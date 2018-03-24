package com.sensefilms.repositories.contracts;

import java.sql.SQLException;

import com.sensefilms.business.entities.BaseEntity;

public interface IBaseRepository<T extends BaseEntity> 
{
	public void insert(T entity) throws SQLException;
	public T getOneById(int id) throws SQLException;
	public void update(T entity) throws SQLException;
	public void deleteOneById(int id) throws SQLException;
}
