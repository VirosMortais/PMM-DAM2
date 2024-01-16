import 'dart:io';


void main(List<String> args){
  // Ejemplo simples
  if (args.length != 1) {
    print('Usage: dart ProgramacionEstructurada.dart <nombre>');
    exit(1);
  }

  var temperatura;

  try {
    temperatura = int.parse(args[0]);
  } on FormatException {
    print('El argumento de entrada debe ser un entero');
    exit(1);
  }

  if(temperatura > 21) {
    print('Hace calor');
  } else {
    print('Hace frio');
  }

  temperatura > 21 ? print('Hace calor') : print('Hace frio');

  var texto = temperatura > 21 ? 'Hace calor' : 'Hace frio';
  print(texto);

  // Ejemplo con switch
  var diaSemana = args[0];

  switch (diaSemana) {
    case 'lunes':
      print('Hoy es lunes');
      break;
    case 'martes':
      print('Hoy es martes');
      break;
    case 'miercoles':
      print('Hoy es miercoles');
      break;
    case 'jueves':
      print('Hoy es jueves');
      break;
    case 'viernes':
      print('Hoy es viernes');
      break;
    case 'sabado':
    case 'domingo':
      print('No es un dia laboral');
      break;
    default:
      print('No es un dia de la semana');
  }

  // Ejemplo con for
  for (var i = 0; i < 10; i++) {
    if(i % 2 == 0) {
      print('$i es par');
    } else {
      print('$i es impar');
    }
  }

  // Ejemplo con while
  var i = 0;
  while (i < 10) {
    if(i % 2 == 0) {
      print('$i es par');
    } else {
      print('$i es impar');
    }
    i++;
  }

  // Ejemplo con do while
  i = 0;
  do {
    if(i % 2 == 0) {
      print('$i es par');
    } else {
      print('$i es impar');
    }
    i++;
  } while (i < 10);
}