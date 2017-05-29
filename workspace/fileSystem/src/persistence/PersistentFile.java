package persistence;


public interface PersistentFile extends PersistentContainee, File4Public {
    
    public void setContents(String newValue) throws PersistenceException ;
    public PersistentFile getThis() throws PersistenceException ;
    
    

}

