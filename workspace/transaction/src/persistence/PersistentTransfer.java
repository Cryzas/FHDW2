package persistence;


public interface PersistentTransfer extends PersistentAbstractTransfer, Transfer4Public {
    
    public void setFromAccount(Account4Public newValue) throws PersistenceException ;
    public void setToAccount(Account4Public newValue) throws PersistenceException ;
    public void setAmount(common.Fraction newValue) throws PersistenceException ;
    public PersistentTransfer getThis() throws PersistenceException ;
    
    

}

