public class Maths {
  // ============== GLOBALES ==============
  final static double PI = 3.14159265358979323846;
  final static double e = 2.71828182845904523;

  public static int parseInt(Double a) {
    Double round = a + 0.5;
    String compose = round.toString();
    String cRound = compose.substring(0, compose.indexOf("."));
    return Integer.parseInt(cRound);
  }

  // ============== ARITMÉTICA ==============
  // SUMA
  public static double sum(Double a, Double b) {
    return a + b;
  }

  // RESTA
  public static double dif(Double a, Double b) {
    return a - b;
  }

  // MULTIPLICACIÓN
  public static double mult(Double a, Double b) {
    return a * b;
  }

  // DIVISION
  public static double div(Double a, Double b) {
    return (double) (a / b);
  }

  // FACTORIAL
  public static double fact(int a) {
    if (a == 0)
      return 1;
    else {
      // VARIABLE DE SALIDA
      double out = a;

      // RECORRER A VECES
      for (int factIndex = 1; factIndex <= a - 1; factIndex++)
        out *= factIndex;

      // RETORNAR SALIDA
      return out;
    }
  }

  // POTENCIA
  public static double pow(double x, int n) {
    if (n == 0)
      return 1;
    else {
      // VARIABLE DE SALIDA
      double out = x;

      // RECORRER A N VECES
      for (int powIndex = 0; powIndex < n - 1; powIndex++)
        out *= x;

      // RETORNAR SALIDA
      return out;
    }
  }

  // RAÍZ CUADRADA
  public static double sqrt(double a) {
    // VARIABLES TEMPORALES
    double temp;
    double divs = a / 2;

    // MÉTODO DE SUMA DE DIVISOR
    do {
      temp = divs;
      divs = (temp + (a / temp)) / 2;
    } while ((temp - divs) != 0);

    // RETORNAR RAÍZ
    return divs;
  }

  public static double inverse(Double a) {
    return (double) (1 / a);
  }

  // NEGATIVO
  public static double negative(Double a) {
    return a * -1;
  }

  // ========== ALGEBRA ==========
  // CALCULAR ECUACIÓN CUADRÁTICA
  public static Double[] quadEq(int a, int b, int c) {
    // VARIABLE DE SALIDA
    Double[] out = new Double[2];

    // CALCULAR CON ECUACIÓN POSITIVA
    out[0] = (-b + sqrt((int) pow(b, 2) - (4 * a * c))) / 2 * a;

    // CALCULAR CON ECUACIÓN NEGATIVA
    out[1] = (-b - sqrt((int) pow(b, 2) - (4 * a * c))) / 2 * a;

    // RETORNAR RESPUESTAS
    return out;
  }

  // FACTORIZACIÓN
  public static int[] quadBin(int a, int b, int c) {
    // VALOR POR DEFECTO
    int[] out = { -1, -1 };

    // CUADRADOS
    int aRoot = parseInt(sqrt(a));
    int cRoot = parseInt(sqrt(b));

    // VERIFICAR SI ES UN BINOMIO CUADRADO PERFECTO
    if ((2 * cRoot * aRoot) == b) {
      out[0] = cRoot;
      out[1] = aRoot;
    }

    // RETORNAR RAÍCES
    return out;
  }

  public static int[] quadDif(int a, int b) {
    // CUADRADOS
    int aRoot = parseInt(sqrt(a));
    int cRoot = parseInt(sqrt(b));

    // VALOR POR DEFECTO
    int[] out = { aRoot, cRoot };

    // RETORNAR RAÍCES
    return out;
  }

  // ============== TRIGONOMÉTRICAS ==============
  public static double sin(double a) {
    if (a == Double.NEGATIVE_INFINITY || !(a < Double.POSITIVE_INFINITY)) {
      return Double.NaN;
    }

    double temp = 0;

    for (int i = 0; i < 100; i++)
      temp += pow(-1, i) * (pow(a, (2 * i) + 1) / fact((2 * i) + 1));

    return temp;
  }

  public static double cos(double a) {
    if (a == Double.NEGATIVE_INFINITY || !(a < Double.POSITIVE_INFINITY)) {
      return Double.NaN;
    }

    double temp = 0;

    for (int i = 0; i < 100; i++)
      temp += pow(-1, i) * (pow(a, (2 * i)) / fact((2 * i)));

    return temp;
  }

  public static double tan(double a) {
    if (a == Double.NEGATIVE_INFINITY || !(a < Double.POSITIVE_INFINITY)) {
      return Double.NaN;
    }

    return sin(a) / cos(a);
  }

  public static double archLength(double angle, double radius) {
    return angle * radius;
  }

  public static Double riemann(int func, double inf, double sup, double dif) {
    Double out = 0.0;
    double n = ((sup > inf ? sup : inf) - (inf < sup ? inf : sup)) / dif;

    switch (func) {
      case 0:
        out = ((n * (n + 1) * ((2 * n) + 1)) / 6) * dif;
        break;
      case 1:
        out = pow((n * (n + 1)) / 2, 2) * dif;
        break;
      case 2:
        for (int k = 1; k < n; k++) {
          double x = inf + ((sup - inf) / n) * k;
          out += pow(e, parseInt(x)) * dif;
        }
        break;
      default:
        break;
    }
    return out;
  }

  public static double[][] matrizInversa(double[][] matriz) {
    double det = 1 / determinante(matriz);
    double[][] nmatriz = matrizAdjunta(matriz);
    multiplicarMatriz(det, nmatriz);
    return nmatriz;
  }

  public static void multiplicarMatriz(double n, double[][] matriz) {
    for (int i = 0; i < matriz.length; i++)
      for (int j = 0; j < matriz.length; j++)
        matriz[i][j] *= n;
  }

  public static double[][] matrizAdjunta(double[][] matriz) {
    return matrizTranspuesta(matrizCofactores(matriz));
  }

  public static double[][] matrizCofactores(double[][] matriz) {
    double[][] nm = new double[matriz.length][matriz.length];
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz.length; j++) {
        double[][] det = new double[matriz.length - 1][matriz.length - 1];
        double detValor;
        for (int k = 0; k < matriz.length; k++) {
          if (k != i) {
            for (int l = 0; l < matriz.length; l++) {
              if (l != j) {
                int indice1 = k < i ? k : k - 1;
                int indice2 = l < j ? l : l - 1;
                det[indice1][indice2] = matriz[k][l];
              }
            }
          }
        }
        detValor = determinante(det);
        nm[i][j] = detValor * (double) Math.pow(-1, i + j + 2);
      }
    }
    return nm;
  }

  public static double[][] matrizTranspuesta(double[][] matriz) {
    double[][] nuevam = new double[matriz[0].length][matriz.length];
    for (int i = 0; i < matriz.length; i++) {
      for (int j = 0; j < matriz.length; j++)
        nuevam[i][j] = matriz[j][i];
    }
    return nuevam;
  }

  public static double determinante(double[][] matriz) {
    double det;
    if (matriz.length == 2) {
      det = (matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]);
      return det;
    }
    double suma = 0;
    for (int i = 0; i < matriz.length; i++) {
      double[][] nm = new double[matriz.length - 1][matriz.length - 1];
      for (int j = 0; j < matriz.length; j++) {
        if (j != i) {
          for (int k = 1; k < matriz.length; k++) {
            int indice = -1;
            if (j < i)
              indice = j;
            else if (j > i)
              indice = j - 1;
            nm[indice][k - 1] = matriz[j][k];
          }
        }
      }
      if (i % 2 == 0)
        suma += matriz[i][0] * determinante(nm);
      else
        suma -= matriz[i][0] * determinante(nm);
    }
    return suma;
  }

}
