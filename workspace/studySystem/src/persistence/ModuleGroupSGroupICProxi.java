package persistence;



import model.visitor.*;

public class ModuleGroupSGroupICProxi extends ModuleAbstractSGroupICProxi implements PersistentModuleGroupSGroup{
    
    public ModuleGroupSGroupICProxi(long objectId) {
        super(objectId);
    }
    public ModuleGroupSGroupICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theModuleGroupSGroupFacade
            .getModuleGroupSGroup(this.getId());
    }
    
    public long getClassId() {
        return 178;
    }
    
    public ModuleGroupSGroup_ModulesProxi getModules() throws PersistenceException {
        return ((PersistentModuleGroupSGroup)this.getTheObject()).getModules();
    }
    public PersistentModuleGroupSGroup getThis() throws PersistenceException {
        return ((PersistentModuleGroupSGroup)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupSGroup(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupSGroup(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupSGroup(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupSGroup(this);
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleGroupSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).register(observee);
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleGroupSGroup)this.getTheObject()).strategyprogramHierarchySGroup(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).updateObservers(event);
    }
    public void addModule(final ModuleAbstractSGroup4Public module) 
				throws model.CycleException, PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).addModule(module);
    }
    public ModuleAbstractStudent4Public copyForStudent() 
				throws PersistenceException{
        return ((PersistentModuleGroupSGroup)this.getTheObject()).copyForStudent();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void endModule() 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).endModule();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleGroupSGroup)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleGroupSGroup)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleGroupSGroup)this.getTheObject()).initializeOnInstantiation();
    }

    
}
