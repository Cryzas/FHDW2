package persistence;


import model.visitor.*;

public interface ComponentLst4Public extends Anything, AbstractPersistentProxi {
    
    public ComponentLst_PartsProxi getParts() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public ComponentLst4Public addList(final ComponentLst4Public argument) 
				throws PersistenceException;
    public void addPart(final Component4Public component, final long quantity) 
				throws PersistenceException;
    public boolean contains(final Component4Public component) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public ComponentLst4Public multiply(final long factor) 
				throws PersistenceException;

}

