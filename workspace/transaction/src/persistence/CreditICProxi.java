package persistence;



import model.visitor.*;

public class CreditICProxi extends EntryICProxi implements PersistentCredit{
    
    public CreditICProxi(long objectId) {
        super(objectId);
    }
    public CreditICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCreditFacade
            .getCredit(this.getId());
    }
    
    public long getClassId() {
        return 120;
    }
    
    public PersistentCredit getThis() throws PersistenceException {
        return ((PersistentCredit)this.getTheObject()).getThis();
    }
    
    public void accept(EntryVisitor visitor) throws PersistenceException {
        visitor.handleCredit(this);
    }
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCredit(this);
    }
    public <E extends model.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends model.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCredit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCredit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCredit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCredit(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCredit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCredit(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCredit(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCredit)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCredit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentCredit)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentCredit)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCredit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCredit)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCredit)this.getTheObject()).initializeOnInstantiation();
    }

    
}
