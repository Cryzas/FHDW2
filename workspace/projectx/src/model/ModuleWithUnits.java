
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleWithUnits extends model.ModuleAbstract implements PersistentModuleWithUnits{
    
    
    public static ModuleWithUnits4Public createModuleWithUnits(String name) throws PersistenceException{
        return createModuleWithUnits(name,false);
    }
    
    public static ModuleWithUnits4Public createModuleWithUnits(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleWithUnits result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newDelayedModuleWithUnits(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newModuleWithUnits(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleWithUnits4Public createModuleWithUnits(String name,boolean delayed$Persistence,ModuleWithUnits4Public This) throws PersistenceException {
        PersistentModuleWithUnits result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newDelayedModuleWithUnits(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
                .newModuleWithUnits(name,-1);
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
            result.put("units", this.getUnits().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleWithUnits provideCopy() throws PersistenceException{
        ModuleWithUnits result = this;
        result = new ModuleWithUnits(this.name, 
                                     this.This, 
                                     this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleWithUnits_UnitsProxi units;
    
    public ModuleWithUnits(String name,PersistentModuleAbstract This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentModuleAbstract)This,id);
        this.units = new ModuleWithUnits_UnitsProxi(this);        
    }
    
    static public long getTypeId() {
        return 154;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 154) ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsFacade
            .newModuleWithUnits(name,this.getId());
        super.store();
        this.getUnits().store();
        
    }
    
    public ModuleWithUnits_UnitsProxi getUnits() throws PersistenceException {
        return this.units;
    }
    public PersistentModuleWithUnits getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleWithUnits result = (PersistentModuleWithUnits)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleWithUnits)this.This;
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnits(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnits(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnits(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnits(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getUnits().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<Unit4Public> iterator0 = getThis().getUnits().iterator();
		while(iterator0.hasNext())
			if(((programHierarchyHIERARCHY)iterator0.next()).containsprogramHierarchy(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleWithUnits)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$units$$ModuleWithUnits = strategy.ModuleWithUnits$$units$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getUnits().iterator();
		while (iterator$$.hasNext()){
			Unit4Public current$$Field = (Unit4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchy(strategy);
			result$$units$$ModuleWithUnits = strategy.ModuleWithUnits$$units$$consolidate(getThis(), result$$units$$ModuleWithUnits, current$$);
		}
		T result = strategy.ModuleWithUnits$$finalize(getThis() ,result$$units$$ModuleWithUnits);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addUnit(final String name, final common.Fraction creditPoints) 
				throws model.CycleException, model.StudyProgramException, PersistenceException{
    	if(getThis().getUnits().findAll(unit -> unit.getName().equals(name)).getLength() > 0)
    		throw new StudyProgramException(AlreadyExistsInParentMessage);
    	getThis().getUnits().add(Unit.createUnit(name, creditPoints));        
    }
    public ModuleAbstractSGroup4Public copyForStudyGroup() 
				throws model.UserException, PersistenceException{
    	ModuleWithUnitsSGroup4Public toBeAdded = ModuleWithUnitsSGroup.createModuleWithUnitsSGroup(getThis().getName());
    	getThis().getUnits().applyToAllException(unit -> toBeAdded.addUnit(unit.copyForStudyGroup()));
    	return toBeAdded;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
		return getThis().getUnits().aggregate(Fraction.Null, (result, argument) -> result.add(argument.getCreditPoints()));
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
    
    static String AlreadyExistsInParentMessage = "Es existiert bereits eine Unit mit eingegebenem Namen in dem Modul.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
