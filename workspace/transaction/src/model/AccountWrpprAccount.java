
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountWrpprAccount extends PersistentObject implements PersistentAccountWrpprAccount{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AccountWrpprAccount4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.getClass(objectId);
        return (AccountWrpprAccount4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static AccountWrpprAccount4Public createAccountWrpprAccount() throws PersistenceException{
        return createAccountWrpprAccount(false);
    }
    
    public static AccountWrpprAccount4Public createAccountWrpprAccount(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountWrpprAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade
                .newDelayedAccountWrpprAccount();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade
                .newAccountWrpprAccount(-1);
        }
        while (!(result instanceof AccountWrpprAccount)) result = (PersistentAccountWrpprAccount)result.getTheObject();
        ((AccountWrpprAccount)result).setThis(result);
        return result;
    }
    
    public AccountWrpprAccount provideCopy() throws PersistenceException{
        AccountWrpprAccount result = this;
        result = new AccountWrpprAccount(this.observer, 
                                         this.observee, 
                                         this.This, 
                                         this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountWrppr observer;
    protected PersistentAccount observee;
    protected PersistentAccountWrpprAccount This;
    
    public AccountWrpprAccount(PersistentAccountWrppr observer,PersistentAccount observee,PersistentAccountWrpprAccount This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 134;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 134) ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade
            .newAccountWrpprAccount(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public AccountWrppr4Public getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(AccountWrppr4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAccountWrppr)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.observerSet(this.getId(), newValue);
        }
    }
    public Account4Public getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(Account4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observee)) return;
        Account4Public oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentAccountWrpprAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountWrpprAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprAccountFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountWrpprAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountWrpprAccount result = (PersistentAccountWrpprAccount)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccountWrpprAccount)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrpprAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrpprAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrpprAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrpprAccount(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrpprAccount(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrpprAccount(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrpprAccount(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrpprAccount(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().account_update((model.meta.AccountMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
