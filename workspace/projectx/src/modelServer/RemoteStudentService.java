
package modelServer;


import persistence.*;

public  class RemoteStudentService extends RemoteService {

	
	public RemoteStudentService(String connectionName, String userName, PersistentStudentService server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> studentService_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentStudentService)this.server).studentService_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}