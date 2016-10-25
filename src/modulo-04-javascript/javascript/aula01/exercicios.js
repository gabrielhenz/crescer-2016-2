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
function subtrair(num1){
  return function(num2){
    return num1 - num2;
  }
}
console.log(subtrair(-1)(2));


//exercicio 5 - igualdade recursiva
function iguais(param1, param2){
  if(param1 instanceof Object && param2 instanceof Object){
    var propriedadesParam1 = Object.getOwnPropertyNames(param1);
    var propriedadesParam2 = Object.getOwnPropertyNames(param2);
    if(propriedadesParam1.length != propriedadesParam2.length){
      return false;
    }
    for(var i = 0, len = propriedadesParam1.length; i < len; i++){
      var ehIgual = true;
      if(param1[propriedadesParam1[i]] instanceof Object && param2[propriedadesParam2[i]] instanceof Object){
        ehIgual = iguais(param1[propriedadesParam1[i]], param2[propriedadesParam2[i]]);
      }
      if(ehIgual){
        var nomePropriedade = propriedadesParam1[i];
        if(param1[nomePropriedade] !== param2[nomePropriedade]){
          return false;
        }
      }
    }
    return true;
  }else{
    return param1 === param2;
  }
}

//exercicio 6 - ctrc
function ctrlC(obj){
  if(obj instanceof Array){
    return ehArray(obj);
  }
  function ehArray(obj){
      var novoArray = [];
      for(var i = 0; i < obj.length; i++){
        novoArray.push(obj[i]);
      }
      return novoArray;
  }
  if(obj instanceof Object){
    var propriedadesObj = Object.getOwnPropertyNames(obj);
    var novoObj = {};
    for(var i = 0, len = propriedadesObj.length; i < len; i++){
      var nomePropriedade = propriedadesObj[i];
      if(obj[nomePropriedade] instanceof Array){
          novoObj[nomePropriedade] = ehArray(obj[nomePropriedade]);
          continue;
      }
      if(obj[nomePropriedade] instanceof Object){
        novoObj[nomePropriedade] = ctrlC(obj[nomePropriedade]);
      }
      novoObj[nomePropriedade] = obj[nomePropriedade];
    }
    return novoObj;
  }else{
    return obj;
  }
}
var origem = { a: '1'}
var destino = ctrlC(origem);
console.log(destino);
// { a: '1' }
console.log(origem === destino);
// false
console.log(iguais(origem, destino));
// true
destino = ctrlC({ a: [ { b: '1', c: '2' }, { d: false }, { e: function() { return 3; } } ] });
console.log(destino.a[2].e());
// 3
