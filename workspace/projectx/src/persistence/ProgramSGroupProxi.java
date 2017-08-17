package persistence;



import model.visitor.*;

public class ProgramSGroupProxi extends PersistentProxi implements PersistentProgramSGroup{
    
    public ProgramSGroupProxi(long objectId) {
        super(objectId);
    }
    public ProgramSGroupProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 177;
    }
    
    public ProgramSGroup_ModulesProxi getModules() throws PersistenceException {
        return ((PersistentProgramSGroup)this.getTheObject()).getModules();
    }
    public Program4Public getProgramCopy() throws PersistenceException {
        return ((PersistentProgramSGroup)this.getTheObject()).getProgramCopy();
    }
    public void setProgramCopy(Program4Public newValue) throws PersistenceException {
        ((PersistentProgramSGroup)this.getTheObject()).setProgramCopy(newValue);
    }
    public PersistentProgramSGroup getThis() throws PersistenceException {
        return ((PersistentProgramSGroup)this.getTheObject()).getThis();
    }
    
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleProgramSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramSGroup(this);
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentProgramSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentProgramSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentProgramSGroup)this.getTheObject()).strategyprogramHierarchySGroup(strategy);
    }
    public void addModule(final ModuleAbstractSGroup4Public module) 
				throws model.AlreadyExistsInParentException, model.CycleException, PersistenceException{
        ((PersistentProgramSGroup)this.getTheObject()).addModule(module);
    }
    public ProgramStudent4Public copyForStudent() 
				throws model.UserException, PersistenceException{
        return ((PersistentProgramSGroup)this.getTheObject()).copyForStudent();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentProgramSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentProgramSGroup)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentProgramSGroup)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentProgramSGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentProgramSGroup)this.getTheObject()).initializeOnInstantiation();
    }

    
}
