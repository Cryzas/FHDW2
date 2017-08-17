package persistence;



import model.visitor.*;

public class TenthGradeProxi extends GradeSystemProxi implements PersistentTenthGrade{
    
    public TenthGradeProxi(long objectId) {
        super(objectId);
    }
    public TenthGradeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 210;
    }
    
    public PersistentTenthGrade getThis() throws PersistenceException {
        return ((PersistentTenthGrade)this.getTheObject()).getThis();
    }
    
    public void accept(GradeSystemVisitor visitor) throws PersistenceException {
        visitor.handleTenthGrade(this);
    }
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTenthGrade(this);
    }
    public <E extends model.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTenthGrade(this);
    }
    public <R, E extends model.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTenthGrade(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTenthGrade(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTenthGrade(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTenthGrade(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTenthGrade(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTenthGrade)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTenthGrade)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTenthGrade)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTenthGrade)this.getTheObject()).initializeOnInstantiation();
    }

    
}
