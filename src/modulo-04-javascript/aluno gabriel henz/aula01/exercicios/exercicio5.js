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
