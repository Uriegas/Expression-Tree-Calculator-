# POO Unidad 1 Actividad 1
## Calculadora Científica mediante árbol de expresión

### Objetivo de la Práctica

El alumno deberá demostrar solura en los siguientes temas de la Programación Orientada a Objetos y Estructura de Datos.
  * Árboles
  * Árboles de Expresión
  * Abstracción
  * Herencia
  * Poliformismo
  * Encapsulación

### Descripción de la práctica.

Se necesita la implementación de una calculadora científica que permita la introducción de ecuaciones en notación infija y que calcule el resultado de acuerdo al análisis de la ecuación introducida. A continuación se denotan algunos ejemplos:

Ejemplo 1
```
$ 3 + 5 - 2
$ Resultado: 6
```

Ejemplo 2
```
$ 3x + 2
$ Introduzca el valor de x: 5
$ Resultado: 17
```

Ejemplo 3
```
$ 3x + sen(2x) - x^2 + sqrt(4)
$ Introduzca el valor de x: 3
$ Resultado: 4.1045
```

Ejemplo 4
```
$ 2x + 5+-4
$ Introduzca el valor de x: 2
$ Resultado: 5
```

### Requerimientos Funcionales
Se deberá hacer uso de los siguientes temas:

  * Árboles de expresión
  * Herencia
  * Polimorfismo
  * Encapsulación
  * Recorrido de árbiles
  * Abstracción
  * Notación infija

De igual manera se deberá tener lo siguiente:

  * Se deberá crear un nuevo proyecto mediante maven. **No se deberá crear una nueva carpeta contenedora** el archivo `pom` deberá estar en la raiz del repositorio.
  * Se deberá utilizar clases que implementen Pruebas Unitarias.
  * Se podrán introducir los siguientes elementos:
    * Operaciones: `+`, `-`, `*`, `/`, `^`, `sin`, `cos`, `tan`, `sqrt`, `()`, `[]`
    * Operandos: 0-9, x
    * No deberá existir límite en el número de operaciones y operandos.
    * El programa deberá emitir un mensaje de error si existiera una sintaxis erronea en la ecuación.

### Requerimientos no funcionales

  * El programa deberá funcionar como una linea de comandos, y sólo deberá salir si se le envía el comando `!exit`.
  * Se introducirán las ecuaciones en notación infija.
  * Si se encuentra una variable `x` el programa preguntará por el valor a establecer.

### Entregables:

  1. Código de la implementación documentado mediante JavaDoc.
  2. Se deberá generar el archivo Jar => **Se subirá a plataforma google classroom**
  3. Se deberá generar un reporte de actividades en formato PDF => **Se subirá a plataforma google classroom**

### Reporte:
[Overleaf](https://www.overleaf.com/read/bkyqpnpdyxjn)