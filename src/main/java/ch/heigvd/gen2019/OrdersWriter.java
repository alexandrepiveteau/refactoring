package ch.heigvd.gen2019;

public class OrdersWriter {

  private Orders orders;

  public OrdersWriter(Orders orders) {
    this.orders = orders;
  }

  public String getContents() {
    StringBuffer sb = new StringBuffer("{\"orders\": [");

    for (int i = 0; i < orders.getOrdersCount(); i++) {
      Order order = orders.getOrder(i);
      sb.append("{");
      sb.append("\"id\": ");
      sb.append(order.getOrderId());
      sb.append(", ");
      sb.append("\"products\": [");
      for (int j = 0; j < order.getProductsCount(); j++) {
        appendProductTo(sb, order.getProduct(j));
      }

      appendEndArray(sb, order.getProductsCount());
      sb.append(", ");
    }

    appendEndArray(sb, orders.getOrdersCount());
    return sb.toString();
  }

  private void appendEndArray(StringBuffer sb, int nbElements) {
    if (nbElements > 0) {
      sb.delete(sb.length() - 2, sb.length());
    }

    sb.append("]}");
  }

  private void appendProductTo(StringBuffer sb, Product product) {
    encodeJson(sb, product);
    sb.append(", ");
  }

  private void encodeJson(StringBuffer sb, Product product) {
    sb.append("{");
    sb.append("\"code\": \"");
    sb.append(product.getCode());
    sb.append("\", ");
    sb.append("\"color\": \"");
    sb.append(product.getColor());
    sb.append("\", ");

    if (product.getSize() != null) {
      sb.append("\"size\": \"");
      sb.append(product.getSize());
      sb.append("\", ");
    }

    sb.append("\"price\": ");
    sb.append(product.getPrice());
    sb.append(", ");
    sb.append("\"currency\": \"");
    sb.append(product.getCurrency());
    sb.append("\"}");
  }
}