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
