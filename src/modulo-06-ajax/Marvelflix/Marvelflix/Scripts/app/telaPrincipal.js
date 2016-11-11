class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos(self) {
    self.btnSincronizar = $('#btn-sincronizar-com-marvel');
    self.btnSincronizar.on('click', self.sincronizar.bind(self));
  }

  sincronizar() {
    let self = this;
    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=5847706b1fb5580feeb66bcad22b81c6&orderBy=-modified&limit=20';
    $.get(url).then((res) => {
      res.data.results.forEach(
          (heroiMarvel) => {
            let thumb = heroiMarvel.thumbnail;
            let heroiASerCriado = {
              nome: heroiMarvel.name,
              urlThumbnail: `${thumb.path}.${thumb.extension}`
            }
            console.log(heroiASerCriado);
            self.cadastrarNovoHeroi(heroiASerCriado);
          }
        )
    });
  }

  cadastrarNovoHeroi(heroi) {
    console.log('Cadastrou!!!');
    $.post('/api/herois', heroi).done((res) => {
      console.log('novo id', res.id);
    });
  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();
    let self = this;
    
    $.get('/api/herois')
      .done(function(res) {
        let renderizar = marvelflix.render('.tela', 'tela-principal', {
          chars: res.map(function (item) {
            return {
              id: item.id,
              name: item.nome,
              thumbnail: item.urlThumbnail
            }
          })
        });
        //renderizar.then(self.registrarBindsEventos.bind(self));
        renderizar.then(() => {
          this.registrarBindsEventos(this);
        })
      }.bind(this));
  }
}
