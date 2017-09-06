package persistence;


import model.visitor.*;

public interface GradesInSimple4Public extends GradesInSimpleOrThird4Public {
    
    
    public void accept(GradesInSimpleVisitor visitor) throws PersistenceException;
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

