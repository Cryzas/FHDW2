
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ModuleAtomarSGroup extends model.ModuleAbstractSGroup implements PersistentModuleAtomarSGroup{
    
    
    public static ModuleAtomarSGroup4Public createModuleAtomarSGroup(ModuleAbstract4Public moduleCopy,common.Fraction ownCreditPoints,GradeSystem4Public gradeSystem) throws PersistenceException{
        return createModuleAtomarSGroup(moduleCopy,ownCreditPoints,gradeSystem,false);
    }
    
    public static ModuleAtomarSGroup4Public createModuleAtomarSGroup(ModuleAbstract4Public moduleCopy,common.Fraction ownCreditPoints,GradeSystem4Public gradeSystem,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleAtomarSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newDelayedModuleAtomarSGroup(ownCreditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newModuleAtomarSGroup(ownCreditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
        final$$Fields.put("ownCreditPoints", ownCreditPoints);
        final$$Fields.put("gradeSystem", gradeSystem);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleAtomarSGroup4Public createModuleAtomarSGroup(ModuleAbstract4Public moduleCopy,common.Fraction ownCreditPoints,GradeSystem4Public gradeSystem,boolean delayed$Persistence,ModuleAtomarSGroup4Public This) throws PersistenceException {
        PersistentModuleAtomarSGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newDelayedModuleAtomarSGroup(ownCreditPoints);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
                .newModuleAtomarSGroup(ownCreditPoints,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
        final$$Fields.put("ownCreditPoints", ownCreditPoints);
        final$$Fields.put("gradeSystem", gradeSystem);
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
            AbstractPersistentRoot gradeSystem = (AbstractPersistentRoot)this.getGradeSystem();
            if (gradeSystem != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    gradeSystem, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("gradeSystem", proxiInformation);
                
            }
        }
        return result;
    }
    
    public ModuleAtomarSGroup provideCopy() throws PersistenceException{
        ModuleAtomarSGroup result = this;
        result = new ModuleAtomarSGroup(this.moduleCopy, 
                                        this.finished, 
                                        this.subService, 
                                        this.This, 
                                        this.ownCreditPoints, 
                                        this.gradeSystem, 
                                        this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected common.Fraction ownCreditPoints;
    protected PersistentGradeSystem gradeSystem;
    
    public ModuleAtomarSGroup(PersistentModuleAbstract moduleCopy,PersistentMyBoolean finished,SubjInterface subService,PersistentModuleAbstractSGroup This,common.Fraction ownCreditPoints,PersistentGradeSystem gradeSystem,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentModuleAbstract)moduleCopy,(PersistentMyBoolean)finished,(SubjInterface)subService,(PersistentModuleAbstractSGroup)This,id);
        this.ownCreditPoints = ownCreditPoints;
        this.gradeSystem = gradeSystem;        
    }
    
    static public long getTypeId() {
        return 179;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 179) ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
            .newModuleAtomarSGroup(ownCreditPoints,this.getId());
        super.store();
        if(this.getGradeSystem() != null){
            this.getGradeSystem().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade.gradeSystemSet(this.getId(), getGradeSystem());
        }
        
    }
    
    public common.Fraction getOwnCreditPoints() throws PersistenceException {
        return this.ownCreditPoints;
    }
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade.ownCreditPointsSet(this.getId(), newValue);
        this.ownCreditPoints = newValue;
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
            ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade.gradeSystemSet(this.getId(), newValue);
        }
    }
    public PersistentModuleAtomarSGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleAtomarSGroup result = (PersistentModuleAtomarSGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleAtomarSGroup)this.This;
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
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
        this.setThis((PersistentModuleAtomarSGroup)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstract)final$$Fields.get("moduleCopy"));
			this.setOwnCreditPoints((common.Fraction)final$$Fields.get("ownCreditPoints"));
			this.setGradeSystem((PersistentGradeSystem)final$$Fields.get("gradeSystem"));
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
        T result = strategy.ModuleAtomarSGroup$$finalize(getThis() );
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
    
    public ModuleAbstractStudent4Public copyForStudent() 
				throws PersistenceException{
    	return ModuleAtomarStudent.createModuleAtomarStudent(getThis());
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void endModule() 
				throws PersistenceException{
        getThis().setFinished(BTrue.getTheBTrue());
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return getThis().getOwnCreditPoints();
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
