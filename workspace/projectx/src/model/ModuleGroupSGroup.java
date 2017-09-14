
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleGroupSGroup extends model.ModuleAbstractSGroup implements PersistentModuleGroupSGroup{
    
    
    public static ModuleGroupSGroup4Public createModuleGroupSGroup(ModuleAbstract4Public moduleCopy) throws PersistenceException{
        return createModuleGroupSGroup(moduleCopy,false);
    }
    
    public static ModuleGroupSGroup4Public createModuleGroupSGroup(ModuleAbstract4Public moduleCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleGroupSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
                .newDelayedModuleGroupSGroup();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
                .newModuleGroupSGroup(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleGroupSGroup4Public createModuleGroupSGroup(ModuleAbstract4Public moduleCopy,boolean delayed$Persistence,ModuleGroupSGroup4Public This) throws PersistenceException {
        PersistentModuleGroupSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
                .newDelayedModuleGroupSGroup();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
                .newModuleGroupSGroup(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
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
            result.put("modules", this.getModules().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleGroupSGroup provideCopy() throws PersistenceException{
        ModuleGroupSGroup result = this;
        result = new ModuleGroupSGroup(this.moduleCopy, 
                                       this.finished, 
                                       this.This, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleGroupSGroup_ModulesProxi modules;
    
    public ModuleGroupSGroup(PersistentModuleAbstract moduleCopy,PersistentMyBoolean finished,PersistentModuleAbstractSGroup This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentModuleAbstract)moduleCopy,(PersistentMyBoolean)finished,(PersistentModuleAbstractSGroup)This,id);
        this.modules = new ModuleGroupSGroup_ModulesProxi(this);        
    }
    
    static public long getTypeId() {
        return 178;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 178) ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
            .newModuleGroupSGroup(this.getId());
        super.store();
        this.getModules().store();
        
    }
    
    public ModuleGroupSGroup_ModulesProxi getModules() throws PersistenceException {
        return this.modules;
    }
    public PersistentModuleGroupSGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleGroupSGroup result = (PersistentModuleGroupSGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleGroupSGroup)this.This;
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<ModuleAbstractSGroup4Public> iterator0 = getThis().getModules().iterator();
		while(iterator0.hasNext())
			if(((programHierarchySGroupHIERARCHY)iterator0.next()).containsprogramHierarchySGroup(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleGroupSGroup)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstract)final$$Fields.get("moduleCopy"));
		}
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$modules$$ModuleGroupSGroup = strategy.ModuleGroupSGroup$$modules$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getModules().iterator();
		while (iterator$$.hasNext()){
			ModuleAbstractSGroup4Public current$$Field = (ModuleAbstractSGroup4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchySGroup(strategy);
			result$$modules$$ModuleGroupSGroup = strategy.ModuleGroupSGroup$$modules$$consolidate(getThis(), result$$modules$$ModuleGroupSGroup, current$$);
		}
		T result = strategy.ModuleGroupSGroup$$finalize(getThis() ,result$$modules$$ModuleGroupSGroup);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModule(final ModuleAbstractSGroup4Public module) 
				throws model.CycleException, PersistenceException{
    	getThis().getModules().add(module);
    }
    public ModuleAbstractStudent4Public copyForStudent() 
				throws PersistenceException{
        ModuleGroupStudent4Public toBeAdded = ModuleGroupStudent.createModuleGroupStudent(getThis());
        try {
			getThis().getModules().applyToAllException(module -> toBeAdded.addModule(module.copyForStudent()));
		} catch (CycleException e) {
			throw new Error();
		}
        return toBeAdded;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void endModule() 
				throws PersistenceException{
        getThis().setFinished(BTrue.getTheBTrue());
        getThis().getModules().applyToAll(module -> module.endModule());
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
    	return getThis().getModules().aggregate(Fraction.Null, (result, argument) -> result.add(argument.getCreditPoints()));
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
