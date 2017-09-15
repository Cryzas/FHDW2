
package modelServer;


import persistence.*;

public abstract class RemoteService extends RemoteServerMaster {

	protected PersistentService server;

	public RemoteService(String connectionName, String userName, PersistentService server){
		super (connectionName, userName );
        this.server = server;
	}

	protected Remote getServer(){
        return this.server;
    }
 



}