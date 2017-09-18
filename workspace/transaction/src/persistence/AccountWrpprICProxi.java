package persistence;



import model.visitor.*;

public class AccountWrpprICProxi extends AccountHandleICProxi implements PersistentAccountWrppr{
    
    public AccountWrpprICProxi(long objectId) {
        super(objectId);
    }
    public AccountWrpprICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade
            .getAccountWrppr(this.getId());
    }
    
    public long getClassId() {
        return 118;
    }
    
    public void setAccount(AccountWrpprAccount4Public newValue) throws PersistenceException {
        ((PersistentAccountWrppr)this.getTheObject()).setAccount(newValue);
    }
    public PersistentAccountWrppr getThis() throws PersistenceException {
        return ((PersistentAccountWrppr)this.getTheObject()).getThis();
    }
    
    public void accept(AccountHandleVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    
    
    public void accountChanged(final Account4Public account) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).accountChanged(account);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).deregister(observee);
    }
    public Account4Public getAccount() 
				throws PersistenceException{
        return ((PersistentAccountWrppr)this.getTheObject()).getAccount();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).register(observee);
    }
    public void setAccount(final Account4Public account) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).setAccount(account);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).updateObservers(event);
    }
    public void accountChangedImplementation(final Account4Public account) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).accountChangedImplementation(account);
    }
    public void account_update(final model.meta.AccountMssgs event) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).account_update(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public Account4Public fetchAccount() 
				throws PersistenceException{
        return ((PersistentAccountWrppr)this.getTheObject()).fetchAccount();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).initializeOnInstantiation();
    }
    public void recycle() 
				throws PersistenceException{
        ((PersistentAccountWrppr)this.getTheObject()).recycle();
    }

    
}
