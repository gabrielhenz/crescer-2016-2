using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public interface IUsuarioRepositorio
    {
        Usuario BuscarPorId(int id);
        void Criar(Usuario usuario);
        void Atualizar(Usuario usuario);
        Usuario BuscarUsuarioAutenticado(string login, string senha);
    }
}
