using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RepositorioEF
{
    public class PersonagemRepositorio : DatabaseContext, IPersonagemRepositorio
    {
        public void EditarPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Modified;
                context.SaveChanges();
            }
        }

        public void ExcluirPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Deleted;
                context.SaveChanges();
            }
        }

        public void IncluirPersonagem(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                context.Entry<Personagem>(personagem).State = EntityState.Added;
                context.SaveChanges();
            }
        }

        public List<Personagem> ListarPersonagens()
        {
            using (var context = new DatabaseContext())
            {
                return context.Personagem.ToList();
            }
        }

        public List<Personagem> FiltrarPorNome(string filtroNome)
        {
            using (var context = new DatabaseContext())
            {
                return context.Personagem.Where(p => p.Nome.Contains(filtroNome)).ToList();
            }
        }
    }
}
