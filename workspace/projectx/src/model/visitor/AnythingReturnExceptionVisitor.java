
package model.visitor;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends model.UserException> extends CommonDateReturnExceptionVisitor<R, E> ,ModuleAbstractReturnExceptionVisitor<R, E> {
    
    public R handleAddModuleCommand(AddModuleCommand4Public addModuleCommand) throws PersistenceException, E;
    public R handleAddUnitCommand(AddUnitCommand4Public addUnitCommand) throws PersistenceException, E;
    public R handleChangeCPOnModuleCommand(ChangeCPOnModuleCommand4Public changeCPOnModuleCommand) throws PersistenceException, E;
    public R handleChangeCPOnUnitCommand(ChangeCPOnUnitCommand4Public changeCPOnUnitCommand) throws PersistenceException, E;
    public R handleCommandCoordinator(CommandCoordinator4Public commandCoordinator) throws PersistenceException, E;
    public R handleCommandExecuter(CommandExecuter4Public commandExecuter) throws PersistenceException, E;
    public R handleCommonDate(CommonDate4Public commonDate) throws PersistenceException, E;
    public R handleCreateModuleCommand(CreateModuleCommand4Public createModuleCommand) throws PersistenceException, E;
    public R handleCreateProgramCommand(CreateProgramCommand4Public createProgramCommand) throws PersistenceException, E;
    public R handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public R handleModuleManager(ModuleManager4Public moduleManager) throws PersistenceException, E;
    public R handleProgram(Program4Public program) throws PersistenceException, E;
    public R handleProgramManager(ProgramManager4Public programManager) throws PersistenceException, E;
    public R handleServer(Server4Public server) throws PersistenceException, E;
    public R handleSubj(Subj4Public subj) throws PersistenceException, E;
    public R handleUnit(Unit4Public unit) throws PersistenceException, E;
    
}
