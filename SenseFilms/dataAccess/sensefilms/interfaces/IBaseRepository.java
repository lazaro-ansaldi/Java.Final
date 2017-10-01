package sensefilms.interfaces;

import java.sql.SQLException;

import sensefilms.entities.BaseEntity;

interface IBaseRepository<T extends BaseEntity> 
{
	public void insert(T entity) throws SQLException;
	public T getOneById(int id) throws SQLException;
	public void update(T entity) throws SQLException;
	public void deleteOneById(int id) throws SQLException;
}
