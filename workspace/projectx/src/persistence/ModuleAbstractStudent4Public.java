package persistence;


import model.visitor.*;

public interface ModuleAbstractStudent4Public extends Anything, programHierarchyStudentHIERARCHY, AbstractPersistentProxi {
    
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public common.Fraction getCreditPoints() 
				throws PersistenceException;
    public String getName() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

