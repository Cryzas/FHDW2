
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleGroupStudent extends model.ModuleAbstractStudent implements PersistentModuleGroupStudent{
    
    
    public static ModuleGroupStudent4Public createModuleGroupStudent(ModuleAbstractSGroup4Public moduleCopy) throws PersistenceException{
        return createModuleGroupStudent(moduleCopy,false);
    }
    
    public static ModuleGroupStudent4Public createModuleGroupStudent(ModuleAbstractSGroup4Public moduleCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleGroupStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
                .newDelayedModuleGroupStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
                .newModuleGroupStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleGroupStudent4Public createModuleGroupStudent(ModuleAbstractSGroup4Public moduleCopy,boolean delayed$Persistence,ModuleGroupStudent4Public This) throws PersistenceException {
        PersistentModuleGroupStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
                .newDelayedModuleGroupStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
                .newModuleGroupStudent(-1);
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
    
    public ModuleGroupStudent provideCopy() throws PersistenceException{
        ModuleGroupStudent result = this;
        result = new ModuleGroupStudent(this.moduleCopy, 
                                        this.This, 
                                        this.getId());
        result.modules = this.modules.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleGroupStudent_ModulesProxi modules;
    
    public ModuleGroupStudent(PersistentModuleAbstractSGroup moduleCopy,PersistentModuleAbstractStudent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentModuleAbstractSGroup)moduleCopy,(PersistentModuleAbstractStudent)This,id);
        this.modules = new ModuleGroupStudent_ModulesProxi(this);        
    }
    
    static public long getTypeId() {
        return 194;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 194) ConnectionHandler.getTheConnectionHandler().theModuleGroupStudentFacade
            .newModuleGroupStudent(this.getId());
        super.store();
        this.getModules().store();
        
    }
    
    public ModuleGroupStudent_ModulesProxi getModules() throws PersistenceException {
        return this.modules;
    }
    public PersistentModuleGroupStudent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleGroupStudent result = (PersistentModuleGroupStudent)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleGroupStudent)this.This;
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<ModuleAbstractStudent4Public> iterator0 = getThis().getModules().iterator();
		while(iterator0.hasNext())
			if(((programHierarchyStudentHIERARCHY)iterator0.next()).containsprogramHierarchyStudent(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleGroupStudent)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstractSGroup)final$$Fields.get("moduleCopy"));
		}
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$modules$$ModuleGroupStudent = strategy.ModuleGroupStudent$$modules$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getModules().iterator();
		while (iterator$$.hasNext()){
			ModuleAbstractStudent4Public current$$Field = (ModuleAbstractStudent4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchyStudent(strategy);
			result$$modules$$ModuleGroupStudent = strategy.ModuleGroupStudent$$modules$$consolidate(getThis(), result$$modules$$ModuleGroupStudent, current$$);
		}
		T result = strategy.ModuleGroupStudent$$finalize(getThis() ,result$$modules$$ModuleGroupStudent);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModule(final ModuleAbstractStudent4Public module) 
				throws model.CycleException, PersistenceException{
    	getThis().getModules().add(module);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public common.Fraction getCPmulGrade() 
				throws PersistenceException{
        return getThis().getModules().aggregate(Fraction.Null, (result,argument) -> {
				return result.add(argument.getCPmulGrade());
		} );
    }
    public common.Fraction getCPwithGrade() 
				throws PersistenceException{
        return getThis().getModules().aggregate(Fraction.Null, (result,argument) -> {
			return result.add(argument.getCPwithGrade());
		} );
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
		if(getThis().getCPwithGrade().equals(Fraction.Null)) {
			return NoGrade.getTheNoGrade();
		}
		return getThis().getCPmulGrade().div(getThis().getCPwithGrade()).toGradeinTenth();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
    	return getThis().getModules().aggregate(Fraction.Null, (result,argument) -> {
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
