
package model;

import persistence.*;
import model.visitor.*;

/* Additional import section end */

public class ProgramModuleService extends model.subAdminService implements PersistentProgramModuleService{
    
    
    public static ProgramModuleService4Public createProgramModuleService(AdminService4Public parentService) throws PersistenceException{
        return createProgramModuleService(parentService,false);
    }
    
    public static ProgramModuleService4Public createProgramModuleService(AdminService4Public parentService,boolean delayed$Persistence) throws PersistenceException {
        PersistentProgramModuleService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade
                .newDelayedProgramModuleService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade
                .newProgramModuleService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("parentService", parentService);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ProgramModuleService4Public createProgramModuleService(AdminService4Public parentService,boolean delayed$Persistence,ProgramModuleService4Public This) throws PersistenceException {
        PersistentProgramModuleService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade
                .newDelayedProgramModuleService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade
                .newProgramModuleService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("parentService", parentService);
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
            AbstractPersistentRoot programManager = (AbstractPersistentRoot)this.getProgramManager();
            if (programManager != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    programManager, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("programManager", proxiInformation);
                
            }
            AbstractPersistentRoot moduleManager = (AbstractPersistentRoot)this.getModuleManager();
            if (moduleManager != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    moduleManager, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("moduleManager", proxiInformation);
                
            }
        }
        return result;
    }
    
    public ProgramModuleService provideCopy() throws PersistenceException{
        ProgramModuleService result = this;
        result = new ProgramModuleService(this.parentService, 
                                          this.subService, 
                                          this.This, 
                                          this.programManager, 
                                          this.moduleManager, 
                                          this.getId());
        result.errors = this.errors.copy(result);
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentProgramModuleServiceProgramManager programManager;
    protected PersistentProgramModuleServiceModuleManager moduleManager;
    
    public ProgramModuleService(PersistentAdminService parentService,SubjInterface subService,PersistentsubAdminService This,PersistentProgramModuleServiceProgramManager programManager,PersistentProgramModuleServiceModuleManager moduleManager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAdminService)parentService,(SubjInterface)subService,(PersistentsubAdminService)This,id);
        this.programManager = programManager;
        this.moduleManager = moduleManager;        
    }
    
    static public long getTypeId() {
        return -305;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -305) ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade
            .newProgramModuleService(this.getId());
        super.store();
        if(this.programManager != null){
            this.programManager.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade.programManagerSet(this.getId(), programManager);
        }
        if(this.moduleManager != null){
            this.moduleManager.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade.moduleManagerSet(this.getId(), moduleManager);
        }
        
    }
    
    public void setProgramManager(ProgramModuleServiceProgramManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.programManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.programManager = (PersistentProgramModuleServiceProgramManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade.programManagerSet(this.getId(), newValue);
        }
    }
    public void setModuleManager(ProgramModuleServiceModuleManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleManager = (PersistentProgramModuleServiceModuleManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramModuleServiceFacade.moduleManagerSet(this.getId(), newValue);
        }
    }
    public PersistentProgramModuleService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProgramModuleService result = (PersistentProgramModuleService)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProgramModuleService)this.This;
    }
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleProgramModuleService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramModuleService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramModuleService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramModuleService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getProgramManager() != null) return 1;
        if (this.getModuleManager() != null) return 1;
        return 0;
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
    public ModuleManager4Public getModuleManager() 
				throws PersistenceException{
        if (this.moduleManager== null) return null;
		return this.moduleManager.getObservee();
    }
    public ProgramManager4Public getProgramManager() 
				throws PersistenceException{
        if (this.programManager== null) return null;
		return this.programManager.getObservee();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProgramModuleService)This);
		if(this.isTheSameAs(This)){
			this.setParentService((PersistentAdminService)final$$Fields.get("parentService"));
		}
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToGroup() 
				throws model.UserException, PersistenceException{
        	return new ModuleAbstractSearchList(getThis().getModuleManager().
                getModules().getList());
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToProg() 
				throws model.UserException, PersistenceException{
        	return new ModuleAbstractSearchList(getThis().getModuleManager().
                getModules().getList());
    }
    public ModuleAbstractSearchList modules_Path_In_DeleteModules(final ModuleManager4Public manager) 
				throws model.UserException, PersistenceException{
        	return new ModuleAbstractSearchList(manager.
                getModules().getList());
    }
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromGroup(final ModuleGroup4Public group) 
				throws model.UserException, PersistenceException{
        	return new ModuleAbstractSearchList(group.
                getModules().getList());
    }
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromProg(final Program4Public program) 
				throws model.UserException, PersistenceException{
        	return new ModuleAbstractSearchList(program.
                getModules().getList());
    }
    public String programModuleService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    public ProgramSearchList programs_Path_In_DeletePrograms(final ProgramManager4Public manager) 
				throws model.UserException, PersistenceException{
        	return new ProgramSearchList(manager.
                getPrograms().getList());
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
    public void setModuleManager(final ModuleManager4Public moduleManager) 
				throws PersistenceException{
        if (this.moduleManager == null) {
			this.setModuleManager(model.ProgramModuleServiceModuleManager.createProgramModuleServiceModuleManager(this.isDelayed$Persistence()));
			this.moduleManager.setObserver(getThis());
		}
		this.moduleManager.setObservee(moduleManager);
    }
    public void setProgramManager(final ProgramManager4Public programManager) 
				throws PersistenceException{
        if (this.programManager == null) {
			this.setProgramManager(model.ProgramModuleServiceProgramManager.createProgramModuleServiceProgramManager(this.isDelayed$Persistence()));
			this.programManager.setObserver(getThis());
		}
		this.programManager.setObservee(programManager);
    }
    public UnitSearchList units_Path_In_RemoveUnit(final ModuleWithUnits4Public module) 
				throws model.UserException, PersistenceException{
        	return new UnitSearchList(module.
                getUnits().getList());
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
    
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
		modules.applyToAll(module -> getThis().getModuleManager().addModuleToGroup(group, module, getThis()));
    }
    public void addModuleToProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
		modules.applyToAll(module -> getThis().getProgramManager().addModuleToProg(program, module, getThis()));
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws PersistenceException{
		getThis().getModuleManager().addUnit(module, name, creditPoints, getThis());
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException{
		getThis().getModuleManager().changeCPOnModule(module, creditPoints, getThis());
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException{
		getThis().getModuleManager().changeCPOnUnit(unit, creditPoints, getThis());
    }
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException{
		getThis().getModuleManager().changeGradeSystem(module, getThis());
    }
    public void connected(final String user) 
				throws PersistenceException{

	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{

	}
    public void createModule(final String type, final String name) 
				throws PersistenceException{
		getThis().getModuleManager().createModule(type, name, getThis());
    }
    public void createProgram(final String name) 
				throws PersistenceException{
		getThis().getProgramManager().createProgram(name, getThis());
    }
    public void deleteModules(final ModuleManager4Public manager, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
    	modules.applyToAll(module -> {
    		manager.getModules().removeFirst(module);
    		module.delete$Me();
    	});
    	getThis().signalChanged(true);
    }
    public void deletePrograms(final ProgramManager4Public manager, final ProgramSearchList programs) 
				throws PersistenceException{
    	programs.applyToAll(program -> {
    		manager.getPrograms().removeFirst(program);
    		program.delete$Me();
    	});
    	getThis().signalChanged(true);
    }
    public void disconnected() 
				throws PersistenceException{
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		super.initializeOnCreation();
		getThis().setModuleManager(ModuleManager.createModuleManager(true));
		getThis().setProgramManager(ProgramManager.createProgramManager(true));
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		super.initializeOnInstantiation();
		getThis().updateMe();
	}
    public void moduleManager_update(final model.meta.ModuleManagerMssgs event) 
				throws PersistenceException{
    	getThis().updatePLZ();
    }
    public void programManager_update(final model.meta.ProgramManagerMssgs event) 
				throws PersistenceException{
    	getThis().updatePLZ();
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
		getThis().getErrors().filter(arg -> !arg.equals(error));
		getThis().signalChanged(true);
	}
    public void removeModuleFromGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
    	modules.applyToAll(module -> group.getModules().removeFirst(module));
        getThis().signalChanged(true);
    }
    public void removeModuleFromProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
    	modules.applyToAll(module -> program.getModules().removeFirst(module));
        getThis().signalChanged(true);
    }
    public void removeUnit(final ModuleWithUnits4Public module, final UnitSearchList units) 
				throws PersistenceException{
    	units.applyToAll(unit -> {
        	module.getUnits().removeFirst(unit);
        	unit.delete$Me();
        });
        getThis().signalChanged(true);
    }
    public void startStudyGroup(final Program4Public program, final String name) 
				throws PersistenceException{
		getThis().getProgramManager().startStudyGroup(program, name, getThis());
    }
    public void updateMe() 
				throws PersistenceException{
    	getThis().getProgramManager().getPrograms().filter(argument -> false);
    	Program.getProgramByName("%").applyToAll(program -> {
			if(getThis().getProgramManager().getPrograms().findFirst(argument -> argument.equals(program)) == null) {
				getThis().getProgramManager().getPrograms().add(program);
			}
		});
    	getThis().getModuleManager().getModules().filter(argument -> false);
		ModuleAbstract.getModuleAbstractByName("%").applyToAll(module -> {
			if(getThis().getModuleManager().getModules().findFirst(argument -> argument.equals(module)) == null) {
				getThis().getModuleManager().getModules().add(module);
			}
		});
        getThis().signalChanged(true);
    }
    public void updatePLZImplementation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
		new Thread(new Runnable() {
			public /* INTERNAL */ void run() {
				// Handle exception!
			}
		}).start();
	}
    public void handleResult(final Command command) 
				throws PersistenceException{
		new Thread(new Runnable() {
			public void /* INTERNAL */ run() {
				try {
					try {
						command.checkException();
						// Handle result!
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					// Handle fatal exception!
				}
			}
		}).start();
	}
    public boolean hasChanged() 
				throws PersistenceException{
		boolean result = this.changed;
		this.changed = false;
		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
