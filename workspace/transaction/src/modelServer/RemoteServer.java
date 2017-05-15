
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
    
    public synchronized java.util.HashMap<?,?> book(String tranferProxiString){
        try {
            PersistentAbstractTransfer tranfer = (PersistentAbstractTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(tranferProxiString));
            ((PersistentServer)this.server).book(tranfer);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> clearAccounts(){
        try {
            ((PersistentServer)this.server).clearAccounts();
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
    
    public synchronized java.util.HashMap<?,?> createCredit(String myAccountProxiString, String otherAccountProxiString, String amountAsString, String subject){
        try {
            PersistentAccount myAccount = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(myAccountProxiString));
            PersistentAccountHandle otherAccount = (PersistentAccountHandle)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(otherAccountProxiString));
            common.Fraction amount = common.Fraction.parse(amountAsString);
            ((PersistentServer)this.server).createCredit(myAccount, otherAccount, amount, subject);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createDebit(String myAccountProxiString, String otherAccountProxiString, String amountAsString, String subject){
        try {
            PersistentAccount myAccount = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(myAccountProxiString));
            PersistentAccountHandle otherAccount = (PersistentAccountHandle)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(otherAccountProxiString));
            common.Fraction amount = common.Fraction.parse(amountAsString);
            ((PersistentServer)this.server).createDebit(myAccount, otherAccount, amount, subject);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> findAccounts(String name){
        try {
            ((PersistentServer)this.server).findAccounts(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}