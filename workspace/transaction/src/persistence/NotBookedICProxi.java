package persistence;



import model.visitor.*;

public class NotBookedICProxi extends TransferStateICProxi implements PersistentNotBooked{
    
    public NotBookedICProxi(long objectId) {
        super(objectId);
    }
    public NotBookedICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theNotBookedFacade
            .getNotBooked(this.getId());
    }
    
    public long getClassId() {
        return 138;
    }
    
    public PersistentNotBooked getThis() throws PersistenceException {
        return ((PersistentNotBooked)this.getTheObject()).getThis();
    }
    
    public void accept(TransferStateVisitor visitor) throws PersistenceException {
        visitor.handleNotBooked(this);
    }
    public <R> R accept(TransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotBooked(this);
    }
    public <E extends model.UserException>  void accept(TransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotBooked(this);
    }
    public <R, E extends model.UserException> R accept(TransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotBooked(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotBooked(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotBooked(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotBooked(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotBooked(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNotBooked(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotBooked(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotBooked(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotBooked(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotBooked)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNotBooked)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNotBooked)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNotBooked)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNotBooked)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNotBooked)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNotBooked)this.getTheObject()).initializeOnInstantiation();
    }

    
}
