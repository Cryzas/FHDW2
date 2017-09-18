
package modelServer;


import persistence.*;

public  class RemoteAdminService extends RemoteService {

	
	public RemoteAdminService(String connectionName, String userName, PersistentAdminService server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> adminService_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentAdminService)this.server).adminService_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}