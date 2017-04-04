
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends ComponentReturnVisitor<R> {
    
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public R handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public R handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException;
    public R handleServer(Server4Public server) throws PersistenceException;
    
}
