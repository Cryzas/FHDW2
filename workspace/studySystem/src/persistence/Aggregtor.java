package persistence;

public interface Aggregtor<Argument,Result> {
	public Result compose(Result result, Argument argument) throws PersistenceException;
}
