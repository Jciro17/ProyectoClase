package co.edu.uco.pch.business.usecase;

public interface UseCaseWithReturn<T, R> {
	
	R excecute(T data);

}
