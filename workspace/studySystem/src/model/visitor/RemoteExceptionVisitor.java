
package model.visitor;
import persistence.*;

public interface RemoteExceptionVisitor<E extends model.UserException> extends ServiceExceptionVisitor<E>,subAdminServiceExceptionVisitor<E>{
    
    public void handleServer(Server4Public server) throws PersistenceException, E;
    
}
