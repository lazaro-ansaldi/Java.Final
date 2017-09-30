package sensefilms.interfaces;

import sensefilms.entities.BaseEntity;

interface IBaseRepository 
{
	public <T extends BaseEntity> void insert(T entity);
	public <T extends BaseEntity> T getOneById(int id);
	public <T extends BaseEntity> void update(T entity);
	public void deleteOneById(int id);
}
