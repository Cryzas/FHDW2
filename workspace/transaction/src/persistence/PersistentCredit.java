package persistence;


public interface PersistentCredit extends PersistentEntry, Credit4Public {
    
    public PersistentCredit getThis() throws PersistenceException ;
    
    

}

