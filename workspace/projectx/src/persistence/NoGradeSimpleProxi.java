package persistence;



import model.visitor.*;

public class NoGradeSimpleProxi extends GradesInSimpleProxi implements PersistentNoGradeSimple{
    
    public NoGradeSimpleProxi(long objectId) {
        super(objectId);
    }
    public NoGradeSimpleProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 218;
    }
    
    public PersistentNoGradeSimple getThis() throws PersistenceException {
        return ((PersistentNoGradeSimple)this.getTheObject()).getThis();
    }
    
    public void accept(GradesInSimpleVisitor visitor) throws PersistenceException {
        visitor.handleNoGradeSimple(this);
    }
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoGradeSimple(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoGradeSimple(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoGradeSimple(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleNoGradeSimple(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleNoGradeSimple(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleNoGradeSimple(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleNoGradeSimple(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentNoGradeSimple)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentNoGradeSimple)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentNoGradeSimple)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentNoGradeSimple)this.getTheObject()).initializeOnInstantiation();
    }

    
}
