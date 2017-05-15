package persistence;


public interface PersistentAccount extends PersistentAccountHandle, Account4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setBalance(common.Fraction newValue) throws PersistenceException ;
    public PersistentAccount getThis() throws PersistenceException ;
    
    

}

