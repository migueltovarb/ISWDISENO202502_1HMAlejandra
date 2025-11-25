# 🎭 ProyectoElena - Plataforma Cultural de Eventos

Backend desarrollado en Spring Boot para la gestión integral de eventos culturales, incluyendo inscripciones, pagos, asistencias y certificados.
##VIDEO
https://drive.google.com/file/d/1nmwmB7nKmACbl5aQETg1KMAa3h6Xb0JX/view?usp=drive_link
## 🚀 Tecnologías

- **Java 17**
- **Spring Boot 3.3.4**
- **MongoDB Atlas** (Base de datos NoSQL)
- **Maven** (Gestión de dependencias)
- **Jakarta Validation** (Validación de datos)
- **Spring Data MongoDB** (Persistencia)

## 📋 Características

- ✅ Gestión de usuarios y autenticación
- ✅ CRUD completo de eventos culturales
- ✅ Sistema de inscripciones con control de cupos
- ✅ Registro de asistencias
- ✅ Emisión de certificados de participación
- ✅ Gestión de pagos con validación administrativa
- ✅ Historial de cambios en eventos
- ✅ Sistema de notificaciones

## 🏗️ Arquitectura

```
backend/
├── src/main/java/com/proyectoelena/
│   ├── config/          # Configuración (MongoDB)
│   ├── domain/          # Entidades de dominio
│   │   └── enums/       # Enumeraciones
│   ├── repository/      # Repositorios MongoDB
│   ├── service/         # Lógica de negocio
│   └── web/             # Controllers REST
│       └── dto/         # Data Transfer Objects
└── src/main/resources/
    └── application.yml  # Configuración de la aplicación
```

## 🔧 Configuración

### Requisitos Previos

- Java 17 o superior
- Maven 3.6+
- Cuenta de MongoDB Atlas (o MongoDB local)

### Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/TU_USUARIO/ProyectoElena.git
   cd ProyectoElena/backend
   ```

2. **Configurar MongoDB**
   
   Edita `src/main/resources/application.yml` o usa variables de entorno:
   ```yaml
   spring:
     data:
       mongodb:
         uri: ${MONGODB_URI:tu-connection-string}
         database: ${MONGODB_DATABASE:eventplatform}
   ```

3. **Compilar el proyecto**
   ```bash
   mvn clean package -DskipTests
   ```

4. **Ejecutar la aplicación**
   ```bash
   mvn spring-boot:run
   ```

   El servidor estará disponible en: `http://localhost:8080`

## 🌐 Endpoints API

### Health
- `GET /api/health` - Verificar estado del servidor

### Autenticación
- `POST /api/auth/registro` - Registrar nuevo usuario

### Eventos
- `GET /api/eventos` - Listar todos los eventos
- `POST /api/eventos` - Crear nuevo evento
- `PUT /api/eventos/{id}` - Editar evento
- `DELETE /api/eventos/{id}` - Eliminar evento

### Inscripciones
- `POST /api/inscripciones` - Inscribir usuario a evento

### Asistencias
- `POST /api/asistencias` - Registrar asistencia

### Certificados
- `POST /api/certificados` - Emitir certificado

### Pagos
- `POST /api/pagos` - Registrar pago
- `PUT /api/pagos/{id}/validar` - Validar/rechazar pago

## 📮 Testing con Postman

Importa la colección de Postman incluida:

1. Abre Postman
2. Import → `backend/ProyectoElena-API.postman_collection.json`
3. Lee la guía completa en `backend/POSTMAN_GUIDE.md`

## 🗄️ Modelos de Datos

### Usuario
- Email, nombre de usuario, password (encriptado)
- Roles: ADMIN, ORGANIZADOR, PARTICIPANTE

### Evento
- Nombre, descripción, lugar, fechas
- Control de cupos, categorías
- Organizadores asociados

### Inscripción
- Relación Usuario-Evento
- Fecha de inscripción

### Pago
- Monto, método de pago (TARJETA, TRANSFERENCIA, EFECTIVO)
- Estado (PENDIENTE, APROBADO, RECHAZADO)
- Comprobante URL

### Asistencia
- Registro de asistencia a eventos
- Fecha y hora de registro

### Certificado
- Código único de verificación
- Fecha de emisión

## 🔒 Seguridad

⚠️ **IMPORTANTE:** No subas credenciales al repositorio

- Usa variables de entorno para datos sensibles
- `.gitignore` configurado para excluir archivos de configuración local
- Passwords encriptados con BCrypt
- Validación de datos en todos los endpoints

## 🚀 Despliegue

### Variables de Entorno Recomendadas

```bash
MONGODB_URI=mongodb+srv://usuario:password@cluster.mongodb.net/?appName=App
MONGODB_DATABASE=eventplatform
SERVER_PORT=8080
```

### Comandos de Producción

```bash
# Compilar JAR
mvn clean package -DskipTests

# Ejecutar JAR
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

## 📝 Convenciones de Código

- **Idioma:** Español (nombres de clases, métodos, variables)
- **Validaciones:** Jakarta Validation en DTOs
- **Repositorios:** Spring Data MongoDB
- **Servicios:** Lógica de negocio separada de controllers
- **DTOs:** Records de Java para requests/responses

## 🤝 Contribuir

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'feat: Agregar nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## 👥 Autor

ProyectoElena - Plataforma Cultural

## 📧 Contacto

Para preguntas o soporte, abre un issue en GitHub.

---

⭐ Si este proyecto te fue útil, considera darle una estrella en GitHub
