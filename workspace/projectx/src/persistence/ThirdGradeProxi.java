package persistence;



import model.visitor.*;

public class ThirdGradeProxi extends GradeSystemProxi implements PersistentThirdGrade{
    
    public ThirdGradeProxi(long objectId) {
        super(objectId);
    }
    public ThirdGradeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 208;
    }
    
    public PersistentThirdGrade getThis() throws PersistenceException {
        return ((PersistentThirdGrade)this.getTheObject()).getThis();
    }
    
    public void accept(GradeSystemVisitor visitor) throws PersistenceException {
        visitor.handleThirdGrade(this);
    }
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdGrade(this);
    }
    public <E extends model.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdGrade(this);
    }
    public <R, E extends model.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdGrade(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleThirdGrade(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleThirdGrade(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleThirdGrade(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleThirdGrade(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentThirdGrade)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentThirdGrade)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentThirdGrade)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentThirdGrade)this.getTheObject()).initializeOnInstantiation();
    }

    
}
