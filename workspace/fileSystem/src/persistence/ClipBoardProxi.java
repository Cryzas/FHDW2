package persistence;



import model.visitor.*;

public class ClipBoardProxi extends PersistentProxi implements PersistentClipBoard{
    
    public ClipBoardProxi(long objectId) {
        super(objectId);
    }
    public ClipBoardProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 130;
    }
    
    public ClipBoardState4Public getState() throws PersistenceException {
        return ((PersistentClipBoard)this.getTheObject()).getState();
    }
    public void setState(ClipBoardState4Public newValue) throws PersistenceException {
        ((PersistentClipBoard)this.getTheObject()).setState(newValue);
    }
    public PersistentClipBoard getThis() throws PersistenceException {
        return ((PersistentClipBoard)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleClipBoard(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleClipBoard(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleClipBoard(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleClipBoard(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentClipBoard)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentClipBoard)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void copy(final Containee4Public containee) 
				throws PersistenceException{
        ((PersistentClipBoard)this.getTheObject()).copy(containee);
    }
    public void deleteClipped() 
				throws PersistenceException{
        ((PersistentClipBoard)this.getTheObject()).deleteClipped();
    }
    public Containee4Public fetchClipped() 
				throws model.FileSystemException, PersistenceException{
        return ((PersistentClipBoard)this.getTheObject()).fetchClipped();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentClipBoard)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentClipBoard)this.getTheObject()).initializeOnInstantiation();
    }

    
}
