package persistence;


public interface PersistentFileSystem extends Anything, AbstractPersistentProxi, FileSystem4Public {
    
    public void setSystemRoot(Directory4Public newValue) throws PersistenceException ;
    public void setClipBoard(ClipBoard4Public newValue) throws PersistenceException ;
    public PersistentFileSystem getThis() throws PersistenceException ;
    
    

}

