
package model;

import persistence.*;
import model.meta.AccountCreditTransferMssg;
import model.meta.AccountDebitTransferMssg;
import model.meta.AccountHandleMssgsVisitor;
import model.meta.AccountWrpprAccountChangedAccountMssg;
import model.visitor.*;


/* Additional import section end */

public class AccountManager extends PersistentObject implements PersistentAccountManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static AccountManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.getClass(objectId);
        return (AccountManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static AccountManager4Public createAccountManager() throws PersistenceException{
        return createAccountManager(false);
    }
    
    public static AccountManager4Public createAccountManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentAccountManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newDelayedAccountManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newAccountManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static AccountManager4Public createAccountManager(boolean delayed$Persistence,AccountManager4Public This) throws PersistenceException {
        PersistentAccountManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newDelayedAccountManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
                .newAccountManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
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
            result.put("currentAccounts", this.getCurrentAccounts().getObservee().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public AccountManager provideCopy() throws PersistenceException{
        AccountManager result = this;
        result = new AccountManager(this.currentAccounts, 
                                    this.subService, 
                                    this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccountManagerCurrentAccounts currentAccounts;
    protected SubjInterface subService;
    protected PersistentAccountManager This;
    
    public AccountManager(PersistentAccountManagerCurrentAccounts currentAccounts,SubjInterface subService,PersistentAccountManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.currentAccounts = currentAccounts;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 122;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 122) ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade
            .newAccountManager(this.getId());
        super.store();
        if(this.currentAccounts != null){
            this.currentAccounts.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.currentAccountsSet(this.getId(), currentAccounts);
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public void setCurrentAccounts(AccountManagerCurrentAccounts4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.currentAccounts)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.currentAccounts = (PersistentAccountManagerCurrentAccounts)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.currentAccountsSet(this.getId(), newValue);
        }
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentAccountManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccountManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccountManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccountManager result = (PersistentAccountManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccountManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManager(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManager(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getCurrentAccounts().getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void accountChanged(final Account4Public account) 
				throws PersistenceException{
        model.meta.AccountManagerAccountChangedAccountMssg event = new model.meta.AccountManagerAccountChangedAccountMssg(account, getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
    }
    public void createAccount(final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateAccountCommand4Public command = model.meta.CreateAccountCommand.createCreateAccountCommand(name, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
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
    public AccountManagerCurrentAccounts4Public getCurrentAccounts() 
				throws PersistenceException{
        if (this.currentAccounts == null) {
			this.setCurrentAccounts(model.AccountManagerCurrentAccounts.createAccountManagerCurrentAccounts(this.isDelayed$Persistence()));
			this.currentAccounts.setObserver(this);
		}
		return this.currentAccounts;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccountManager)This);
		if(this.isTheSameAs(This)){
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
    public void clearAccounts() 
				throws PersistenceException{
    	getThis().getCurrentAccounts().filter(new Predcate<AccountHandle4Public>() {
			@Override
			public boolean test(AccountHandle4Public argument) throws PersistenceException {
				return argument.accept(new AccountHandleReturnVisitor<Boolean>() {
					@Override
					public Boolean handleAccount(Account4Public account) throws PersistenceException {
						return true;
					}
					@Override
					public Boolean handleAccountWrppr(AccountWrppr4Public accountWrppr) throws PersistenceException {
						accountWrppr.recycle();
						return false;
					}
					@Override
					public Boolean handleNoAccount(NoAccount4Public noAccount) throws PersistenceException {
						return false;
					}
				});
			}
		});
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void createAccount(final String name) 
				throws model.AccountException, PersistenceException{
    	if (!common.FieldChecks.checkAccountName(name))
    		throw new AccountException(serverConstants.ErrorMessages.WrongNameFormatMessage);
    	if (Account.getAccountByName(name).iterator().hasNext())
    		throw new AccountException(serverConstants.ErrorMessages.ChooseOtherNameMessage);
    	getThis().getCurrentAccounts().add(Account.createAccount(name));
    }
    public void currentAccounts_update(final model.meta.AccountHandleMssgs event) 
				throws PersistenceException{
        event.accept(new AccountHandleMssgsVisitor() {
			@Override
			public void handleAccountWrpprAccountChangedAccountMssg(AccountWrpprAccountChangedAccountMssg event)
					throws PersistenceException {
		    	getThis().accountChanged(event.account);
			}
			@Override
			public void handleAccountDebitTransferMssg(AccountDebitTransferMssg event) throws PersistenceException {
		    	getThis().accountChanged(event.rcvr);
			}
			@Override
			public void handleAccountCreditTransferMssg(AccountCreditTransferMssg event) throws PersistenceException {
		    	getThis().accountChanged(event.rcvr);
			}
		});
    }
    public void findAccounts(final String name) 
				throws PersistenceException{
    	AccountSearchList foundAccounts = Account.getAccountByName(name);
    	foundAccounts.applyToAll(new Procdure<Account4Public>() {
			@Override
			public void doItTo(Account4Public foundAccount) throws PersistenceException {
				if (getThis().getCurrentAccounts().findFirst(new Predcate<AccountHandle4Public>() {
					@Override
					public boolean test(AccountHandle4Public argument) throws PersistenceException {
						return argument.fetchAccount().equals(foundAccount);
					}
				}) == null) getThis().getCurrentAccounts().add(WrapperRecycle.getTheWrapperRecycle().fecthAccountWrapper(foundAccount));
			}
		});
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
