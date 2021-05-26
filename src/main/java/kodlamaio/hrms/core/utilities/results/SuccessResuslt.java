package kodlamaio.hrms.core.utilities.results;

public class SuccessResuslt extends Result {
	public SuccessResuslt() {
		super(true);
	}

	public SuccessResuslt(String message) {
		super(true, message);
	}
}
