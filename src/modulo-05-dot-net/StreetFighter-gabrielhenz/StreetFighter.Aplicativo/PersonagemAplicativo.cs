using RepositorioEF;
using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly IPersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        internal PersonagemAplicativo(IPersonagemRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public List<Personagem> ListarPersonagens()
        {
            return repositorio.ListarPersonagens();
        }

        public List<Personagem> FiltrarPorNome(string filtroNome)
        {
            return repositorio.FiltrarPorNome(filtroNome);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.IncluirPersonagem(personagem);
            else
                repositorio.EditarPersonagem(personagem);
        }

        public Personagem BuscarPorId(int? Id)
        {
            return (Id != null) ? repositorio.ListarPersonagens().Find(p => p.Id == Id) : null;
        }

        public void Excluir(int Id)
        {
            Personagem personagem = BuscarPorId(Id);
            repositorio.ExcluirPersonagem(personagem);
        }
    }
}
