package sensefilms.interfaces;

import java.sql.SQLException;

import sensefilms.entities.BaseEntity;
import sensefilms.exceptions.LoggedException;

interface IBaseRepository<T extends BaseEntity> 
{
	public void insert(T entity) throws SQLException, LoggedException;
	public T getOneById(int id) throws SQLException, LoggedException;
	public void update(T entity) throws SQLException, LoggedException;
	public void deleteOneById(int id) throws SQLException, LoggedException;
}
