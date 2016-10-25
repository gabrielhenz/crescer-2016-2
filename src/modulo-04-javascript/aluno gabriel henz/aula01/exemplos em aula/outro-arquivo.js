var elfo = { nome: 'Legolas', experiencia: 1};

function exebirElfoNaTela(elfo){
  alert(maiusculo(elfo.nome));

  function maiusculo(texto){
    return texto.toUpperCase();
  }
  //antes de executar ele faz o asteamento (hoisting?)
  //coloca a function para cima
};


//funcao anonima e armazena numa variavel
//nao faz asteamento
/*
var minusculo = function(texto){
  return texto.toUpperCase();
}
*/


//pode chamar pelos dois nomes
/*
var minusculo = function maiusculo(texto){
  return texto.toUpperCase();
}
*/

/*
function imprimeArray(array){
  for(var i = 0, len = array.length; i < len; i++){
    console.log(array[i]);
  }
  console.log('i', i);
  //o 'var i' está no escopo da function
}
imprimeArray([ 1, null, '2', false, 3, { nome: 'Oi' } ]);
*/

//“Immediately-Invoked Function Expression (IIFE)”
(function(array){
  var i = 0
    , len = array.length;
  for(; i < len; i++){
    console.log(array[i]);
  }
  console.log('i', i);
  //o 'var i' está no escopo da function
})([ 1, null, '2', false, 3, { nome: 'Oi' } ]);
