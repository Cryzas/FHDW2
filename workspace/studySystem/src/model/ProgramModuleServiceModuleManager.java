
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ProgramModuleServiceModuleManager extends PersistentObject implements PersistentProgramModuleServiceModuleManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ProgramModuleServiceModuleManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.getClass(objectId);
        return (ProgramModuleServiceModuleManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ProgramModuleServiceModuleManager4Public createProgramModuleServiceModuleManager() throws PersistenceException{
        return createProgramModuleServiceModuleManager(false);
    }
    
    public static ProgramModuleServiceModuleManager4Public createProgramModuleServiceModuleManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentProgramModuleServiceModuleManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade
                .newDelayedProgramModuleServiceModuleManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade
                .newProgramModuleServiceModuleManager(-1);
        }
        while (!(result instanceof ProgramModuleServiceModuleManager)) result = (PersistentProgramModuleServiceModuleManager)result.getTheObject();
        ((ProgramModuleServiceModuleManager)result).setThis(result);
        return result;
    }
    
    public ProgramModuleServiceModuleManager provideCopy() throws PersistenceException{
        ProgramModuleServiceModuleManager result = this;
        result = new ProgramModuleServiceModuleManager(this.observer, 
                                                       this.observee, 
                                                       this.This, 
                                                       this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentProgramModuleService observer;
    protected PersistentModuleManager observee;
    protected PersistentProgramModuleServiceModuleManager This;
    
    public ProgramModuleServiceModuleManager(PersistentProgramModuleService observer,PersistentModuleManager observee,PersistentProgramModuleServiceModuleManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 310;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 310) ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade
            .newProgramModuleServiceModuleManager(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ProgramModuleService4Public getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(ProgramModuleService4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentProgramModuleService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.observerSet(this.getId(), newValue);
        }
    }
    public ModuleManager4Public getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(ModuleManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observee)) return;
        ModuleManager4Public oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentModuleManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentProgramModuleServiceModuleManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceModuleManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentProgramModuleServiceModuleManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProgramModuleServiceModuleManager result = (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProgramModuleServiceModuleManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().moduleManager_update((model.meta.ModuleManagerMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
