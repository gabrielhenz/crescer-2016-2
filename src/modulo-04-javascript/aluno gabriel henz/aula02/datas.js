//MDN date javascript

var agora = new Date();
console.log(agora);
//retorna a data de agora

var dataNascimento = new Date(2000, 4, 8);
console.log(dataNascimento);
//diferença entre datas retorna em milisegundos.

//ISO -> International Organization for Standardization
//ISO 8601 - padronização de datas
var dataString = agora.toISOString();
console.log(dataString);

//ao contrario do ISO
var dataConvertida = new Date(Date.parse(dataString));
console.log(dataConvertida);

agora.toLocaleString();

// não mostra as datas, somente o horario e a localidade
agora.toTimeString();
