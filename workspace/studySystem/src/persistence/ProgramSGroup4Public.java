package persistence;


import model.visitor.*;

public interface ProgramSGroup4Public extends programHierarchySGroupHIERARCHY, Anything, SubjInterface, AbstractPersistentProxi {
    
    public ProgramSGroup_ModulesProxi getModules() throws PersistenceException ;
    public MyBoolean4Public getFinished() throws PersistenceException ;
    
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void addModule(final ModuleAbstractSGroup4Public module) 
				throws model.CycleException, PersistenceException;
    public ProgramStudent4Public copyForStudent() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void endProgram() 
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

