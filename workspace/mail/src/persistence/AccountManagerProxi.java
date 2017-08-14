package persistence;



import model.visitor.*;

public class AccountManagerProxi extends PersistentProxi implements PersistentAccountManager{
    
    public AccountManagerProxi(long objectId) {
        super(objectId);
    }
    public AccountManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    
    public long getClassId() {
        return 125;
    }
    
    public AccountManager_AccountsProxi getAccounts() throws PersistenceException {
        return ((PersistentAccountManager)this.getTheObject()).getAccounts();
    }
    public PersistentAccountManager getThis() throws PersistenceException {
        return ((PersistentAccountManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAccountManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAccountManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAccountManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAccountManager(this);
    }
    
    
    public void addReceiver(final Draft4Public draft, final Account4Public account, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).addReceiver(draft, account, invoker);
    }
    public void answerAll(final MailEntry4Public mail, final String subject, final String text, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).answerAll(mail, subject, text, invoker);
    }
    public void answer(final MailEntry4Public mail, final String subject, final String text, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).answer(mail, subject, text, invoker);
    }
    public void createAccount(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createAccount(name, invoker);
    }
    public void createDraft(final Account4Public account, final String subject, final String text, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createDraft(account, subject, text, invoker);
    }
    public void createFolder(final Account4Public account, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createFolder(account, name, invoker);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void send(final Draft4Public draft, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).send(draft, invoker);
    }
    public void addReceiver(final Draft4Public draft, final Account4Public account) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).addReceiver(draft, account);
    }
    public void answerAll(final MailEntry4Public mail, final String subject, final String text) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).answerAll(mail, subject, text);
    }
    public void answer(final MailEntry4Public mail, final String subject, final String text) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).answer(mail, subject, text);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createAccount(final String name) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createAccount(name);
    }
    public void createDraft(final Account4Public account, final String subject, final String text) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createDraft(account, subject, text);
    }
    public void createFolder(final Account4Public account, final String name) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).createFolder(account, name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void send(final Draft4Public draft) 
				throws PersistenceException{
        ((PersistentAccountManager)this.getTheObject()).send(draft);
    }

    
}
