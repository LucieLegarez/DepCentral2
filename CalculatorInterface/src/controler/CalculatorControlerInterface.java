package controler;


public interface CalculatorControlerInterface {
	public void handleDigitButtonClick(String digit);
    public void handlePushButtonClick();
    public void handleOppositeButtonClick();
    public void handleDropButtonClick();
    public void handleClearButtonClick();
    public void handleSwapButtonClick();
    public void handleOperatorButtonClick(String operator);

}
