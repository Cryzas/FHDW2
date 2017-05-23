package persistence;


public interface PersistentAccountManager extends Anything, AbstractPersistentProxi, AccountManager4Public {
    
    public PersistentAccountManager getThis() throws PersistenceException ;
    
    

}

