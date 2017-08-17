
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleGroup extends model.ModuleAbstract implements PersistentModuleGroup{
    
    
    public static ModuleGroup4Public createModuleGroup(String name) throws PersistenceException{
        return createModuleGroup(name,false);
    }
    
    public static ModuleGroup4Public createModuleGroup(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newDelayedModuleGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newModuleGroup(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleGroup4Public createModuleGroup(String name,boolean delayed$Persistence,ModuleGroup4Public This) throws PersistenceException {
        PersistentModuleGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newDelayedModuleGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
                .newModuleGroup(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
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
    
    public ModuleGroup provideCopy() throws PersistenceException{
        ModuleGroup result = this;
        result = new ModuleGroup(this.name, 
                                 this.gradeSystem, 
                                 this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleGroup_ModulesProxi modules;
    
    public ModuleGroup(String name,PersistentGradeSystem gradeSystem,PersistentModuleAbstract This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentGradeSystem)gradeSystem,(PersistentModuleAbstract)This,id);
        this.modules = new ModuleGroup_ModulesProxi(this);        
    }
    
    static public long getTypeId() {
        return 166;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 166) ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
            .newModuleGroup(name,this.getId());
        super.store();
        this.getModules().store();
        
    }
    
    public ModuleGroup_ModulesProxi getModules() throws PersistenceException {
        return this.modules;
    }
    public PersistentModuleGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleGroup result = (PersistentModuleGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleGroup)this.This;
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<ModuleAbstract4Public> iterator0 = getThis().getModules().iterator();
		while(iterator0.hasNext())
			if(((programHierarchyHIERARCHY)iterator0.next()).containsprogramHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleGroup)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$modules$$ModuleGroup = strategy.ModuleGroup$$modules$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getModules().iterator();
		while (iterator$$.hasNext()){
			ModuleAbstract4Public current$$Field = (ModuleAbstract4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchy(strategy);
			result$$modules$$ModuleGroup = strategy.ModuleGroup$$modules$$consolidate(getThis(), result$$modules$$ModuleGroup, current$$);
		}
		T result = strategy.ModuleGroup$$finalize(getThis() ,result$$modules$$ModuleGroup);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModule(final ModuleAbstract4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
    	if(getThis().containsprogramHierarchy(module))
    		throw new AlreadyExistsInParentException(AlreadyExistsInParentMessage);
    	getThis().getModules().add(module);
    }
    public ModuleAbstractSGroup4Public copyForStudyGroup() 
				throws model.UserException, PersistenceException{
        ModuleGroupSGroup4Public toBeAdded = ModuleGroupSGroup.createModuleGroupSGroup(getThis());
        getThis().getModules().applyToAllException(module -> toBeAdded.addModule(module.copyForStudyGroup()));
        return toBeAdded;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
    	return getThis().getModules().aggregate(Fraction.Null, (result, argument) -> result.add(argument.getCreditPoints()));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        getThis().setGradeSystem(TenthGrade.getTheTenthGrade());
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String AlreadyExistsInParentMessage = "Das ausgewählte Modul ist bereits in der Modulgruppe.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
