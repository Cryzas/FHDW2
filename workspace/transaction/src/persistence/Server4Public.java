package persistence;


import model.visitor.*;

public interface Server4Public extends Invoker, Anything, SubjInterface, Remote, AbstractPersistentProxi {
    
    public AccountManager4Public getAccounts() throws PersistenceException ;
    public TransferManager4Public getTransfers() throws PersistenceException ;
    
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public String server_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public void signalChanged(final boolean signal) 
				throws PersistenceException;
    public void addTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws PersistenceException;
    public void book(final Bookable4Public bookable) 
				throws PersistenceException;
    public void clearAccounts() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createAccount(final String name) 
				throws PersistenceException;
    public void createCredit(final Account4Public myAccount, final AccountHandle4Public otherAccount, final common.Fraction amount, final String subject) 
				throws PersistenceException;
    public void createDebit(final Account4Public myAccount, final AccountHandle4Public otherAccount, final common.Fraction amount, final String subject) 
				throws PersistenceException;
    public void createTransaction(final String subject) 
				throws PersistenceException;
    public void findAccounts(final String name) 
				throws PersistenceException;
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException;
    public void handleResult(final Command command) 
				throws PersistenceException;
    public boolean hasChanged() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws model.NotPartException, PersistenceException;

}

