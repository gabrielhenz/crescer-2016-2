using Loja.Dominio.Exceptions.Usuario;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class UsuarioServico
    {
        private IUsuarioRepositorio usuarioRepositorio;
        private IServicoDeCriptografia servicoCriptografia;

        public UsuarioServico(IUsuarioRepositorio usuarioRepositorio, IServicoDeCriptografia servicoCriptografia)
        {
            this.usuarioRepositorio = usuarioRepositorio;
            this.servicoCriptografia = servicoCriptografia;
        }

        public Usuario BuscarPorAutenticacao(string email, string senha)
        {
            Usuario usuarioEncontrado = this.usuarioRepositorio.BuscarPorEmail(email);

            string senhaCriptografada = this.servicoCriptografia.Criptografar(senha);

            if (usuarioEncontrado != null && usuarioEncontrado.Senha.Equals(senhaCriptografada))
            {
                return usuarioEncontrado;
            }

            return null;
        }

        public void Salvar(Usuario usuario)
        {
            if (usuario.Email.Length <= 5)
                throw new EmailMenorOuIgualACincoCaracteresException("O email precisa conter mais que cinco caracteres.");
            if (!usuario.Email.Contains("@"))
                throw new NaoContemArrobaException("O email precisa conter \"@\".");
            if (usuarioRepositorio.BuscarPorEmail(usuario.Email) != null)
                throw new EmailJaExistenteException("Este email já está cadastrado.");

            if(usuario.Id == 0)
                usuarioRepositorio.Criar(usuario);
            else
                usuarioRepositorio.Editar(usuario);
        }

        public void Excluir(Usuario usuario)
        {
            usuarioRepositorio.Excluir(usuario);
        }

        public Usuario BuscarPorId(int id)
        {
            return usuarioRepositorio.BuscarPorId(id);
        }
    }
}
