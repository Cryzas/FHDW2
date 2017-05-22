package persistence;


import model.visitor.*;

public interface Transaction4Public extends bookableHierarchyHIERARCHY, Bookable4Public {
    
    public Transaction_TransfersProxi getTransfers() throws PersistenceException ;
    
    public void accept(BookableVisitor visitor) throws PersistenceException;
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(bookableHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(bookableHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(bookableHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(bookableHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsbookableHierarchy(final bookableHierarchyHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategybookableHierarchy(final bookableHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void addTransfer(final Transfer4Public transfer) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeTransfer(final Transfer4Public transfer) 
				throws PersistenceException;

}

