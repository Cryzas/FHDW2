package persistence;



import model.visitor.*;

public class AccountICProxi extends abstractAccICProxi implements PersistentAccount{
    
    public AccountICProxi(long objectId) {
        super(objectId);
    }
    public AccountICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAccountFacade
            .getAccount(this.getId());
    }
    
    public long getClassId() {
        return 119;
    }
    
    public Folder4Public getInBox() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getInBox();
    }
    public void setInBox(Folder4Public newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setInBox(newValue);
    }
    public Folder4Public getOutBox() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getOutBox();
    }
    public void setOutBox(Folder4Public newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setOutBox(newValue);
    }
    public Folder4Public getDrafts() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getDrafts();
    }
    public void setDrafts(Folder4Public newValue) throws PersistenceException {
        ((PersistentAccount)this.getTheObject()).setDrafts(newValue);
    }
    public Account_FoldersProxi getFolders() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getFolders();
    }
    public PersistentAccount getThis() throws PersistenceException {
        return ((PersistentAccount)this.getTheObject()).getThis();
    }
    
    public void accept(abstractAccVisitor visitor) throws PersistenceException {
        visitor.handleAccount(this);
    }
    public <R> R accept(abstractAccReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccount(this);
    }
    public <E extends model.UserException>  void accept(abstractAccExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccount(this);
    }
    public <R, E extends model.UserException> R accept(abstractAccReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccount(this);
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
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createDraft(final String subject, final String text) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).createDraft(subject, text);
    }
    public void createFolder(final String name) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).createFolder(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).initializeOnInstantiation();
    }
    public void receive(final MailEntry4Public mail) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).receive(mail);
    }
    public void send(final Draft4Public draft) 
				throws PersistenceException{
        ((PersistentAccount)this.getTheObject()).send(draft);
    }
    public AccountWrapper4Public wrap() 
				throws PersistenceException{
        return ((PersistentAccount)this.getTheObject()).wrap();
    }

    
}
