package sensefilms.interfaces;

import java.sql.SQLException;

import sensefilms.entities.BaseEntity;

interface IBaseRepository 
{
	public <T extends BaseEntity> void insert(T entity) throws SQLException;
	public <T extends BaseEntity> T getOneById(int id) throws SQLException;
	public <T extends BaseEntity> void update(T entity) throws SQLException;
	public void deleteOneById(int id) throws SQLException;
}
