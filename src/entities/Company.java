package entities;

public class Company extends TaxPayer{
    private Integer numberOfEmployees;
    public Company(){
        super();
    }
    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int  getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int  numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
    @Override
    public double tax() {
        return (getNumberOfEmployees() < 10) ? getAnualIncome() * 0.16 : getAnualIncome() * 0.14;
    }
}
