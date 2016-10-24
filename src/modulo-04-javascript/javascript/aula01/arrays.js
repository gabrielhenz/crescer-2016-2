var array = [ 1, null, '2', false, 3, { nome: 'Oi' } ];
array.lenght;
//6

array[99] = oi;

console.log(array);
//[ 1, null, '2', false, 3, { nome: 'Oi' }, undefined x 93, "oi" ]

/*
for (var i = 0; i < array.lenght; i++){
  console.log(array[i]);
}
*/

for (var i = 0, len = array.length; i < len; i++){
  console.log(array[i]);
}

var array = []; // forma mais utilizada
var array = new Array();

array.push('primeiro item');
array.push('segundo item');
//.push() retorna o lenght do array
