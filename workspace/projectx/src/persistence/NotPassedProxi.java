package persistence;



import model.visitor.*;

public class NotPassedProxi extends GradesInSimpleProxi implements PersistentNotPassed{
    
    public NotPassedProxi(long objectId) {
        super(objectId);
    }
    public NotPassedProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 219;
    }
    
    public PersistentNotPassed getThis() throws PersistenceException {
        return ((PersistentNotPassed)this.getTheObject()).getThis();
    }
    
    public void accept(GradesInSimpleVisitor visitor) throws PersistenceException {
        visitor.handleNotPassed(this);
    }
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotPassed(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotPassed(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotPassed(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNotPassed(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNotPassed(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNotPassed(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNotPassed(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNotPassed)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNotPassed)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNotPassed)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNotPassed)this.getTheObject()).initializeOnInstantiation();
    }

    
}
