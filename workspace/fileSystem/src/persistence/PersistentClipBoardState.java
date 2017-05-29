package persistence;


public interface PersistentClipBoardState extends Anything, AbstractPersistentProxi, ClipBoardState4Public {
    
    public abstract PersistentClipBoardState getThis() throws PersistenceException ;
    
    

}

