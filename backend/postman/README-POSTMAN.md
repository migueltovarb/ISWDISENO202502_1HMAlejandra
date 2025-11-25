# Colección de Postman - Vehicles API

## Importar la Colección

1. Abre Postman
2. Click en **Import** (esquina superior izquierda)
3. Selecciona el archivo `Vehicles-API-Collection.postman_collection.json`
4. La colección aparecerá en tu sidebar con todos los endpoints

## Endpoints Incluidos

### Básicos
- **Health Check** - Verifica que la API está funcionando
- **Obtener Todos los Vehículos** - Lista completa
- **Crear Vehículo** - POST con datos de ejemplo
- **Obtener Vehículo por ID** - GET por ID específico
- **Actualizar Vehículo** - PUT para modificar
- **Eliminar Vehículo** - DELETE por ID

### Búsquedas
- **Buscar por Marca** - Ejemplo: Toyota
- **Buscar por Modelo** - Ejemplo: Corolla
- **Buscar por Año** - Ejemplo: 2023
- **Buscar por Placa** - Ejemplo: ABC123
- **Buscar por Tipo** - Ejemplo: sedan

### Ejemplos Adicionales
- **Crear Honda Civic** - Segundo ejemplo de creación
- **Crear Ford F-150** - Ejemplo de pickup

## Cómo Usar

### 1. Iniciar el Servidor
\`\`\`bash
cd backend
mvn spring-boot:run
\`\`\`

### 2. Probar Health Check
- Ejecuta el primer request "Health Check"
- Deberías ver: `{"status":"UP","message":"Vehicles API is running"}`

### 3. Crear Vehículos de Prueba
- Ejecuta "Crear Vehículo"
- Ejecuta "Crear Vehículo - Honda Civic"
- Ejecuta "Crear Vehículo - Ford F-150"
- Copia el `id` que devuelve cada respuesta

### 4. Probar GET
- Ejecuta "Obtener Todos los Vehículos"
- Deberías ver los 3 vehículos creados

### 5. Probar GET por ID
- En "Obtener Vehículo por ID", reemplaza `:id` con un ID real
- En Postman, ve a la pestaña **Params** y pega el ID

### 6. Probar UPDATE
- En "Actualizar Vehículo", reemplaza `:id` con un ID real
- Modifica los datos en el Body
- Ejecuta el request

### 7. Probar Búsquedas
- "Buscar por Marca" → Cambia `Toyota` por otra marca
- "Buscar por Modelo" → Cambia `Corolla` por otro modelo
- etc.

### 8. Probar DELETE
- En "Eliminar Vehículo", reemplaza `:id` con un ID real
- Ejecuta el request
- Verifica con "Obtener Todos los Vehículos" que fue eliminado

## Variables de Postman (Opcional)

Para facilitar el uso, puedes crear variables:

1. Click derecho en la colección → **Edit**
2. Pestaña **Variables**
3. Agrega:
   - `baseUrl` = `http://localhost:8080`
   - `vehicleId` = (copia un ID real después de crear un vehículo)

4. En los requests, cambia:
   - `http://localhost:8080` → `{{baseUrl}}`
   - `:id` → `{{vehicleId}}`

## Respuestas Esperadas

### Success
- **POST** → Status 201 Created
- **GET** → Status 200 OK
- **PUT** → Status 200 OK
- **DELETE** → Status 204 No Content

### Error
- **404** → Vehículo no encontrado
- **400** → Datos inválidos (validación)
- **500** → Error del servidor

## Troubleshooting

Si no funciona:
1. Verifica que MongoDB esté corriendo
2. Verifica que el servidor esté en `localhost:8080`
3. Revisa los logs del servidor en VS Code
4. Asegúrate de que no haya errores de CORS

## Exportar Resultados

Postman te permite ejecutar toda la colección automáticamente:
1. Click en los tres puntos de la colección
2. Selecciona **Run collection**
3. Click **Run Vehicles API - CRUD**
4. Ve todos los tests ejecutarse en secuencia
