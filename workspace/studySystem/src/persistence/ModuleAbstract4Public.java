package persistence;


import model.visitor.*;

public interface ModuleAbstract4Public extends Anything, programHierarchyHIERARCHY, SubjInterface, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException;
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public ModuleGroupSearchList getParentGroup() 
				throws PersistenceException;
    public ProgramSearchList getParentProgram() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public ModuleAbstractSGroup4Public copyForStudyGroup() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public common.Fraction getCreditPoints() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;

}

