using StreetFighter.Dominio;
using StreetFighter.Infra;
using StreetFighter.Persistencia;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class ServicoDeUsuario
    {
        public static Usuario BuscarUsuarioAutenticado(string login, string senha)
        {

            string senhaDeComparacao = ServicoDeCriptografia.ConverterParaMD5($"{login}_$_{senha}");

            var repositorio = new UsuarioRepositorio();

            return repositorio.BuscarUsuarioAutenticado(login, senhaDeComparacao);
        }
    }
}
