package persistence;


import model.visitor.*;

public interface QuantifiedComponent4Public extends Anything, AbstractPersistentProxi {
    
    public long getQuantity() throws PersistenceException ;
    public Component4Public getComponent() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addQuantity(final long quantity) 
				throws PersistenceException;
    public boolean contains(final Component4Public component) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public ComponentLst4Public fetchMaterials() 
				throws PersistenceException;
    public common.Fraction fetchOverallPrice() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public QuantifiedComponent4Public multiply(final long factor) 
				throws PersistenceException;

}

