# Colección Postman — ProyectoElena (Backend)

Este archivo describe cómo importar y usar la colección de Postman incluida para probar el backend de ProyectoElena.

📌 Requisitos
- Backend corriendo (por defecto: http://localhost:8080)
- Postman (o cualquier cliente compatible con colecciones Postman)

🚀 Instrucciones rápidas
1. Abrir Postman
2. Import → seleccionar `ProyectoElena.postman_collection.json` desde la carpeta `backend/postman` en este repositorio
3. Crear un Environment (opcional) y definir la variable `baseUrl` (por defecto: `http://localhost:8080`) y otras variables (actorId, usuarioId, eventoId, pagoId)
4. Ejecutar las requests en el orden que prefieras — hay ejemplos de body preparados

📁 Archivos incluidos
- `ProyectoElena.postman_collection.json` — colección con todos los endpoints (health, auth, eventos, inscripciones, certificados, asistencias, pagos)

🧭 Notas / consejos
- Si tu backend corre en otro puerto, modifica la variable `baseUrl` del Environment en Postman.
- Algunas rutas esperan `actorId`, `usuarioId` o `eventoId` como variables: actualízalas antes de ejecutar.
- No hay un endpoint de login (solo registro). Si tu aplicación añade autenticación en el futuro, actualizaremos la colección para inyectar tokens en el header `Authorization`.

Si quieres, puedo también generar un Environment JSON para Postman con valores de ejemplo o convertir la colección a Insomnia/Postwoman. ¿Deseas eso? 
