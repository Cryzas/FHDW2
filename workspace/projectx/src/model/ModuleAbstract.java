
package model;

import persistence.*;


/* Additional import section end */

public abstract class ModuleAbstract extends PersistentObject implements PersistentModuleAbstract{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ModuleAbstract4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.getClass(objectId);
        return (ModuleAbstract4Public)PersistentProxi.createProxi(objectId, classId);
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
            AbstractPersistentRoot gradeSystem = (AbstractPersistentRoot)this.getGradeSystem();
            if (gradeSystem != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    gradeSystem, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("gradeSystem", proxiInformation);
                
            }
        }
        return result;
    }
    
    public static ModuleAbstractSearchList getModuleAbstractByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade
            .getModuleAbstractByName(name);
    }
    
    public abstract ModuleAbstract provideCopy() throws PersistenceException;
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentGradeSystem gradeSystem;
    protected PersistentModuleAbstract This;
    
    public ModuleAbstract(String name,PersistentGradeSystem gradeSystem,PersistentModuleAbstract This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.gradeSystem = gradeSystem;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 152;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        super.store();
        if(this.getGradeSystem() != null){
            this.getGradeSystem().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.gradeSystemSet(this.getId(), getGradeSystem());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public GradeSystem4Public getGradeSystem() throws PersistenceException {
        return this.gradeSystem;
    }
    public void setGradeSystem(GradeSystem4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.gradeSystem)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.gradeSystem = (PersistentGradeSystem)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.gradeSystemSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentModuleAbstract newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentModuleAbstract)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAbstractFacade.ThisSet(this.getId(), newValue);
        }
    }
    public abstract PersistentModuleAbstract getThis() throws PersistenceException ;
    
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleAbstract)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
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
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
