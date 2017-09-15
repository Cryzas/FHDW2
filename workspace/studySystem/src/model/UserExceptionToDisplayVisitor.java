package model;

import persistence.PersistenceException;
import persistence.ErrorDisplay4Public;
import model.visitor.UserExceptionStandardVisitor;

public class UserExceptionToDisplayVisitor extends UserExceptionStandardVisitor {

	private ErrorDisplay4Public result;

	public void standardHandling(UserException userException)
			throws PersistenceException {
		this.result = ErrorDisplay.createErrorDisplay(userException.getMessage(), false);
	}
	public ErrorDisplay4Public getResult(){
		return this.result;
	}

}
