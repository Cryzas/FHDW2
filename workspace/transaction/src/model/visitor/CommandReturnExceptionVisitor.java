
package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends AccountManagerCommandReturnExceptionVisitor<R, E> ,TransferManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
