
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ProgramModuleServiceProgramManager extends PersistentObject implements PersistentProgramModuleServiceProgramManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ProgramModuleServiceProgramManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.getClass(objectId);
        return (ProgramModuleServiceProgramManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ProgramModuleServiceProgramManager4Public createProgramModuleServiceProgramManager() throws PersistenceException{
        return createProgramModuleServiceProgramManager(false);
    }
    
    public static ProgramModuleServiceProgramManager4Public createProgramModuleServiceProgramManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentProgramModuleServiceProgramManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade
                .newDelayedProgramModuleServiceProgramManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade
                .newProgramModuleServiceProgramManager(-1);
        }
        while (!(result instanceof ProgramModuleServiceProgramManager)) result = (PersistentProgramModuleServiceProgramManager)result.getTheObject();
        ((ProgramModuleServiceProgramManager)result).setThis(result);
        return result;
    }
    
    public ProgramModuleServiceProgramManager provideCopy() throws PersistenceException{
        ProgramModuleServiceProgramManager result = this;
        result = new ProgramModuleServiceProgramManager(this.observer, 
                                                        this.observee, 
                                                        this.This, 
                                                        this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentProgramModuleService observer;
    protected PersistentProgramManager observee;
    protected PersistentProgramModuleServiceProgramManager This;
    
    public ProgramModuleServiceProgramManager(PersistentProgramModuleService observer,PersistentProgramManager observee,PersistentProgramModuleServiceProgramManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 309;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 309) ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade
            .newProgramModuleServiceProgramManager(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.observerSet(this.getId(), newValue);
        }
    }
    public ProgramManager4Public getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(ProgramManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observee)) return;
        ProgramManager4Public oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentProgramManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentProgramModuleServiceProgramManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceProgramManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentProgramModuleServiceProgramManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProgramModuleServiceProgramManager result = (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProgramModuleServiceProgramManager)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().programManager_update((model.meta.ProgramManagerMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
