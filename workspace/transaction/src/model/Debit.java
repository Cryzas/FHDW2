
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Debit extends model.Entry implements PersistentDebit{
    
    
    public static Debit4Public createDebit(Transfer4Public transfer) throws PersistenceException{
        return createDebit(transfer,false);
    }
    
    public static Debit4Public createDebit(Transfer4Public transfer,boolean delayed$Persistence) throws PersistenceException {
        PersistentDebit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDelayedDebit();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDebit(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("transfer", transfer);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Debit4Public createDebit(Transfer4Public transfer,boolean delayed$Persistence,Debit4Public This) throws PersistenceException {
        PersistentDebit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDelayedDebit();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDebitFacade
                .newDebit(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("transfer", transfer);
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
    
    public Debit provideCopy() throws PersistenceException{
        Debit result = this;
        result = new Debit(this.transfer, 
                           this.subService, 
                           this.This, 
                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Debit(PersistentTransfer transfer,SubjInterface subService,PersistentEntry This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentTransfer)transfer,(SubjInterface)subService,(PersistentEntry)This,id);        
    }
    
    static public long getTypeId() {
        return 116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 116) ConnectionHandler.getTheConnectionHandler().theDebitFacade
            .newDebit(this.getId());
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleDebit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDebit(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDebit(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDebit(this);
    }
    public int getLeafInfo() throws PersistenceException{
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
        this.setThis((PersistentDebit)This);
		if(this.isTheSameAs(This)){
			this.setTransfer((PersistentTransfer)final$$Fields.get("transfer"));
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
