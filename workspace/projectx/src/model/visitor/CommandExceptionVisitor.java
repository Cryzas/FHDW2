
package model.visitor;
public interface CommandExceptionVisitor<E extends model.UserException> extends ModuleManagerCommandExceptionVisitor<E>,ProgramManagerCommandExceptionVisitor<E>,StudyGroupManagerCommandExceptionVisitor<E>{
    
    
}
