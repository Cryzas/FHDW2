package persistence;



import model.visitor.*;

public class ModuleAtomarSGroupICProxi extends ModuleAbstractSGroupICProxi implements PersistentModuleAtomarSGroup{
    
    public ModuleAtomarSGroupICProxi(long objectId) {
        super(objectId);
    }
    public ModuleAtomarSGroupICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theModuleAtomarSGroupFacade
            .getModuleAtomarSGroup(this.getId());
    }
    
    public long getClassId() {
        return 179;
    }
    
    public common.Fraction getOwnCreditPoints() throws PersistenceException {
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).getOwnCreditPoints();
    }
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentModuleAtomarSGroup)this.getTheObject()).setOwnCreditPoints(newValue);
    }
    public GradeSystem4Public getGradeSystem() throws PersistenceException {
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).getGradeSystem();
    }
    public void setGradeSystem(GradeSystem4Public newValue) throws PersistenceException {
        ((PersistentModuleAtomarSGroup)this.getTheObject()).setGradeSystem(newValue);
    }
    public PersistentModuleAtomarSGroup getThis() throws PersistenceException {
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractSGroupVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(ModuleAbstractSGroupReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractSGroupExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractSGroupReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarSGroup(this);
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAtomarSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).strategyprogramHierarchySGroup(strategy);
    }
    public ModuleAbstractStudent4Public copyForStudent() 
				throws model.UserException, PersistenceException{
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).copyForStudent();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleAtomarSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void endModule() 
				throws PersistenceException{
        ((PersistentModuleAtomarSGroup)this.getTheObject()).endModule();
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentModuleAtomarSGroup)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleAtomarSGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleAtomarSGroup)this.getTheObject()).initializeOnInstantiation();
    }

    
}
