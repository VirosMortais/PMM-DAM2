/*
// Funcion que no devuelve nada y no recibe parametros
void funcion(){

}

// Funcion que no devuelve nada y recibe parametros
void funcion(tipus1 arg1, tipus2 arg2, ...){

}

// Funcion que devuelve un valor y no recibe parametros
tipusDeRetorn funcion(){
  return valor;
}
*/

int funcion(arg1, arg2, callback) => callback(arg1, arg2);

void f1(int obligatori, [int opcional = 0]) {
  print("${obligatori}, ${opcional}");
}
void f2(int obligatori, {int opcionalAmbNom = 0}) {
  print("${obligatori}, ${opcionalAmbNom}");
}

void main() {
  /*Dart demanda funciones sin nombre o funicones anonimas, que pueden ser invocadas directamente,
  * pero que se pueden utlizar con callbacks, es decir, con argumentos por outras funciones*/
  print('Funcion anonima');
  int valor=funcion(3, 4, (arg1, arg2){
    // El codi de la funció anònima
    return (arg1+arg2);
  });
  print(valor);

  //Funcion flecha
  print('\nFuncion flecha');
  print (funcion(3, 4, (arg1, arg2) => arg1+arg2));

  //Argumentos opcionales y nombrados en funciones (opcional y opcionalAmbNom)
  print('\nArgumentos posiciones f1');
  f1(1); // Mostra: 1, 0
  //f1(); // Si llancem f1() sense arguments, obtindrem
  // l'error: Context: Found this candidate,
  // but the arguments don't match.

  f1(1, 2); // Mostra: 1, 2
  print('\nf2');
  f2(1); // Mostra: 1, 0
// f2(1, 2); // Si proporcionem dos arguments a f2, però
// sense indicar el nom, rebrem de nou un error.

  f2(1, opcionalAmbNom: 3); // Mostra 1, 3

}