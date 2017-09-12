
package model;

import persistence.*;


/* Additional import section end */

public abstract class ModuleAbstractSGroup extends PersistentObject implements PersistentModuleAbstractSGroup{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ModuleAbstractSGroup4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.getClass(objectId);
        return (ModuleAbstractSGroup4Public)PersistentProxi.createProxi(objectId, classId);
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
            result.put("name", this.getName());
            result.put("creditPoints", this.getCreditPoints().toString());
            AbstractPersistentRoot moduleCopy = (AbstractPersistentRoot)this.getModuleCopy();
            if (moduleCopy != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    moduleCopy, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("moduleCopy", proxiInformation);
                
            }
            AbstractPersistentRoot finished = (AbstractPersistentRoot)this.getFinished();
            if (finished != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    finished, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("finished", proxiInformation);
                
            }
        }
        return result;
    }
    
    public abstract ModuleAbstractSGroup provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentModuleAbstract moduleCopy;
    protected PersistentMyBoolean finished;
    protected PersistentModuleAbstractSGroup This;
    
    public ModuleAbstractSGroup(PersistentModuleAbstract moduleCopy,PersistentMyBoolean finished,PersistentModuleAbstractSGroup This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.moduleCopy = moduleCopy;
        this.finished = finished;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 176;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getModuleCopy() != null){
            this.getModuleCopy().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.moduleCopySet(this.getId(), getModuleCopy());
        }
        if(this.getFinished() != null){
            this.getFinished().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.finishedSet(this.getId(), getFinished());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ModuleAbstract4Public getModuleCopy() throws PersistenceException {
        return this.moduleCopy;
    }
    public void setModuleCopy(ModuleAbstract4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleCopy)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleCopy = (PersistentModuleAbstract)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.moduleCopySet(this.getId(), newValue);
        }
    }
    public MyBoolean4Public getFinished() throws PersistenceException {
        return this.finished;
    }
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.finished)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.finished = (PersistentMyBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.finishedSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentModuleAbstractSGroup newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentModuleAbstractSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractSGroupFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentModuleAbstractSGroup getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleAbstractSGroup)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstract)final$$Fields.get("moduleCopy"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setFinished(BFalse.getTheBFalse());        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    
    public String getName() 
				throws PersistenceException{
        return getThis().getModuleCopy().getName();
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
