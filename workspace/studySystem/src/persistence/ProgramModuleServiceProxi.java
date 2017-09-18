package persistence;



import model.visitor.*;

public class ProgramModuleServiceProxi extends subAdminServiceProxi implements PersistentProgramModuleService{
    
    public ProgramModuleServiceProxi(long objectId) {
        super(objectId);
    }
    public ProgramModuleServiceProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return -305;
    }
    
    public void setProgramManager(ProgramModuleServiceProgramManager4Public newValue) throws PersistenceException {
        ((PersistentProgramModuleService)this.getTheObject()).setProgramManager(newValue);
    }
    public void setModuleManager(ProgramModuleServiceModuleManager4Public newValue) throws PersistenceException {
        ((PersistentProgramModuleService)this.getTheObject()).setModuleManager(newValue);
    }
    public PersistentProgramModuleService getThis() throws PersistenceException {
        return ((PersistentProgramModuleService)this.getTheObject()).getThis();
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
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).deregister(observee);
    }
    public ModuleManager4Public getModuleManager() 
				throws PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).getModuleManager();
    }
    public ProgramManager4Public getProgramManager() 
				throws PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).getProgramManager();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).modules_Path_In_AddModuleToGroup();
    }
    public ModuleAbstractSearchList modules_Path_In_AddModuleToProg() 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).modules_Path_In_AddModuleToProg();
    }
    public ModuleAbstractSearchList modules_Path_In_DeleteModules(final ModuleManager4Public manager) 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).modules_Path_In_DeleteModules(manager);
    }
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromGroup(final ModuleGroup4Public group) 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).modules_Path_In_RemoveModuleFromGroup(group);
    }
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromProg(final Program4Public program) 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).modules_Path_In_RemoveModuleFromProg(program);
    }
    public String programModuleService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).programModuleService_Menu_Filter(anything);
    }
    public ProgramSearchList programs_Path_In_DeletePrograms(final ProgramManager4Public manager) 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).programs_Path_In_DeletePrograms(manager);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).register(observee);
    }
    public void setModuleManager(final ModuleManager4Public moduleManager) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).setModuleManager(moduleManager);
    }
    public void setProgramManager(final ProgramManager4Public programManager) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).setProgramManager(programManager);
    }
    public void signalChanged(final boolean signal) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).signalChanged(signal);
    }
    public UnitSearchList units_Path_In_RemoveUnit(final ModuleWithUnits4Public module) 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).units_Path_In_RemoveUnit(module);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).updateObservers(event);
    }
    public void updatePLZ() 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).updatePLZ();
    }
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).addModuleToGroup(group, modules);
    }
    public void addModuleToProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).addModuleToProg(program, modules);
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).addUnit(module, name, creditPoints);
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).changeCPOnModule(module, creditPoints);
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).changeCPOnUnit(unit, creditPoints);
    }
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).changeGradeSystem(module);
    }
    public void connected(final String user) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).connected(user);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createModule(final String type, final String name) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).createModule(type, name);
    }
    public void createProgram(final String name) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).createProgram(name);
    }
    public void deleteModules(final ModuleManager4Public manager, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).deleteModules(manager, modules);
    }
    public void deletePrograms(final ProgramManager4Public manager, final ProgramSearchList programs) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).deletePrograms(manager, programs);
    }
    public void disconnected() 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).disconnected();
    }
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).handleException(command, exception);
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).handleResult(command);
    }
    public boolean hasChanged() 
				throws PersistenceException{
        return ((PersistentProgramModuleService)this.getTheObject()).hasChanged();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).initializeOnInstantiation();
    }
    public void moduleManager_update(final model.meta.ModuleManagerMssgs event) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).moduleManager_update(event);
    }
    public void programManager_update(final model.meta.ProgramManagerMssgs event) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).programManager_update(event);
    }
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).removeError(error);
    }
    public void removeModuleFromGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).removeModuleFromGroup(group, modules);
    }
    public void removeModuleFromProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).removeModuleFromProg(program, modules);
    }
    public void removeUnit(final ModuleWithUnits4Public module, final UnitSearchList units) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).removeUnit(module, units);
    }
    public void startStudyGroup(final Program4Public program, final String name) 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).startStudyGroup(program, name);
    }
    public void updateMe() 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).updateMe();
    }
    public void updatePLZImplementation() 
				throws PersistenceException{
        ((PersistentProgramModuleService)this.getTheObject()).updatePLZImplementation();
    }

    
}
