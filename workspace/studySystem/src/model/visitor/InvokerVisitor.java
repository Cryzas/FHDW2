
package model.visitor;
import persistence.*;

public interface InvokerVisitor extends ServiceVisitor,subAdminServiceVisitor{
    
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
