package persistence;


public interface PersistentTransaction extends bookableHierarchyHIERARCHY, PersistentBookable, Transaction4Public {
    
    public PersistentTransaction getThis() throws PersistenceException ;
    
    

}

