
![](utm.png "Title")

# TSU Desarrollo de Software Multiplataforma
# Daniel Ivan Escobar Vasquez
# Ruth Martinez Dominguez
# Estructura de Datos - 4F
# 20 de Septiembre del 2024

\pagebreak

# Contenido
1. [Ejercicio 7](#ejercicio-7)
2. [Ejercicio 8](#ejercicio-8)
3. [Ejercicio 9](#ejercicio-9)
4. [Ejercicio 10](#ejercicio-10)
5. [Github](#github)

# Ejercicio 7

Definimos una clase ArrayCounter que cuenta el número de ceros en una matriz bidimensional.

Definición de la matriz: La clase tiene una propiedad pública llamada matrix, que es una lista de listas de enteros predefinida con valores numéricos.
Método count(): Esta función cuenta el número de ceros en la matriz recorriendo cada fila y columna, e incrementando un contador (zeroCounter) cada vez que encuentra un 0.
Método getArrayAsString(): Este método convierte la matriz en una cadena de texto HTML, con cada valor separado por un salto de línea.
Método getNumberOfZeros(): Esta función devuelve un mensaje con el número de ceros encontrados en la matriz.

```java
public class ArrayCounter {
    public String name = "Práctica 7";
    public static List<List<Integer>> matrix = List.of(
            List.of(0, 2, 5, 7, 6),
            List.of(0, 0, 0, 3, 8),
            List.of(2, 9, 6, 3, 4),
            List.of(1, 5, 6, 1, 4),
            List.of(0, 9, 2, 5, 0));

    public static int count() {
        int zeroCounter = 0;

        for (List<Integer> row : matrix) {
            for (Integer n : row) {
                if (n == 0)
                    zeroCounter++;
            }
        }
        return zeroCounter;
    }
    
    public static String getArrayAsString(){
        String text = "<html>";
         for (List<Integer> row : matrix) {
            for (Integer n : row) {
                text = text + n;
            }
            text = text + "<br>";
        }       
        return text + "<html/>";
    }

    public static String getNumberOfZeros() {
        return String.format("Hay %s zeros en el arreglo. ", count());
    }
}
```

# Ejercicio 8

Definimos una clase llamada `CuadroMagico` que representa un cuadrado mágico, que es un tipo de cuadrado numérico donde la suma de los números en cada fila, columna y diagonal principal es la misma.

### `setup(int size)` Método

Este método configura el tamaño del cuadrado mágico estableciendo el valor de la variable `size`. Esta configuración permite instanciar objetos de tipo `CuadroMagico` con diferentes tamaños, lo que es útil cuando se trabaja con cuadrados mágicos de distinto tamaño. El método devuelve el objeto `this` para permitir cadenas de métodos.

```java
public CuadroMagico setup(int size){
    this.size = size;
    return this;
}
```

### 4. `verifySum()` Método

Este es el método principal para verificar si un cuadrado mágico es efectivamente uno. Realiza varias comprobaciones:

- **Filas:** Calcula la suma de los números en cada fila.
- **Columnas:** Calcula la suma de los números en cada columna.
- **Diagonal (izquierda a derecha):** Calcula la suma de los números que se encuentran en la diagonal principal del cuadrado, de izquierda a derecha.
- **Diagonal inversa (derecha a izquierda):** Calcula la suma de los números en la diagonal inversa.

Luego, verifica si todas estas sumas son iguales. Si lo son, establece el número mágico como la primera suma calculada y devuelve `true`, indicando que se trata de un cuadrado mágico válido.

```java
public boolean verifySum() {
    List<Integer> sumList = new ArrayList<>();

    // Verificar filas
    for (int row = 0; row < size; row++) {
        int rowSum = 0;
        for (JTextField textField : matrixOfTextFields.get(row)) {
            rowSum = rowSum + Integer.parseInt(textField.getText());
        }
        sumList.add(rowSum);
        System.out.println("Row sum = " + rowSum);
    }

    // Verificar columnas
    int columns = matrixOfTextFields.get(0).size();
    for (int column = 0; column < columns; column++) {
        int rows = matrixOfTextFields.size();
        int colSum = 0;
        for (int row = 0; row < rows; row++) {
            colSum = colSum + Integer.parseInt(matrixOfTextFields.get(row).get(column).getText());
        }
        sumList.add(colSum);
        System.out.println("cols sum =" + colSum );
    }

    // Verificar diagonal izquierda a derecha
    int leftToRightSum = 0;
    for (int row = 0; row < columns; row++) {
        for (int column = 0; column < columns; column++) {
            if (row == column)
                leftToRightSum = leftToRightSum + Integer.parseInt(matrixOfTextFields.get(row).get(column).getText());
        }
    }
    System.out.println("left to right sum = " + leftToRightSum);
    sumList.add(leftToRightSum);

    int rightToLeftSum = 0;
    for (int i = 0; i < matrixOfTextFields.size(); i++) {
        int j = columns - i - 1;
        rightToLeftSum = rightToLeftSum + Integer.parseInt(matrixOfTextFields.get(i).get(j).getText());
    }
    System.out.println("suma antidiagonal" + rightToLeftSum);
    sumList.add(rightToLeftSum);

    System.out.println(sumList);
    System.out.println("All are the same?" + checkIfAllElementsAreSame(sumList));
    if(checkIfAllElementsAreSame(sumList)){
        magicNumber = sumList.get(0);
    }
    
    return checkIfAllElementsAreSame(sumList);
}
```

### `checkIfAllElementsAreSame(List<Integer> list)` Método Estático

Este método verifica si todos los elementos de una lista son iguales. Si la lista está vacía, devuelve `true`. De lo contrario, compara cada elemento con el primero (considerado como el "primer" elemento en caso de que sean todos iguales). Si encuentra un elemento distinto, devuelve `false`.

```java
public static boolean checkIfAllElementsAreSame(List<Integer> list) {
    if (list.isEmpty()) {
        return true;  // o lanza una excepción
    }
    
    int firstElement = list.get(0);
    for (Integer element : list) {
        System.out.println(element + "==" + firstElement);
        if (element != firstElement) {
            return false;
        }
    }
    return true;
}
```

# Ejercicio 9

**Constructor `Matrix(double[][] data)`**

Este constructor crea una nueva matriz a partir de un arreglo bidimensional `data`. El parámetro `data` es un arreglo de arreglos, donde cada sub-arreglo representa una fila de la matriz. El constructor copia los valores del arreglo `data` en la matriz interna `this.data`.

```java
public Matrix(double[][] data) {
    this.data = new double[2][2];
    for (int i = 0; i < 2; i++) {
        System.arraycopy(data[i], 0, this.data[i], 0, 2);
    }
}
```

**Método `print()`**

Este método imprime la matriz en consola. Se utiliza un bucle anidado para recorrer cada fila y columna de la matriz.

```java
public String print() {
    String message = "";
    for (double[] row : data) {
        for (double element : row) {
            message = message + element + " ";
            System.out.print(element + " ");
        }
        System.out.println();
    }
    System.out.println();
    return message;
}
```

**Método `add(Matrix other)`**

Este método suma dos matrices. Se crea una nueva matriz resultante con los mismos tamaños que las matrices de entrada, y se calcula la suma de cada elemento correspondiente.

```java
public Matrix add(Matrix other) {
    double[][] result = new double[2][2];
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            result[i][j] = data[i][j] + other.data[i][j];
        }
    }
    return new Matrix(result);
}
```

**Método `subtract(Matrix other)`**

Este método resta dos matrices. Se crea una nueva matriz resultante con los mismos tamaños que las matrices de entrada, y se calcula la resta de cada elemento correspondiente.

```java
public Matrix subtract(Matrix other) {
    double[][] result = new double[2][2];
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            result[i][j] = data[i][j] - other.data[i][j];
        }
    }
    return new Matrix(result);
}
```

**Método `multiply(Matrix other)`**

Este método multiplica dos matrices.

```java
public Matrix multiply(Matrix other) {
    double[][] result = new double[2][2];
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            result[i][j] += data[i][j] * other.data[i][j];
        }
    }
    return new Matrix(result);
}
```

**Método `divide(Matrix other)`**

Este método divide dos matrices. Se crea una nueva matriz resultante con los mismos tamaños que las matrices de entrada, y se calcula la división de cada elemento correspondiente. Si un divisor es cero, se lanza una excepción de aritmética.

```java
public Matrix divide(Matrix other) {
    double[][] result = new double[2][2];
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 2; j++) {
            if (other.data[i][j] == 0)
                throw new ArithmeticException("Cannot divide by zero!");
            result[i][j] = data[i][j] / other.data[i][j];
        }
    }
    return new Matrix(result);
}
```

**Método `get(int i, int j)`**

Este método devuelve el valor de un elemento específico en la matriz.

```java
public double get(int i, int j) {
    return data[i][j];
}
```


# Ejercicio 10


**Función `displayMatrix(double[][] matrix)`**

Esta función imprime una matriz en con cuatro decimales después de cada elemento.

```java
public static void displayMatrix(double[][] matrix) {
    for (double[] row : matrix) {
        for (double value : row) {
            System.out.printf("%8.3f", value);
        }
        System.out.println();
    }
}
```

**Función `gaussJordanInverse(double[][] matrix)`**

Esta función calcula la inversa de una matriz cuadrada utilizando el algoritmo de Gauss-Jordan.

```java
public static double[][] gaussJordanInverse(double[][] matrix) {
    int n = matrix.length;
    double[][] augmentedMatrix = new double[n][2 * n];

    // Crear la matriz aumentada [A|I]
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            augmentedMatrix[i][j] = matrix[i][j];
        }
        augmentedMatrix[i][i + n] = 1;
    }

    // Aplicando Gauss-Jordan 
    for (int i = 0; i < n; i++) {
        // Hacer el elemento diagonal 1 y reducir la fila
        double diagValue = augmentedMatrix[i][i];
        for (int j = 0; j < 2 * n; j++) {
            augmentedMatrix[i][j] /= diagValue;
        }

        // Reducir otras filas
        for (int k = 0; k < n; k++) {
            if (k != i) {
                double factor = augmentedMatrix[k][i];
                for (int j = 0; j < 2 * n; j++) {
                    augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                }
            }
        }
    }

    // Extraer la matriz inversa de la matriz aumentada
    double[][] inverseMatrix = new double[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            inverseMatrix[i][j] = augmentedMatrix[i][j + n];
        }
    }

    return inverseMatrix;
}
```

**Función `multiplyMatrices(double[][] a, double[][] b)`**

Esta función calcula el producto de dos matrices.

```java
public static double[][] multiplyMatrices(double[][] a, double[][] b) {
    int n = a.length;
    double[][] result = new double[n][n];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }

    return result;
}
```

**Función `isIdentityMatrix(double[][] matrix)`**

Esta función verifica si una matriz es una matriz de identidad.

```java
public static boolean isIdentityMatrix(double[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j && Math.abs(matrix[i][j] - 1) > 1e-9) {
                return false;
            }
            if (i != j && Math.abs(matrix[i][j]) > 1e-9) {
                return false;
            }
        }
    }

    return true;
}
```

# Github

<https://github.com/MindSetFPS/practica-7>