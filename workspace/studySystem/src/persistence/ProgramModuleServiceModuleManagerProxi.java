package persistence;



import model.visitor.*;

public class ProgramModuleServiceModuleManagerProxi extends PersistentProxi implements PersistentProgramModuleServiceModuleManager{
    
    public ProgramModuleServiceModuleManagerProxi(long objectId) {
        super(objectId);
    }
    public ProgramModuleServiceModuleManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 310;
    }
    
    public ProgramModuleService4Public getObserver() throws PersistenceException {
        return ((PersistentProgramModuleServiceModuleManager)this.getTheObject()).getObserver();
    }
    public void setObserver(ProgramModuleService4Public newValue) throws PersistenceException {
        ((PersistentProgramModuleServiceModuleManager)this.getTheObject()).setObserver(newValue);
    }
    public ModuleManager4Public getObservee() throws PersistenceException {
        return ((PersistentProgramModuleServiceModuleManager)this.getTheObject()).getObservee();
    }
    public void setObservee(ModuleManager4Public newValue) throws PersistenceException {
        ((PersistentProgramModuleServiceModuleManager)this.getTheObject()).setObservee(newValue);
    }
    public PersistentProgramModuleServiceModuleManager getThis() throws PersistenceException {
        return ((PersistentProgramModuleServiceModuleManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleServiceModuleManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleServiceModuleManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleServiceModuleManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleServiceModuleManager(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleServiceModuleManager(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleServiceModuleManager(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleServiceModuleManager(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleServiceModuleManager(this);
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentProgramModuleServiceModuleManager)this.getTheObject()).update(event);
    }

    
}
