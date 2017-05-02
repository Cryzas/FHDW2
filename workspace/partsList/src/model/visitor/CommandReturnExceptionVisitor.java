
package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends PartsListManagerCommandReturnExceptionVisitor<R, E> ,ProductCommandReturnExceptionVisitor<R, E> {
    
    
}
