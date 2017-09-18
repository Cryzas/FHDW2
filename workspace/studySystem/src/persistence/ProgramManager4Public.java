package persistence;


import model.visitor.*;

public interface ProgramManager4Public extends Anything, SubjInterface, AbstractPersistentProxi {
    
    public ProgramManager_ProgramsProxi getPrograms() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void addModuleToProg(final Program4Public program, final ModuleAbstract4Public module, final Invoker invoker) 
				throws PersistenceException;
    public void createProgram(final String name, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public void startStudyGroup(final Program4Public program, final String name) 
				throws model.AlreadyExistsInParentException, model.NoFractionValueException, PersistenceException;
    public void startStudyGroup(final Program4Public program, final String name, final Invoker invoker) 
				throws PersistenceException;
    public void addModuleToProg(final Program4Public program, final ModuleAbstract4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createProgram(final String name) 
				throws model.AlreadyExistsInParentException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void startStudyGroupImplementation(final Program4Public program, final String name) 
				throws model.AlreadyExistsInParentException, model.NoFractionValueException, PersistenceException;

}

