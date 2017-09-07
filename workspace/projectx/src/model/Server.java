
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class Server extends PersistentObject implements PersistentServer{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static Server4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theServerFacade.getClass(objectId);
        return (Server4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static Server4Public createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay) throws PersistenceException{
        return createServer(password,user,hackCount,hackDelay,false);
    }
    
    public static Server4Public createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,boolean delayed$Persistence) throws PersistenceException {
        if (password == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (user == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newDelayedServer(password,user,hackCount,hackDelay);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newServer(password,user,hackCount,hackDelay,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("password", password);
        final$$Fields.put("user", user);
        final$$Fields.put("hackCount", hackCount);
        final$$Fields.put("hackDelay", hackDelay);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static Server4Public createServer(String password,String user,long hackCount,java.sql.Timestamp hackDelay,boolean delayed$Persistence,Server4Public This) throws PersistenceException {
        if (password == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if (user == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentServer result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newDelayedServer(password,user,hackCount,hackDelay);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theServerFacade
                .newServer(password,user,hackCount,hackDelay,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("password", password);
        final$$Fields.put("user", user);
        final$$Fields.put("hackCount", hackCount);
        final$$Fields.put("hackDelay", hackDelay);
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
            result.put("errors", this.getErrors().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, true, false));
            result.put("user", this.getUser());
        }
        return result;
    }
    
    public static ServerSearchList getServerByUser(String user) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theServerFacade
            .getServerByUser(user);
    }
    
    public Server provideCopy() throws PersistenceException{
        Server result = this;
        result = new Server(this.programManager, 
                            this.moduleManager, 
                            this.groupManager, 
                            this.studentManager, 
                            this.This, 
                            this.password, 
                            this.user, 
                            this.hackCount, 
                            this.hackDelay, 
                            this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistenceException exception = null;
    protected model.UserException userException = null;
    protected boolean changed = false;
    
    protected PersistentProgramManager programManager;
    protected PersistentModuleManager moduleManager;
    protected PersistentStudyGroupManager groupManager;
    protected PersistentStudentManager studentManager;
    protected PersistentServer This;
    protected Server_ErrorsProxi errors;
    protected String password;
    protected String user;
    protected long hackCount;
    protected java.sql.Timestamp hackDelay;
    
    public Server(PersistentProgramManager programManager,PersistentModuleManager moduleManager,PersistentStudyGroupManager groupManager,PersistentStudentManager studentManager,PersistentServer This,String password,String user,long hackCount,java.sql.Timestamp hackDelay,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.programManager = programManager;
        this.moduleManager = moduleManager;
        this.groupManager = groupManager;
        this.studentManager = studentManager;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;
        this.errors = new Server_ErrorsProxi(this);
        this.password = password;
        this.user = user;
        this.hackCount = hackCount;
        this.hackDelay = hackDelay;        
    }
    
    static public long getTypeId() {
        return -102;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -102) ConnectionHandler.getTheConnectionHandler().theServerFacade
            .newServer(password,user,hackCount,hackDelay,this.getId());
        super.store();
        if(this.getProgramManager() != null){
            this.getProgramManager().store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.programManagerSet(this.getId(), getProgramManager());
        }
        if(this.getModuleManager() != null){
            this.getModuleManager().store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.moduleManagerSet(this.getId(), getModuleManager());
        }
        if(this.getGroupManager() != null){
            this.getGroupManager().store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.groupManagerSet(this.getId(), getGroupManager());
        }
        if(this.getStudentManager() != null){
            this.getStudentManager().store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.studentManagerSet(this.getId(), getStudentManager());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), getThis());
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
            ConnectionHandler.getTheConnectionHandler().theServerFacade.programManagerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theServerFacade.moduleManagerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theServerFacade.groupManagerSet(this.getId(), newValue);
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
            ConnectionHandler.getTheConnectionHandler().theServerFacade.studentManagerSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentServer newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentServer)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), newValue);
        }
    }
    public Server_ErrorsProxi getErrors() throws PersistenceException {
        return this.errors;
    }
    public String getPassword() throws PersistenceException {
        return this.password;
    }
    public void setPassword(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.passwordSet(this.getId(), newValue);
        this.password = newValue;
    }
    public String getUser() throws PersistenceException {
        return this.user;
    }
    public void setUser(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.userSet(this.getId(), newValue);
        this.user = newValue;
    }
    public long getHackCount() throws PersistenceException {
        return this.hackCount;
    }
    public void setHackCount(long newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.hackCountSet(this.getId(), newValue);
        this.hackCount = newValue;
    }
    public java.sql.Timestamp getHackDelay() throws PersistenceException {
        return this.hackDelay;
    }
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theServerFacade.hackDelaySet(this.getId(), newValue);
        this.hackDelay = newValue;
    }
    public PersistentServer getThis() throws PersistenceException {
        if(this.This == null){
            PersistentServer result = (PersistentServer)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentServer)this.This;
    }
    
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleServer(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleServer(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleServer(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleServer(this);
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
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        	return new UnitSGroupSearchList(module.
                getUnits().getList());
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentServer)This);
		if(this.isTheSameAs(This)){
			this.setPassword((String)final$$Fields.get("password"));
			this.setUser((String)final$$Fields.get("user"));
			this.setHackCount((Long)final$$Fields.get("hackCount"));
			this.setHackDelay((java.sql.Timestamp)final$$Fields.get("hackDelay"));
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
    public String server_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        this.changed = signal;
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
    public void changeGradeOfModule(final ModuleAtomarStudent4Public module, final String grade) 
				throws PersistenceException{
    	getThis().getStudentManager().changeGradeOfModule(module, grade, getThis());
    }
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade) 
				throws PersistenceException{
    	getThis().getStudentManager().changeGradeOfUnit(unit, grade, getThis());
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
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException{
    	getThis().getStudentManager().createStudent(group, firstName, lastName, birthDate, getThis());        
    }
    public void disconnected() 
				throws PersistenceException{
        
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public /*INTERNAL*/ void run() {
				//Handle exception!
			}
		}).start();
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public void  /*INTERNAL*/  run() {
				try {
					try {
						command.checkException();
						//Handle result!
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
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
    public void initializeOnCreation() 
				throws PersistenceException{ 
    	getThis().setModuleManager(ModuleManager.createModuleManager());
    	getThis().setProgramManager(ProgramManager.createProgramManager());
    	getThis().setGroupManager(StudyGroupManager.createStudyGroupManager());
    	getThis().setStudentManager(StudentManager.createStudentManager());
    	getThis().signalChanged(true); 
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{    
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
    	getThis().getGroupManager().swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints, getThis());
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
