package persistence;



import model.visitor.*;

public class ProgramManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentProgramManager{
    
    public ProgramManagerICProxi(long objectId) {
        super(objectId);
    }
    public ProgramManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theProgramManagerFacade
            .getProgramManager(this.getId());
    }
    
    public long getClassId() {
        return 148;
    }
    
    public ProgramManager_ProgramsProxi getPrograms() throws PersistenceException {
        return ((PersistentProgramManager)this.getTheObject()).getPrograms();
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentProgramManager)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentProgramManager)this.getTheObject()).setSubService(newValue);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleProgramManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).register(observee);
    }
    public void startStudyGroup(final Program4Public program, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).startStudyGroup(program, name, invoker);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).updateObservers(event);
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
    public void startStudyGroup(final Program4Public program, final String name) 
				throws model.AlreadyExistsInParentException, model.NoFractionValueException, PersistenceException{
        ((PersistentProgramManager)this.getTheObject()).startStudyGroup(program, name);
    }

    
}
