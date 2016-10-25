//exercicio 2 - diglett dig, trio trio trio
function diglettDig(){
  let divisivelPor3
    , divisivelPor5;
  //'i' fica dentro do escopo da função
  for(let i = 1; i <= 100; i++){
    divisivelPor3 = i % 3 === 0;
    divisivelPor5= i % 5 === 0;

    // define a variável para o escopo
    let texto;

    /* EXEMPLO DE FORMA ALTERNATIVA DE SE FAZER
    if(divisivelPor3 && divisivelPor5){
      texto= 'Diglett dig, trio trio trio';
      continue;
    }
    if(divisivelPor3){
      texto = 'Diglett dig';
      continue;
    }
    if(divisivelPor5){
      texto = 'trio trio trio';
      continue;
    }
    */

    if(divisivelPor3 && divisivelPor5){
      texto= 'Diglett dig, trio trio trio';
    } else if (divisivelPor3){
      texto = 'Diglett dig';
    } else if (divisivelPor5){
      texto = 'trio trio trio';
    } else{
      texto = i;
    }
    console.log(texto);
  }
}
