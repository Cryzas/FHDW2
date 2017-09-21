
package model;

import persistence.*;
import model.visitor.*;

/* Additional import section end */

public class StudyGroupService extends model.subAdminService implements PersistentStudyGroupService{
    
    
    public static StudyGroupService4Public createStudyGroupService(AdminService4Public parentService) throws PersistenceException{
        return createStudyGroupService(parentService,false);
    }
    
    public static StudyGroupService4Public createStudyGroupService(AdminService4Public parentService,boolean delayed$Persistence) throws PersistenceException {
        PersistentStudyGroupService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceFacade
                .newDelayedStudyGroupService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceFacade
                .newStudyGroupService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("parentService", parentService);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudyGroupService4Public createStudyGroupService(AdminService4Public parentService,boolean delayed$Persistence,StudyGroupService4Public This) throws PersistenceException {
        PersistentStudyGroupService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceFacade
                .newDelayedStudyGroupService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceFacade
                .newStudyGroupService(-1);
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
            AbstractPersistentRoot groupManager = (AbstractPersistentRoot)this.getGroupManager();
            if (groupManager != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    groupManager, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("groupManager", proxiInformation);
                
            }
        }
        return result;
    }
    
    public StudyGroupService provideCopy() throws PersistenceException{
        StudyGroupService result = this;
        result = new StudyGroupService(this.parentService, 
                                       this.subService, 
                                       this.This, 
                                       this.groupManager, 
                                       this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentStudyGroupServiceGroupManager groupManager;
    
    public StudyGroupService(PersistentAdminService parentService,SubjInterface subService,PersistentsubAdminService This,PersistentStudyGroupServiceGroupManager groupManager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAdminService)parentService,(SubjInterface)subService,(PersistentsubAdminService)This,id);
        this.groupManager = groupManager;        
    }
    
    static public long getTypeId() {
        return -302;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -302) ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceFacade
            .newStudyGroupService(this.getId());
        super.store();
        if(this.groupManager != null){
            this.groupManager.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceFacade.groupManagerSet(this.getId(), groupManager);
        }
        
    }
    
    public void setGroupManager(StudyGroupServiceGroupManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.groupManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.groupManager = (PersistentStudyGroupServiceGroupManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupServiceFacade.groupManagerSet(this.getId(), newValue);
        }
    }
    public PersistentStudyGroupService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudyGroupService result = (PersistentStudyGroupService)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudyGroupService)this.This;
    }
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroupService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroupService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroupService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroupService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getGroupManager() != null && this.getGroupManager().getTheObject().getLeafInfo() != 0) return 1;
        return 0;
    }
    
    
    public UnitSGroupSearchList ToUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        	return new UnitSGroupSearchList(module.
                getUnits().getList());
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
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        	return new UnitSGroupSearchList(module.
                getUnits().getList());
    }
    public StudyGroupManager4Public getGroupManager() 
				throws PersistenceException{
        if (this.groupManager== null) return null;
		return this.groupManager.getObservee();
    }
    public StudyGroupSearchList groups_Path_In_DeleteStudyGroups() 
				throws model.UserException, PersistenceException{
        	return new StudyGroupSearchList(getThis().getGroupManager().
                getGroups().getList());
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudyGroupService)This);
		if(this.isTheSameAs(This)){
			this.setParentService((PersistentAdminService)final$$Fields.get("parentService"));
		}
    }
    public ModuleAbstractStudentSearchList lecture_Path_In_ChangeGradeforStudent(final Student4Public student) 
				throws model.UserException, PersistenceException{
        	return new ModuleAbstractStudentSearchList(student.
                getProgram().
                getModules().getList());
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
    public void setGroupManager(final StudyGroupManager4Public groupManager) 
				throws PersistenceException{
        if (this.groupManager == null) {
			this.setGroupManager(model.StudyGroupServiceGroupManager.createStudyGroupServiceGroupManager(this.isDelayed$Persistence()));
			this.groupManager.setObserver(getThis());
		}
		this.groupManager.setObservee(groupManager);
    }
    public StudentSearchList students_Path_In_AddStudentToGroup() 
				throws model.UserException, PersistenceException{
        	return new StudentSearchList(getThis().getStudents());
    }
    public StudentSearchList students_Path_In_RemoveStudentFromGroup(final StudyGroup4Public group) 
				throws model.UserException, PersistenceException{
        	return new StudentSearchList(group.
                getStudents().getList());
    }
    public String studyGroupService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
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
    
    public void addStudentToGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException{
		students.applyToAll(student -> getThis().getGroupManager().addStudentToGroup(group, student, getThis()));
	}
    public void changeGradeforStudent(final Student4Public student, final LectureWithGrade lecture, final String grade, final String comment) 
				throws PersistenceException{
        ((StudentManageService4Public)getThis().getParentService().getServices().findFirst(service -> service instanceof StudentManageService4Public)).changeGradeforStudent(student, lecture, grade, comment);
    }
    public void connected(final String user) 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException{
		getThis().getGroupManager().createStudent(group, firstName, lastName, birthDate, getThis());
	}
    public void deleteStudyGroups(final StudyGroupSearchList groups) 
				throws PersistenceException{
		groups.applyToAll(group -> {
    		getThis().getGroupManager().getGroups().removeFirst(group);
    		group.delete$Me();
    	});
    	getThis().signalChanged(true);
	}
    public void disconnected() 
				throws PersistenceException{
	}
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws PersistenceException{
		getThis().getGroupManager().endStudyGroup(studyGroup, getThis());
	}
    public StudentSearchList getStudents() 
				throws PersistenceException{
		return ((StudentManageService4Public)getThis().getParentService().getServices().findFirst(service -> service instanceof StudentManageService4Public)).getStudentManager().getStudents().getList();
	}
    public void groupManager_update(final model.meta.StudyGroupManagerMssgs event) 
				throws PersistenceException{
		getThis().updatePLZ();
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		super.initializeOnCreation();
		getThis().setGroupManager(StudyGroupManager.createStudyGroupManager());
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		super.initializeOnInstantiation();
		getThis().updateMe();
	}
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
		getThis().getErrors().filter(arg -> !arg.equals(error));
		getThis().signalChanged(true);
	}
    public void removeStudentFromGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException{
		students.applyToAll(student -> {
			group.getStudents().removeFirst(student);
			student.setProgram(NoProgram.getTheNoProgram());
		});
		getThis().updatePLZ();
		getThis().signalChanged(true);
	}
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws PersistenceException{
		getThis().getGroupManager().swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints, getThis());
	}
    public void updateMe() 
				throws PersistenceException{
    	getThis().getGroupManager().getGroups().filter(group -> false);
    	StudyGroup.getStudyGroupByName("%").applyToAll(group -> {
			if(getThis().getGroupManager().getGroups().findFirst(argument -> argument.equals(group)) == null) {
				getThis().getGroupManager().getGroups().add(group);
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
