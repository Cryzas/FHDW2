package persistence;


public interface PersistentManager extends Anything, AbstractPersistentProxi, Manager4Public {
    
    public PersistentManager getThis() throws PersistenceException ;
    
    

}

