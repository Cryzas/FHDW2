package persistence;



import model.visitor.*;

public class UnitProxi extends PersistentProxi implements PersistentUnit{
    
    public UnitProxi(long objectId) {
        super(objectId);
    }
    public UnitProxi(PersistentInCacheProxi object) {
        super(object);
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
    public SubjInterface getSubService() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getSubService();
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        ((PersistentUnit)this.getTheObject()).setSubService(newValue);
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
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    
    
    public void changeCPOnUnit(final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).changeCPOnUnit(creditPoints);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).deregister(observee);
    }
    public ModuleWithUnitsSearchList getParentModule() 
				throws PersistenceException{
        return ((PersistentUnit)this.getTheObject()).getParentModule();
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).updateObservers(event);
    }
    public void changeCPOnUnitImplementation(final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).changeCPOnUnitImplementation(creditPoints);
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
