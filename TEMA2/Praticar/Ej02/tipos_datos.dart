var dia = 'dijous'; // Infereix el tipus String
String dia2 = 'dimarts'; // Declara el tipus String
int dia3 = 3; // Declara el tipus int
double dia4 = 4.0; // Declara el tipus double
bool dia5 = true; // Declara el tipus bool

// Tambien puedes realizar conversiones de tipos
String cadena_numero = "3"; // Declara el tipus String que contiene un numero
int numero2 = int.parse(cadena_numero); // Convierte el String a int

const curs = 'Flutter'; // Constante

int? variable1; // Variable que puede ser nula

/*
* Operador de assignacion nula (Null assertion operator) (!): se utiliza cuando
* queremos assignar una variable que puede ser nula a variables que no puede contener.*/
int variable2 = variable1!;

enum DiasSetmana { dilluns, dimarts, dimecres, dijous, divendres, dissabte, diumenge }
List<DiasSetmana> Dies = DiasSetmana.values; // Lista de los valores del enum

void main(List<String> args){
/*  int? variable1;
  print('Operador de assignacion nula (Null assertion operator) (!): ${variable1!}');

  try{
    int variable2 = variable1!;
    print(variable2);
  } catch(e){
    print(e.runtimeType); // -> NullThrownError
    print(e); // -> NoSuchMethodError: t1 is null
  } finally{
    print('Finalmente');
  }*/

  /*Operador null (??): este operador retorna un valor resultante de la expression
  * de la parte esquierda del operador, siempre que no sea nulo. En caso contrario
  * se retornara la expression de la derecha.
 */
  print('\n->Operador null ??');
  var nom;
  // Escriu el nom si no és nul, o escriu "Anònim"
  print(nom ?? "Anònim");

  /*Assignacion conciente de nulos (null aware assignment) (??=): assigna un valor
  * a una variable que si este valor es nulo. En caso que la variable tiene un valor
  * previamente diferente a nulo, no assignara.*/

  print('\n->Assignació concient dels nulls:');
  int? variable11; // Si no indiquem nullable donaría error (coincideix amb l'anterior)
  print(variable11); // Mostra null
  variable11 ??= 10;
  print(variable11); // Mostra "10"
  variable11 ??= 15;
  print(variable11); // Mostra "10", ja que variable1 tenia ja valor.

  /*
  * Los tipus enumerados en Dart (enum), como en las otras lenguajes, nos sirve
  * para representar un nombre fijo de valores constantes. */

  DiasSetmana dia = DiasSetmana.dijous;
  print('\n->Tipus enumerats:');
  print(dia); // Mostra "DiasSetmana.dijous"
  print(Dies); // Mostra "[DiasSetmana.dilluns, DiasSetmana.dimarts, DiasSetmana.dimecres, DiasSetmana.dijous, DiasSetmana.divendres, DiasSetmana.dissabte, DiasSetmana.diumenge]"
}