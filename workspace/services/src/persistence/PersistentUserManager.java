package persistence;


public interface PersistentUserManager extends PersistentService, UserManager4Public {
    
    public PersistentUserManager getThis() throws PersistenceException ;
    
    

}

