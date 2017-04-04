package persistence;


public interface PersistentQuantifiedComponent extends Anything, AbstractPersistentProxi, QuantifiedComponent4Public {
    
    public void setQuantity(long newValue) throws PersistenceException ;
    public void setComponent(Component4Public newValue) throws PersistenceException ;
    public PersistentQuantifiedComponent getThis() throws PersistenceException ;
    
    

}

