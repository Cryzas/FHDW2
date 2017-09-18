
package model.visitor;
public interface CommandReturnVisitor<R> extends AccountManagerCommandReturnVisitor<R> ,TransferManagerCommandReturnVisitor<R> {
    
    
}
