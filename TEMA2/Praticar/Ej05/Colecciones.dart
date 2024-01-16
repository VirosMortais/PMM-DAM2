void main(){
  //Lista nula
  List llistaNula;
  //Lista buida
  List llistaBuida = [];
  //Lista buida especificando el tipo de datos
  List<String> llistaBuidaTipus = []; // Forma 1
  List<String> _llistaBuidaTipus = <String>[]; // Forma 2

  //Lista con valores
  List llistaValors = [1, 2, 3];
  //Lista con valores especificando el tipo de datos
  List<String> llistaValorsTipus = ['a', 'b', 'c']; // Forma 1
  List laborales = ['Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes']; // Forma 2
  List<String> _llistaValorsTipus = <String>['a', 'b', 'c']; // Forma 2

  List<String> festivos = ['Sabado', 'Domingo'];

  //Manipulación de listas
  print('Manipulación de listas');
  print(llistaValorsTipus[0]); // Mostra: a

  //Añadir un elemento al final de la lista
  llistaBuida.add('d');

  // Modificar un elemento existente en la lista
  llistaBuida[0] = "Element modificat";

  // Eliminar el ultimo elemento de la lista
  llistaBuida.removeLast();

  // Eliminar un elemento de la lista por su posición
  llistaBuida.add('d');
  llistaBuida.removeAt(0);

  // Eliminar un elemento de la lista por su valor
  llistaBuida.remove('d');

  // Ampliar una lista con el final de otra
  List diasSemana=[];
  diasSemana.addAll(laborales);
  diasSemana.addAll(festivos);

  print(diasSemana);



  //Sets
  print('\nSets');

  //Declarar un conjunto a partir de una lista
  var modulos = Set.from(['M03', 'M05', 'M07', 'M09']);

  //Para poner elementos con un add
  modulos.add('M11');
  print(modulos);

  //Para saber si existe un elemento en un conjunto
  print(modulos.contains('M03'));


  //Diccionarios
  print('\nDiccionarios - Maps');

  //Definicion de una mapa y assignación de valores
  Map notes;

  notes = {
    'M03': 8,
    'M05': 7,
    'M07': 9,
    'M09': 10
  };

  // Acceso
  print(notes['M03']); // Mostra: 8

  // Definicion de un mapa especificando el tipo de datos

  Map<String, int> mapa2;

  //Definicion de un mapa especificando el tipo de dato dinamico por valor
  Map<String, dynamic> mapa3;

  // Afegint nous elements al mapa
  // Si ja existeix la clau, es modifica el valor
  notes["EIE"]=10;
  // Eliminant elements
  notes.remove("PMDM");
  // Per saber si un element existeix
  print (notes.containsKey("PMDM"));

  //Recorrer una lista
  print('\nRecorrer una lista');
  for (var i = 0; i < laborales.length; i++) {
    print(laborales[i]);
  }

  //Recorrer una lista con for in
  print('\nRecorrer una lista con for in');
  for (var dia in laborales) {
    print(dia);
  }

  //Recorrer una lista con forEach
  print('\nRecorrer una lista con forEach');
  laborales.forEach((dia) => print(dia));

  //Recorrer un mapa
  Map<String, int> notes2 = {
    'M03': 8,
    'M05': 7,
    'M07': 9,
    'M09': 10
  };

  print('\nRecorrer un mapa');
  notes2.forEach((key, value) => print('${key}: ${value}'));

  //Mapeado de estrucuturas
  print('\nMapeado de estrucuturas');
  print(modulos);


  // E usamos o método map para processar
  //cada elemento do conjunto
  // (Neste caso, convertemos para minúsculas)
  var modulos2 = modulos.map((item) {
    return item.toString().toLowerCase();
  });

  print(modulos2);

  // E usamos o método map para processar
  //cada elemento do conjunto
  // (Neste caso, convertemos para minúsculas)
  var modulos3 = modulos.map((item) => item.toString().toLowerCase());
  print(modulos3);

  // Filtrado de estrucuturas
  print('\nFiltrado de estrucuturas');
  // Filtrado de listas
  var laborales2 = laborales.where((dia) => dia.startsWith('L'));
  print(laborales2);

  // Filtrado de mapas
  var notes3 = notes2.entries.where((entry) => entry.value >= 9);
  print(notes3);

  // Reducción de estrucuturas
  print('\nReducción de estrucuturas');
  // Reducción de listas
  var laborales3 = laborales.reduce((value, element) => value + ', ' + element);
  print(laborales3);

  // Reducción de mapas
  var notes4 = notes2.entries.map((e) => e.key + ': ' + e.value.toString()).reduce((value, element) => value + ', ' + element);
  print(notes4);
}