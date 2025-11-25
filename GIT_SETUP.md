# 🚀 Guía para Subir ProyectoElena a GitHub

## 📋 Prerequisitos

1. Tener Git instalado
2. Tener una cuenta de GitHub
3. Haber creado un repositorio en GitHub (o crearlo ahora)

---

## 🔧 Paso 1: Verificar que Git esté instalado

```cmd
git --version
```

Si no está instalado, descárgalo de: https://git-scm.com/download/win

---

## 📁 Paso 2: Crear archivo .gitignore (Importante)

Antes de hacer commit, crea un archivo `.gitignore` en la raíz del proyecto para evitar subir archivos innecesarios:

**Ubicación:** `C:\Users\LENOVO\Downloads\ProyectoElena\ProyectoElena\.gitignore`

**Contenido:**
```gitignore
# Maven
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties
.mvn/wrapper/maven-wrapper.jar

# IDE
.idea/
*.iml
*.iws
*.ipr
.vscode/
.settings/
.project
.classpath

# Logs
*.log
logs/

# OS
.DS_Store
Thumbs.db

# Application
application-local.yml
application-dev.yml

# Sensitive data (IMPORTANTE)
*.env
.env.*

# Compiled
*.class
*.jar
*.war
*.ear
*.zip
*.tar.gz
*.rar
```

---

## 🎯 Paso 3: Inicializar Git en tu proyecto

Abre PowerShell o CMD en la carpeta del proyecto:

```cmd
cd C:\Users\LENOVO\Downloads\ProyectoElena\ProyectoElena
git init
```

---

## ✅ Paso 4: Configurar tu identidad Git (si es primera vez)

```cmd
git config --global user.name "Tu Nombre"
git config --global user.email "tu-email@ejemplo.com"
```

---

## 📦 Paso 5: Agregar archivos al staging area

```cmd
git add .
```

Esto agrega TODOS los archivos (excepto los del .gitignore)

**Alternativa (más selectivo):**
```cmd
git add backend/
git add *.md
git add .gitignore
```

---

## 💾 Paso 6: Hacer el primer commit

```cmd
git commit -m "Initial commit: ProyectoElena - Plataforma Cultural Backend"
```

**Commits más detallados (recomendado):**

```cmd
git commit -m "feat: Initial Spring Boot project setup

- Configuración de MongoDB Atlas
- Implementación de controllers (Auth, Eventos, Inscripciones, etc.)
- Modelos de dominio (Usuario, Evento, Pago, Certificado)
- Servicios de negocio
- Colección de Postman para testing
- Documentación de API"
```

---

## 🌐 Paso 7: Crear repositorio en GitHub

1. Ve a https://github.com/new
2. Nombre del repositorio: `ProyectoElena` (o el que prefieras)
3. Descripción: "Plataforma de gestión de eventos culturales - Backend Spring Boot"
4. Elige público o privado
5. **NO** marques "Add a README file" (ya tienes archivos locales)
6. **NO** agregues .gitignore ni licencia (ya los tienes)
7. Click en "Create repository"

---

## 🔗 Paso 8: Conectar tu repositorio local con GitHub

GitHub te mostrará comandos, pero aquí están personalizados:

```cmd
git remote add origin https://github.com/TU_USUARIO/ProyectoElena.git
```

**Ejemplo:**
```cmd
git remote add origin https://github.com/helenmoncayo42/ProyectoElena.git
```

Verifica que se agregó correctamente:
```cmd
git remote -v
```

---

## 🚀 Paso 9: Subir el código a GitHub

### Opción A: Rama main (recomendado)
```cmd
git branch -M main
git push -u origin main
```

### Opción B: Rama master
```cmd
git push -u origin master
```

**Primera vez:** Te pedirá autenticación de GitHub
- Usa tu **Personal Access Token** (no contraseña)
- O configura SSH keys

---

## 🔐 Si necesitas Personal Access Token:

1. Ve a GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
2. Generate new token (classic)
3. Selecciona scopes: `repo` (todos)
4. Copia el token generado
5. Úsalo como contraseña cuando Git te lo pida

---

## 📊 Comandos de Seguimiento

### Ver estado de tu repositorio
```cmd
git status
```

### Ver historial de commits
```cmd
git log --oneline
```

### Ver archivos que se subirán
```cmd
git ls-files
```

---

## 🔄 Flujo de trabajo para futuros cambios

```cmd
# 1. Hacer cambios en tu código

# 2. Ver qué archivos cambiaron
git status

# 3. Agregar cambios
git add .

# 4. Commit con mensaje descriptivo
git commit -m "feat: Agregar validación de pagos"

# 5. Subir a GitHub
git push
```

---

## 📝 Convención de Commits (Recomendado)

Usa prefijos para categorizar tus commits:

- `feat:` Nueva funcionalidad
- `fix:` Corrección de bug
- `docs:` Cambios en documentación
- `refactor:` Refactorización de código
- `test:` Agregar o modificar tests
- `chore:` Tareas de mantenimiento
- `style:` Cambios de formato (sin afectar lógica)

**Ejemplos:**
```cmd
git commit -m "feat: Agregar endpoint de notificaciones"
git commit -m "fix: Corregir validación de fechas en eventos"
git commit -m "docs: Actualizar guía de Postman"
git commit -m "refactor: Optimizar consultas de MongoDB"
```

---

## ⚠️ IMPORTANTE: Seguridad

### Antes de subir, REVISA que no estés subiendo credenciales:

```cmd
git diff --cached
```

Si ves credenciales de MongoDB o contraseñas:

1. **Elimina del staging:**
   ```cmd
   git reset backend/src/main/resources/application.yml
   ```

2. **Usa variables de entorno en producción:**
   - NO subas `application.yml` con credenciales reales
   - O usa `application-example.yml` con valores de ejemplo

3. **Actualiza .gitignore:**
   ```gitignore
   application-local.yml
   application-prod.yml
   ```

---

## 🌿 Trabajar con Ramas (Opcional pero recomendado)

```cmd
# Crear rama para nueva feature
git checkout -b feature/pagos-online

# Hacer cambios y commits
git add .
git commit -m "feat: Implementar integración con pasarela de pago"

# Subir la rama a GitHub
git push -u origin feature/pagos-online

# Volver a la rama main
git checkout main

# Fusionar la feature (después de revisión)
git merge feature/pagos-online
git push
```

---

## 🆘 Comandos de Emergencia

### Deshacer último commit (sin perder cambios)
```cmd
git reset --soft HEAD~1
```

### Deshacer cambios no commiteados
```cmd
git checkout -- .
```

### Ver cambios antes de commit
```cmd
git diff
```

### Eliminar archivos del índice (pero mantenerlos localmente)
```cmd
git rm --cached backend/target/ -r
```

---

## ✅ Checklist Final

Antes de hacer push, verifica:

- [ ] `.gitignore` creado y configurado
- [ ] No hay credenciales en `application.yml`
- [ ] Carpeta `target/` no se sube (está en .gitignore)
- [ ] README.md existe y describe el proyecto
- [ ] Colección de Postman incluida
- [ ] Commits tienen mensajes descriptivos

---

## 🎉 ¡Listo!

Tu proyecto ahora está en GitHub. Comparte el link:
```
https://github.com/TU_USUARIO/ProyectoElena
```

---

## 📚 Recursos Adicionales

- [Git Cheat Sheet](https://education.github.com/git-cheat-sheet-education.pdf)
- [Conventional Commits](https://www.conventionalcommits.org/)
- [GitHub Docs](https://docs.github.com/)
