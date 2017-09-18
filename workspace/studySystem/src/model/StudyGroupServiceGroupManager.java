
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudyGroupServiceGroupManager extends PersistentObject implements PersistentStudyGroupServiceGroupManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static StudyGroupServiceGroupManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.getClass(objectId);
        return (StudyGroupServiceGroupManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static StudyGroupServiceGroupManager4Public createStudyGroupServiceGroupManager() throws PersistenceException{
        return createStudyGroupServiceGroupManager(false);
    }
    
    public static StudyGroupServiceGroupManager4Public createStudyGroupServiceGroupManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentStudyGroupServiceGroupManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade
                .newDelayedStudyGroupServiceGroupManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade
                .newStudyGroupServiceGroupManager(-1);
        }
        while (!(result instanceof StudyGroupServiceGroupManager)) result = (PersistentStudyGroupServiceGroupManager)result.getTheObject();
        ((StudyGroupServiceGroupManager)result).setThis(result);
        return result;
    }
    
    public StudyGroupServiceGroupManager provideCopy() throws PersistenceException{
        StudyGroupServiceGroupManager result = this;
        result = new StudyGroupServiceGroupManager(this.observer, 
                                                   this.observee, 
                                                   this.This, 
                                                   this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentStudyGroupService observer;
    protected PersistentStudyGroupManager observee;
    protected PersistentStudyGroupServiceGroupManager This;
    
    public StudyGroupServiceGroupManager(PersistentStudyGroupService observer,PersistentStudyGroupManager observee,PersistentStudyGroupServiceGroupManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 308;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 308) ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade
            .newStudyGroupServiceGroupManager(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public StudyGroupService4Public getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(StudyGroupService4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentStudyGroupService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.observerSet(this.getId(), newValue);
        }
    }
    public StudyGroupManager4Public getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(StudyGroupManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observee)) return;
        StudyGroupManager4Public oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentStudyGroupManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentStudyGroupServiceGroupManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceGroupManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentStudyGroupServiceGroupManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudyGroupServiceGroupManager result = (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudyGroupServiceGroupManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupServiceGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupServiceGroupManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().groupManager_update((model.meta.StudyGroupManagerMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
