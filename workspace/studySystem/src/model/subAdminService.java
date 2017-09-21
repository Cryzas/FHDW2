
package model;

import persistence.*;


/* Additional import section end */

public abstract class subAdminService extends PersistentObject implements PersistentsubAdminService{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static subAdminService4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.getClass(objectId);
        return (subAdminService4Public)PersistentProxi.createProxi(objectId, classId);
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
            AbstractPersistentRoot parentService = (AbstractPersistentRoot)this.getParentService();
            if (parentService != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    parentService, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("parentService", proxiInformation);
                
            }
            result.put("errors", this.getErrors().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, true, false));
        }
        return result;
    }
    
    public abstract subAdminService provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistenceException exception = null;
    protected model.UserException userException = null;
    protected boolean changed = false;
    
    protected PersistentAdminService parentService;
    protected SubjInterface subService;
    protected PersistentsubAdminService This;
    protected subAdminService_ErrorsProxi errors;
    
    public subAdminService(PersistentAdminService parentService,SubjInterface subService,PersistentsubAdminService This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.parentService = parentService;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;
        this.errors = new subAdminService_ErrorsProxi(this);        
    }
    
    static public long getTypeId() {
        return -291;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getParentService() != null){
            this.getParentService().store();
            ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.parentServiceSet(this.getId(), getParentService());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public AdminService4Public getParentService() throws PersistenceException {
        return this.parentService;
    }
    public void setParentService(AdminService4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.parentService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.parentService = (PersistentAdminService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.parentServiceSet(this.getId(), newValue);
        }
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
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentsubAdminService newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentsubAdminService)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().thesubAdminServiceFacade.ThisSet(this.getId(), newValue);
        }
    }
    public subAdminService_ErrorsProxi getErrors() throws PersistenceException {
        return this.errors;
    }
    public abstract PersistentsubAdminService getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentsubAdminService)This);
		if(this.isTheSameAs(This)){
			this.setParentService((PersistentAdminService)final$$Fields.get("parentService"));
		}
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        this.changed = signal;
    }
    public void updatePLZ() 
				throws PersistenceException{
        model.meta.subAdminServiceUpdatePLZMssg event = new model.meta.subAdminServiceUpdatePLZMssg(getThis());
		event.execute();
		getThis().updateObservers(event);
		event.getResult();
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
