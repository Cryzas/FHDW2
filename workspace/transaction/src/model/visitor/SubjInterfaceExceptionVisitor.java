
package model.visitor;
import persistence.*;

public interface SubjInterfaceExceptionVisitor<E extends model.UserException> extends AbstractTransferExceptionVisitor<E>,AccountHandleExceptionVisitor<E>,EntryExceptionVisitor<E>,TransferStateExceptionVisitor<E>{
    
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException, E;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException, E;
    public void handleServer(Server4Public server) throws PersistenceException, E;
    public void handleSubj(Subj4Public subj) throws PersistenceException, E;
    public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException, E;
    public void handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException, E;
    
}
