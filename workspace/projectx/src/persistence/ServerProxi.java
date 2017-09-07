package persistence;



import model.visitor.*;

public class ServerProxi extends PersistentProxi implements PersistentServer{
    
    public ServerProxi(long objectId) {
        super(objectId);
    }
    public ServerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -102;
    }
    
    public ProgramManager4Public getProgramManager() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getProgramManager();
    }
    public void setProgramManager(ProgramManager4Public newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setProgramManager(newValue);
    }
    public ModuleManager4Public getModuleManager() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getModuleManager();
    }
    public void setModuleManager(ModuleManager4Public newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setModuleManager(newValue);
    }
    public StudyGroupManager4Public getGroupManager() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getGroupManager();
    }
    public void setGroupManager(StudyGroupManager4Public newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setGroupManager(newValue);
    }
    public StudentManager4Public getStudentManager() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getStudentManager();
    }
    public void setStudentManager(StudentManager4Public newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setStudentManager(newValue);
    }
    public Server_ErrorsProxi getErrors() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getErrors();
    }
    public String getPassword() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getPassword();
    }
    public void setPassword(String newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setPassword(newValue);
    }
    public String getUser() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getUser();
    }
    public void setUser(String newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setUser(newValue);
    }
    public long getHackCount() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getHackCount();
    }
    public void setHackCount(long newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setHackCount(newValue);
    }
    public java.sql.Timestamp getHackDelay() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getHackDelay();
    }
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException {
        ((PersistentServer)this.getTheObject()).setHackDelay(newValue);
    }
    public PersistentServer getThis() throws PersistenceException {
        return ((PersistentServer)this.getTheObject()).getThis();
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
    
    
    public UnitSGroupSearchList ToUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        return ((PersistentServer)this.getTheObject()).ToUnit_Path_In_SwapCPonModuleWithUnits(module);
    }
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        return ((PersistentServer)this.getTheObject()).fromUnit_Path_In_SwapCPonModuleWithUnits(module);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ModuleAbstractStudentSearchList lecture_Path_In_ChangeGradeforStudent(final Student4Public student) 
				throws model.UserException, PersistenceException{
        return ((PersistentServer)this.getTheObject()).lecture_Path_In_ChangeGradeforStudent(student);
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentServer)this.getTheObject()).modules_Path_In_AddModuleToGroup();
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToProg() 
				throws model.UserException, PersistenceException{
        return ((PersistentServer)this.getTheObject()).modules_Path_In_AddModuleToProg();
    }
    public String server_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).server_Menu_Filter(anything);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).signalChanged(signal);
    }
    public StudentSearchList students_Path_In_AddStudentToGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentServer)this.getTheObject()).students_Path_In_AddStudentToGroup();
    }
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addModuleToGroup(group, modules);
    }
    public void addModuleToProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addModuleToProg(program, modules);
    }
    public void addStudentToGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addStudentToGroup(group, students);
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).addUnit(module, name, creditPoints);
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).changeCPOnModule(module, creditPoints);
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).changeCPOnUnit(unit, creditPoints);
    }
    public void changeGradeOfModule(final ModuleAtomarStudent4Public module, final String grade) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).changeGradeOfModule(module, grade);
    }
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).changeGradeOfUnit(unit, grade);
    }
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).changeGradeSystem(module);
    }
    public void changeGradeforStudent(final Student4Public student, final LectureWithGrade lecture, final String grade) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).changeGradeforStudent(student, lecture, grade);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createModule(final String type, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createModule(type, name);
    }
    public void createProgram(final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createProgram(name);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).createStudent(group, firstName, lastName, birthDate);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentServer)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).removeError(error);
    }
    public void startStudyGroup(final Program4Public program, final String name) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).startStudyGroup(program, name);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentServer)this.getTheObject()).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
    }

    
}
