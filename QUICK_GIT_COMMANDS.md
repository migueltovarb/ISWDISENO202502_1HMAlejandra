# 🚀 Comandos Rápidos para Subir a GitHub

## ⚡ Secuencia Completa (Copy-Paste)

```cmd
cd C:\Users\LENOVO\Downloads\ProyectoElena\ProyectoElena

git init

git config --global user.name "Tu Nombre"
git config --global user.email "tu-email@ejemplo.com"

git add .

git commit -m "Initial commit: ProyectoElena - Plataforma Cultural Backend"

git remote add origin https://github.com/TU_USUARIO/ProyectoElena.git

git branch -M main

git push -u origin main
```

---

## 📝 Antes de ejecutar:

1. ✅ Crear repositorio en GitHub: https://github.com/new
2. ✅ Reemplazar `TU_USUARIO` con tu usuario de GitHub
3. ✅ Tener tu Personal Access Token listo

---

## 🔐 Obtener Personal Access Token:

1. GitHub → Settings → Developer settings
2. Personal access tokens → Tokens (classic)
3. Generate new token (classic)
4. Marcar scope: `repo`
5. Copiar el token generado
6. Usar como contraseña cuando Git lo pida

---

## 🔄 Para futuros cambios:

```cmd
git add .
git commit -m "Descripción del cambio"
git push
```
