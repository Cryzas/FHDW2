package persistence;


import model.visitor.*;

public interface TransferManager4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public TransferManager_TransfersProxi getTransfers() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addTransfer(final Transaction4Public transaction, final Transfer4Public transfer, final Invoker invoker) 
				throws PersistenceException;
    public void book(final Bookable4Public bookable, final Invoker invoker) 
				throws PersistenceException;
    public void createTransaction(final String subject, final Invoker invoker) 
				throws PersistenceException;
    public void createTransfer(final AccountHandle4Public fromAccount, final AccountHandle4Public toAccount, final common.Fraction amount, final String subject, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void removeTransfer(final Transaction4Public transaction, final Transfer4Public transfer, final Invoker invoker) 
				throws PersistenceException;
    public void addTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws PersistenceException;
    public void book(final Bookable4Public bookable) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createTransaction(final String subject) 
				throws PersistenceException;
    public void createTransfer(final AccountHandle4Public fromAccount, final AccountHandle4Public toAccount, final common.Fraction amount, final String subject) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeTransfer(final Transaction4Public transaction, final Transfer4Public transfer) 
				throws model.NotPartException, PersistenceException;

}

