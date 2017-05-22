
package modelServer;


import persistence.*;

public  class RemoteCustomer extends RemoteService {

	
	public RemoteCustomer(String connectionName, String userName, PersistentCustomer server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> customer_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentCustomer)this.server).customer_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> customerOp(){
        try {
            ((PersistentCustomer)this.server).customerOp();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}