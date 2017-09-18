package persistence;



import model.visitor.*;

public class NoAccountProxi extends AccountProxi implements PersistentNoAccount{
    
    public NoAccountProxi(long objectId) {
        super(objectId);
    }
    public NoAccountProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 140;
    }
    
    public PersistentNoAccount getThis() throws PersistenceException {
        return ((PersistentNoAccount)this.getTheObject()).getThis();
    }
    
    public void accept(AccountVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AccountReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(AccountExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(AccountReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(AccountHandleVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleNoAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoAccount(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoAccount(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoAccount(this);
    }
    
    
    public void credit(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).credit(transfer);
    }
    public void debit(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).debit(transfer);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void creditImplementation(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).creditImplementation(transfer);
    }
    public void debitImplementation(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).debitImplementation(transfer);
    }
    public Account4Public fetchAccount() 
				throws PersistenceException{
        return ((PersistentNoAccount)this.getTheObject()).fetchAccount();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoAccount)this.getTheObject()).initializeOnInstantiation();
    }

    
}
