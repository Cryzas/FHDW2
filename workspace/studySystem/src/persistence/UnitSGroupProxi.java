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
    
    public Unit4Public getUnitCopy() throws PersistenceException {
        return ((PersistentUnitSGroup)this.getTheObject()).getUnitCopy();
    }
    public void setUnitCopy(Unit4Public newValue) throws PersistenceException {
        ((PersistentUnitSGroup)this.getTheObject()).setUnitCopy(newValue);
    }
    public common.Fraction getCreditPoints() throws PersistenceException {
        return ((PersistentUnitSGroup)this.getTheObject()).getCreditPoints();
    }
    public void setCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentUnitSGroup)this.getTheObject()).setCreditPoints(newValue);
    }
    public MyBoolean4Public getFinished() throws PersistenceException {
        return ((PersistentUnitSGroup)this.getTheObject()).getFinished();
    }
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException {
        ((PersistentUnitSGroup)this.getTheObject()).setFinished(newValue);
    }
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentUnitSGroup)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentUnitSGroup)this.getTheObject()).setSubService(newValue);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleUnitSGroup(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitSGroup(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitSGroup(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitSGroup(this);
    }
    
    
    public boolean containsprogramHierarchySGroup(final programHierarchySGroupHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentUnitSGroup)this.getTheObject()).containsprogramHierarchySGroup(part);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).register(observee);
    }
    public <T> T strategyprogramHierarchySGroup(final programHierarchySGroupHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentUnitSGroup)this.getTheObject()).strategyprogramHierarchySGroup(strategy);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).updateObservers(event);
    }
    public void addCP(final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).addCP(creditPoints);
    }
    public UnitStudent4Public copyForStudent() 
				throws PersistenceException{
        return ((PersistentUnitSGroup)this.getTheObject()).copyForStudent();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void endUnit() 
				throws PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).endUnit();
    }
    public String getName() 
				throws PersistenceException{
        return ((PersistentUnitSGroup)this.getTheObject()).getName();
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
				throws model.UnitSwapException, PersistenceException{
        ((PersistentUnitSGroup)this.getTheObject()).subCP(creditPoints);
    }

    
}
