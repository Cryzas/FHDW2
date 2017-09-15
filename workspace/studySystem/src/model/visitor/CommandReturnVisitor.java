
package model.visitor;
public interface CommandReturnVisitor<R> extends ModuleManagerCommandReturnVisitor<R> ,ProgramManagerCommandReturnVisitor<R> ,StudentManagerCommandReturnVisitor<R> ,StudyGroupManagerCommandReturnVisitor<R> {
    
    
}
