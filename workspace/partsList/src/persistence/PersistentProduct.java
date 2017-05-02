package persistence;


public interface PersistentProduct extends PersistentComponent, Product4Public {
    
    public void setComponents(ComponentLst4Public newValue) throws PersistenceException ;
    public PersistentProduct getThis() throws PersistenceException ;
    
    

}

