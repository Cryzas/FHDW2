
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Transfer extends model.Bookable implements PersistentTransfer{
    
    
    public static Transfer4Public createTransfer(String subject,Account4Public fromAccount,Account4Public toAccount,common.Fraction amount) throws PersistenceException{
        return createTransfer(subject,fromAccount,toAccount,amount,false);
    }
    
    public static Transfer4Public createTransfer(String subject,Account4Public fromAccount,Account4Public toAccount,common.Fraction amount,boolean delayed$Persistence) throws PersistenceException {
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(subject,amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(subject,amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("subject", subject);
        final$$Fields.put("fromAccount", fromAccount);
        final$$Fields.put("toAccount", toAccount);
        final$$Fields.put("amount", amount);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Transfer4Public createTransfer(String subject,Account4Public fromAccount,Account4Public toAccount,common.Fraction amount,boolean delayed$Persistence,Transfer4Public This) throws PersistenceException {
        PersistentTransfer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newDelayedTransfer(subject,amount);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransferFacade
                .newTransfer(subject,amount,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("subject", subject);
        final$$Fields.put("fromAccount", fromAccount);
        final$$Fields.put("toAccount", toAccount);
        final$$Fields.put("amount", amount);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("amount", this.getAmount().toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Transfer provideCopy() throws PersistenceException{
        Transfer result = this;
        result = new Transfer(this.subject, 
                              this.subService, 
                              this.This, 
                              this.fromAccount, 
                              this.toAccount, 
                              this.amount, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAccount fromAccount;
    protected PersistentAccount toAccount;
    protected common.Fraction amount;
    
    public Transfer(String subject,SubjInterface subService,PersistentBookable This,PersistentAccount fromAccount,PersistentAccount toAccount,common.Fraction amount,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)subject,(SubjInterface)subService,(PersistentBookable)This,id);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;        
    }
    
    static public long getTypeId() {
        return 121;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 121) ConnectionHandler.getTheConnectionHandler().theTransferFacade
            .newTransfer(subject,amount,this.getId());
        super.store();
        if(this.getFromAccount() != null){
            this.getFromAccount().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.fromAccountSet(this.getId(), getFromAccount());
        }
        if(this.getToAccount() != null){
            this.getToAccount().store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.toAccountSet(this.getId(), getToAccount());
        }
        
    }
    
    public Account4Public getFromAccount() throws PersistenceException {
        return this.fromAccount;
    }
    public void setFromAccount(Account4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.fromAccount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromAccount = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.fromAccountSet(this.getId(), newValue);
        }
    }
    public Account4Public getToAccount() throws PersistenceException {
        return this.toAccount;
    }
    public void setToAccount(Account4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.toAccount)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.toAccount = (PersistentAccount)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theTransferFacade.toAccountSet(this.getId(), newValue);
        }
    }
    public common.Fraction getAmount() throws PersistenceException {
        return this.amount;
    }
    public void setAmount(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theTransferFacade.amountSet(this.getId(), newValue);
        this.amount = newValue;
    }
    public PersistentTransfer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransfer result = (PersistentTransfer)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTransfer)this.This;
    }
    
    public void accept(BookableVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public void accept(bookableHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleTransfer(this);
    }
    public <R> R accept(bookableHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransfer(this);
    }
    public <E extends model.UserException>  void accept(bookableHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransfer(this);
    }
    public <R, E extends model.UserException> R accept(bookableHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransfer(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public boolean containsbookableHierarchy(final bookableHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
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
        this.setThis((PersistentTransfer)This);
		if(this.isTheSameAs(This)){
			this.setSubject((String)final$$Fields.get("subject"));
			this.setFromAccount((PersistentAccount)final$$Fields.get("fromAccount"));
			this.setToAccount((PersistentAccount)final$$Fields.get("toAccount"));
			this.setAmount((common.Fraction)final$$Fields.get("amount"));
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
    public <T> T strategybookableHierarchy(final bookableHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.Transfer$$finalize(getThis() );
		return result;
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
    
    public void book() 
				throws PersistenceException{
        getThis().getFromAccount().debit(getThis());
        getThis().getToAccount().credit(getThis());
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
