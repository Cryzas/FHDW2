
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleWithUnitsSGroup extends model.ModuleAbstractSGroup implements PersistentModuleWithUnitsSGroup{
    
    
    public static ModuleWithUnitsSGroup4Public createModuleWithUnitsSGroup(String name) throws PersistenceException{
        return createModuleWithUnitsSGroup(name,false);
    }
    
    public static ModuleWithUnitsSGroup4Public createModuleWithUnitsSGroup(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleWithUnitsSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newDelayedModuleWithUnitsSGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newModuleWithUnitsSGroup(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleWithUnitsSGroup4Public createModuleWithUnitsSGroup(String name,boolean delayed$Persistence,ModuleWithUnitsSGroup4Public This) throws PersistenceException {
        PersistentModuleWithUnitsSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newDelayedModuleWithUnitsSGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newModuleWithUnitsSGroup(name,-1);
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
    
    public ModuleWithUnitsSGroup provideCopy() throws PersistenceException{
        ModuleWithUnitsSGroup result = this;
        result = new ModuleWithUnitsSGroup(this.name, 
                                           this.This, 
                                           this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleWithUnitsSGroup_UnitsProxi units;
    
    public ModuleWithUnitsSGroup(String name,PersistentModuleAbstractSGroup This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentModuleAbstractSGroup)This,id);
        this.units = new ModuleWithUnitsSGroup_UnitsProxi(this);        
    }
    
    static public long getTypeId() {
        return 182;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 182) ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
            .newModuleWithUnitsSGroup(name,this.getId());
        super.store();
        this.getUnits().store();
        
    }
    
    public ModuleWithUnitsSGroup_UnitsProxi getUnits() throws PersistenceException {
        return this.units;
    }
    public PersistentModuleWithUnitsSGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleWithUnitsSGroup result = (PersistentModuleWithUnitsSGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleWithUnitsSGroup)this.This;
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getUnits().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<UnitSGroup4Public> iterator0 = getThis().getUnits().iterator();
		while(iterator0.hasNext())
			if(((programHierarchySGroupHIERARCHY)iterator0.next()).containsprogramHierarchySGroup(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleWithUnitsSGroup)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$units$$ModuleWithUnitsSGroup = strategy.ModuleWithUnitsSGroup$$units$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getUnits().iterator();
		while (iterator$$.hasNext()){
			UnitSGroup4Public current$$Field = (UnitSGroup4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchySGroup(strategy);
			result$$units$$ModuleWithUnitsSGroup = strategy.ModuleWithUnitsSGroup$$units$$consolidate(getThis(), result$$units$$ModuleWithUnitsSGroup, current$$);
		}
		T result = strategy.ModuleWithUnitsSGroup$$finalize(getThis() ,result$$units$$ModuleWithUnitsSGroup);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addUnit(final UnitSGroup4Public unit) 
				throws model.CycleException, model.StudyProgramException, PersistenceException{
    	if(getThis().containsprogramHierarchySGroup(unit))
    		throw new StudyProgramException(AlreadyExistsInParentMessage);
    	getThis().getUnits().add(unit);
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
    public void swapCPonModuleWithUnits(final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.StudyProgramException, PersistenceException{
    	getThis().getUnits().findFirst(unit -> unit.equals(fromUnit)).subCP(creditPoints);
    	getThis().getUnits().findFirst(unit -> unit.equals(ToUnit)).addCP(creditPoints);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String AlreadyExistsInParentMessage = "Es existiert bereits eine Unit mit eingegebenem Namen in dem Modul.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
