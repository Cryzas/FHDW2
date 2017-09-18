
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudentManageServiceStudentManager extends PersistentObject implements PersistentStudentManageServiceStudentManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static StudentManageServiceStudentManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.getClass(objectId);
        return (StudentManageServiceStudentManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static StudentManageServiceStudentManager4Public createStudentManageServiceStudentManager() throws PersistenceException{
        return createStudentManageServiceStudentManager(false);
    }
    
    public static StudentManageServiceStudentManager4Public createStudentManageServiceStudentManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentStudentManageServiceStudentManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade
                .newDelayedStudentManageServiceStudentManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade
                .newStudentManageServiceStudentManager(-1);
        }
        while (!(result instanceof StudentManageServiceStudentManager)) result = (PersistentStudentManageServiceStudentManager)result.getTheObject();
        ((StudentManageServiceStudentManager)result).setThis(result);
        return result;
    }
    
    public StudentManageServiceStudentManager provideCopy() throws PersistenceException{
        StudentManageServiceStudentManager result = this;
        result = new StudentManageServiceStudentManager(this.observer, 
                                                        this.observee, 
                                                        this.This, 
                                                        this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentStudentManageService observer;
    protected PersistentStudentManager observee;
    protected PersistentStudentManageServiceStudentManager This;
    
    public StudentManageServiceStudentManager(PersistentStudentManageService observer,PersistentStudentManager observee,PersistentStudentManageServiceStudentManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 311;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 311) ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade
            .newStudentManageServiceStudentManager(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public StudentManageService4Public getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(StudentManageService4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentStudentManageService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.observerSet(this.getId(), newValue);
        }
    }
    public StudentManager4Public getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(StudentManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observee)) return;
        StudentManager4Public oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentStudentManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentStudentManageServiceStudentManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceStudentManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentStudentManageServiceStudentManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudentManageServiceStudentManager result = (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudentManageServiceStudentManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageServiceStudentManager(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageServiceStudentManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().studentManager_update((model.meta.StudentManagerMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
