
<h1>PROYECTO CAMPAMENTO</h1>

## Estado del proyecto

<img src="https://img.shields.io/badge/STATUS-EN CURSO%20-green" alt="Una imagen que muestra el estado actual: En Curso">


## Table of Contents
1. [General Info](#general-info)
2. [Technologies](#technologies)
3. [Installation](#installation)
4. [Problems](#problems)
5. [Developers](#developers)

## General Info

Este proyecto ha sido llevado a cabo por cuatro estudiantes de 3º de Ingeniería Informática con el objetivo de aprender el lenguaje de programación Java. Este proyecto es una práctica de la asignatura Programación Web.

## 🔧Technologies 

Hemos utilizado la herramienta IntelliJ IDEA para el desarrollo de nuestro software en Java. Además, la integración con GitHub es excelente y nos ha facilitado el trabajo en este proyecto.
Hemos trabajado con _IntelliJ IDEA Community Edition_, puesto que es la versión gratuita.
El enlace para descargar IntelliJ IDEA es este: https://www.jetbrains.com/idea/download/?section=windows

Hemos utilizado _GitHub_ para que todos los miembros de nuestro proyecto tuviesen siempre el código actualizado, el repositorio utilizado es este:
https://github.com/i12fecam/ProyectoCampamento

Además, para el diseño, implementación y mantenimiento de la base de datos hemos utilizado MySQL.Hemos llevado a cabo la administración de la base de datos mediante PHPMyAdmin.Este fue el enlace que el profesor nos proporcionó: http://oraclepr.uco.es/abd/



## ⚙️Installation

Para poder utilizar nuestro software vamos a necesitar tener instalada esta versión de _Java_: **1.8.0_341**

Para que todo funcione correctamente, hemos necesitado tener instalado **mysql-connector-java-5.1.47**. A través de este enlace lo podemos descargar:
https://downloads.mysql.com/archives/c-j/

Podemos llevar a cabo la ejecución de nuestro programa a través de la terminal.
En primer lugar, debemos asegurarnos de que la estructura de nuestro proyecto es la siguiente:
![Captura de pantalla 2023-11-10 222732.png](Captura%20de%20pantalla%202023-11-10%20222732.png)
![Captura de pantalla 2023-11-10 222942.png](Captura%20de%20pantalla%202023-11-10%20222942.png)
Una vez estemos en la carpeta ProyectoCampamento debemos utilizar dos comandos:

    javac -d out -cp "src;lib\mysql-connector-java-5.1.47.jar;ojdbc8.jar" src\Interface\Main.java //Este comando compila un programa escrito en Java y si no hay errores obtenemos el ejecutable.

Una vez hayamos obtenido el Main.class, utilizamos este comando:

     java -cp "out;src;lib/mysql-connector-java-5.1.47.jar;lib/ojdbc8.jar" Interface.Main //Ejecuta el programa Java

Después de esto ya deberías poder utilizar nuestro programa.

Esto sirve para el sistema operativo Windows.

Si te han aparecido problemas a la hora de utilizar los comandos anteriores, en el punto 5 se da una solución.

## Problems

### Problema: Configuración incorrecta de la variable "PATH"
#### Descripción:
Algunos usuarios pueden encontrarse con problemas al ejecutar el software si la variable "PATH" no está configurada adecuadamente para incluir la ruta al directorio donde se encuentran los ejecutables necesarios.

#### Solución:
Para resolver este problema, asegúrate de que la variable "PATH" incluya la ruta al directorio que contiene los ejecutables necesarios para tu software. Puedes hacerlo siguiendo estos pasos:

Abre la configuración del sistema o las variables de entorno según el sistema operativo que estés utilizando.

Agrega o modifica la variable "PATH" y asegúrate de incluir la ruta completa al directorio relevante. La dirección que debes poner tiene que ser similar a esta:

_C:\Program Files\Java\jdk1.8.0_341\bin_

Reinicia la línea de comandos o la sesión de usuario para que los cambios surtan efecto.
### Problema: "java.io.FileNotFoundException"
Para resolver este problema,debemos copiar los archivos config.properties y sql.properties en la ruta especificada en el error.
## ✒️Developers

| [<sub>i12rumon </sub>](https://github.com/i12rumon)
| [<sub>i12qugaa </sub>](https://github.com/i12qugaa)
| [<sub>i12fecam </sub>](https://github.com/i12fecam)
| [<sub>fatiicn </sub>](https://github.com/fatiicn)



