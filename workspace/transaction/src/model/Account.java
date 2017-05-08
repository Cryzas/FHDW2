
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class Account extends PersistentObject implements PersistentAccount{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Account4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theAccountFacade.getClass(objectId);
        return (Account4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Account4Public createAccount(String description) throws PersistenceException{
        return createAccount(description,false);
    }
    
    public static Account4Public createAccount(String description,boolean delayed$Persistence) throws PersistenceException {
        if (description == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(0,description,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(0,description,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("description", description);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Account4Public createAccount(String description,boolean delayed$Persistence,Account4Public This) throws PersistenceException {
        if (description == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentAccount result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newDelayedAccount(0,description,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAccountFacade
                .newAccount(0,description,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("description", description);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("number", new Long(this.getNumber()).toString());
            result.put("description", this.getDescription());
            result.put("balance", this.getBalance().toString());
            result.put("entries", this.getEntries().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Account provideCopy() throws PersistenceException{
        Account result = this;
        result = new Account(this.number, 
                             this.description, 
                             this.balance, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long number;
    protected String description;
    protected common.Fraction balance;
    protected Account_EntriesProxi entries;
    protected PersistentAccount This;
    
    public Account(long number,String description,common.Fraction balance,PersistentAccount This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.number = number;
        this.description = description;
        this.balance = balance;
        this.entries = new Account_EntriesProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 130;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 130) ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .newAccount(number,description,balance,this.getId());
        super.store();
        this.getEntries().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public long getNumber() throws PersistenceException {
        return this.number;
    }
    public void setNumber(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAccountFacade.numberSet(this.getId(), newValue);
        this.number = newValue;
    }
    public String getDescription() throws PersistenceException {
        return this.description;
    }
    public void setDescription(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theAccountFacade.descriptionSet(this.getId(), newValue);
        this.description = newValue;
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
    protected void setThis(PersistentAccount newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAccountFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentAccount getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAccount result = (PersistentAccount)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAccount)this.This;
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
    public int getLeafInfo() throws PersistenceException{
        if (this.getEntries().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAccount)This);
		if(this.isTheSameAs(This)){
			this.setDescription((String)final$$Fields.get("description"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void book(final Entry4Public entry) 
				throws PersistenceException{
    	if (entry instanceof Credit4Public) {
    		getThis().setBalance(getThis().getBalance().add(entry.getAmount()));
		} else if (entry instanceof Debit4Public) {
    		getThis().setBalance(getThis().getBalance().add(entry.getAmount().mul(Fraction.parse("-1"))));
		}
		getThis().getEntries().add(entry);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
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
