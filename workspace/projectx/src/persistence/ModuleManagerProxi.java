package persistence;



import model.visitor.*;

public class ModuleManagerProxi extends PersistentProxi implements PersistentModuleManager{
    
    public ModuleManagerProxi(long objectId) {
        super(objectId);
    }
    public ModuleManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 145;
    }
    
    public ModuleManager_ModulesProxi getModules() throws PersistenceException {
        return ((PersistentModuleManager)this.getTheObject()).getModules();
    }
    public PersistentModuleManager getThis() throws PersistenceException {
        return ((PersistentModuleManager)this.getTheObject()).getThis();
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
    
    
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstract4Public module, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).addModuleToGroup(group, module, invoker);
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).addUnit(module, name, creditPoints, invoker);
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).changeCPOnModule(module, creditPoints, invoker);
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).changeCPOnUnit(unit, creditPoints, invoker);
    }
    public void createModule(final String type, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).createModule(type, name, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addModuleToGroup(final ModuleGroup4Public group, final ModuleAbstract4Public module) 
				throws model.CycleException, model.StudyProgramException, PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).addModuleToGroup(group, module);
    }
    public void addUnit(final ModuleWithUnits4Public module, final String name, final common.Fraction creditPoints) 
				throws model.CycleException, model.StudyProgramException, PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).addUnit(module, name, creditPoints);
    }
    public void changeCPOnModule(final ModuleAtomar4Public module, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).changeCPOnModule(module, creditPoints);
    }
    public void changeCPOnUnit(final Unit4Public unit, final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).changeCPOnUnit(unit, creditPoints);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createModule(final String type, final String name) 
				throws model.StudyProgramException, PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).createModule(type, name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleManager)this.getTheObject()).initializeOnInstantiation();
    }

    
}
