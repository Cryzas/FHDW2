package persistence;


public interface PersistentComponentLst extends Anything, AbstractPersistentProxi, ComponentLst4Public {
    
    public ComponentLst_PartsProxi getParts() throws PersistenceException ;
    public PersistentComponentLst getThis() throws PersistenceException ;
    
    

}

