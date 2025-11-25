# 📮 Guía de Uso de la Colección de Postman - ProyectoElena API

## 📥 Importar la Colección

### Opción 1: Importar desde archivo local
1. Abre Postman
2. Haz clic en **"Import"** (esquina superior izquierda)
3. Selecciona **"Upload Files"**
4. Navega a `backend/ProyectoElena-API.postman_collection.json`
5. Haz clic en **"Import"**

### Opción 2: Arrastrar y soltar
1. Abre Postman
2. Arrastra el archivo `ProyectoElena-API.postman_collection.json` directamente a la ventana de Postman

---

## 🚀 Configuración Inicial

### Variables de Entorno
La colección incluye variables predefinidas que puedes editar:

- **`baseUrl`**: URL base del servidor (por defecto: `http://localhost:8080`)
- **`usuarioId`**: ID de usuario registrado (se obtiene al registrar)
- **`eventoId`**: ID de evento creado (se obtiene al crear evento)
- **`categoriaId`**: ID de categoría
- **`organizadorId`**: ID del usuario organizador
- **`adminId`**: ID del administrador
- **`pagoId`**: ID del pago registrado

#### Cómo editar variables:
1. Selecciona la colección "ProyectoElena API"
2. Ve a la pestaña **"Variables"**
3. Actualiza los valores según tus necesidades

---

## 📋 Flujo de Pruebas Recomendado

### 1️⃣ Verificar que el servidor esté corriendo
```
GET /api/health
```
✅ Debe responder: `"ok"`

### 2️⃣ Registrar un usuario
```
POST /api/auth/registro
```
📝 Copia el `id` de la respuesta y guárdalo en la variable `usuarioId`

**Ejemplo de respuesta:**
```json
{
  "id": "674321abcd1234567890",
  "email": "usuario@ejemplo.com",
  "nombreUsuario": "usuario123"
}
```

### 3️⃣ Crear un evento
```
POST /api/eventos
```
📝 Usa el `usuarioId` del paso anterior en `actorId`  
📝 Copia el `id` del evento creado y guárdalo en la variable `eventoId`

### 4️⃣ Listar eventos
```
GET /api/eventos
```
✅ Verifica que tu evento aparezca en la lista

### 5️⃣ Inscribir usuario a evento
```
POST /api/inscripciones
```
📝 Usa los valores de `usuarioId` y `eventoId` guardados

### 6️⃣ Registrar asistencia
```
POST /api/asistencias
```
📝 Requiere un `actorId` (organizador) válido

### 7️⃣ Emitir certificado
```
POST /api/certificados
```
✅ Solo si el usuario asistió al evento

### 8️⃣ Registrar pago
```
POST /api/pagos
```
📝 Métodos válidos: `TARJETA`, `TRANSFERENCIA`, `EFECTIVO`  
📝 Copia el `id` del pago para validarlo después

### 9️⃣ Validar pago (requiere admin)
```
PUT /api/pagos/{pagoId}/validar
```
📝 Usa el `pagoId` del paso anterior

---

## 🔧 Métodos HTTP y Endpoints

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/health` | Verificar salud del servidor |
| POST | `/api/auth/registro` | Registrar nuevo usuario |
| GET | `/api/eventos` | Listar todos los eventos |
| POST | `/api/eventos` | Crear evento |
| PUT | `/api/eventos/{id}` | Editar evento |
| DELETE | `/api/eventos/{id}` | Eliminar evento |
| POST | `/api/inscripciones` | Inscribir usuario a evento |
| POST | `/api/asistencias` | Registrar asistencia |
| POST | `/api/certificados` | Emitir certificado |
| POST | `/api/pagos` | Registrar pago |
| PUT | `/api/pagos/{id}/validar` | Validar/rechazar pago |

---

## 💡 Tips y Buenas Prácticas

### ✅ Usar Variables
En lugar de escribir IDs manualmente, usa las variables de Postman:
- `{{baseUrl}}` - para la URL base
- `{{usuarioId}}` - para IDs de usuario
- `{{eventoId}}` - para IDs de evento

### ✅ Guardar respuestas
Después de cada request exitoso, copia los IDs de las respuestas y actualiza las variables correspondientes.

### ✅ Validar formatos de fecha
Las fechas deben estar en formato ISO 8601:
```
2025-12-01T18:00:00Z
```

### ✅ Revisar validaciones
- Email debe ser válido
- Password mínimo 8 caracteres
- Campos marcados con `@NotBlank` son obligatorios

---

## 🐛 Solución de Problemas

### ❌ Error: "Connection refused"
**Causa:** El servidor backend no está corriendo  
**Solución:** Ejecuta el backend:
```cmd
cd C:\Users\LENOVO\Downloads\ProyectoElena\ProyectoElena\backend
mvn spring-boot:run
```

### ❌ Error 400: Bad Request
**Causa:** Datos inválidos en el request  
**Solución:** Verifica que todos los campos obligatorios estén presentes y con formato correcto

### ❌ Error 404: Not Found
**Causa:** Endpoint o ID incorrecto  
**Solución:** Verifica la URL y que el recurso exista en la base de datos

### ❌ Error 500: Internal Server Error
**Causa:** Error en el servidor (ej: problemas con MongoDB)  
**Solución:** Revisa los logs del backend en la terminal

---

## 📊 Estructura de la Colección

```
ProyectoElena API/
├── Health/
│   └── Health Check
├── Auth/
│   └── Registrar Usuario
├── Eventos/
│   ├── Listar Eventos
│   ├── Crear Evento
│   ├── Editar Evento
│   └── Eliminar Evento
├── Inscripciones/
│   └── Inscribir Usuario a Evento
├── Asistencias/
│   └── Registrar Asistencia
├── Certificados/
│   └── Emitir Certificado
└── Pagos/
    ├── Registrar Pago
    └── Validar Pago
```

---

## 🔗 Recursos Adicionales

- **Puerto del servidor:** 8080
- **Base URL:** http://localhost:8080
- **Documentación de la API:** [Revisar controllers en `src/main/java/com/proyectoelena/web`]

---

## 📝 Notas Importantes

1. **Orden de ejecución:** Algunos endpoints dependen de datos previos (ej: necesitas crear un evento antes de inscribirte)
2. **IDs generados:** MongoDB genera IDs automáticamente en formato ObjectId (24 caracteres hexadecimales)
3. **Validaciones:** El backend valida todos los datos según las anotaciones en los DTOs
4. **Métodos de pago:** Solo acepta: `TARJETA`, `TRANSFERENCIA`, `EFECTIVO`

---

¡Listo para probar la API! 🎉
