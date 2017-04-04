package persistence;


public interface PersistentProduct extends PersistentComponent, Product4Public {
    
    public ComponentLst4Public getComponents() throws PersistenceException ;
    public void setComponents(ComponentLst4Public newValue) throws PersistenceException ;
    public PersistentProduct getThis() throws PersistenceException ;
    
    

}

