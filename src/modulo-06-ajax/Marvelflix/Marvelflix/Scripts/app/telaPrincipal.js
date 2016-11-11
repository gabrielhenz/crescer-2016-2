class TelaPrincipal {
  
  constructor(seletor) {
    this.$elem = $(seletor);
    this.renderizarEstadoInicial();
  }

  registrarBindsEventos(self) {
    self.$btnSincronizar = $('#btn-sincronizar-com-marvel');
    self.$btnSincronizar.on('click', self.sincronizar.bind(self));
    if (self.paginaAtual != 1) {
      self.$btnPaginaAnterior = $('#btn-pagina-anterior');
      self.$btnPaginaAnterior.on('click', self.obterPaginaAnterior.bind(self));
    }
    self.$btnProximaPagina = $('#btn-proxima-pagina');
    self.$btnProximaPagina.on('click', self.obterProximaPagina.bind(self));
  }

  obterProximaPagina() {
    var pagina = this.paginaAtual;
    this.qtdeHerois(++pagina)
      .done((herois) => {
        if (herois.length != 0)
          this.carregarERenderizarHerois(++this.paginaAtual);
      });
  }

  obterPaginaAnterior() {
      this.carregarERenderizarHerois(--this.paginaAtual);
  }

  sincronizar() {
    let self = this;
    let url = 'https://gateway.marvel.com:443/v1/public/characters?apikey=7ae597c1277cc37f2a4001139b3e2199&orderBy=-modified&limit=20';
    $.get(url).then((res) => {
      res.data.results.forEach(
        (heroiMarvel) => {
          let heroiASerCriado = {
            nome: heroiMarvel.name,
            urlThumbnail: `${heroiMarvel.thumbnail.path}.${heroiMarvel.thumbnail.extension}`
          }
          self.cadastrarNovoHeroi(heroiASerCriado)
        }
      )
    });
  }

  cadastrarNovoHeroi(heroi) {
    $.post('/api/herois', heroi).done((res) => {
      console.log('novo id', res.id);
    });
  }

  carregarERenderizarHerois(pagina) {
    return this.getHerois(pagina).done(function(res) {
      this.renderizarHerois(res).then(() => {
        this.registrarBindsEventos(this);
      })
    }.bind(this));
  }

  getHerois(pagina) {
    return $.get('/api/herois', {
      pagina: pagina,
      tamanhoPagina: 5
    });
  }

  qtdeHerois(pagina) {
    return this.getHerois(pagina);
  }

  renderizarHerois(heroisServidor) {
    return marvelflix.render('.tela', 'tela-principal', {
      chars: heroisServidor.map(function (item) {
        return {
          id: item.id,
          name: item.nome,
          thumbnail: item.urlThumbnail
        }
      })
    });
  }

  renderizarEstadoInicial() {
    $('.tela-centralizada').removeClass('tela-centralizada');
    this.$elem.show();
    this.paginaAtual = 1;
    this.carregarERenderizarHerois(this.pagina);
  }
}
