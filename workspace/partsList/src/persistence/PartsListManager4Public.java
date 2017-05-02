package persistence;


import model.visitor.*;

public interface PartsListManager4Public extends Anything, AbstractPersistentProxi {
    
    public PartsListManager_CurrentComponentsProxi getCurrentComponents() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void createMaterial(final String name, final common.Fraction price, final Invoker invoker) 
				throws PersistenceException;
    public void createProduct(final String name, final common.Fraction price, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void clearComponents() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createMaterial(final String name, final common.Fraction price) 
				throws model.PartsListException, PersistenceException;
    public void createProduct(final String name, final common.Fraction price) 
				throws model.PartsListException, PersistenceException;
    public void findComponents(final String name) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

