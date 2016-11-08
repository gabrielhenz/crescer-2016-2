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
    public static class UsuarioAplicativo
    {
        private static List<Usuario> _usuarios;

        public static void PopularUsuariosNoArquivoDeTexto(List<Usuario> usuarios)
        {
            UsuarioRepositorio repositorio = new UsuarioRepositorio();
            repositorio.PopularUsuarios(usuarios);
            _usuarios = repositorio.Usuarios;
        }

        public static void PopularUsuariosNoBanco()
        {
            List<Usuario> usuarios = new List<Usuario>()
            {
                new Usuario(1, "gabrielhenz", ServicoDeCriptografia.ConverterParaMD5("gabriel_$_12345"), "Gabriel Dias Henz"),
                new Usuario(2, "nunestrivial", ServicoDeCriptografia.ConverterParaMD5("nunestrivial_$_morrodapedra"), "André Nunes"),
                new Usuario(3, "bernarndo", ServicoDeCriptografia.ConverterParaMD5("bernarndo_$_vaidarjabulani"), "Bernardo Brezende")
            };

            new UsuarioRepositorioAdo().PopularUsuarios(usuarios);
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
            return new UsuarioRepositorioAdo().BuscarUsuarioAutenticado(login, senhaDeComparacao);
        }
    }
}
