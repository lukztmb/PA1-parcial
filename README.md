# Parcial 1
## Programación Avanzada I (Backend)
### Ing. y Lic. en Sistemas

### Objetivos
- Desarrollar una feature, a nivel core, que permita el registro de la entidad Piloto

### Evaluacion
- Fecha de Entrega (máximo): 14/10/2025 19:20:00 UTC-3
- El proyecto debe compilar sin errores en cualquier entorno de programación en el que se abra
- Todos los test unitarios deben pasar en verde
- Se generará solo un branch para la feature, partiendo desde main
- Se evaluará la funcionalidad a través de Pull Request (o Merge Request) del branch feature hacia main

### Punto de partida
- Se proveerá el esquema base de un Backend, de manera que el alumno pueda construir la feature desde cero, incluyendo test.

## Consigna
_Se desea implementar un backend para un microservicio que permita registrar pilotos._

#### Restricciones:
- No puede existir dos Pilotos con el mismo documento
- Todos los atributos de Piloto son obligatorios
- El piloto no puede ser menor a 18 años
- El caso de uso debe devolver la Licencia asignada al Piloto creado con éxito
- La licencia del piloto debe ser de tipo UUID, generada aleatoriamente en el UseCase

#### Funcionalidad
- Crear Piloto
  - Atributos:
    ```json
    {
      "licencia": "cabbd417-1841-4b25-8798-e8d54df1416e",
      "nombre": "Fanco Colapinto",
      "documento": "123456ABC"
      "fecha_nacimiento": "2020-01-01T10:00:00.000Z"
    }
    ```

### Entregable
Caso de uso que cubra la funcionalidad, aplicando patrones y principios de diseño SOLID. Debe incluir test de clase y de caso de uso

#### Buenas prácticas y conceptos a considerar
- La nomenclatura de paquetes será en minúsculas
- La nomenclatura de clases será en UpperCamelCase
- La nomenclatura de métodos será en lowerCamelCase
- La organización de paquetes será por modelo->aspecto, tanto a nivel src/main como a nivel src/test. Ejemplo:
  ```
  piloto
  └─ excepciones
  └─ modelo
  └─ repositorio
  └─ casodeuso
  ```
- Usar Excepciones personalizadas
- Se debe usar método factory/instancia para crear objetos
- Nomenclatura representativa de clases, métodos, etc.
