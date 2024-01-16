import 'dart:convert' as convert;
import 'package:http/http.dart' as http;

void main(List<String> args) async{
  // This example uses the Google Books API to search for books about http.
  // for books about http. For details, see
  // https://developers.google.com/books/docs/overview

  final url = Uri.https('www.googleapis.com', '/books/v1/volumes', {
    'q': '{Un centimetro de ti}',
  });

  // Await the http get response, then decode the json-formatted response.
  // JSON data it contains
  final response = await http.get(url);

  if (response.statusCode == 200){
    final jsonResponse = convert.jsonDecode(response.body);
    final itemCount = jsonResponse['totalItems'];
    print('Number of books about http: $itemCount.');
  } else {
    print('Request failed with status: ${response.statusCode}.');
  }
}