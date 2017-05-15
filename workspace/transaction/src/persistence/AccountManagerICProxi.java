package persistence;



import model.visitor.*;

public class AccountManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentAccountManager{
    
    public AccountManagerICProxi(long objectId) {
        super(objectId);
    }
    public AccountManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
            .getAccountManager(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public AccountManager_CurrentAccountsProxi getCurrentAccounts() throws PersistenceException {
        return ((PersistentAccountManager)this.getTheObject()).getCurrentAccounts();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentAccountManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentAccountManager)this.getTheObject()).setSubService(newValue);
    }
    public PersistentAccountManager getThis() throws PersistenceException {
        return ((PersistentAccountManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManager(this);
    }
    
    
    public void accountChanged() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).accountChanged();
    }
    public void createAccount(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createAccount(name, invoker);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).updateObservers(event);
    }
    public void accountChangedImplementation() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).accountChangedImplementation();
    }
    public void clearAccounts() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).clearAccounts();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAccount(final String name) 
				throws model.AccountException, PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createAccount(name);
    }
    public void findAccounts(final String name) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).findAccounts(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initializeOnInstantiation();
    }

    
}
