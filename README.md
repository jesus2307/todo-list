# Project-Software
# Proyecto: Todo List

## Descripción General
Este proyecto implementa una aplicación para la gestión de tareas desarrollada en Java. La aplicación está diseñada para ayudar a los usuarios a organizar y priorizar sus tareas pendientes de manera eficiente. Utiliza principios de diseño orientado a objetos, pruebas unitarias con JUnit, y persistencia de datos con SQLite.

## Características Principales
- **Gestor de Tareas**:
  - Crear tareas con nombre, descripción, categoría, prioridad, y fecha de vencimiento.
  - Marcar tareas como completadas o pendientes.
  - Listar todas las tareas.
  - Actualizar el estado de una tarea (completada o no completada).
  - Eliminar tareas especificadas por su ID.
- **Persistencia de Datos**:
  - Las tareas se almacenan en una base de datos SQLite para garantizar su disponibilidad incluso tras cerrar la aplicación.
- **Pruebas Unitarias**:
  - Validación del funcionamiento de las clases principales mediante pruebas con JUnit.

## Estructura del Proyecto
El proyecto está organizado en las siguientes capas y componentes:

### Directorios
- **`src/main/java`**:
  - **controller**: Contiene la lógica del controlador para manejar interacciones del usuario.
  - **dao**: Implementación del patrón DAO para el acceso a la base de datos.
  - **model**: Define las entidades del proyecto, como `Tarea`.
  - Clases principales:
    - `ListaDeTareas`: Gestiona una colección de tareas.
    - `Main`: Punto de entrada de la aplicación.
- **`src/test/java`**:
  - Incluye las clases de prueba, como `TareaTest` y `TaskTest`, para validar las funcionalidades clave.

### Diagramas
- **Diagrama de Clases**: Proporciona una vista general de las clases y sus relaciones. [Ver Diagrama](project5.0/ClassDiagram_Project_EN.png).
- **Diagrama de Casos de Uso**: Describe las interacciones del usuario con la aplicación. [Ver Diagrama](project5.0/UseCaseDiagram_Project_EN.png).

## Requisitos del Sistema
- Java 11 o superior.
- Maven 3.6 o superior.
- SQLite.

## Instalación y Ejecución
1. **Clonar el repositorio**:
   ```bash
   git clone [https://github.com/tu_usuario/todo-list.git](https://github.com/jesus2307/Project-Software5.0.git)
   cd todo-list
   ```
2. **Configurar las dependencias**:
   Ejecuta el siguiente comando para descargar las dependencias necesarias:
   ```bash
   mvn clean install
   ```
3. **Ejecutar la aplicación**:
   Inicia la aplicación desde la clase `Main` con Maven:
   ```bash
   mvn compile exec:java -Dexec.mainClass="Main"
   ```
4. **Ejecutar pruebas**:
   Para validar las funcionalidades del proyecto, ejecuta:
   ```bash
   mvn test
   ```

## Funcionalidades del Menú
El menú principal incluye las siguientes opciones:

1. **Agregar Tarea**: Solicita al usuario introducir los detalles de la tarea (nombre, descripción, categoría, prioridad, fecha de vencimiento).
2. **Listar Tareas**: Muestra todas las tareas existentes con sus detalles.
3. **Actualizar Estado de Tarea**: Permite cambiar el estado de una tarea a completada o no completada.
4. **Eliminar Tarea**: Permite eliminar una tarea ingresando su ID.
5. **Salir**: Finaliza la aplicación.

## Pruebas Unitarias
Las pruebas incluidas validan los siguientes aspectos:
- Creación y manipulación de tareas.
- Persistencia y recuperación de datos desde la base de datos.
- Operaciones del controlador, como agregar, actualizar y eliminar tareas.

Para ejecutar las pruebas, utiliza el comando:
```bash
mvn test
```

## Mejoras Futuras
- **Filtros Avanzados**: Permitir filtrar tareas por prioridad, categoría o estado.
- **Notificaciones**: Implementar alertas para las tareas que están cerca de su fecha de vencimiento.
- **Interfaz Gráfica**: Crear una GUI utilizando JavaFX para mejorar la experiencia del usuario.
- **Integración Continua**: Configurar pipelines con herramientas como Jenkins o GitHub Actions.

