package persistence;



import model.visitor.*;

public class UnitSGroupProxi extends PersistentProxi implements PersistentUnitSGroup{
    
    public UnitSGroupProxi(long objectId) {
        super(objectId);
    }
    public UnitSGroupProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 181;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentUnitSGroup)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentUnitSGroup)this.getTheObject()).setName(newValue);
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return ((PersistentUnitSGroup)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentUnitSGroup)this.getTheObject()).setCreditPoints(newValue);
    }
    public PersistentUnitSGroup getThis() throws PersistenceException {
        return ((PersistentUnitSGroup)this.getTheObject()).getThis();
    }
    
    public void accept(programHierarchySGroupHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleUnitSGroup(this);
    }
    public <R> R accept(programHierarchySGroupHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitSGroup(this);
    }
    public <E extends model.UserException>  void accept(programHierarchySGroupHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitSGroup(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchySGroupHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitSGroup(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitSGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitSGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitSGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitSGroup(this);
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentUnitSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentUnitSGroup)this.getTheObject()).strategyprogramHierarchySGroup(strategy);
    }
    public void addCP(final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).addCP(creditPoints);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).initializeOnInstantiation();
    }
    public void subCP(final common.Fraction creditPoints) 
				throws model.StudyProgramException, PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).subCP(creditPoints);
    }

    
}
