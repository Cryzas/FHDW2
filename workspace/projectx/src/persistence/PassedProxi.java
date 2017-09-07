package persistence;



import model.visitor.*;

public class PassedProxi extends GradesInSimpleProxi implements PersistentPassed{
    
    public PassedProxi(long objectId) {
        super(objectId);
    }
    public PassedProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 214;
    }
    
    public PersistentPassed getThis() throws PersistenceException {
        return ((PersistentPassed)this.getTheObject()).getThis();
    }
    
    public void accept(GradesInSimpleVisitor visitor) throws PersistenceException {
        visitor.handlePassed(this);
    }
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePassed(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePassed(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws PersistenceException {
        visitor.handlePassed(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePassed(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePassed(this);
    }
    public void accept(GradeVisitor visitor) throws PersistenceException {
        visitor.handlePassed(this);
    }
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePassed(this);
    }
    public <E extends model.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends model.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePassed(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePassed(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePassed(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePassed(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePassed(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentPassed)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentPassed)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentPassed)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentPassed)this.getTheObject()).initializeOnInstantiation();
    }
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentPassed)this.getTheObject()).toFraction();
    }

    
}
