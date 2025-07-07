public class Order {
    private String number;
    private Date date;

    // Default constructor
    public Order() {
    }

    // Parameterized constructor
    public Order(String number, Date date) {
        this.number = number;
        this.date = date;
    }

    // Getter and setter for number
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Getter and setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}