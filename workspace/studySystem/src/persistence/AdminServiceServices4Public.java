package persistence;


import model.visitor.*;

public interface AdminServiceServices4Public extends PersistentListProxiInterface<subAdminService4Public>, Anything, ObsInterface, AbstractPersistentProxi {
    
    public AdminServiceServices_ObserveeProxi getObservee() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void add(final subAdminService4Public observee) 
				throws PersistenceException;
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<subAdminService4Public,R,E> aggregtion) 
				throws E, PersistenceException;
    public <R> R aggregate(final persistence.Aggregtion<subAdminService4Public,R> aggregtion) 
				throws PersistenceException;
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<subAdminService4Public,E> procdure) 
				throws E, PersistenceException;
    public void applyToAll(final persistence.Procdure<subAdminService4Public> procdure) 
				throws PersistenceException;
    public <E extends model.UserException> void filterException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException;
    public void filter(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> SearchListRoot<subAdminService4Public> findAllException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException;
    public SearchListRoot<subAdminService4Public> findAll(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> subAdminService4Public findFirstException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException;
    public subAdminService4Public findFirst(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException;
    public long getLength() 
				throws PersistenceException;
    public subAdminServiceSearchList getList() 
				throws PersistenceException;
    public java.util.Iterator<subAdminService4Public> iterator() 
				throws PersistenceException;
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstFailure(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException;
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException;
    public void removeFirstSuccess(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException;
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

}

