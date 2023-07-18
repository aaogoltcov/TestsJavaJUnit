public class IntegerConverter {
  private final int number;

  public IntegerConverter(int number) {
    this.number = number;
  }

  public String toBinary() {
    return Integer.toString(this.number, 2);
  }

  public String toOctal() {
    return Integer.toString(this.number, 8);
  }

  public String toHex() {
    return Integer.toString(this.number, 16);
  }
}
