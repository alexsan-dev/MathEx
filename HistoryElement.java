import java.util.Date;

public class HistoryElement {
  private int type;
  private double result;
  private Date date;

  public HistoryElement(int type, double result, Date date) {
    this.type = type;
    this.result = result;
    this.date = date;
  }

  public int getType() {
    return type;
  }

  public double getResult() {
    return result;
  }

  public Date getDate() {
    return date;
  }
}