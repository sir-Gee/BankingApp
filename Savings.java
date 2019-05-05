package bankApp;

public class Savings extends Account{
    public Savings() {
        super();
    }

    public void checkingAmount(int amount){
        if(amount > this.getInitBalance()){
            System.out.println("Wrong amount");
        }
    }

}
