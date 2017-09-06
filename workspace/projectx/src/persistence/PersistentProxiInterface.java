package persistence;

public interface PersistentProxiInterface extends AbstractPersistentProxi {
	
	public PersistentRoot getTheObject() throws PersistenceException;
	public void setObject(PersistentRoot object);
	public String toString(boolean inner)throws PersistenceException;
	public Anything getThis() throws PersistenceException;

}