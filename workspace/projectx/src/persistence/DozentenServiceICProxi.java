package persistence;



import model.visitor.*;

public class DozentenServiceICProxi extends ServiceICProxi implements PersistentDozentenService{
    
    public DozentenServiceICProxi(long objectId) {
        super(objectId);
    }
    public DozentenServiceICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theDozentenServiceFacade
            .getDozentenService(this.getId());
    }
    
    public long getClassId() {
        return -287;
    }
    
    public ProgramManager4Public getProgramManager() throws PersistenceException {
        return ((PersistentDozentenService)this.getTheObject()).getProgramManager();
    }
    public void setProgramManager(ProgramManager4Public newValue) throws PersistenceException {
        ((PersistentDozentenService)this.getTheObject()).setProgramManager(newValue);
    }
    public ModuleManager4Public getModuleManager() throws PersistenceException {
        return ((PersistentDozentenService)this.getTheObject()).getModuleManager();
    }
    public void setModuleManager(ModuleManager4Public newValue) throws PersistenceException {
        ((PersistentDozentenService)this.getTheObject()).setModuleManager(newValue);
    }
    public StudyGroupManager4Public getGroupManager() throws PersistenceException {
        return ((PersistentDozentenService)this.getTheObject()).getGroupManager();
    }
    public void setGroupManager(StudyGroupManager4Public newValue) throws PersistenceException {
        ((PersistentDozentenService)this.getTheObject()).setGroupManager(newValue);
    }
    public StudentManager4Public getStudentManager() throws PersistenceException {
        return ((PersistentDozentenService)this.getTheObject()).getStudentManager();
    }
    public void setStudentManager(StudentManager4Public newValue) throws PersistenceException {
        ((PersistentDozentenService)this.getTheObject()).setStudentManager(newValue);
    }
    public PersistentDozentenService getThis() throws PersistenceException {
        return ((PersistentDozentenService)this.getTheObject()).getThis();
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
    
    
    public UnitSGroupSearchList ToUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).ToUnit_Path_In_SwapCPonModuleWithUnits(module);
    }
    public String dozentenService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).dozentenService_Menu_Filter(anything);
    }
    public UnitSGroupSearchList fromUnit_Path_In_SwapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module) 
				throws model.UserException, PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).fromUnit_Path_In_SwapCPonModuleWithUnits(module);
    }
    public ServerSearchList getParentServer() 
				throws PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).getParentServer();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ModuleAbstractStudentSearchList lecture_Path_In_ChangeGradeforStudent(final Student4Public student) 
				throws model.UserException, PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).lecture_Path_In_ChangeGradeforStudent(student);
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).modules_Path_In_AddModuleToGroup();
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToProg() 
				throws model.UserException, PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).modules_Path_In_AddModuleToProg();
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).signalChanged(signal);
    }
    public StudentSearchList students_Path_In_AddStudentToGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).students_Path_In_AddStudentToGroup();
    }
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).addModuleToGroup(group, modules);
    }
    public void addModuleToProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).addModuleToProg(program, modules);
    }
    public void addStudentToGroup(final StudyGroup4Public group, final StudentSearchList students) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).addStudentToGroup(group, students);
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).addUnit(module, name, creditPoints);
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).changeCPOnModule(module, creditPoints);
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).changeCPOnUnit(unit, creditPoints);
    }
    public void changeGradeOfModule(final ModuleAtomarStudent4Public module, final String grade, final String comment) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).changeGradeOfModule(module, grade, comment);
    }
    public void changeGradeOfUnit(final UnitStudent4Public unit, final String grade, final String comment) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).changeGradeOfUnit(unit, grade, comment);
    }
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).changeGradeSystem(module);
    }
    public void changeGradeforStudent(final Student4Public student, final LectureWithGrade lecture, final String grade, final String comment) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).changeGradeforStudent(student, lecture, grade, comment);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createModule(final String type, final String name) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).createModule(type, name);
    }
    public void createProgram(final String name) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).createProgram(name);
    }
    public void createStudent(final StudyGroup4Public group, final String firstName, final String lastName, final java.sql.Date birthDate) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).createStudent(group, firstName, lastName, birthDate);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).disconnected();
    }
    public void endStudyGroup(final StudyGroup4Public studyGroup) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).endStudyGroup(studyGroup);
    }
    public String getUsername() 
				throws PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).getUsername();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentDozentenService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).initializeOnInstantiation();
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).removeError(error);
    }
    public void startStudyGroup(final Program4Public program, final String name) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).startStudyGroup(program, name);
    }
    public void swapCPonModuleWithUnits(final ModuleWithUnitsSGroup4Public module, final UnitSGroup4Public fromUnit, final UnitSGroup4Public ToUnit, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentDozentenService)this.getTheObject()).swapCPonModuleWithUnits(module, fromUnit, ToUnit, creditPoints);
    }

    
}
