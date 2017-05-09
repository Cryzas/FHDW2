
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
    
    public synchronized java.util.HashMap<?,?> book(String transferProxiString){
        try {
            PersistentTransfer transfer = (PersistentTransfer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(transferProxiString));
            ((PersistentServer)this.server).book(transfer);
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
    
    public synchronized java.util.HashMap<?,?> createAccount(String description){
        try {
            ((PersistentServer)this.server).createAccount(description);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createTransfer(String description, String fromAccProxiString, String toAccProxiString, String amountAsString){
        try {
            PersistentAccount fromAcc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fromAccProxiString));
            PersistentAccount toAcc = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(toAccProxiString));
            common.Fraction amount = common.Fraction.parse(amountAsString);
            ((PersistentServer)this.server).createTransfer(description, fromAcc, toAcc, amount);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> findAccountByNumber(String numberAsString){
        try {
            long number = new Long(numberAsString).longValue();
            ((PersistentServer)this.server).findAccountByNumber(number);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> findAccountByString(String name){
        try {
            ((PersistentServer)this.server).findAccountByString(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}