
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class AccountWrppr extends model.AccountHandle implements PersistentAccountWrppr{
    
    
    public static AccountWrppr4Public createAccountWrppr(Account4Public account) throws PersistenceException{
        return createAccountWrppr(account,false);
    }
    
    public static AccountWrppr4Public createAccountWrppr(Account4Public account,boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountWrppr result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade
                .newDelayedAccountWrppr();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade
                .newAccountWrppr(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("account", account);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static AccountWrppr4Public createAccountWrppr(Account4Public account,boolean delayed$Persistence,AccountWrppr4Public This) throws PersistenceException {
        PersistentAccountWrppr result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade
                .newDelayedAccountWrppr();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade
                .newAccountWrppr(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("account", account);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public AccountWrppr provideCopy() throws PersistenceException{
        AccountWrppr result = this;
        result = new AccountWrppr(this.subService, 
                                  this.This, 
                                  this.account, 
                                  this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountWrpprAccount account;
    
    public AccountWrppr(SubjInterface subService,PersistentAccountHandle This,PersistentAccountWrpprAccount account,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentAccountHandle)This,id);
        this.account = account;        
    }
    
    static public long getTypeId() {
        return 118;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 118) ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade
            .newAccountWrppr(this.getId());
        super.store();
        if(this.account != null){
            this.account.store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade.accountSet(this.getId(), account);
        }
        
    }
    
    public void setAccount(AccountWrpprAccount4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.account)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.account = (PersistentAccountWrpprAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountWrpprFacade.accountSet(this.getId(), newValue);
        }
    }
    public PersistentAccountWrppr getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountWrppr result = (PersistentAccountWrppr)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccountWrppr)this.This;
    }
    
    public void accept(AccountHandleVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountWrppr(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountWrppr(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountWrppr(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountWrppr(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void accountChanged(final Account4Public account) 
				throws PersistenceException{
        model.meta.AccountWrpprAccountChangedAccountMssg event = new model.meta.AccountWrpprAccountChangedAccountMssg(account, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public Account4Public getAccount() 
				throws PersistenceException{
        if (this.account== null) return null;
		return this.account.getObservee();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountWrppr)This);
		if(this.isTheSameAs(This)){
			this.setAccount((PersistentAccount)final$$Fields.get("account"));
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public void setAccount(final Account4Public account) 
				throws PersistenceException{
        if (this.account == null) {
			this.setAccount(model.AccountWrpprAccount.createAccountWrpprAccount(this.isDelayed$Persistence()));
			this.account.setObserver(getThis());
		}
		this.account.setObservee(account);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void accountChangedImplementation(final Account4Public account) 
				throws PersistenceException{
    }
    public void account_update(final model.meta.AccountMssgs event) 
				throws PersistenceException{
    	getThis().accountChanged(getThis().getAccount());
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public Account4Public fetchAccount() 
				throws PersistenceException{
    	return getThis().getAccount();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void recycle() 
				throws PersistenceException{
        getThis().setAccount(NoAccount.getTheNoAccount());
        WrapperRecycle.getTheWrapperRecycle().storeWrapper(getThis());
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
