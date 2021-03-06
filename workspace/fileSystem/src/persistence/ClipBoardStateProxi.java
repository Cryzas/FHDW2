package persistence;



public abstract class ClipBoardStateProxi extends PersistentProxi implements PersistentClipBoardState{
    
    public ClipBoardStateProxi(long objectId) {
        super(objectId);
    }
    public ClipBoardStateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public abstract PersistentClipBoardState getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentClipBoardState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentClipBoardState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentClipBoardState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentClipBoardState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
