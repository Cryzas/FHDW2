
package model;

import persistence.*;
import model.meta.ModuleAbstractSwitchPARAMETER;
import model.meta.StringFACTORY;
import model.visitor.*;


/* Additional import section end */

public class ModuleManager extends PersistentObject implements PersistentModuleManager{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ModuleManager4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade.getClass(objectId);
        return (ModuleManager4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ModuleManager4Public createModuleManager() throws PersistenceException{
        return createModuleManager(false);
    }
    
    public static ModuleManager4Public createModuleManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade
                .newDelayedModuleManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade
                .newModuleManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleManager4Public createModuleManager(boolean delayed$Persistence,ModuleManager4Public This) throws PersistenceException {
        PersistentModuleManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade
                .newDelayedModuleManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade
                .newModuleManager(-1);
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
            result.put("modules", this.getModules().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleManager provideCopy() throws PersistenceException{
        ModuleManager result = this;
        result = new ModuleManager(this.This, 
                                   this.getId());
        result.modules = this.modules.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ModuleManager_ModulesProxi modules;
    protected PersistentModuleManager This;
    
    public ModuleManager(PersistentModuleManager This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.modules = new ModuleManager_ModulesProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 145;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 145) ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade
            .newModuleManager(this.getId());
        super.store();
        this.getModules().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ModuleManager_ModulesProxi getModules() throws PersistenceException {
        return this.modules;
    }
    protected void setThis(PersistentModuleManager newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentModuleManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleManagerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentModuleManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleManager result = (PersistentModuleManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleManager)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstract4Public module, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddModuleToGroupCommand4Public command = model.meta.AddModuleToGroupCommand.createAddModuleToGroupCommand(nw, d1170);
		command.setGroup(group);
		command.setModule(module);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		AddUnitCommand4Public command = model.meta.AddUnitCommand.createAddUnitCommand(name, creditPoints, nw, d1170);
		command.setModule(module);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeCPOnModuleCommand4Public command = model.meta.ChangeCPOnModuleCommand.createChangeCPOnModuleCommand(creditPoints, nw, d1170);
		command.setModule(module);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeCPOnUnitCommand4Public command = model.meta.ChangeCPOnUnitCommand.createChangeCPOnUnitCommand(creditPoints, nw, d1170);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void changeGradeSystem(final ModuleAtomar4Public module, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		ChangeGradeSystemCommand4Public command = model.meta.ChangeGradeSystemCommand.createChangeGradeSystemCommand(nw, d1170);
		command.setModule(module);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void createModule(final String type, final String name, final Invoker invoker) 
				throws PersistenceException{
        java.sql.Date nw = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Date d1170 = new java.sql.Date(new java.util.Date(0).getTime());
		CreateModuleCommand4Public command = model.meta.CreateModuleCommand.createCreateModuleCommand(type, name, nw, d1170);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentModuleManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstract4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
    	group.addModule(module);
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
    	module.addUnit(name, creditPoints);
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException{
        module.changeCPOnModule(creditPoints);        
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException{
        unit.changeCPOnUnit(creditPoints);
    }
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException{
    	GradeSystem4Public newSystem = module.getGradeSystem().accept(new GradeSystemReturnVisitor<GradeSystem4Public>() {

			@Override
			public GradeSystem4Public handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGrade) throws PersistenceException {
				return ThirdGradeSystem.getTheThirdGradeSystem();
			}

			@Override
			public GradeSystem4Public handleThirdGradeSystem(ThirdGradeSystem4Public thirdGrade) throws PersistenceException {
				return SimpleGradeSystem.getTheSimpleGradeSystem();
			}
		});
    	module.changeGradeSystem(newSystem);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void createModule(final String type, final String name) 
				throws model.AlreadyExistsInParentException, PersistenceException{
    	if (ModuleAbstract.getModuleAbstractByName(name).iterator().hasNext()) {
			throw new AlreadyExistsInParentException(String.format(ModuleAlreadyExistsInDBMessage, name));
		}
    	if (Program.getProgramByName(name).iterator().hasNext()) {
			throw new AlreadyExistsInParentException(String.format(ProgramAlreadyExistsInDBMessage, name));
		}
    	getThis().getModules().add(StringFACTORY.createObjectBySubTypeNameForModuleAbstract(type, new ModuleAbstractSwitchPARAMETER() {
			
			@Override
			public ModuleWithUnits4Public handleModuleWithUnits() throws PersistenceException {
				return ModuleWithUnits.createModuleWithUnits(name);
			}
			
			@Override
			public ModuleAtomar4Public handleModuleAtomar() throws PersistenceException {
				return ModuleAtomar.createModuleAtomar(name);
			}

			@Override
			public ModuleGroup4Public handleModuleGroup() throws PersistenceException {
				return ModuleGroup.createModuleGroup(name);
			}
    	}));
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */

    static String ProgramAlreadyExistsInDBMessage = "Es existiert bereits ein Programm mit dem Namen %s.";
    static String ModuleAlreadyExistsInDBMessage = "Es existiert bereits ein Modul mit dem Namen %s.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
