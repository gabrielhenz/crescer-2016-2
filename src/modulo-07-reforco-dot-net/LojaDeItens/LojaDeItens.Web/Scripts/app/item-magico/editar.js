var itemMagicoEditar = {};


itemMagicoEditar.sucessoNoCadastro = function (resposta) {
    alert(resposta.Mensagem);
}

itemMagicoEditar.erroNoCadastro = function (resposta) {
  $('#erro-cadastro').text(resposta.Message);
}
