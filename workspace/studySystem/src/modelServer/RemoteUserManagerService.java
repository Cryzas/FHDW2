
package modelServer;


import persistence.*;

public  class RemoteUserManagerService extends RemotesubAdminService {

	
	public RemoteUserManagerService(String connectionName, String userName, PersistentUserManagerService server){
		super (connectionName, userName , server);
	}

	
 

    public synchronized java.util.HashMap<?,?> userManagerService_Menu_Filter(String anythingProxiString){
        try {
            Anything anything = (Anything)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(anythingProxiString));
            String result = ((PersistentUserManagerService)this.server).userManagerService_Menu_Filter(anything);
            return createOKResult(result);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> users_Path_In_DeleteUsers(){
        try {
            ServerSearchList result = ((PersistentUserManagerService)this.server).users_Path_In_DeleteUsers();
            return createOKResult(result.getVector(1, 0, false, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createAdminUser(String name, String pw){
        try {
            ((PersistentUserManagerService)this.server).createAdminUser(name, pw);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> deleteUsers(java.util.Vector<String> usersTrnsprt){
        try {
            ServerSearchList users = new ServerSearchList();
			java.util.Iterator<String> usersItrtr = usersTrnsprt.iterator();
			while (usersItrtr.hasNext()){
				PersistentServer currentProxi = (PersistentServer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(usersItrtr.next()));
				users.add(currentProxi);
			}
            ((PersistentUserManagerService)this.server).deleteUsers(users);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> removeError(String errorProxiString){
        try {
            PersistentErrorDisplay error = (PersistentErrorDisplay)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(errorProxiString));
            ((PersistentUserManagerService)this.server).removeError(error);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updateMe(){
        try {
            ((PersistentUserManagerService)this.server).updateMe();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> updatePLZImplementation(){
        try {
            ((PersistentUserManagerService)this.server).updatePLZImplementation();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}