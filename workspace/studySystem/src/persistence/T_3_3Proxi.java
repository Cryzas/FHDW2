package persistence;



import model.visitor.*;

public class T_3_3Proxi extends GradesInThirdProxi implements PersistentT_3_3{
    
    public T_3_3Proxi(long objectId) {
        super(objectId);
    }
    public T_3_3Proxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 263;
    }
    
    public PersistentT_3_3 getThis() throws PersistenceException {
        return ((PersistentT_3_3)this.getTheObject()).getThis();
    }
    
    public void accept(GradesInThirdVisitor visitor) throws PersistenceException {
        visitor.handleT_3_3(this);
    }
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_3_3(this);
    }
    public <E extends model.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_3_3(this);
    }
    public <R, E extends model.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_3_3(this);
    }
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws PersistenceException {
        visitor.handleT_3_3(this);
    }
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_3_3(this);
    }
    public <E extends model.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_3_3(this);
    }
    public <R, E extends model.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_3_3(this);
    }
    public void accept(GradeVisitor visitor) throws PersistenceException {
        visitor.handleT_3_3(this);
    }
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_3_3(this);
    }
    public <E extends model.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_3_3(this);
    }
    public <R, E extends model.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_3_3(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleT_3_3(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleT_3_3(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleT_3_3(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleT_3_3(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentT_3_3)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentT_3_3)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentT_3_3)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentT_3_3)this.getTheObject()).initializeOnInstantiation();
    }
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentT_3_3)this.getTheObject()).toFraction();
    }

    
}