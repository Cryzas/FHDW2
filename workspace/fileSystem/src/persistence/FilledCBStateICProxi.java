package persistence;



import model.visitor.*;

public class FilledCBStateICProxi extends ClipBoardStateICProxi implements PersistentFilledCBState{
    
    public FilledCBStateICProxi(long objectId) {
        super(objectId);
    }
    public FilledCBStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theFilledCBStateFacade
            .getFilledCBState(this.getId());
    }
    
    public long getClassId() {
        return 128;
    }
    
    public Containee4Public getContents() throws PersistenceException {
        return ((PersistentFilledCBState)this.getTheObject()).getContents();
    }
    public void setContents(Containee4Public newValue) throws PersistenceException {
        ((PersistentFilledCBState)this.getTheObject()).setContents(newValue);
    }
    public PersistentFilledCBState getThis() throws PersistenceException {
        return ((PersistentFilledCBState)this.getTheObject()).getThis();
    }
    
    public void accept(ClipBoardStateVisitor visitor) throws PersistenceException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends model.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends model.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFilledCBState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleFilledCBState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleFilledCBState(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleFilledCBState(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleFilledCBState(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentFilledCBState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentFilledCBState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentFilledCBState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentFilledCBState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
