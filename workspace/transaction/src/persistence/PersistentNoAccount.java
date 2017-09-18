package persistence;


public interface PersistentNoAccount extends PersistentAccount, NoAccount4Public {
    
    public PersistentNoAccount getThis() throws PersistenceException ;
    
    

}

