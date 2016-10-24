console.log('Olá "JS"!');
console.log('Olá \'JS\'!');

//var elfo = { nome: 'Legolas', experiencia: 1}; -> contido no outro-arquivo.js
console.log("Nome: 'oi'", elfo.nome);
elfo.flechas = 42;

console.log(elfo.flechas);

delete elfo.nome;
elfo.flechas = undefined;
elfo['Nome Completo'] = 'Legolas da Silva';
elfo.atirarFlecha = function(dwarf, opt, boolean, batman){
  opt();
  dwarf.vida -= 10;
  elfo.experiencia++;
  dwarf.feliz = false;
  return dwarf;
};

// IIFE
/*
(funtion(){
    console.log('oi');
})();
*/

var outraFuncao = function(){
  console.log('oi');
};

var dwarf =  elfo.atirarFlecha({vida: 110}, outraFuncao,
   true, 'batman');



console.log(elfo, dwarf);


elfo.nome = 'Fingolfin';
exebirElfoNaTela(elfo);

//maiusculo(elfo.nome); -> maiusculo is not defined
//tudo oq for definido dentro de uma function so existe dentro dela
