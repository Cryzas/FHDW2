package persistence;



import model.visitor.*;

public class ProgramModuleServiceProgramManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentProgramModuleServiceProgramManager{
    
    public ProgramModuleServiceProgramManagerICProxi(long objectId) {
        super(objectId);
    }
    public ProgramModuleServiceProgramManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade
            .getProgramModuleServiceProgramManager(this.getId());
    }
    
    public long getClassId() {
        return 309;
    }
    
    public ProgramModuleService4Public getObserver() throws PersistenceException {
        return ((PersistentProgramModuleServiceProgramManager)this.getTheObject()).getObserver();
    }
    public void setObserver(ProgramModuleService4Public newValue) throws PersistenceException {
        ((PersistentProgramModuleServiceProgramManager)this.getTheObject()).setObserver(newValue);
    }
    public ProgramManager4Public getObservee() throws PersistenceException {
        return ((PersistentProgramModuleServiceProgramManager)this.getTheObject()).getObservee();
    }
    public void setObservee(ProgramManager4Public newValue) throws PersistenceException {
        ((PersistentProgramModuleServiceProgramManager)this.getTheObject()).setObservee(newValue);
    }
    public PersistentProgramModuleServiceProgramManager getThis() throws PersistenceException {
        return ((PersistentProgramModuleServiceProgramManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleServiceProgramManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleServiceProgramManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleServiceProgramManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleServiceProgramManager(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleServiceProgramManager(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleServiceProgramManager(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleServiceProgramManager(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleServiceProgramManager(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentProgramModuleServiceProgramManager)this.getTheObject()).update(event);
    }

    
}
