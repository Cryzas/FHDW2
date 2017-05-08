
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Debit extends model.Entry implements PersistentDebit{
    
    
    public static Debit4Public createDebit(String description,common.Fraction amount,Account4Public otherAcc) throws PersistenceException{
        return createDebit(description,amount,otherAcc,false);
    }
    
    public static Debit4Public createDebit(String description,common.Fraction amount,Account4Public otherAcc,boolean delayed$Persistence) throws PersistenceException {
        PersistentDebit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDelayedDebit(description,amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDebit(description,amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("description", description);
        final$$Fields.put("amount", amount);
        final$$Fields.put("otherAcc", otherAcc);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Debit4Public createDebit(String description,common.Fraction amount,Account4Public otherAcc,boolean delayed$Persistence,Debit4Public This) throws PersistenceException {
        PersistentDebit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDelayedDebit(description,amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDebit(description,amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("description", description);
        final$$Fields.put("amount", amount);
        final$$Fields.put("otherAcc", otherAcc);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Debit provideCopy() throws PersistenceException{
        Debit result = this;
        result = new Debit(this.description, 
                           this.amount, 
                           this.otherAcc, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Debit(String description,common.Fraction amount,PersistentAccount otherAcc,PersistentEntry This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)description,(common.Fraction)amount,(PersistentAccount)otherAcc,(PersistentEntry)This,id);        
    }
    
    static public long getTypeId() {
        return 131;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 131) ConnectionHandler.getTheConnectionHandler().theDebitFacade
            .newDebit(description,amount,this.getId());
        super.store();
        
    }
    
    public PersistentDebit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDebit result = (PersistentDebit)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentDebit)this.This;
    }
    
    public void accept(EntryVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends model.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends model.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getOtherAcc() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDebit)This);
		if(this.isTheSameAs(This)){
			this.setDescription((String)final$$Fields.get("description"));
			this.setAmount((common.Fraction)final$$Fields.get("amount"));
			this.setOtherAcc((PersistentAccount)final$$Fields.get("otherAcc"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
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
