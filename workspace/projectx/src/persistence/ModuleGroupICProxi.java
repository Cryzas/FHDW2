package persistence;



import model.visitor.*;

public class ModuleGroupICProxi extends ModuleAbstractICProxi implements PersistentModuleGroup{
    
    public ModuleGroupICProxi(long objectId) {
        super(objectId);
    }
    public ModuleGroupICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theModuleGroupFacade
            .getModuleGroup(this.getId());
    }
    
    public long getClassId() {
        return 166;
    }
    
    public ModuleGroup_ModulesProxi getModules() throws PersistenceException {
        return ((PersistentModuleGroup)this.getTheObject()).getModules();
    }
    public PersistentModuleGroup getThis() throws PersistenceException {
        return ((PersistentModuleGroup)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroup(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroup(this);
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).containsprogramHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).strategyprogramHierarchy(strategy);
    }
    public void addModule(final ModuleAbstract4Public module) 
				throws model.CycleException, model.StudyProgramException, PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).addModule(module);
    }
    public ModuleAbstractSGroup4Public copyForStudyGroup() 
				throws model.UserException, PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).copyForStudyGroup();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleGroup)this.getTheObject()).getCreditPoints();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleGroup)this.getTheObject()).initializeOnInstantiation();
    }

    
}
