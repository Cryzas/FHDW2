
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Transfer extends PersistentObject implements PersistentTransfer{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Transfer4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theTransferFacade.getClass(objectId);
        return (Transfer4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Transfer4Public createTransfer(String description,common.Fraction amount,Account4Public fromAcc,Account4Public toAcc) throws PersistenceException{
        return createTransfer(description,amount,fromAcc,toAcc,false);
    }
    
    public static Transfer4Public createTransfer(String description,common.Fraction amount,Account4Public fromAcc,Account4Public toAcc,boolean delayed$Persistence) throws PersistenceException {
        if (description == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(description,amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(description,amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("description", description);
        final$$Fields.put("amount", amount);
        final$$Fields.put("fromAcc", fromAcc);
        final$$Fields.put("toAcc", toAcc);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Transfer4Public createTransfer(String description,common.Fraction amount,Account4Public fromAcc,Account4Public toAcc,boolean delayed$Persistence,Transfer4Public This) throws PersistenceException {
        if (description == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(description,amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(description,amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("description", description);
        final$$Fields.put("amount", amount);
        final$$Fields.put("fromAcc", fromAcc);
        final$$Fields.put("toAcc", toAcc);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("description", this.getDescription());
            result.put("amount", this.getAmount().toString());
            AbstractPersistentRoot fromAcc = (AbstractPersistentRoot)this.getFromAcc();
            if (fromAcc != null) {
                result.put("fromAcc", fromAcc.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    fromAcc.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && fromAcc.hasEssentialFields())fromAcc.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            AbstractPersistentRoot toAcc = (AbstractPersistentRoot)this.getToAcc();
            if (toAcc != null) {
                result.put("toAcc", toAcc.createProxiInformation(false, essentialLevel <= 1));
                if(depth > 1) {
                    toAcc.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && toAcc.hasEssentialFields())toAcc.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Transfer provideCopy() throws PersistenceException{
        Transfer result = this;
        result = new Transfer(this.description, 
                              this.amount, 
                              this.fromAcc, 
                              this.toAcc, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String description;
    protected common.Fraction amount;
    protected PersistentAccount fromAcc;
    protected PersistentAccount toAcc;
    protected PersistentTransfer This;
    
    public Transfer(String description,common.Fraction amount,PersistentAccount fromAcc,PersistentAccount toAcc,PersistentTransfer This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.description = description;
        this.amount = amount;
        this.fromAcc = fromAcc;
        this.toAcc = toAcc;
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
        if (this.getClassId() == 134) ConnectionHandler.getTheConnectionHandler().theTransferFacade
            .newTransfer(description,amount,this.getId());
        super.store();
        if(this.getFromAcc() != null){
            this.getFromAcc().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.fromAccSet(this.getId(), getFromAcc());
        }
        if(this.getToAcc() != null){
            this.getToAcc().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.toAccSet(this.getId(), getToAcc());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getDescription() throws PersistenceException {
        return this.description;
    }
    public void setDescription(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theTransferFacade.descriptionSet(this.getId(), newValue);
        this.description = newValue;
    }
    public common.Fraction getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theTransferFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public Account4Public getFromAcc() throws PersistenceException {
        return this.fromAcc;
    }
    public void setFromAcc(Account4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.fromAcc)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromAcc = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.fromAccSet(this.getId(), newValue);
        }
    }
    public Account4Public getToAcc() throws PersistenceException {
        return this.toAcc;
    }
    public void setToAcc(Account4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.toAcc)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.toAcc = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.toAccSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentTransfer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentTransfer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentTransfer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransfer result = (PersistentTransfer)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTransfer)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getFromAcc() != null) return 1;
        if (this.getToAcc() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentTransfer)This);
		if(this.isTheSameAs(This)){
			this.setDescription((String)final$$Fields.get("description"));
			this.setAmount((common.Fraction)final$$Fields.get("amount"));
			this.setFromAcc((PersistentAccount)final$$Fields.get("fromAcc"));
			this.setToAcc((PersistentAccount)final$$Fields.get("toAcc"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void book() 
				throws PersistenceException{
    	getThis().getFromAcc().book(Debit.createDebit(getThis().getDescription(), getThis().getAmount(), getThis().getToAcc()));
    	getThis().getToAcc().book(Credit.createCredit(getThis().getDescription(), getThis().getAmount(), getThis().getFromAcc()));
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
