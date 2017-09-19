package persistence;


import model.visitor.*;

public interface ProgramModuleService4Public extends subAdminService4Public {
    
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException;
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(InvokerVisitor visitor) throws PersistenceException;
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException;
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(RemoteVisitor visitor) throws PersistenceException;
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public ModuleManager4Public getModuleManager() 
				throws PersistenceException;
    public ProgramManager4Public getProgramManager() 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_AddModuleToGroup() 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_AddModuleToProg() 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_DeleteModules() 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromGroup(final ModuleGroup4Public group) 
				throws model.UserException, PersistenceException;
    public ModuleAbstractSearchList modules_Path_In_RemoveModuleFromProg(final Program4Public program) 
				throws model.UserException, PersistenceException;
    public String programModuleService_Menu_Filter(final Anything anything) 
				throws PersistenceException;
    public ProgramSearchList programs_Path_In_DeletePrograms() 
				throws model.UserException, PersistenceException;
    public UnitSearchList units_Path_In_RemoveUnit(final ModuleWithUnits4Public module) 
				throws model.UserException, PersistenceException;
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void addModuleToProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws PersistenceException;
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException;
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException;
    public void changeGradeSystem(final ModuleAtomar4Public module) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createModule(final String type, final String name) 
				throws PersistenceException;
    public void createProgram(final String name) 
				throws PersistenceException;
    public void deleteModules(final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void deletePrograms(final ProgramSearchList programs) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void removeModuleFromGroup(final ModuleGroup4Public group, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void removeModuleFromProg(final Program4Public program, final ModuleAbstractSearchList modules) 
				throws PersistenceException;
    public void removeUnit(final ModuleWithUnits4Public module, final UnitSearchList units) 
				throws PersistenceException;
    public void startStudyGroup(final Program4Public program, final String name) 
				throws PersistenceException;

}

