
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleWithUnitsStudent extends model.ModuleAbstractStudent implements PersistentModuleWithUnitsStudent{
    
    
    public static ModuleWithUnitsStudent4Public createModuleWithUnitsStudent(ModuleAbstractSGroup4Public moduleCopy) throws PersistenceException{
        return createModuleWithUnitsStudent(moduleCopy,false);
    }
    
    public static ModuleWithUnitsStudent4Public createModuleWithUnitsStudent(ModuleAbstractSGroup4Public moduleCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleWithUnitsStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
                .newDelayedModuleWithUnitsStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
                .newModuleWithUnitsStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleWithUnitsStudent4Public createModuleWithUnitsStudent(ModuleAbstractSGroup4Public moduleCopy,boolean delayed$Persistence,ModuleWithUnitsStudent4Public This) throws PersistenceException {
        PersistentModuleWithUnitsStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
                .newDelayedModuleWithUnitsStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
                .newModuleWithUnitsStudent(-1);
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
    
    public ModuleWithUnitsStudent provideCopy() throws PersistenceException{
        ModuleWithUnitsStudent result = this;
        result = new ModuleWithUnitsStudent(this.moduleCopy, 
                                            this.subService, 
                                            this.This, 
                                            this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleWithUnitsStudent_UnitsProxi units;
    
    public ModuleWithUnitsStudent(PersistentModuleAbstractSGroup moduleCopy,SubjInterface subService,PersistentModuleAbstractStudent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentModuleAbstractSGroup)moduleCopy,(SubjInterface)subService,(PersistentModuleAbstractStudent)This,id);
        this.units = new ModuleWithUnitsStudent_UnitsProxi(this);        
    }
    
    static public long getTypeId() {
        return 193;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 193) ConnectionHandler.getTheConnectionHandler().theModuleWithUnitsStudentFacade
            .newModuleWithUnitsStudent(this.getId());
        super.store();
        this.getUnits().store();
        
    }
    
    public ModuleWithUnitsStudent_UnitsProxi getUnits() throws PersistenceException {
        return this.units;
    }
    public PersistentModuleWithUnitsStudent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleWithUnitsStudent result = (PersistentModuleWithUnitsStudent)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleWithUnitsStudent)this.This;
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleWithUnitsStudent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleWithUnitsStudent(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleWithUnitsStudent(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getUnits().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<UnitStudent4Public> iterator0 = getThis().getUnits().iterator();
		while(iterator0.hasNext())
			if(((programHierarchyStudentHIERARCHY)iterator0.next()).containsprogramHierarchyStudent(part)) return true; 
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
        this.setThis((PersistentModuleWithUnitsStudent)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstractSGroup)final$$Fields.get("moduleCopy"));
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
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$units$$ModuleWithUnitsStudent = strategy.ModuleWithUnitsStudent$$units$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getUnits().iterator();
		while (iterator$$.hasNext()){
			UnitStudent4Public current$$Field = (UnitStudent4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchyStudent(strategy);
			result$$units$$ModuleWithUnitsStudent = strategy.ModuleWithUnitsStudent$$units$$consolidate(getThis(), result$$units$$ModuleWithUnitsStudent, current$$);
		}
		T result = strategy.ModuleWithUnitsStudent$$finalize(getThis() ,result$$units$$ModuleWithUnitsStudent);
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
    
    public void addUnit(final UnitStudent4Public unit) 
				throws model.CycleException, PersistenceException{
    	getThis().getUnits().add(unit);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public common.Fraction getCPmulGrade() 
				throws PersistenceException{
        return getThis().getUnits().aggregate(Fraction.Null, (result,argument) -> {
        	return result.add(argument.getCPmulGrade());
		} );
    }
    public common.Fraction getCPwithGrade() 
				throws PersistenceException{
        return getThis().getUnits().aggregate(Fraction.Null, (result,argument) -> {
			return result.add(argument.getCPwithGrade());
        });
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
		if(getThis().getCPwithGrade().equals(Fraction.Null)) {
			return NoGrade.getTheNoGrade();
		}
		return getThis().getCPmulGrade().div(getThis().getCPwithGrade()).toGradeinThird();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
    	return getThis().getUnits().aggregate(Fraction.Null, (result,argument) -> {
        	return result.add(argument.getPassedCP());
		} );
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
    
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return getThis().getModuleCopy().getFinished();
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
