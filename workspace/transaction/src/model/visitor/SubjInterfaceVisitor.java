
package model.visitor;
import persistence.*;

public interface SubjInterfaceVisitor extends AbstractTransferVisitor,AccountHandleVisitor,EntryVisitor,TransferStateVisitor{
    
    public void handleAccountManager(AccountManager4Public accountManager) throws PersistenceException;
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException;
    public void handleServer(Server4Public server) throws PersistenceException;
    public void handleSubj(Subj4Public subj) throws PersistenceException;
    public void handleTransferManager(TransferManager4Public transferManager) throws PersistenceException;
    public void handleWrapperRecycle(WrapperRecycle4Public wrapperRecycle) throws PersistenceException;
    
}
