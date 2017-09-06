package persistence;



import model.visitor.*;

public class UnitStudentICProxi extends PersistentInCacheProxiOptimistic implements PersistentUnitStudent{
    
    public UnitStudentICProxi(long objectId) {
        super(objectId);
    }
    public UnitStudentICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade
            .getUnitStudent(this.getId());
    }
    
    public long getClassId() {
        return 197;
    }
    
    public UnitSGroup4Public getUnitCopy() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getUnitCopy();
    }
    public void setUnitCopy(UnitSGroup4Public newValue) throws PersistenceException {
        ((PersistentUnitStudent)this.getTheObject()).setUnitCopy(newValue);
    }
    public GradesInThird4Public getGrade() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getGrade();
    }
    public void setGrade(GradesInThird4Public newValue) throws PersistenceException {
        ((PersistentUnitStudent)this.getTheObject()).setGrade(newValue);
    }
    public PersistentUnitStudent getThis() throws PersistenceException {
        return ((PersistentUnitStudent)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).containsprogramHierarchyStudent(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).strategyprogramHierarchyStudent(strategy);
    }
    public void changeGrade(final GradesInThird4Public grade) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).changeGrade(grade);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getCreditPoints();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentUnitStudent)this.getTheObject()).getName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitStudent)this.getTheObject()).initializeOnInstantiation();
    }

    
}
