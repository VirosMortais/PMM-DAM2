import 'dart:io';

import 'package:http/http.dart' as http;
import 'dart:convert';

String uri = "https://node-comarques-rest-server-production.up.railway.app/api/comarques/";

void main(List<String> args){

  if(args.isEmpty){
    print("No se ha introducido ningún argumento");
    exit(1);
  }

  if(args[0] == "comarcas"){
    comarcas(args[1]);
  }else if(args[0] == "infocomarca") {
    inforComarca(args[1]);
  }else{
    print("No se ha introducido ningún argumento válido");
    exit(1);
  }


}

void comarcas(String provincia){
  var response = http.get(Uri.parse(uri));
  var bodyJson;
  response.then((value) {
    if(value.statusCode == 200){
      String body = utf8.decode(value.bodyBytes);
      bodyJson = jsonDecode(body) as List;
    }
  });

  for(var comarca in bodyJson){
    print(comarca);
  }

}

void inforComarca(String comarca){

}