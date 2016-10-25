//exercicio 1 - piramide iluminatti
function gerarPiramede(niveis){
  for(var i = 0; i <= niveis; i++){
    console.log(Array(i+1).join('R$'));
  }
}
gerarPiramede(9);

//exercicio 2 - diglett dig, trio trio trio
function diglettDig(){
  var divisivelPor3
    , divisivelPor5;
  for(var i = 1; i <= 100; i++){
    divisivelPor3 = i % 3 === 0;
    divisivelPor5= i % 5 === 0;
    if(divisivelPor3 && divisivelPor5){
      console.log('Diglett dig, trio trio trio');
      continue;
    }
    if(divisivelPor3){
      console.log('Diglett dig');
      continue;
    }
    if(divisivelPor5){
      console.log('trio trio trio');
      continue;
    }
    console.log(i);
  }
}
diglettDig();

//exercico 3 - funcoes por parametro!?
function find(array, funcao){
  if(typeof funcao === "function"){
    var arrayRetorno = [];
    for(var i = 0, len = array.length; i < len; i++){
      if(funcao(array[i])){
        arrayRetorno.push(array[i]);
      }
    }
  }
  return arrayRetorno;
}
console.log(find([ 1, 2, 3 ], function(elemento) { return elemento >=2;}));
console.log(find([ 'a', 5, null, false, 'false' ], function(elem) {
  return typeof elem === 'string';
}));
console.log(find([ { nome: 'a' }, { nome: 'b' }  ], function(elem) {
  return typeof elem.nome === 'c';
}));

//bonus exercicio 3
var maiorIgualADois = 'maior igual ou a dois';
console.log(find([ 1, 2, 3 ], maiorIgualADois));


//exercicio 4 - voce sabe subtrair?

//exercicio 5 - igualdade recursiva
function iguais(param1, param2){
  
}
