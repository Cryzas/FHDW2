
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudentManageService extends model.subAdminService implements PersistentStudentManageService{
    
    
    public static StudentManageService4Public createStudentManageService(AdminService4Public parentService) throws PersistenceException{
        return createStudentManageService(parentService,false);
    }
    
    public static StudentManageService4Public createStudentManageService(AdminService4Public parentService,boolean delayed$Persistence) throws PersistenceException {
        PersistentStudentManageService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade
                .newDelayedStudentManageService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade
                .newStudentManageService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("parentService", parentService);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudentManageService4Public createStudentManageService(AdminService4Public parentService,boolean delayed$Persistence,StudentManageService4Public This) throws PersistenceException {
        PersistentStudentManageService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade
                .newDelayedStudentManageService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade
                .newStudentManageService(-1);
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
            AbstractPersistentRoot studentManager = (AbstractPersistentRoot)this.getStudentManager();
            if (studentManager != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    studentManager, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("studentManager", proxiInformation);
                
            }
        }
        return result;
    }
    
    public StudentManageService provideCopy() throws PersistenceException{
        StudentManageService result = this;
        result = new StudentManageService(this.parentService, 
                                          this.subService, 
                                          this.This, 
                                          this.studentManager, 
                                          this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentStudentManageServiceStudentManager studentManager;
    
    public StudentManageService(PersistentAdminService parentService,SubjInterface subService,PersistentsubAdminService This,PersistentStudentManageServiceStudentManager studentManager,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAdminService)parentService,(SubjInterface)subService,(PersistentsubAdminService)This,id);
        this.studentManager = studentManager;        
    }
    
    static public long getTypeId() {
        return -303;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -303) ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade
            .newStudentManageService(this.getId());
        super.store();
        if(this.studentManager != null){
            this.studentManager.store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade.studentManagerSet(this.getId(), studentManager);
        }
        
    }
    
    public void setStudentManager(StudentManageServiceStudentManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.studentManager)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.studentManager = (PersistentStudentManageServiceStudentManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudentManageServiceFacade.studentManagerSet(this.getId(), newValue);
        }
    }
    public PersistentStudentManageService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudentManageService result = (PersistentStudentManageService)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudentManageService)this.This;
    }
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleStudentManageService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentManageService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentManageService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentManageService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getStudentManager() != null && this.getStudentManager().getTheObject().getLeafInfo() != 0) return 1;
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
    public StudentManager4Public getStudentManager() 
				throws PersistenceException{
        if (this.studentManager== null) return null;
		return this.studentManager.getObservee();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudentManageService)This);
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
    public void setStudentManager(final StudentManager4Public studentManager) 
				throws PersistenceException{
        if (this.studentManager == null) {
			this.setStudentManager(model.StudentManageServiceStudentManager.createStudentManageServiceStudentManager(this.isDelayed$Persistence()));
			this.studentManager.setObserver(getThis());
		}
		this.studentManager.setObservee(studentManager);
    }
    public String studentManageService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    public StudentSearchList students_Path_In_DeleteStudents() 
				throws model.UserException, PersistenceException{
        	return new StudentSearchList(getThis().getStudentManager().
                getStudents().getList());
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
    
    public void changeGradeOfModule(final ModuleAtomarStudent4Public module, final String grade, final String comment) 
				throws PersistenceException{
		getThis().getStudentManager().changeGrade(module, grade, comment, getThis());
        
    }
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade, final String comment) 
				throws PersistenceException{
		getThis().getStudentManager().changeGrade(unit, grade, comment, getThis());
        
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
    public void deleteStudents(final StudentSearchList students) 
				throws PersistenceException{
    	students.applyToAll(student -> {
    		getThis().getStudentManager().getStudents().removeFirst(student);
    		student.delete$Me();
    		Server.getServerByUser(String.valueOf(student.getMatrNr())).iterator().next().delete$Me();
    	});
    	getThis().signalChanged(true);
    }
    public void disconnected() 
				throws PersistenceException{
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		getThis().setStudentManager(StudentManager.createStudentManager(true));
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
    public void studentManager_update(final model.meta.StudentManagerMssgs event) 
				throws PersistenceException{
        getThis().updatePLZ();
    }
    public void updateMe() 
				throws PersistenceException{
    	getThis().getStudentManager().getStudents().filter(student -> false);
    	ServerSearchList servers = Server.getServerByUser("%");
		servers.filter(server -> !server.getUser().equals(common.RPCConstantsAndServices.AdministratorName));
		servers.applyToAll(server -> {
			try {Student4Public student = Student.getById(Long.valueOf(server.getUser()));
			if(getThis().getStudentManager().getStudents().findFirst(argument -> argument.equals(student)) == null) {
				getThis().getStudentManager().getStudents().add(student);
			}
			} catch (NumberFormatException e) {
				
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
