
package modelServer;


import persistence.*;

public  class RemoteServer extends RemoteServerMaster {

	protected PersistentServer server;

	public RemoteServer(String connectionName, String userName, PersistentServer server){
		super (connectionName, userName );
        this.server = server;
	}

	protected Remote getServer(){
        return this.server;
    }
 

    public synchronized java.util.HashMap<?,?> server_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentServer)this.server).server_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> addReceiver(String draftProxiString, String accountProxiString){
        try {
            PersistentDraft draft = (PersistentDraft)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(draftProxiString));
            PersistentAccount account = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountProxiString));
            ((PersistentServer)this.server).addReceiver(draft, account);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> answerAll(String mailProxiString, String subject, String text){
        try {
            PersistentMailEntry mail = (PersistentMailEntry)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(mailProxiString));
            ((PersistentServer)this.server).answerAll(mail, subject, text);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> answer(String mailProxiString, String subject, String text){
        try {
            PersistentMailEntry mail = (PersistentMailEntry)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(mailProxiString));
            ((PersistentServer)this.server).answer(mail, subject, text);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createAccount(String name){
        try {
            ((PersistentServer)this.server).createAccount(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createDraft(String accountProxiString, String subject, String text){
        try {
            PersistentAccount account = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountProxiString));
            ((PersistentServer)this.server).createDraft(account, subject, text);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createFolder(String accountProxiString, String name){
        try {
            PersistentAccount account = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountProxiString));
            ((PersistentServer)this.server).createFolder(account, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> send(String draftProxiString){
        try {
            PersistentDraft draft = (PersistentDraft)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(draftProxiString));
            ((PersistentServer)this.server).send(draft);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}