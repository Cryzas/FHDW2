package persistence;


public interface PersistentComponent extends Anything, AbstractPersistentProxi, Component4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public void setPrice(common.Fraction newValue) throws PersistenceException ;
    public abstract PersistentComponent getThis() throws PersistenceException ;
    
    

}

