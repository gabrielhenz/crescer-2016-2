//exercicio 1 - piramide iluminatti
function gerarPiramede(niveis){
  for(var i = 0; i <= niveis; i++){
    console.log(Array(i+1).join('R$'));
  }
}
