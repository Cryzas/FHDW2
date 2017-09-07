package persistence;



import model.visitor.*;

public class Z_3_3ICProxi extends GradesInTenthICProxi implements PersistentZ_3_3{
    
    public Z_3_3ICProxi(long objectId) {
        super(objectId);
    }
    public Z_3_3ICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theZ_3_3Facade
            .getZ_3_3(this.getId());
    }
    
    public long getClassId() {
        return 248;
    }
    
    public PersistentZ_3_3 getThis() throws PersistenceException {
        return ((PersistentZ_3_3)this.getTheObject()).getThis();
    }
    
    public void accept(GradesInTenthVisitor visitor) throws PersistenceException {
        visitor.handleZ_3_3(this);
    }
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_3_3(this);
    }
    public <E extends model.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_3_3(this);
    }
    public <R, E extends model.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_3_3(this);
    }
    public void accept(GradeVisitor visitor) throws PersistenceException {
        visitor.handleZ_3_3(this);
    }
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_3_3(this);
    }
    public <E extends model.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_3_3(this);
    }
    public <R, E extends model.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_3_3(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleZ_3_3(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_3_3(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_3_3(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_3_3(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentZ_3_3)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentZ_3_3)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentZ_3_3)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentZ_3_3)this.getTheObject()).initializeOnInstantiation();
    }
    public common.Fraction toFraction() 
				throws model.NoFractionValueException, PersistenceException{
        return ((PersistentZ_3_3)this.getTheObject()).toFraction();
    }

    
}