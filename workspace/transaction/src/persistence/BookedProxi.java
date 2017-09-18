package persistence;



import model.visitor.*;

public class BookedProxi extends TransferStateProxi implements PersistentBooked{
    
    public BookedProxi(long objectId) {
        super(objectId);
    }
    public BookedProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 137;
    }
    
    public PersistentBooked getThis() throws PersistenceException {
        return ((PersistentBooked)this.getTheObject()).getThis();
    }
    
    public void accept(TransferStateVisitor visitor) throws PersistenceException {
        visitor.handleBooked(this);
    }
    public <R> R accept(TransferStateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooked(this);
    }
    public <E extends model.UserException>  void accept(TransferStateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooked(this);
    }
    public <R, E extends model.UserException> R accept(TransferStateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooked(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooked(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooked(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooked(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooked(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleBooked(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooked(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooked(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooked(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBooked)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooked)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentBooked)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentBooked)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBooked)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBooked)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBooked)this.getTheObject()).initializeOnInstantiation();
    }

    
}
