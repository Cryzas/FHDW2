package persistence;


public interface PersistentDraft extends PersistentMail, Draft4Public {
    
    public void setSender(AccountWrapper4Public newValue) throws PersistenceException ;
    public PersistentDraft getThis() throws PersistenceException ;
    
    

}

