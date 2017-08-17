
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudyGroupManager extends PersistentObject implements PersistentStudyGroupManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static StudyGroupManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.getClass(objectId);
        return (StudyGroupManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static StudyGroupManager4Public createStudyGroupManager() throws PersistenceException{
        return createStudyGroupManager(false);
    }
    
    public static StudyGroupManager4Public createStudyGroupManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentStudyGroupManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newDelayedStudyGroupManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newStudyGroupManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudyGroupManager4Public createStudyGroupManager(boolean delayed$Persistence,StudyGroupManager4Public This) throws PersistenceException {
        PersistentStudyGroupManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newDelayedStudyGroupManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
                .newStudyGroupManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
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
            result.put("groups", this.getGroups().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public StudyGroupManager provideCopy() throws PersistenceException{
        StudyGroupManager result = this;
        result = new StudyGroupManager(this.This, 
                                       this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected StudyGroupManager_GroupsProxi groups;
    protected PersistentStudyGroupManager This;
    
    public StudyGroupManager(PersistentStudyGroupManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.groups = new StudyGroupManager_GroupsProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 186;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 186) ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade
            .newStudyGroupManager(this.getId());
        super.store();
        this.getGroups().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public StudyGroupManager_GroupsProxi getGroups() throws PersistenceException {
        return this.groups;
    }
    protected void setThis(PersistentStudyGroupManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentStudyGroupManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentStudyGroupManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudyGroupManager result = (PersistentStudyGroupManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudyGroupManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getGroups().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudyGroupManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public void startStudyGroup(final Program4Public program, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		StartStudyGroupCommand4Public command = model.meta.StartStudyGroupCommand.createStartStudyGroupCommand(name, nw, d1170);
		command.setProgram(program);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		SwapCPonModuleWithUnitsCommand4Public command = model.meta.SwapCPonModuleWithUnitsCommand.createSwapCPonModuleWithUnitsCommand(creditPoints, nw, d1170);
		command.setModule(module);
		command.setFromUnit(fromUnit);
		command.setToUnit(ToUnit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
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
    public void startStudyGroup(final Program4Public program, final String name) 
				throws model.UserException, PersistenceException{
    	StudyGroup4Public toBeAdded = StudyGroup.createStudyGroup(name);
    	toBeAdded.setProgram(program.copyForStudyGroup());
    	getThis().getGroups().add(toBeAdded);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws model.UnitSwapException, PersistenceException{
    	module.swapCPonModuleWithUnits(fromUnit, ToUnit, creditPoints);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
