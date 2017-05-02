
package model.visitor;

public interface CommandExceptionVisitor<E extends model.UserException> extends PartsListManagerCommandExceptionVisitor<E>,ProductCommandExceptionVisitor<E>{
    
    
}
