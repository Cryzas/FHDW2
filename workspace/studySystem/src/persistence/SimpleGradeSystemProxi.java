package persistence;



import model.visitor.*;

public class SimpleGradeSystemProxi extends GradeSystemProxi implements PersistentSimpleGradeSystem{
    
    public SimpleGradeSystemProxi(long objectId) {
        super(objectId);
    }
    public SimpleGradeSystemProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 213;
    }
    
    public PersistentSimpleGradeSystem getThis() throws PersistenceException {
        return ((PersistentSimpleGradeSystem)this.getTheObject()).getThis();
    }
    
    public void accept(GradeSystemVisitor visitor) throws PersistenceException {
        visitor.handleSimpleGradeSystem(this);
    }
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSimpleGradeSystem(this);
    }
    public <E extends model.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSimpleGradeSystem(this);
    }
    public <R, E extends model.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSimpleGradeSystem(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSimpleGradeSystem(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSimpleGradeSystem(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSimpleGradeSystem(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSimpleGradeSystem(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentSimpleGradeSystem)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentSimpleGradeSystem)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentSimpleGradeSystem)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentSimpleGradeSystem)this.getTheObject()).initializeOnInstantiation();
    }

    
}
