package persistence;



import model.visitor.*;

public class AccountProxi extends AccountHandleProxi implements PersistentAccount{
    
    public AccountProxi(long objectId) {
        super(objectId);
    }
    public AccountProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 115;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getBalance() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getBalance();
    }
    public void setBalance(common.Fraction newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setBalance(newValue);
    }
    public Account_EntriesProxi getEntries() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getEntries();
    }
    public PersistentAccount getThis() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getThis();
    }
    
    public void accept(AccountHandleVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void credit(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).credit(transfer);
    }
    public void debit(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).debit(transfer);
    }
    public Account4Public fetchAccount() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).fetchAccount();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnInstantiation();
    }

    
}
