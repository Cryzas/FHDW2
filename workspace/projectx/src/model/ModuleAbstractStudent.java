
package model;

import persistence.*;


/* Additional import section end */

public abstract class ModuleAbstractStudent extends PersistentObject implements PersistentModuleAbstractStudent{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ModuleAbstractStudent4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.getClass(objectId);
        return (ModuleAbstractStudent4Public)PersistentProxi.createProxi(objectId, classId);
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
            AbstractPersistentRoot moduleCopy = (AbstractPersistentRoot)this.getModuleCopy();
            if (moduleCopy != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    moduleCopy, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("moduleCopy", proxiInformation);
                
            }
            result.put("name", this.getName());
            result.put("creditPoints", this.getCreditPoints().toString());
        }
        return result;
    }
    
    public abstract ModuleAbstractStudent provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentModuleAbstractSGroup moduleCopy;
    protected PersistentModuleAbstractStudent This;
    
    public ModuleAbstractStudent(PersistentModuleAbstractSGroup moduleCopy,PersistentModuleAbstractStudent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.moduleCopy = moduleCopy;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 196;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getModuleCopy() != null){
            this.getModuleCopy().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.moduleCopySet(this.getId(), getModuleCopy());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ModuleAbstractSGroup4Public getModuleCopy() throws PersistenceException {
        return this.moduleCopy;
    }
    public void setModuleCopy(ModuleAbstractSGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleCopy)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleCopy = (PersistentModuleAbstractSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.moduleCopySet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentModuleAbstractStudent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentModuleAbstractStudent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractStudentFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentModuleAbstractStudent getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleAbstractStudent)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstractSGroup)final$$Fields.get("moduleCopy"));
		}
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
    
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
    	return getThis().getModuleCopy().getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
    	return getThis().getModuleCopy().getName();
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
