package persistence;


public interface PersistentDirectory extends PersistentContainee, Directory4Public {
    
    public PersistentDirectory getThis() throws PersistenceException ;
    
    

}

