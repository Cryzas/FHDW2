
package model.visitor;

import persistence.*;

public interface AnythingExceptionVisitor<E extends model.UserException> extends ComponentExceptionVisitor<E>{
    
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public void handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    
}
