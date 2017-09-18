package persistence;



import model.visitor.*;

public class BTrueICProxi extends MyBooleanICProxi implements PersistentBTrue{
    
    public BTrueICProxi(long objectId) {
        super(objectId);
    }
    public BTrueICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBTrueFacade
            .getBTrue(this.getId());
    }
    
    public long getClassId() {
        return 281;
    }
    
    public PersistentBTrue getThis() throws PersistenceException {
        return ((PersistentBTrue)this.getTheObject()).getThis();
    }
    
    public void accept(MyBooleanVisitor visitor) throws PersistenceException {
        visitor.handleBTrue(this);
    }
    public <R> R accept(MyBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBTrue(this);
    }
    public <E extends model.UserException>  void accept(MyBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBTrue(this);
    }
    public <R, E extends model.UserException> R accept(MyBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBTrue(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBTrue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBTrue(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBTrue(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBTrue(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBTrue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBTrue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBTrue)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBTrue)this.getTheObject()).initializeOnInstantiation();
    }
    public boolean toBoolean() 
				throws PersistenceException{
        return ((PersistentBTrue)this.getTheObject()).toBoolean();
    }

    
}
