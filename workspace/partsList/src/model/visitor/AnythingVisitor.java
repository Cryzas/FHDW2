
package model.visitor;
import persistence.*;

public interface AnythingVisitor extends CommonDateVisitor,ComponentVisitor{
    
    public void handleAddPartCommand(AddPartCommand4Public addPartCommand) throws PersistenceException;
    public void handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException;
    public void handleCommonDate(CommonDate4Public commonDate) throws PersistenceException;
    public void handleComponentLst(ComponentLst4Public componentLst) throws PersistenceException;
    public void handleCreateMaterialCommand(CreateMaterialCommand4Public createMaterialCommand) throws PersistenceException;
    public void handleCreateProductCommand(CreateProductCommand4Public createProductCommand) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handlePartsListManager(PartsListManager4Public partsListManager) throws PersistenceException;
    public void handleQuantifiedComponent(QuantifiedComponent4Public quantifiedComponent) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    
}
