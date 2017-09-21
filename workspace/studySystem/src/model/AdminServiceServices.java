
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AdminServiceServices extends PersistentObject implements PersistentAdminServiceServices{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AdminServiceServices4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.getClass(objectId);
        return (AdminServiceServices4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static AdminServiceServices4Public createAdminServiceServices() throws PersistenceException{
        return createAdminServiceServices(false);
    }
    
    public static AdminServiceServices4Public createAdminServiceServices(boolean delayed$Persistence) throws PersistenceException {
        PersistentAdminServiceServices result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade
                .newDelayedAdminServiceServices();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade
                .newAdminServiceServices(-1);
        }
        while (!(result instanceof AdminServiceServices)) result = (PersistentAdminServiceServices)result.getTheObject();
        ((AdminServiceServices)result).setThis(result);
        return result;
    }
    
    public AdminServiceServices provideCopy() throws PersistenceException{
        AdminServiceServices result = this;
        result = new AdminServiceServices(this.observer, 
                                          this.This, 
                                          this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAdminService observer;
    protected AdminServiceServices_ObserveeProxi observee;
    protected PersistentAdminServiceServices This;
    
    public AdminServiceServices(PersistentAdminService observer,PersistentAdminServiceServices This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new AdminServiceServices_ObserveeProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 298;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 298) ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade
            .newAdminServiceServices(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public AdminService4Public getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(AdminService4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAdminService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.observerSet(this.getId(), newValue);
        }
    }
    public AdminServiceServices_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentAdminServiceServices newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAdminServiceServices)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServiceServicesFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAdminServiceServices getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAdminServiceServices result = (PersistentAdminServiceServices)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAdminServiceServices)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdminServiceServices(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServiceServices(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServiceServices(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServiceServices(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAdminServiceServices(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminServiceServices(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminServiceServices(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminServiceServices(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final subAdminService4Public observee) 
				throws PersistenceException{
        this.getObservee().add(observee);
    }
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<subAdminService4Public,R,E> aggregtion) 
				throws E, PersistenceException{
        return this.getObservee().aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<subAdminService4Public,R> aggregtion) 
				throws PersistenceException{
        return this.getObservee().aggregate(aggregtion);
    }
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<subAdminService4Public,E> procdure) 
				throws E, PersistenceException{
        this.getObservee().applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<subAdminService4Public> procdure) 
				throws PersistenceException{
        this.getObservee().applyToAll(procdure);
    }
    public <E extends model.UserException> void filterException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().filterException(predcate);
    }
    public void filter(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        this.getObservee().filter(predcate);
    }
    public <E extends model.UserException> SearchListRoot<subAdminService4Public> findAllException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findAllException(predcate);
    }
    public SearchListRoot<subAdminService4Public> findAll(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        return this.getObservee().findAll(predcate);
    }
    public <E extends model.UserException> subAdminService4Public findFirstException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findFirstException(predcate);
    }
    public subAdminService4Public findFirst(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        return this.getObservee().findFirst(predcate);
    }
    public long getLength() 
				throws PersistenceException{
        		return this.getObservee().getLength();
    }
    public subAdminServiceSearchList getList() 
				throws PersistenceException{
        return this.getObservee().getList();
    }
    public java.util.Iterator<subAdminService4Public> iterator() 
				throws PersistenceException{
        return this.getObservee().iterator();
    }
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstFailure(predcate);
    }
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<subAdminService4Public,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<subAdminService4Public> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().services_update((model.meta.subAdminServiceMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
