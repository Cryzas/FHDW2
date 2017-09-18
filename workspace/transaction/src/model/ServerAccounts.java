
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ServerAccounts extends PersistentObject implements PersistentServerAccounts{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ServerAccounts4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.getClass(objectId);
        return (ServerAccounts4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ServerAccounts4Public createServerAccounts() throws PersistenceException{
        return createServerAccounts(false);
    }
    
    public static ServerAccounts4Public createServerAccounts(boolean delayed$Persistence) throws PersistenceException {
        PersistentServerAccounts result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade
                .newDelayedServerAccounts();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade
                .newServerAccounts(-1);
        }
        while (!(result instanceof ServerAccounts)) result = (PersistentServerAccounts)result.getTheObject();
        ((ServerAccounts)result).setThis(result);
        return result;
    }
    
    public ServerAccounts provideCopy() throws PersistenceException{
        ServerAccounts result = this;
        result = new ServerAccounts(this.observer, 
                                    this.observee, 
                                    this.This, 
                                    this.getId());
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentServer observer;
    protected PersistentAccountManager observee;
    protected PersistentServerAccounts This;
    
    public ServerAccounts(PersistentServer observer,PersistentAccountManager observee,PersistentServerAccounts This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = observee;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 136;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 136) ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade
            .newServerAccounts(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.observerSet(this.getId(), getObserver());
        }
        if(this.getObservee() != null){
            this.getObservee().store();
            ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.observeeSet(this.getId(), getObservee());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Server4Public getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(Server4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentServer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.observerSet(this.getId(), newValue);
        }
    }
    public AccountManager4Public getObservee() throws PersistenceException {
        return this.observee;
    }
    public void setObservee(AccountManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observee)) return;
        AccountManager4Public oldValue =  this.getObservee();
        if (oldValue != null) oldValue.deregister(this);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observee = (PersistentAccountManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.observeeSet(this.getId(), newValue);
        }
        newValue.register(this);
    }
    protected void setThis(PersistentServerAccounts newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentServerAccounts)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServerAccountsFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentServerAccounts getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServerAccounts result = (PersistentServerAccounts)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentServerAccounts)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServerAccounts(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServerAccounts(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServerAccounts(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServerAccounts(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleServerAccounts(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServerAccounts(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServerAccounts(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServerAccounts(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee() != null) return 1;
        return 0;
    }
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().accounts_update((model.meta.AccountManagerMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
