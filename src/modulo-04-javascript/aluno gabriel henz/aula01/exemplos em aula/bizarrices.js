1/0;
//Infinity

0/0;
//Nan

1/-0;
//-Infinity

0/0 == 0/0;
//false

typeof 2;
//number

typeof 'oi';
//string

typeof [];
//object

typeof elfo;
//object

typeof NaN;
//number

//NaN -> not a number

NaN == NaN;
//false

isNaN(0/0);
//true

//se isNaN() retornar false, então é um número

isNaN(false);
//false

[] instanceof Object;
//true

[] instanceof Array;
//true

Array(10);
//[undefined x 10]

typeof null;
//object

null instanceof Object;
//false

[] + [];
//""
//se eu concateno 2 arrays, vem uma string vazia

[] + {}
//"[object Object]"
//join do array vazio com o tostring do objeto

{} + []
//0
//{} -> interpreta isso como um bloco de código
//bloco de código .tostring é vazio
//+[]
//converte string em numero(?)

[ '1', '2' ].join('');
//"12"

['1', '2', true].join('');
//12true

['1', '2', function()].join('');
//12function()

1/+[];
//(1/0) ou (1/zero) -> Infinity

Array(10).join('js');
//"jsjsjsjsjsjsjsjsjsjs"

1 + 2 + 3;
//6

1 + 2 + '3';
//"33"

1 + '2' + 3;
//123

Array(10).join('js' + 1);
//"js1js1js1js1js1js1js1js1js1js1"

Array(10).join('js' - 1) + 'Batman!';
//"NaNNaNNaNNaNNaNNaNNaNNaNNaNNaN Batman!"

1 + ('2' * 10);
//21

(1 + '2') * 10
//120

1 + '2' * 10
//21

1 + parseint('2') * 10;
//120

parseFloat('3.14');
//3.14

parseint('two');
//NaN

undefined;
//undefined

!undefined;
//true

!!undefined;
//false

var naoSei;
//undefined

if(!!naoSei){};
//if(false)

!!'';
//false

!!null;
//false

'2' == 2;
//true

['2'] == 2;
//true

'0' == false;
//true

[] == ![]
//true

'0' == false;
//true
'0' === false;
//false

//== -> twin evils
//=== -> don't fear

if(elfo === undefined){
  var minusculo = elfo.nome.toLowerCase();
}
minusculo += 'oi';
//variable minusculo is not defined

typeof goku === 'undefined';
//true
//versao correta de verificar se é undefined
