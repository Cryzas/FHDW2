package persistence;


import model.visitor.*;

public interface AccountManagerCurrentAccounts4Public extends PersistentListProxiInterface<AccountHandle4Public>, Anything, ObsInterface, AbstractPersistentProxi {
    
    public AccountManagerCurrentAccounts_ObserveeProxi getObservee() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final AccountHandle4Public observee) 
				throws PersistenceException;
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<AccountHandle4Public,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<AccountHandle4Public,R> aggregtion) 
				throws PersistenceException;
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<AccountHandle4Public,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<AccountHandle4Public> procdure) 
				throws PersistenceException;
    public <E extends model.UserException> void filterException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> SearchListRoot<AccountHandle4Public> findAllException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<AccountHandle4Public> findAll(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> AccountHandle4Public findFirstException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException;
    public AccountHandle4Public findFirst(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException;
    public long getLength() 
				throws PersistenceException;
    public AccountHandleSearchList getList() 
				throws PersistenceException;
    public java.util.Iterator<AccountHandle4Public> iterator() 
				throws PersistenceException;
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

