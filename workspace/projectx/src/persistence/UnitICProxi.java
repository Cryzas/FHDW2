package persistence;



import model.visitor.*;

public class UnitICProxi extends PersistentInCacheProxiOptimistic implements PersistentUnit{
    
    public UnitICProxi(long objectId) {
        super(objectId);
    }
    public UnitICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .getUnit(this.getId());
    }
    
    public long getClassId() {
        return 147;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentUnit)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentUnit)this.getTheObject()).setCreditPoints(newValue);
    }
    public PersistentUnit getThis() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(programHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(programHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    
    
    public boolean containsprogramHierarchy(final programHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentUnit)this.getTheObject()).containsprogramHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchy(final programHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentUnit)this.getTheObject()).strategyprogramHierarchy(strategy);
    }
    public void changeCPOnUnit(final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).changeCPOnUnit(creditPoints);
    }
    public UnitSGroup4Public copyForStudyGroup() 
				throws PersistenceException{
        return ((PersistentUnit)this.getTheObject()).copyForStudyGroup();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnInstantiation();
    }

    
}
