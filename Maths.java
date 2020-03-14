public class Maths {
  // ========== ARITMETICA ==============
  // SUMA
  public static int sum(int a, int b) {
    return a + b;
  }

  // RESTA
  public static int dif(int a, int b) {
    return a - b;
  }

  // MULTIPLICACION
  public static int mult(int a, int b) {
    return a * b;
  }

  // DIVISION
  public static Double div(int a, int b) {
    return (double) (a / b);
  }

  // FACTORIAL
  public static long fact(int a) {
    // VARIABLE DE SALIDA
    long out = a;

    // REOCRRER A VECES
    for (int factIndex = 0; factIndex < a - 1; factIndex++)
      out *= ((a - factIndex) - 1);

    // RETORNAR SALIDA
    return out;
  }

  // POTENCIA
  public static long pow(int a, int n) {
    // VARIABLE DE SALIDA
    long out = a;

    // RECORERR A N VECES
    for (int powIndex = 0; powIndex < n - 1; powIndex++)
      out *= a;

    // RETORNAR SALIDA
    return out;
  }

  // RAIZ CUADRADA
  public static Double sqrt(int a) {
    // VARIABLES TEMPORALES
    double temp;
    double divs = a / 2;

    // METODO DE SUMA DE DIVISOR
    do {
      temp = divs;
      divs = (temp + (a / temp)) / 2;
    } while ((temp - divs) != 0);

    // RETORNAR RAIZ
    return divs;
  }

  // CALCULAR INVERSO
  public static double inverse(int a) {
    return (double) 1 / a;
  }

  // NEGATIVO
  public static int negative(int a) {
    return a * -1;
  }

}