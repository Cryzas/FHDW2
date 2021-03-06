package persistence;



import model.visitor.*;

public class Z_2_7Proxi extends GradesInTenthProxi implements PersistentZ_2_7{
    
    public Z_2_7Proxi(long objectId) {
        super(objectId);
    }
    public Z_2_7Proxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 236;
    }
    
    public PersistentZ_2_7 getThis() throws PersistenceException {
        return ((PersistentZ_2_7)this.getTheObject()).getThis();
    }
    
    public void accept(GradesInTenthVisitor visitor) throws PersistenceException {
        visitor.handleZ_2_7(this);
    }
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_2_7(this);
    }
    public <E extends model.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_2_7(this);
    }
    public <R, E extends model.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_2_7(this);
    }
    public void accept(GradeVisitor visitor) throws PersistenceException {
        visitor.handleZ_2_7(this);
    }
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_2_7(this);
    }
    public <E extends model.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_2_7(this);
    }
    public <R, E extends model.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_2_7(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleZ_2_7(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_2_7(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_2_7(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_2_7(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleZ_2_7(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_2_7(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_2_7(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_2_7(this);
    }
    
    
    public void deregister(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentZ_2_7)this.getTheObject()).deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentZ_2_7)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void register(final ObsInterface observee) 
				throws PersistenceException{
        ((PersistentZ_2_7)this.getTheObject()).register(observee);
    }
    public void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        ((PersistentZ_2_7)this.getTheObject()).updateObservers(event);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentZ_2_7)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentZ_2_7)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentZ_2_7)this.getTheObject()).initializeOnInstantiation();
    }
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentZ_2_7)this.getTheObject()).toFraction();
    }

    
}
