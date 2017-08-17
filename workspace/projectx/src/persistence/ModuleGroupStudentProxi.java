package persistence;



import model.visitor.*;

public class ModuleGroupStudentProxi extends ModuleAbstractStudentProxi implements PersistentModuleGroupStudent{
    
    public ModuleGroupStudentProxi(long objectId) {
        super(objectId);
    }
    public ModuleGroupStudentProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 194;
    }
    
    public ModuleGroupStudent_ModulesProxi getModules() throws PersistenceException {
        return ((PersistentModuleGroupStudent)this.getTheObject()).getModules();
    }
    public PersistentModuleGroupStudent getThis() throws PersistenceException {
        return ((PersistentModuleGroupStudent)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleGroupStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleGroupStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleGroupStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleGroupStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void addModule(final ModuleAbstractStudent4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).addModule(module);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleGroupStudent)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleGroupStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
