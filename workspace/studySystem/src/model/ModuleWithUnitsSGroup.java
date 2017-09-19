
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleWithUnitsSGroup extends model.ModuleAbstractSGroup implements PersistentModuleWithUnitsSGroup{
    
    
    public static ModuleWithUnitsSGroup4Public createModuleWithUnitsSGroup(ModuleAbstract4Public moduleCopy) throws PersistenceException{
        return createModuleWithUnitsSGroup(moduleCopy,false);
    }
    
    public static ModuleWithUnitsSGroup4Public createModuleWithUnitsSGroup(ModuleAbstract4Public moduleCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleWithUnitsSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newDelayedModuleWithUnitsSGroup();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newModuleWithUnitsSGroup(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleWithUnitsSGroup4Public createModuleWithUnitsSGroup(ModuleAbstract4Public moduleCopy,boolean delayed$Persistence,ModuleWithUnitsSGroup4Public This) throws PersistenceException {
        PersistentModuleWithUnitsSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newDelayedModuleWithUnitsSGroup();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsSGroupFacade
                .newModuleWithUnitsSGroup(-1);
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
            result.put("units", this.getUnits().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleWithUnitsSGroup provideCopy() throws PersistenceException{
        ModuleWithUnitsSGroup result = this;
        result = new ModuleWithUnitsSGroup(this.moduleCopy, 
                                           this.finished, 
                                           this.subService, 
                                           this.This, 
                                           this.getId());
        result.units = this.units.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleWithUnitsSGroup_UnitsProxi units;
    
    public ModuleWithUnitsSGroup(PersistentModuleAbstract moduleCopy,PersistentMyBoolean finished,SubjInterface subService,PersistentModuleAbstractSGroup This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentModuleAbstract)moduleCopy,(PersistentMyBoolean)finished,(SubjInterface)subService,(PersistentModuleAbstractSGroup)This,id);
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
            .newModuleWithUnitsSGroup(this.getId());
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsSGroup(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsSGroup(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
        this.setThis((PersistentModuleWithUnitsSGroup)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstract)final$$Fields.get("moduleCopy"));
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
    
    public void addUnit(final UnitSGroup4Public unit) 
				throws model.CycleException, PersistenceException{
    	getThis().getUnits().add(unit);
    }
    public ModuleAbstractStudent4Public copyForStudent() 
				throws PersistenceException{
    	ModuleWithUnitsStudent4Public toBeAdded = ModuleWithUnitsStudent.createModuleWithUnitsStudent(getThis());
    	try {
			getThis().getUnits().applyToAllException(unit -> toBeAdded.addUnit(unit.copyForStudent()));
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
        getThis().getUnits().applyToAll(unit -> unit.endUnit());
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
    public void swapCP(final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.AlreadyFinishedException, model.UnitSwapException, PersistenceException{
    	if(getThis().getFinished().toBoolean()) {
    		throw new AlreadyFinishedException(AlreadyFinishedMessage);
		}    	
    	if (creditPoints.lessOrEquals(Fraction.Null)) {
    		fromUnit.addCP(creditPoints.mul(Fraction.parse("-1")));
    		ToUnit.subCP(creditPoints.mul(Fraction.parse("-1")));
		} else {
	    	fromUnit.subCP(creditPoints);
	    	ToUnit.addCP(creditPoints);
		}
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String AlreadyFinishedMessage = "Der Studiengang ist bereits abgeschlossen.";    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
