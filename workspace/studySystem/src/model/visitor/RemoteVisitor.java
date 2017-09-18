
package model.visitor;
import persistence.*;

public interface RemoteVisitor extends ServiceVisitor,subAdminServiceVisitor{
    
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
