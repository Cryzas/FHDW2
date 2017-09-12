
package model;

import persistence.*;
import model.visitor.*;

/* Additional import section end */

public class DozentenService extends model.Service implements PersistentDozentenService{
    
    
    public static DozentenService4Public createDozentenService() throws PersistenceException{
        return createDozentenService(false);
    }
    
    public static DozentenService4Public createDozentenService(boolean delayed$Persistence) throws PersistenceException {
        PersistentDozentenService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade
                .newDelayedDozentenService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade
                .newDozentenService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static DozentenService4Public createDozentenService(boolean delayed$Persistence,DozentenService4Public This) throws PersistenceException {
        PersistentDozentenService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade
                .newDelayedDozentenService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade
                .newDozentenService(-1);
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
            AbstractPersistentRoot groupManager = (AbstractPersistentRoot)this.getGroupManager();
            if (groupManager != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    groupManager, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("groupManager", proxiInformation);
                
            }
            AbstractPersistentRoot studentManager = (AbstractPersistentRoot)this.getStudentManager();
            if (studentManager != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    studentManager, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("studentManager", proxiInformation);
                
            }
        }
        return result;
    }
    
    public DozentenService provideCopy() throws PersistenceException{
        DozentenService result = this;
        result = new DozentenService(this.This, 
                                     this.programManager, 
                                     this.moduleManager, 
                                     this.groupManager, 
                                     this.studentManager, 
                                     this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentProgramManager programManager;
    protected PersistentModuleManager moduleManager;
    protected PersistentStudyGroupManager groupManager;
    protected PersistentStudentManager studentManager;
    
    public DozentenService(PersistentService This,PersistentProgramManager programManager,PersistentModuleManager moduleManager,PersistentStudyGroupManager groupManager,PersistentStudentManager studentManager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);
        this.programManager = programManager;
        this.moduleManager = moduleManager;
        this.groupManager = groupManager;
        this.studentManager = studentManager;        
    }
    
    static public long getTypeId() {
        return -287;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -287) ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade
            .newDozentenService(this.getId());
        super.store();
        if(this.getProgramManager() != null){
            this.getProgramManager().store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.programManagerSet(this.getId(), getProgramManager());
        }
        if(this.getModuleManager() != null){
            this.getModuleManager().store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.moduleManagerSet(this.getId(), getModuleManager());
        }
        if(this.getGroupManager() != null){
            this.getGroupManager().store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.groupManagerSet(this.getId(), getGroupManager());
        }
        if(this.getStudentManager() != null){
            this.getStudentManager().store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.studentManagerSet(this.getId(), getStudentManager());
        }
        
    }
    
    public ProgramManager4Public getProgramManager() throws PersistenceException {
        return this.programManager;
    }
    public void setProgramManager(ProgramManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.programManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.programManager = (PersistentProgramManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.programManagerSet(this.getId(), newValue);
        }
    }
    public ModuleManager4Public getModuleManager() throws PersistenceException {
        return this.moduleManager;
    }
    public void setModuleManager(ModuleManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.moduleManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.moduleManager = (PersistentModuleManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.moduleManagerSet(this.getId(), newValue);
        }
    }
    public StudyGroupManager4Public getGroupManager() throws PersistenceException {
        return this.groupManager;
    }
    public void setGroupManager(StudyGroupManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.groupManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.groupManager = (PersistentStudyGroupManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.groupManagerSet(this.getId(), newValue);
        }
    }
    public StudentManager4Public getStudentManager() throws PersistenceException {
        return this.studentManager;
    }
    public void setStudentManager(StudentManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.studentManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.studentManager = (PersistentStudentManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade.studentManagerSet(this.getId(), newValue);
        }
    }
    public PersistentDozentenService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentDozentenService result = (PersistentDozentenService)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentDozentenService)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleDozentenService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDozentenService(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDozentenService(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDozentenService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleDozentenService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDozentenService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDozentenService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDozentenService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleDozentenService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDozentenService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDozentenService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDozentenService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleDozentenService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleDozentenService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleDozentenService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleDozentenService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getProgramManager() != null) return 1;
        if (this.getModuleManager() != null) return 1;
        if (this.getGroupManager() != null) return 1;
        if (this.getStudentManager() != null) return 1;
        return 0;
    }
    
    
    public UnitSGroupSearchList ToUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        	return new UnitSGroupSearchList(module.
                getUnits().getList());
    }
    public String dozentenService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        	return new UnitSGroupSearchList(module.
                getUnits().getList());
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentDozentenService)This);
		if(this.isTheSameAs(This)){
		}
    }
    public ModuleAbstractStudentSearchList lecture_Path_In_ChangeGradeforStudent(final Student4Public student) 
				throws model.UserException, PersistenceException{
        	return new ModuleAbstractStudentSearchList(student.
                getProgram().
                getModules().getList());
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
    public StudentSearchList students_Path_In_AddStudentToGroup() 
				throws model.UserException, PersistenceException{
        	return new StudentSearchList(getThis().getStudentManager().
                getStudents().getList());
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
    public void addStudentToGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException{
		students.applyToAll(student -> getThis().getStudentManager().addStudentToGroup(group, student, getThis()));
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
    public void changeGradeOfModule(final ModuleAtomarStudent4Public module, final String grade, final String comment) 
				throws PersistenceException{
		getThis().getStudentManager().changeGrade(module, grade, comment, getThis());
	}
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade, final String comment) 
				throws PersistenceException{
		getThis().getStudentManager().changeGrade(unit, grade, comment, getThis());
	}
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException{
		getThis().getModuleManager().changeGradeSystem(module, getThis());
	}
    public void changeGradeforStudent(final Student4Public student, final LectureWithGrade lecture, final String grade, final String comment) 
				throws PersistenceException{
		getThis().getStudentManager().changeGrade(lecture, grade, comment, getThis());
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
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException{
		getThis().getStudentManager().createStudent(group, firstName, lastName, birthDate, getThis());
	}
    public void disconnected() 
				throws PersistenceException{
	}
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws PersistenceException{
		getThis().getGroupManager().endStudyGroup(studyGroup, getThis());
	}
    public String getUsername() 
				throws PersistenceException{
        return getThis().getParentServer().iterator().next().toString();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
		super.initializeOnCreation();
		getThis().setGroupManager(StudyGroupManager.createStudyGroupManager(true));
		getThis().setModuleManager(ModuleManager.createModuleManager(true));
		getThis().setProgramManager(ProgramManager.createProgramManager(true));
		getThis().setStudentManager(StudentManager.createStudentManager(true));
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		super.initializeOnInstantiation();
		Program.getProgramByName("%").applyToAll(program -> {
			if(getThis().getProgramManager().getPrograms().findFirst(argument -> argument.equals(program)) == null) {
				getThis().getProgramManager().getPrograms().add(program);
			}
		});
		ModuleAbstract.getModuleAbstractByName("%").applyToAll(module -> {
			if(getThis().getModuleManager().getModules().findFirst(argument -> argument.equals(module)) == null) {
				getThis().getModuleManager().getModules().add(module);
			}
		});
		StudyGroup.getStudyGroupByName("%").applyToAll(group -> {
			if(getThis().getGroupManager().getGroups().findFirst(argument -> argument.equals(group)) == null) {
				getThis().getGroupManager().getGroups().add(group);
			}
		});
		// TODO Students Instantiation
	}
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
		getThis().getErrors().filter(arg -> !arg.equals(error));
		getThis().signalChanged(true);
	}
    public void startStudyGroup(final Program4Public program, final String name) 
				throws PersistenceException{
		getThis().getGroupManager().startStudyGroup(program, name, getThis());
	}
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws PersistenceException{
		getThis().setModuleManager(ModuleManager.createModuleManager());
		getThis().setProgramManager(ProgramManager.createProgramManager());
		getThis().setGroupManager(StudyGroupManager.createStudyGroupManager());
		getThis().setStudentManager(StudentManager.createStudentManager());
		getThis().signalChanged(true);
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
