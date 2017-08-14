package persistence;



import model.visitor.*;

public class ModuleAtomarProxi extends ModuleAbstractProxi implements PersistentModuleAtomar{
    
    public ModuleAtomarProxi(long objectId) {
        super(objectId);
    }
    public ModuleAtomarProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 153;
    }
    
    public common.Fraction getOwnCreditPoints() throws PersistenceException {
        return ((PersistentModuleAtomar)this.getTheObject()).getOwnCreditPoints();
    }
    public void setOwnCreditPoints(common.Fraction newValue) throws PersistenceException {
        ((PersistentModuleAtomar)this.getTheObject()).setOwnCreditPoints(newValue);
    }
    public PersistentModuleAtomar getThis() throws PersistenceException {
        return ((PersistentModuleAtomar)this.getTheObject()).getThis();
    }
    
    public void accept(ModuleAbstractVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(ModuleAbstractReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomar(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomar(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomar(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomar(this);
    }
    
    
    public void changeCPOnModule(final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).changeCPOnModule(creditPoints);
    }
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).updateObservers(event);
    }
    public void changeCPOnModuleImplementation(final common.Fraction creditPoints) 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).changeCPOnModuleImplementation(creditPoints);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return ((PersistentModuleAtomar)this.getTheObject()).getCreditPoints();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentModuleAtomar)this.getTheObject()).initializeOnInstantiation();
    }

    
}
