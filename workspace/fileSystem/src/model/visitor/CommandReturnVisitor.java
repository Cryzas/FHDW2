
package model.visitor;

public interface CommandReturnVisitor<R> extends ContaineeCommandReturnVisitor<R> ,DirectoryCommandReturnVisitor<R> ,FileCommandReturnVisitor<R> {
    
    
}
