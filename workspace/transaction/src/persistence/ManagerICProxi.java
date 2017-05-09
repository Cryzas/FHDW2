package persistence;



import model.visitor.*;

public class ManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentManager{
    
    public ManagerICProxi(long objectId) {
        super(objectId);
    }
    public ManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theManagerFacade
            .getManager(this.getId());
    }
    
    public long getClassId() {
        return 135;
    }
    
    public Manager_CurrentAccountsProxi getCurrentAccounts() throws PersistenceException {
        return ((PersistentManager)this.getTheObject()).getCurrentAccounts();
    }
    public Manager_OpenTransfersProxi getOpenTransfers() throws PersistenceException {
        return ((PersistentManager)this.getTheObject()).getOpenTransfers();
    }
    public PersistentManager getThis() throws PersistenceException {
        return ((PersistentManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleManager(this);
    }
    
    
    public void book(final Transfer4Public transfer, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).book(transfer, invoker);
    }
    public void createAccount(final String description, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).createAccount(description, invoker);
    }
    public void createTransfer(final Account4Public fromAcc, final Account4Public toAcc, final String description, final common.Fraction amount, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).createTransfer(fromAcc, toAcc, description, amount, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void book(final Transfer4Public transfer) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).book(transfer);
    }
    public void clearAccounts() 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).clearAccounts();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAccount(final String description) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).createAccount(description);
    }
    public void createTransfer(final Account4Public fromAcc, final Account4Public toAcc, final String description, final common.Fraction amount) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).createTransfer(fromAcc, toAcc, description, amount);
    }
    public void findAccountByName(final String name) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).findAccountByName(name);
    }
    public void findAccountByNumber(final long number) 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).findAccountByNumber(number);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentManager)this.getTheObject()).initializeOnInstantiation();
    }

    
}
