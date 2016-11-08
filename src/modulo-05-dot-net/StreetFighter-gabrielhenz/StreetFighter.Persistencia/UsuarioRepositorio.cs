using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Persistencia
{
    public class UsuarioRepositorio
    { 
        const string path = @"c:\temp\ListaDeUsuarios.txt";
        public List<Usuario> Usuarios { get; private set; } = new List<Usuario>();

        public UsuarioRepositorio()
        {
            if (!System.IO.File.Exists(path))
            {
                using (System.IO.File.Create(path)) { }
            }
        }

        private void LerUsuarios()
        {
            var usuarios = File.ReadAllLines(path);
            foreach (var usuario in usuarios)
            {
                string[] atributosUsuario = usuario.Split(';');
                Usuarios.Add(
                    new Usuario(
                        Convert.ToInt32(atributosUsuario[0]), 
                        atributosUsuario[1],
                        atributosUsuario[2],
                        atributosUsuario[3])
                );
            }
        }

        public void PopularUsuarios(List<Usuario> usuarios)
        {
            string[] arrayDeUsuarios =
            {
                usuarios[0].ToString(),
                usuarios[1].ToString(),
                usuarios[2].ToString()
            };

            File.WriteAllLines(path, arrayDeUsuarios);
            LerUsuarios();
        }
    }
}
