package persistence;


public interface PersistentFolder extends Anything, AbstractPersistentProxi, Folder4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public PersistentFolder getThis() throws PersistenceException ;
    
    

}

