//exercico 3 - funcoes por parametro!?
function find(array, funcao){
  var arrayRetorno = [];
  if(typeof funcao === "function"){
    for(var i = 0, len = array.length; i < len; i++){
      if(funcao(array[i])){
        arrayRetorno.push(array[i]);
      }
    }
  }
  return arrayRetorno;
}
