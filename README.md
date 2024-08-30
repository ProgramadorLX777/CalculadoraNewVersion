# Proyecto : Calculadora Básica

Este proyecto de la clase del dia 23-08-2024 de la resolución de operaciones básicas en una calculadora Android. A través de este proyecto, hemos puesto en práctica conceptos clave vistos en clase, como el uso de `LinearLayout` y la creación de componentes directamente en `activity_main.xml`.

## Ejecución del Proyecto

Para ejecutar este proyecto en tu computador, sigue los siguientes pasos:

1. Clona este repositorio en tu máquina local:
    ```bash
    git clone https://github.com/lonkonao/classAndroid2024
    ```
2. Abre el proyecto en Android Studio.
3. Compila y ejecuta el proyecto en un emulador o dispositivo físico.

## Conceptos Aplicados

Durante el desarrollo de esta calculadora, se aplicaron los siguientes conceptos:

1. **Uso de LinearLayout**: Aprendimos a organizar nuestros elementos de la interfaz gráfica usando este tipo de layout.
2. **Creación de componentes en `activity_main.xml`**: Todos los elementos de la calculadora fueron diseñados directamente en este archivo.

## Funcionamiento de la Calculadora

La calculadora implementa las operaciones básicas de suma, resta, multiplicación y división. La idea central es utilizar la función `guardarNumeroYOperacion("")` para almacenar el número y la operación seleccionada, como se muestra a continuación:

```java
btnSumar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        guardarNumeroYOperacion("+");
    }
});
```

Al presionar el botón de igual, se calcula el resultado ejecutando la función `calcularResultado()`, que utiliza un `switch case` para determinar la operación correspondiente:

```java
btnIgual.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        calcularResultado();
    }
});

private void calcularResultado() {
    String numeroIngresado = etNumero.getText().toString();
    if (!numeroIngresado.isEmpty()) {
        numero2 = Double.parseDouble(numeroIngresado);
        double resultado = 0;

        switch (operacion) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    Toast.makeText(this, "No se puede dividir por cero", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        tvResultado.setText("Resultado: " + resultado);
        etNumero.setText(""); 
    } else {
        Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show();
    }
}
```
<img width="371" alt="Captura de pantalla 2024-08-24 a la(s) 5 53 28 p  m" src="https://github.com/user-attachments/assets/5f9ef3b5-dfb8-4dbf-a241-9d7f7d470bdf">


## Tareas Pendientes

### 1. Eliminación de Decimales Innecesarios
El resultado debe eliminar el decimal si no es necesario. Por ejemplo, al sumar `2 + 2`, el resultado debe ser `4` en lugar de `4.0`.

<img width="379" alt="Captura de pantalla 2024-08-24 a la(s) 5 54 34 p  m" src="https://github.com/user-attachments/assets/bf312c9b-7fe9-4235-ba96-912ddfee928e">

### 2. Ejecución de Operaciones con Múltiples Valores
La calculadora debe permitir realizar operaciones con múltiples valores de forma continua. Por ejemplo, debe poder ejecutar `2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 + 2 = 20`.

## Entrega del Proyecto

- **Fecha de Entrega:** Jueves 29 de agosto, 23:59.
- **Modo de Entrega:** Deben crear un `Issue` en este repositorio con el link de su repositorio donde se encuentra el proyecto.
- **Entrega por Grupo:** Asegúrense de que la entrega sea grupal.

![Grabaciondepantalla2024-08-24alas6 00 35p m -ezgif com-resize](https://github.com/user-attachments/assets/5ca1f70a-6f98-4641-8d6c-fd14b867c1f3)

---

**Nota:** No olviden revisar que el proyecto funcione correctamente antes de la entrega.
