package persistence;


public interface PersistentTransfer extends Anything, AbstractPersistentProxi, Transfer4Public {
    
    public void setDescription(String newValue) throws PersistenceException ;
    public void setAmount(common.Fraction newValue) throws PersistenceException ;
    public void setFromAcc(Account4Public newValue) throws PersistenceException ;
    public void setToAcc(Account4Public newValue) throws PersistenceException ;
    public PersistentTransfer getThis() throws PersistenceException ;
    
    

}

