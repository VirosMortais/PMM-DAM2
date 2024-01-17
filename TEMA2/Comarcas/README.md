# ComarquesVirosms

![Logo](https://github.com/VirosMs/PMM-DAM2/assets/94723454/91a3b40f-5de1-4527-8ddf-8c550ffedf22)


## Descripción del Proyecto

Este proyecto es una aplicación de línea de comandos desarrollada en Dart para interactuar con una API de comarcas. La aplicación permite obtener información sobre las comarcas de una provincia específica y detalles adicionales sobre una comarca en particular.

La aplicación consta de dos funciones principales:

- `comarcas(String provincia)`: Muestra una lista de comarcas de una provincia específica.

- `inforComarca(String comarca)`: Muestra detalles sobre una comarca específica, incluyendo su nombre, capital, población, imagen, descripción, latitud y longitud.

## Configuración

Para ejecutar este proyecto, necesitarás tener instalado Dart en tu máquina.

## Dependencias

Este proyecto depende de la biblioteca [http](https://pub.dev/packages/http) para realizar solicitudes HTTP. Esta dependencia está definida en el archivo `pubspec.yaml` del proyecto.

## Ejecución

Para ejecutar este proyecto, abre una terminal en el directorio del proyecto y ejecuta el siguiente comando:

```bash
dart bin/Main.dart
```

## Cómo funciona

Cuando ejecutas la aplicación, puedes proporcionar argumentos para obtener información sobre las comarcas de una provincia o detalles sobre una comarca específica.

## Estructura del Proyecto

El proyecto consta de un archivo principal:

- `Main.dart`: Este es el archivo principal que contiene las funciones para interactuar con la API de comarcas.


## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT. Para más detalles, consulta el archivo [MIT license](https://github.com/VirosMs/ComarquesVirosMs?tab=MIT-1-ov-file) en el directorio raíz del proyecto.

## Instalación

Para instalar este proyecto, necesitarás tener Dart instalado en tu sistema. Aquí están los pasos para instalar y ejecutar el proyecto:

1. Clona el repositorio en tu máquina local usando Git:

```bash
git clone https://github.com/VirosMortais/comarquesvirosms.git
cd comarquesvirosms
```

2. Ejecuta el proyecto con el siguiente comando:

```bash
dart bin/Main.dart
```

## Acknowledgements

- [Awesome Readme Templates](https://awesomeopensource.com/project/elangosundar/awesome-README-templates)
- [Awesome README](https://github.com/matiassingers/awesome-readme)
- [How to write a Good readme](https://bulldogjob.com/news/449-how-to-write-a-good-readme-for-your-github-project)

## Authors

- [@VirosMS](https://github.com/VirosMs)
