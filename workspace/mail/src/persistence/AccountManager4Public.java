package persistence;


import model.visitor.*;

public interface AccountManager4Public extends Anything, AbstractPersistentProxi {
    
    public AccountManager_AccountsProxi getAccounts() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addReceiver(final Draft4Public draft, final Account4Public account, final Invoker invoker) 
				throws PersistenceException;
    public void createAccount(final String name, final Invoker invoker) 
				throws PersistenceException;
    public void createDraft(final Account4Public account, final String subject, final String text, final Invoker invoker) 
				throws PersistenceException;
    public void createFolder(final Account4Public account, final String name, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void send(final Draft4Public draft, final Invoker invoker) 
				throws PersistenceException;
    public void addReceiver(final Draft4Public draft, final Account4Public account) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createAccount(final String name) 
				throws PersistenceException;
    public void createDraft(final Account4Public account, final String subject, final String text) 
				throws PersistenceException;
    public void createFolder(final Account4Public account, final String name) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void send(final Draft4Public draft) 
				throws PersistenceException;

}

