package persistence;


public interface PersistentServer extends Invoker, Anything, SubjInterface, Remote, AbstractPersistentProxi, Server4Public {
    
    public void setAccounts(ServerAccounts4Public newValue) throws PersistenceException ;
    public void setTransfers(TransferManager4Public newValue) throws PersistenceException ;
    public SubjInterface getSubService() throws PersistenceException ;
    public void setSubService(SubjInterface newValue) throws PersistenceException ;
    public Server_ErrorsProxi getErrors() throws PersistenceException ;
    public String getPassword() throws PersistenceException ;
    public void setPassword(String newValue) throws PersistenceException ;
    public void setUser(String newValue) throws PersistenceException ;
    public long getHackCount() throws PersistenceException ;
    public void setHackCount(long newValue) throws PersistenceException ;
    public java.sql.Timestamp getHackDelay() throws PersistenceException ;
    public void setHackDelay(java.sql.Timestamp newValue) throws PersistenceException ;
    public PersistentServer getThis() throws PersistenceException ;
    
    
    public void setAccounts(final AccountManager4Public accounts) 
				throws PersistenceException;
    public void accounts_update(final model.meta.AccountManagerMssgs event) 
				throws PersistenceException;

}

