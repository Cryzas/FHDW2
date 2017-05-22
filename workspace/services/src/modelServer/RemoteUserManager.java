
package modelServer;


import persistence.*;

public  class RemoteUserManager extends RemoteService {

	
	public RemoteUserManager(String connectionName, String userName, PersistentUserManager server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> userManager_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentUserManager)this.server).userManager_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> userManagerOP(){
        try {
            ((PersistentUserManager)this.server).userManagerOP();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}