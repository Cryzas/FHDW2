
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Transaction extends model.Bookable implements PersistentTransaction{
    
    
    public static Transaction4Public createTransaction(String subject) throws PersistenceException{
        return createTransaction(subject,false);
    }
    
    public static Transaction4Public createTransaction(String subject,boolean delayed$Persistence) throws PersistenceException {
        PersistentTransaction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newDelayedTransaction(subject);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newTransaction(subject,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("subject", subject);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Transaction4Public createTransaction(String subject,boolean delayed$Persistence,Transaction4Public This) throws PersistenceException {
        PersistentTransaction result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newDelayedTransaction(subject);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theTransactionFacade
                .newTransaction(subject,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("subject", subject);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("transfers", this.getTransfers().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Transaction provideCopy() throws PersistenceException{
        Transaction result = this;
        result = new Transaction(this.subject, 
                                 this.subService, 
                                 this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Transaction_TransfersProxi transfers;
    
    public Transaction(String subject,SubjInterface subService,PersistentBookable This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)subject,(SubjInterface)subService,(PersistentBookable)This,id);
        this.transfers = new Transaction_TransfersProxi(this);        
    }
    
    static public long getTypeId() {
        return 135;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 135) ConnectionHandler.getTheConnectionHandler().theTransactionFacade
            .newTransaction(subject,this.getId());
        super.store();
        this.getTransfers().store();
        
    }
    
    public Transaction_TransfersProxi getTransfers() throws PersistenceException {
        return this.transfers;
    }
    public PersistentTransaction getThis() throws PersistenceException {
        if(this.This == null){
            PersistentTransaction result = (PersistentTransaction)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentTransaction)this.This;
    }
    
    public void accept(BookableVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(BookableReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(BookableExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(BookableReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public void accept(bookableHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleTransaction(this);
    }
    public <R> R accept(bookableHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTransaction(this);
    }
    public <E extends model.UserException>  void accept(bookableHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTransaction(this);
    }
    public <R, E extends model.UserException> R accept(bookableHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTransaction(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getTransfers().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsbookableHierarchy(final bookableHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<Transfer4Public> iterator0 = getThis().getTransfers().iterator();
		while(iterator0.hasNext())
			if(((bookableHierarchyHIERARCHY)iterator0.next()).containsbookableHierarchy(part)) return true; 
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
        this.setThis((PersistentTransaction)This);
		if(this.isTheSameAs(This)){
			this.setSubject((String)final$$Fields.get("subject"));
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
        T result$$transfers$$Transaction = strategy.Transaction$$transfers$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getTransfers().iterator();
		while (iterator$$.hasNext()){
			Transfer4Public current$$Field = (Transfer4Public)iterator$$.next();
			T current$$ = current$$Field.strategybookableHierarchy(strategy);
			result$$transfers$$Transaction = strategy.Transaction$$transfers$$consolidate(getThis(), result$$transfers$$Transaction, current$$);
		}
		T result = strategy.Transaction$$finalize(getThis() ,result$$transfers$$Transaction);
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
    
    public void addTransfer(final Transfer4Public transfer) 
				throws PersistenceException{
    	try {
			getThis().getTransfers().add(transfer);
		} catch (CycleException e) {
			throw new PersistenceExceptionCycleTunnel(e);
		}
    }
    public void book() 
				throws PersistenceException{
    	getThis().getTransfers().applyToAll(transfer -> transfer.book());
        
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
    public void removeTransfer(final Transfer4Public transfer) 
				throws PersistenceException{
    	getThis().getTransfers().removeFirst(transfer);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
