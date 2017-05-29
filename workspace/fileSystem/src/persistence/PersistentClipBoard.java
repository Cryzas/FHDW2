package persistence;


public interface PersistentClipBoard extends Anything, AbstractPersistentProxi, ClipBoard4Public {
    
    public void setState(ClipBoardState4Public newValue) throws PersistenceException ;
    public PersistentClipBoard getThis() throws PersistenceException ;
    
    

}

