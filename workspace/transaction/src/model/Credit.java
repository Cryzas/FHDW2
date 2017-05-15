
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Credit extends model.Entry implements PersistentCredit{
    
    
    public static Credit4Public createCredit(Transfer4Public transfer) throws PersistenceException{
        return createCredit(transfer,false);
    }
    
    public static Credit4Public createCredit(Transfer4Public transfer,boolean delayed$Persistence) throws PersistenceException {
        PersistentCredit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreditFacade
                .newDelayedCredit();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreditFacade
                .newCredit(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("transfer", transfer);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Credit4Public createCredit(Transfer4Public transfer,boolean delayed$Persistence,Credit4Public This) throws PersistenceException {
        PersistentCredit result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCreditFacade
                .newDelayedCredit();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCreditFacade
                .newCredit(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("transfer", transfer);
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
    
    public Credit provideCopy() throws PersistenceException{
        Credit result = this;
        result = new Credit(this.transfer, 
                            this.subService, 
                            this.This, 
                            this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Credit(PersistentTransfer transfer,SubjInterface subService,PersistentEntry This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentTransfer)transfer,(SubjInterface)subService,(PersistentEntry)This,id);        
    }
    
    static public long getTypeId() {
        return 120;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 120) ConnectionHandler.getTheConnectionHandler().theCreditFacade
            .newCredit(this.getId());
        super.store();
        
    }
    
    public PersistentCredit getThis() throws PersistenceException {
        if(this.This == null){
            PersistentCredit result = (PersistentCredit)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentCredit)this.This;
    }
    
    public void accept(EntryVisitor visitor) throws PersistenceException {
        visitor.handleCredit(this);
    }
    public <R> R accept(EntryReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCredit(this);
    }
    public <E extends model.UserException>  void accept(EntryExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends model.UserException> R accept(EntryReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCredit(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCredit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCredit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCredit(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleCredit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCredit(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCredit(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCredit(this);
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
        this.setThis((PersistentCredit)This);
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
