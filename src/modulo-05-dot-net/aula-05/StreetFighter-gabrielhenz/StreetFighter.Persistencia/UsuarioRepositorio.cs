using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Persistencia
{
    public class UsuarioRepositorio
    { 
        public Usuario BuscarUsuarioAutenticado(string login, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["StreetFighterConnection"].ConnectionString;

            using(var connection = new SqlConnection(connectionString))
            {
                connection.Open();

                string sql = "SELECT * FROM Usuarios WHERE Login = @param_login AND Senha = @param_senha;";

                var command = new SqlCommand(sql, connection);

                command.Parameters.Add(new SqlParameter("param_login", login));
                command.Parameters.Add(new SqlParameter("param_senha", senha));

                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    return ConverterReaderParaUsuario(reader);
                }

                connection.Close();
            }

            return null;
        }

        private Usuario ConverterReaderParaUsuario(SqlDataReader reader)
        {
                Usuario found = new Usuario(
                    id: Convert.ToInt32(reader["Id"]),
                    login: reader["Login"].ToString(),
                    senha: reader["Senha"].ToString(),
                    nome: reader["Nome"].ToString()
                    );
            return found;
        }
    }
}
