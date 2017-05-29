package persistence;


public interface PersistentContainee extends Anything, FileTreeHIERARCHY, AbstractPersistentProxi, Containee4Public {
    
    public void setName(String newValue) throws PersistenceException ;
    public abstract PersistentContainee getThis() throws PersistenceException ;
    
    
    public DirectorySearchList getParent() 
				throws PersistenceException;

}

