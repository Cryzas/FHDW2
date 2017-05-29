
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends ContaineeCommandExceptionVisitor<E>,DirectoryCommandExceptionVisitor<E>,FileCommandExceptionVisitor<E>{
    
    
}
