
package model.visitor;
public interface CommandReturnExceptionVisitor<R, E extends model.UserException> extends ModuleManagerCommandReturnExceptionVisitor<R, E> ,ProgramManagerCommandReturnExceptionVisitor<R, E> ,StudentManagerCommandReturnExceptionVisitor<R, E> ,StudyGroupManagerCommandReturnExceptionVisitor<R, E> {
    
    
}
