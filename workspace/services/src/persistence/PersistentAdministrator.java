package persistence;


public interface PersistentAdministrator extends PersistentService, Administrator4Public {
    
    public PersistentAdministrator getThis() throws PersistenceException ;
    
    

}

