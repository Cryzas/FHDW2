
package model.visitor;

import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends ComponentReturnExceptionVisitor<R, E> {
    
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    
}
