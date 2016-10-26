//exercicio 7 - mesclar
function mesclar(obj1, obj2, bool = false) {
  for(var propriedade in obj2){
    if(bool && typeof obj2[propriedade] === 'object'){
      mesclar(obj1[propriedade], obj2[propriedade], bool);
    }else{
      obj1[propriedade] = obj2[propriedade];
    }
  }
}
