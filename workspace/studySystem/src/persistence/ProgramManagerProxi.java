package persistence;



import model.visitor.*;

public class ProgramManagerProxi extends PersistentProxi implements PersistentProgramManager{
    
    public ProgramManagerProxi(long objectId) {
        super(objectId);
    }
    public ProgramManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 148;
    }
    
    public ProgramManager_ProgramsProxi getPrograms() throws PersistenceException {
        return ((PersistentProgramManager)this.getTheObject()).getPrograms();
    }
    public PersistentProgramManager getThis() throws PersistenceException {
        return ((PersistentProgramManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramManager(this);
    }
    
    
    public void addModuleToProg(final Program4Public program, final ModuleAbstract4Public module, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).addModuleToProg(program, module, invoker);
    }
    public void createProgram(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).createProgram(name, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addModuleToProg(final Program4Public program, final ModuleAbstract4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).addModuleToProg(program, module);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createProgram(final String name) 
				throws model.AlreadyExistsInParentException, PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).createProgram(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).initializeOnInstantiation();
    }

    
}
