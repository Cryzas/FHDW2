
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
    
    public synchronized java.util.HashMap<?,?> changeContents(String fileProxiString, String contents){
        try {
            PersistentFile file = (PersistentFile)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fileProxiString));
            ((PersistentServer)this.server).changeContents(file, contents);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> clip(String containeeProxiString){
        try {
            PersistentContainee containee = (PersistentContainee)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(containeeProxiString));
            ((PersistentServer)this.server).clip(containee);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> create(String containerProxiString, String name, String type){
        try {
            PersistentDirectory container = (PersistentDirectory)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(containerProxiString));
            ((PersistentServer)this.server).create(container, name, type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> delete(String containeeProxiString){
        try {
            PersistentContainee containee = (PersistentContainee)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(containeeProxiString));
            ((PersistentServer)this.server).delete(containee);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> paste(String directoryProxiString){
        try {
            PersistentDirectory directory = (PersistentDirectory)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(directoryProxiString));
            ((PersistentServer)this.server).paste(directory);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.FileSystemException e0){
            return createExceptionResult(e0, this);
        }
    }
    


}