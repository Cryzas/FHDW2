
package model;

import persistence.*;


/* Additional import section end */

public abstract class Service extends PersistentObject implements PersistentService{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Service4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theServiceFacade.getClass(objectId);
        return (Service4Public)PersistentProxi.createProxi(objectId, classId);
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
            result.put("username", this.getUsername());
            result.put("parentServer", this.getParentServer().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            result.put("errors", this.getErrors().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, true, false));
        }
        return result;
    }
    
    public abstract Service provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistenceException exception = null;
    protected model.UserException userException = null;
    protected boolean changed = false;
    
    protected PersistentService This;
    protected Service_ErrorsProxi errors;
    
    public Service(PersistentService This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;
        this.errors = new Service_ErrorsProxi(this);        
    }
    
    static public long getTypeId() {
        return -288;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theServiceFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    protected void setThis(PersistentService newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServiceFacade.ThisSet(this.getId(), newValue);
        }
    }
    public Service_ErrorsProxi getErrors() throws PersistenceException {
        return this.errors;
    }
    public abstract PersistentService getThis() throws PersistenceException ;
    
    
    
    public ServerSearchList getParentServer() 
				throws PersistenceException{
        ServerSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theServerFacade
										.inverseGetService(getThis().getId(), getThis().getClassId());
		return result;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentService)This);
		if(this.isTheSameAs(This)){
		}
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        this.changed = signal;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
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
