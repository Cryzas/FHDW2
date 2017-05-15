
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ErrorDisplay extends PersistentObject implements PersistentErrorDisplay{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ErrorDisplay4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade.getClass(objectId);
        return (ErrorDisplay4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ErrorDisplay4Public createErrorDisplay(String message) throws PersistenceException{
        return createErrorDisplay(message,false);
    }
    
    public static ErrorDisplay4Public createErrorDisplay(String message,boolean delayed$Persistence) throws PersistenceException {
        PersistentErrorDisplay result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
                .newDelayedErrorDisplay();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
                .newErrorDisplay(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("message", message);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ErrorDisplay4Public createErrorDisplay(String message,boolean delayed$Persistence,ErrorDisplay4Public This) throws PersistenceException {
        PersistentErrorDisplay result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
                .newDelayedErrorDisplay();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
                .newErrorDisplay(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("message", message);
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
    
    public ErrorDisplay provideCopy() throws PersistenceException{
        ErrorDisplay result = this;
        result = new ErrorDisplay(this.getId());
        result.message = this.message;
        result.subService = this.subService;
        result.This = this.This;
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String message;
    protected SubjInterface subService;
    protected PersistentErrorDisplay This;
    
    public ErrorDisplay(long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);        
    }
    
    static public long getTypeId() {
        return -103;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -103) ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
            .newErrorDisplay(this.getId());
        super.store();
        
    }
    
    public String getMessage() throws PersistenceException {
        return this.message;
    }
    public void setMessage(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        this.message = newValue;
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
    }
    protected void setThis(PersistentErrorDisplay newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentErrorDisplay)PersistentProxi.createProxi(objectId, classId);
    }
    public PersistentErrorDisplay getThis() throws PersistenceException {
        if(this.This == null){
            PersistentErrorDisplay result = (PersistentErrorDisplay)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentErrorDisplay)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErrorDisplay(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErrorDisplay(this);
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
        this.setThis((PersistentErrorDisplay)This);
		if(this.isTheSameAs(This)){
			this.setMessage((String)final$$Fields.get("message"));
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
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    public String toString(){
		 return this.message;
	}
    /* End of protected part that is not overridden by persistence generator */
    
}
