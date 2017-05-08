package persistence;


public interface PersistentEntry extends Anything, AbstractPersistentProxi, Entry4Public {
    
    public void setDescription(String newValue) throws PersistenceException ;
    public void setAmount(common.Fraction newValue) throws PersistenceException ;
    public void setOtherAcc(Account4Public newValue) throws PersistenceException ;
    public abstract PersistentEntry getThis() throws PersistenceException ;
    
    

}

