package persistence;

public interface AggregtorException<Argument, Result, E extends model.UserException> {

	public Result compose(Result result,Argument argument) throws PersistenceException, E;

}
