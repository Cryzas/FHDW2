package persistence;


import model.visitor.*;

public interface Manager4Public extends Anything, AbstractPersistentProxi {
    
    public Manager_CurrentAccountsProxi getCurrentAccounts() throws PersistenceException ;
    public Manager_OpenTransfersProxi getOpenTransfers() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void book(final Transfer4Public transfer, final Invoker invoker) 
				throws PersistenceException;
    public void createAccount(final String description, final Invoker invoker) 
				throws PersistenceException;
    public void createTransfer(final Account4Public fromAcc, final Account4Public toAcc, final String description, final common.Fraction amount, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void book(final Transfer4Public transfer) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createAccount(final String description) 
				throws PersistenceException;
    public void createTransfer(final Account4Public fromAcc, final Account4Public toAcc, final String description, final common.Fraction amount) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

