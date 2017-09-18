
package model.visitor;
public interface CommandExceptionVisitor<E extends model.UserException> extends AccountManagerCommandExceptionVisitor<E>,TransferManagerCommandExceptionVisitor<E>{
    
    
}
