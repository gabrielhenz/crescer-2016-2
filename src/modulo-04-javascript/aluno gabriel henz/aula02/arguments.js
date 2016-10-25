// IIFE
(function () {
  console.log(arguments);
  console.log(this);
  (function(){
    console.log(arguments);
  })(1, 2);
})('primeiro param', 3, { nome: "nosa jureg"});

// arguments é uma pseudo variável
// ele muda de acordo com o escopo
// ele e o 'this'
//quanto mais interno mais especifico ele vai ser

//this é o contexto do código que o código está enquadrado
//, nao necessariamente um objeto
//por padrão, 'this' = window;
//podemos mudar o 'this'
//this é um objeto global

//CHAMADA DE FUNCOES
function imprime(texto){
  console.log(this);
  console.log('imprime', texto, this.qualquercoisa);
}

// 1º
console.log('Chamada normal');
imprime('olá mundo');
console.log('--------------------------');

// 2º
console.log('call');
imprime.call({ qualquercoisa: 'sim' }, 'olá mundo');
console.log('-----------------------------');

// 3º - consigo informar um array de argumentos
console.log('apply');
imprime.apply({ qualquercoisa: 'via apply' }, ['olá mundo', 'dois', 3, false, {} ]);
console.log('------------------------------');

//javascript nao eh multithread

//------------------------------------------------------------------------------------
//para postergar execuções
console.log('instantaneo');
setTimeout(function (){
  console.log('depois de um segundo');
}, 1000);

//tecnica de pulling, o usuario consultar o servidor pra ver se ter coisa nova
//dirty checking
//react - virtual dom
setInterval(function(){
  console.log('A cada seugndo');
})1000;

//conceito de assincronia
console.log('está depois, mas vai executar antes');
