
package model.visitor;

public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends ContaineeCommandReturnExceptionVisitor<R, E> ,DirectoryCommandReturnExceptionVisitor<R, E> ,FileCommandReturnExceptionVisitor<R, E> {
    
    
}
