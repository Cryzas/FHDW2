
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
    
    public synchronized java.util.HashMap<?,?> addPart(String productProxiString, String componentProxiString, String quantityAsString){
        try {
            PersistentProduct product = (PersistentProduct)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(productProxiString));
            PersistentComponent component = (PersistentComponent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(componentProxiString));
            long quantity = new Long(quantityAsString).longValue();
            ((PersistentServer)this.server).addPart(product, component, quantity);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PartsListException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> clearComponents(){
        try {
            ((PersistentServer)this.server).clearComponents();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createMaterial(String name){
        try {
            ((PersistentServer)this.server).createMaterial(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PartsListException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> createProduct(String name){
        try {
            ((PersistentServer)this.server).createProduct(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.PartsListException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.HashMap<?,?> fetchMaterials(String componentProxiString){
        try {
            PersistentComponent component = (PersistentComponent)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(componentProxiString));
            ComponentLst4Public result = ((PersistentServer)this.server).fetchMaterials(component);
            return createOKResult(result, 1, this);
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.HashMap<?,?> findComponents(String name){
        try {
            ((PersistentServer)this.server).findComponents(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}