
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountManagerCurrentAccounts extends PersistentObject implements PersistentAccountManagerCurrentAccounts{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AccountManagerCurrentAccounts4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.getClass(objectId);
        return (AccountManagerCurrentAccounts4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static AccountManagerCurrentAccounts4Public createAccountManagerCurrentAccounts() throws PersistenceException{
        return createAccountManagerCurrentAccounts(false);
    }
    
    public static AccountManagerCurrentAccounts4Public createAccountManagerCurrentAccounts(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountManagerCurrentAccounts result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade
                .newDelayedAccountManagerCurrentAccounts();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade
                .newAccountManagerCurrentAccounts(-1);
        }
        while (!(result instanceof AccountManagerCurrentAccounts)) result = (PersistentAccountManagerCurrentAccounts)result.getTheObject();
        ((AccountManagerCurrentAccounts)result).setThis(result);
        return result;
    }
    
    public AccountManagerCurrentAccounts provideCopy() throws PersistenceException{
        AccountManagerCurrentAccounts result = this;
        result = new AccountManagerCurrentAccounts(this.observer, 
                                                   this.This, 
                                                   this.getId());
        result.observee = this.observee.copy(result);
        
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountManager observer;
    protected AccountManagerCurrentAccounts_ObserveeProxi observee;
    protected PersistentAccountManagerCurrentAccounts This;
    
    public AccountManagerCurrentAccounts(PersistentAccountManager observer,PersistentAccountManagerCurrentAccounts This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.observer = observer;
        this.observee = new AccountManagerCurrentAccounts_ObserveeProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 135;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 135) ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade
            .newAccountManagerCurrentAccounts(this.getId());
        super.store();
        if(this.getObserver() != null){
            this.getObserver().store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.observerSet(this.getId(), getObserver());
        }
        this.getObservee().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public AccountManager4Public getObserver() throws PersistenceException {
        return this.observer;
    }
    public void setObserver(AccountManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.observer)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.observer = (PersistentAccountManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.observerSet(this.getId(), newValue);
        }
    }
    public AccountManagerCurrentAccounts_ObserveeProxi getObservee() throws PersistenceException {
        return this.observee;
    }
    protected void setThis(PersistentAccountManagerCurrentAccounts newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountManagerCurrentAccounts)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerCurrentAccountsFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountManagerCurrentAccounts getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountManagerCurrentAccounts result = (PersistentAccountManagerCurrentAccounts)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccountManagerCurrentAccounts)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    public void accept(ObsInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R> R accept(ObsInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <E extends model.UserException>  void accept(ObsInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManagerCurrentAccounts(this);
    }
    public <R, E extends model.UserException> R accept(ObsInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManagerCurrentAccounts(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getObserver() != null) return 1;
        if (this.getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void add(final AccountHandle4Public observee) 
				throws PersistenceException{
        this.getObservee().add(observee);
    }
    public <E extends model.UserException,R> R aggregateException(final persistence.AggregtionException<AccountHandle4Public,R,E> aggregtion) 
				throws E, PersistenceException{
        return this.getObservee().aggregateException(aggregtion);
    }
    public <R> R aggregate(final persistence.Aggregtion<AccountHandle4Public,R> aggregtion) 
				throws PersistenceException{
        return this.getObservee().aggregate(aggregtion);
    }
    public <E extends model.UserException> void applyToAllException(final persistence.ProcdureException<AccountHandle4Public,E> procdure) 
				throws E, PersistenceException{
        this.getObservee().applyToAllException(procdure);
    }
    public void applyToAll(final persistence.Procdure<AccountHandle4Public> procdure) 
				throws PersistenceException{
        this.getObservee().applyToAll(procdure);
    }
    public <E extends model.UserException> void filterException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().filterException(predcate);
    }
    public void filter(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        this.getObservee().filter(predcate);
    }
    public <E extends model.UserException> SearchListRoot<AccountHandle4Public> findAllException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findAllException(predcate);
    }
    public SearchListRoot<AccountHandle4Public> findAll(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        return this.getObservee().findAll(predcate);
    }
    public <E extends model.UserException> AccountHandle4Public findFirstException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        return this.getObservee().findFirstException(predcate);
    }
    public AccountHandle4Public findFirst(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        return this.getObservee().findFirst(predcate);
    }
    public long getLength() 
				throws PersistenceException{
        		return this.getObservee().getLength();
    }
    public AccountHandleSearchList getList() 
				throws PersistenceException{
        return this.getObservee().getList();
    }
    public java.util.Iterator<AccountHandle4Public> iterator() 
				throws PersistenceException{
        return this.getObservee().iterator();
    }
    public <E extends model.UserException> void removeFirstFailureException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstFailureException(predcate);
    }
    public void removeFirstFailure(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstFailure(predcate);
    }
    public <E extends model.UserException> void removeFirstSuccessException(final persistence.PredcateException<AccountHandle4Public,E> predcate) 
				throws E, PersistenceException{
        this.getObservee().removeFirstSuccessException(predcate);
    }
    public void removeFirstSuccess(final persistence.Predcate<AccountHandle4Public> predcate) 
				throws PersistenceException{
        this.getObservee().removeFirstSuccess(predcate);
    }
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException{
        this.observer.getThis().currentAccounts_update((model.meta.AccountHandleMssgs)event);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
