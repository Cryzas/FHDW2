package persistence;


public interface PersistentMailEntry extends PersistentMail, MailEntry4Public {
    
    public void setSender(AccountWrapper4Public newValue) throws PersistenceException ;
    public PersistentMailEntry getThis() throws PersistenceException ;
    
    

}

