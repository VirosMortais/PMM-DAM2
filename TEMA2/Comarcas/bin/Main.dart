// Importing necessary libraries
import 'dart:convert';
import 'dart:io';
import 'package:http/http.dart' as http;

// Base URI for the API
String uri = 'https://node-comarques-rest-server-production.up.railway.app/api/comarques/';

// Main function
void main(List<String> args) {
  // Check if arguments are provided
  if (args.isEmpty) {
    print("No se ha introducido ningún argumento");
    exit(1);
  }

  // Check the first argument and call the appropriate function
  if (args[0] == 'comarcas') {
    comarcas(args[1]);
  } else if (args[0] == 'infocomarca') {
    var comarca = "";

    // Concatenate all arguments after the first one
    for (var element in args.skip(1)) {
      if(element !=args.last){
        comarca += element + ' ';
      }else{
        comarca += element;
      }
    }
    inforComarca(comarca);
  } else {
    print("No se ha introducido ningún argumento válido");
    exit(1);
  }
}

// Function to get all comarcas of a province
comarcas(String provincia) async {
  print("Comarcas de la provincia de " + provincia + "\n");

  try {
    // Send a GET request to the API
    var response = await http.get(Uri.parse(uri + provincia));

    // Check the status code of the response
    if (response.statusCode == 200) {
      var body = utf8.decode(response.bodyBytes);

      // Parse the response body and print each comarca
      List<String> listComarcas = List.from(jsonDecode(body));
      listComarcas.forEach((element) => print(element));
    } else {
      print(response.statusCode);
      exit(1);
    }
  } catch (e) {
    throw Exception("Error al conectar con el servidor");
  }
}

// Function to get information about a comarca
void inforComarca(String comarca) async {
  print("Información de la comarca de " + comarca + "\n");

  try {
    // Send a GET request to the API
    var response = await http.get(Uri.parse(uri + 'infocomarca/' + comarca));

    // Check the status code of the response
    if (response.statusCode == 200) {
      Map<String, dynamic> comarca;

      try {
        // Parse the response body
        comarca = jsonDecode(response.body);
      } catch (e) {
        throw Exception("Error al decodificar el JSON");
      }

      // Create a Comarca object from the parsed data
      Comarca comarcaObj = Comarca(
        nombre: comarca['comarca'],
        capital: comarca['capital'],
        poblacion: comarca['poblacio'],
        img: comarca['img'],
        desc: comarca['desc'],
        latitud: comarca['latitud'],
        longitud: comarca['longitud'],
      );

      // Print the Comarca object
      print(comarcaObj);
    } else {
      print(response.statusCode);
      exit(1);
    }

  } catch (e) {
    throw Exception("Error al conectar con el servidor");
  }
}

// Class to represent a Comarca
class Comarca {
  String nombre;
  String? capital;
  String? poblacion;
  String? img;
  String? desc;
  double? latitud;
  double? longitud;

  // Constructor for the Comarca class
  Comarca({
    required this.nombre,
    required this.capital,
    required this.poblacion,
    required this.img,
    required this.desc,
    required this.latitud,
    required this.longitud,
  });

  // Override the toString method to print a Comarca object in a specific format
  @override
  String toString() {
    return "Comarca: " + nombre + "\n" +
    "Capital: " + capital! + "\n" +
    "Población: " + poblacion! + "\n" +
    "Imagen: " + img! + "\n" +
    "Descripción: " + desc! + "\n" +
    "Latitud: " + latitud.toString() + "\n" +
    "Longitud: " + longitud.toString() + "\n";
  }
}