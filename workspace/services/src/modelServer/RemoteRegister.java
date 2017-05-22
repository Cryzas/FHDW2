
package modelServer;


import persistence.*;

public  class RemoteRegister extends RemoteService {

	
	public RemoteRegister(String connectionName, String userName, PersistentRegister server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> register_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentRegister)this.server).register_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> register(String accountName, String password){
        try {
            ((PersistentRegister)this.server).register(accountName, password);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}