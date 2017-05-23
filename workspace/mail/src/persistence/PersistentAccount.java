package persistence;


public interface PersistentAccount extends PersistentabstractAcc, Account4Public {
    
    public void setInBox(Folder4Public newValue) throws PersistenceException ;
    public void setOutBox(Folder4Public newValue) throws PersistenceException ;
    public void setDrafts(Folder4Public newValue) throws PersistenceException ;
    public PersistentAccount getThis() throws PersistenceException ;
    
    

}

