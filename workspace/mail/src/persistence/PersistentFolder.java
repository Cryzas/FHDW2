package persistence;


public interface PersistentFolder extends Anything, AbstractPersistentProxi, Folder4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public PersistentFolder getThis() throws PersistenceException ;
    
    
    public AccountSearchList inverseGetDrafts() 
				throws PersistenceException;
    public AccountSearchList inverseGetFolders() 
				throws PersistenceException;
    public AccountSearchList inverseGetInBox() 
				throws PersistenceException;
    public AccountSearchList inverseGetOutBox() 
				throws PersistenceException;

}

