
package modelServer;


import persistence.*;

public  class RemoteAdministrator extends RemoteService {

	
	public RemoteAdministrator(String connectionName, String userName, PersistentAdministrator server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> administrator_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentAdministrator)this.server).administrator_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> administratorOp(){
        try {
            ((PersistentAdministrator)this.server).administratorOp();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}