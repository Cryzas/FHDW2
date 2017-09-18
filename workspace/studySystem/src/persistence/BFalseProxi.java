package persistence;



import model.visitor.*;

public class BFalseProxi extends MyBooleanProxi implements PersistentBFalse{
    
    public BFalseProxi(long objectId) {
        super(objectId);
    }
    public BFalseProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 282;
    }
    
    public PersistentBFalse getThis() throws PersistenceException {
        return ((PersistentBFalse)this.getTheObject()).getThis();
    }
    
    public void accept(MyBooleanVisitor visitor) throws PersistenceException {
        visitor.handleBFalse(this);
    }
    public <R> R accept(MyBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBFalse(this);
    }
    public <E extends model.UserException>  void accept(MyBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBFalse(this);
    }
    public <R, E extends model.UserException> R accept(MyBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBFalse(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBFalse(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBFalse(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBFalse(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBFalse(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBFalse)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBFalse)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBFalse)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBFalse)this.getTheObject()).initializeOnInstantiation();
    }
    public boolean toBoolean() 
				throws PersistenceException{
        return ((PersistentBFalse)this.getTheObject()).toBoolean();
    }

    
}
