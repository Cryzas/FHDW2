
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Account extends model.AccountHandle implements PersistentAccount{
    
    
    public static Account4Public createAccount(String name) throws PersistenceException{
        return createAccount(name,false);
    }
    
    public static Account4Public createAccount(String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(name,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Account4Public createAccount(String name,boolean delayed$Persistence,Account4Public This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(name,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            result.put("balance", this.getBalance().toString());
            result.put("entries", this.getEntries().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static AccountSearchList getAccountByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .getAccountByName(name);
    }
    
    public Account provideCopy() throws PersistenceException{
        Account result = this;
        result = new Account(this.subService, 
                             this.This, 
                             this.name, 
                             this.balance, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected common.Fraction balance;
    protected Account_EntriesProxi entries;
    
    public Account(SubjInterface subService,PersistentAccountHandle This,String name,common.Fraction balance,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentAccountHandle)This,id);
        this.name = name;
        this.balance = balance;
        this.entries = new Account_EntriesProxi(this);        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 115) ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .newAccount(name,balance,this.getId());
        super.store();
        this.getEntries().store();
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAccountFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public common.Fraction getBalance() throws PersistenceException {
        return this.balance;
    }
    public void setBalance(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAccountFacade.balanceSet(this.getId(), newValue);
        this.balance = newValue;
    }
    public Account_EntriesProxi getEntries() throws PersistenceException {
        return this.entries;
    }
    public PersistentAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccount result = (PersistentAccount)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccount)this.This;
    }
    
    public void accept(AccountHandleVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AccountHandleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(AccountHandleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(AccountHandleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getEntries().getLength() > 0) return 1;
        return 0;
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
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccount)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
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
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void credit(final Transfer4Public transfer) 
				throws PersistenceException{
        //TODO: implement method: credit
        
    }
    public void debit(final Transfer4Public transfer) 
				throws PersistenceException{
        //TODO: implement method: debit
        
    }
    public Account4Public fetchAccount() 
				throws PersistenceException{
        //TODO: implement method: fetchAccount
        try{
            throw new java.lang.UnsupportedOperationException("Method \"fetchAccount\" not implemented yet.");
        } catch (java.lang.UnsupportedOperationException uoe){
            uoe.printStackTrace();
            throw uoe;
        }
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
