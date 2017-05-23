package persistence;


public interface PersistentabstractAcc extends Anything, AbstractPersistentProxi, abstractAcc4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public abstract PersistentabstractAcc getThis() throws PersistenceException ;
    
    

}

