
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ModuleAtomar extends model.ModuleAbstract implements PersistentModuleAtomar{
    
    
    public static ModuleAtomar4Public createModuleAtomar(String name) throws PersistenceException{
        return createModuleAtomar(name,false);
    }
    
    public static ModuleAtomar4Public createModuleAtomar(String name,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleAtomar result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newDelayedModuleAtomar(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newModuleAtomar(name,common.Fraction.Null,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleAtomar4Public createModuleAtomar(String name,boolean delayed$Persistence,ModuleAtomar4Public This) throws PersistenceException {
        PersistentModuleAtomar result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newDelayedModuleAtomar(name,common.Fraction.Null);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
                .newModuleAtomar(name,common.Fraction.Null,-1);
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
            AbstractPersistentRoot gradeSystem = (AbstractPersistentRoot)this.getGradeSystem();
            if (gradeSystem != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    gradeSystem, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("gradeSystem", proxiInformation);
                
            }
        }
        return result;
    }
    
    public ModuleAtomar provideCopy() throws PersistenceException{
        ModuleAtomar result = this;
        result = new ModuleAtomar(this.name, 
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
    
    public ModuleAtomar(String name,PersistentModuleAbstract This,common.Fraction ownCreditPoints,PersistentGradeSystem gradeSystem,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((String)name,(PersistentModuleAbstract)This,id);
        this.ownCreditPoints = ownCreditPoints;
        this.gradeSystem = gradeSystem;        
    }
    
    static public long getTypeId() {
        return 153;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 153) ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade
            .newModuleAtomar(name,ownCreditPoints,this.getId());
        super.store();
        if(this.getGradeSystem() != null){
            this.getGradeSystem().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade.gradeSystemSet(this.getId(), getGradeSystem());
        }
        
    }
    
    public common.Fraction getOwnCreditPoints() throws PersistenceException {
        return this.ownCreditPoints;
    }
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade.ownCreditPointsSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theModuleAtomarFacade.gradeSystemSet(this.getId(), newValue);
        }
    }
    public PersistentModuleAtomar getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleAtomar result = (PersistentModuleAtomar)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleAtomar)this.This;
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleAtomar)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.ModuleAtomar$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeCPOnModule(final common.Fraction creditPoints) 
				throws PersistenceException{
        getThis().setOwnCreditPoints(creditPoints);
    }
    public void changeGradeSystem(final GradeSystem4Public gradeSystem) 
				throws PersistenceException{
    	getThis().setGradeSystem(gradeSystem);
    }
    public ModuleAbstractSGroup4Public copyForStudyGroup() 
				throws model.UserException, PersistenceException{
    	return ModuleAtomarSGroup.createModuleAtomarSGroup(getThis(), getThis().getCreditPoints(), getThis().getGradeSystem());
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{ 
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
    	return getThis().getOwnCreditPoints();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
        getThis().setGradeSystem(ThirdGradeSystem.getTheThirdGradeSystem());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
