package persistence;



import model.visitor.*;

public class DebitProxi extends EntryProxi implements PersistentDebit{
    
    public DebitProxi(long objectId) {
        super(objectId);
    }
    public DebitProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 116;
    }
    
    public PersistentDebit getThis() throws PersistenceException {
        return ((PersistentDebit)this.getTheObject()).getThis();
    }
    
    public void accept(EntryVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends model.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends model.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDebit)this.getTheObject()).initializeOnInstantiation();
    }

    
}
