package persistence;


import model.visitor.*;

public interface Student4Public extends Anything, AbstractPersistentProxi {
    
    public String getFirstName() throws PersistenceException ;
    public String getLastName() throws PersistenceException ;
    public java.sql.Date getBirthDate() throws PersistenceException ;
    public ProgramStudent4Public getProgram() throws PersistenceException ;
    public void setProgram(ProgramStudent4Public newValue) throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public long getMatrNr() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

