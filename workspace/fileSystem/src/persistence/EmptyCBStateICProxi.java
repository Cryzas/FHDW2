package persistence;



import model.visitor.*;

public class EmptyCBStateICProxi extends ClipBoardStateICProxi implements PersistentEmptyCBState{
    
    public EmptyCBStateICProxi(long objectId) {
        super(objectId);
    }
    public EmptyCBStateICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theEmptyCBStateFacade
            .getEmptyCBState(this.getId());
    }
    
    public long getClassId() {
        return 129;
    }
    
    public PersistentEmptyCBState getThis() throws PersistenceException {
        return ((PersistentEmptyCBState)this.getTheObject()).getThis();
    }
    
    public void accept(ClipBoardStateVisitor visitor) throws PersistenceException {
        visitor.handleEmptyCBState(this);
    }
    public <R> R accept(ClipBoardStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEmptyCBState(this);
    }
    public <E extends model.UserException>  void accept(ClipBoardStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEmptyCBState(this);
    }
    public <R, E extends model.UserException> R accept(ClipBoardStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEmptyCBState(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleEmptyCBState(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleEmptyCBState(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleEmptyCBState(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleEmptyCBState(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentEmptyCBState)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentEmptyCBState)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentEmptyCBState)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentEmptyCBState)this.getTheObject()).initializeOnInstantiation();
    }

    
}
