using StreetFighter.Dominio;
using StreetFighter.Infra;
using StreetFighter.Persistencia;
using RepositorioEF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public static class UsuarioAplicativo
    {
        private static List<Usuario> _usuarios;

        public static void PopularUsuariosNoArquivoDeTexto(List<Usuario> usuarios)
        {
            Persistencia.UsuarioRepositorio repositorio = new Persistencia.UsuarioRepositorio();
            repositorio.PopularUsuarios(usuarios);
            _usuarios = repositorio.Usuarios;
        }

        public static Usuario BuscarUsuarioAutenticadoNoArquivoDeTexto(string login, string senha)
        {
            Usuario usuarioEncontrado = _usuarios.FirstOrDefault(
                usuario => usuario.Nome.Equals(login));

            string senhaDeComparacao =
                ServicoDeCriptografia.ConverterParaMD5($"{login}_$_{senha}");

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaDeComparacao))
            {
                return usuarioEncontrado;
            }

            return null;
        }

        public static Usuario BuscarUsuarioAutenticadoNoBanco(string login, string senha)
        {
            string senhaDeComparacao = ServicoDeCriptografia.ConverterParaMD5($"{login}_$_{senha}");
            return new RepositorioEF.UsuarioRepositorio().BuscarUsuarioAutenticado(login, senhaDeComparacao);
        }
    }
}
