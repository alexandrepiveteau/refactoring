package ch.heigvd.gen2019;

public class Product implements ToJson {

  private String code;
  private Color color;
  private Size size;
  private double price;
  private String currency;

  public Product(String code, Color color, Size size, double price, String currency) {
    this.code = code;
    this.color = color;
    this.size = size;
    this.price = price;
    this.currency = currency;
  }

  public String getCode() {
    return code;
  }

  public Color getColor() {
    return color;
  }

  public Size getSize() {
    return size;
  }

  public double getPrice() {
    return price;
  }

  public String getCurrency() {
    return currency;
  }

  public void encodeJson(StringBuffer sb) {
    sb.append("{");
    sb.append("\"code\": \"");
    sb.append(getCode());
    sb.append("\", ");
    sb.append("\"color\": \"");
    sb.append(getColor());
    sb.append("\", ");

    if (getSize() != null) {
      sb.append("\"size\": \"");
      sb.append(getSize());
      sb.append("\", ");
    }

    sb.append("\"price\": ");
    sb.append(getPrice());
    sb.append(", ");
    sb.append("\"currency\": \"");
    sb.append(getCurrency());
    sb.append("\"}");
  }
}