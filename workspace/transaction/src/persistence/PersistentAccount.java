package persistence;


public interface PersistentAccount extends Anything, AbstractPersistentProxi, Account4Public {
    
    public void setDescription(String newValue) throws PersistenceException ;
    public void setBalance(common.Fraction newValue) throws PersistenceException ;
    public PersistentAccount getThis() throws PersistenceException ;
    
    

}

