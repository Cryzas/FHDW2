package persistence;



import model.visitor.*;

public class AccountProxi extends PersistentProxi implements PersistentAccount{
    
    public AccountProxi(long objectId) {
        super(objectId);
    }
    public AccountProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 130;
    }
    
    public long getNumber() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getNumber();
    }
    public void setNumber(long newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setNumber(newValue);
    }
    public String getDescription() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getDescription();
    }
    public void setDescription(String newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setDescription(newValue);
    }
    public common.Fraction getBalance() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getBalance();
    }
    public void setBalance(common.Fraction newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setBalance(newValue);
    }
    public Account_EntriesProxi getEntries() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getEntries();
    }
    public PersistentAccount getThis() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void book(final Entry4Public entry) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).book(entry);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnInstantiation();
    }

    
}
