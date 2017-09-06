package persistence;



import model.visitor.*;

public class Z_1_7ICProxi extends GradesInTenthICProxi implements PersistentZ_1_7{
    
    public Z_1_7ICProxi(long objectId) {
        super(objectId);
    }
    public Z_1_7ICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theZ_1_7Facade
            .getZ_1_7(this.getId());
    }
    
    public long getClassId() {
        return 253;
    }
    
    public PersistentZ_1_7 getThis() throws PersistenceException {
        return ((PersistentZ_1_7)this.getTheObject()).getThis();
    }
    
    public void accept(GradesInTenthVisitor visitor) throws PersistenceException {
        visitor.handleZ_1_7(this);
    }
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_1_7(this);
    }
    public <E extends model.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_1_7(this);
    }
    public <R, E extends model.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_1_7(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleZ_1_7(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleZ_1_7(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleZ_1_7(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleZ_1_7(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentZ_1_7)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentZ_1_7)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentZ_1_7)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentZ_1_7)this.getTheObject()).initializeOnInstantiation();
    }

    
}
